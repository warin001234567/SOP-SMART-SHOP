package com.sop.smartshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.List;

@RestController
@SpringBootApplication
public class SmartshopApplication {
//    private static ArrayList<DoughnutCafeMenu> shoppingCart = new ArrayList<>();


    public static void main(String[] args) {
        SpringApplication.run(SmartshopApplication.class, args);
    }
    @RequestMapping("/")
    String home(){
        return "Welcom to my Doughnut Cafe <br> how to use this site" +
                "<br> add /promotion behind localhost:8080 to see all promotion" +
                "<br> add /promotion/{anynumber} behind localhost:8080 to see specific promotion" +
                "<br> add /promotion/add/{anynumber} behind localhost:8080 to add promotion to shopping cart" +
                "<br> add /promotion/remove/{anynumber} behind localhost:8080 to remove promotion from shopping cart" +
                "<br> add /cart behind localhost:8080 to see all promotion in shopping cart" +
                "<br> add /pay behind localhost:8080 to pay all promotion in shopping cart" +
                "<br> add /cartlog behind localhost:8080 to see all sell history";
    }

    @RequestMapping("/promotion")
    DoughnutCafeMenu[] promotionMenuList(){
        return DoughnutCafeMenuFactory.getMenulist();
    }

    @RequestMapping("/promotion/{id}")
    DoughnutCafeMenu promotionMenu(@PathVariable int id){
        return  DoughnutCafeMenuFactory.getMenu(id);
    }
    @RequestMapping("/promotion/add/{id}")
    String addToCart(@PathVariable int id) {
        Cart cart = Cart.getInstance();
        cart.setShoppingCart(DoughnutCafeMenuFactory.getMenu(id));
        return String.format("%s has been added to the shopping cart.", DoughnutCafeMenuFactory.getMenu(id).getName());
//        shoppingCart.add(DoughnutCafeMenuFactory.getMenu(id));
//        return String.format("\"%s\" has been added to the shopping cart.", DoughnutCafeMenuFactory.getMenu(id).getName());
    }

    @RequestMapping("/promotion/remove/{id}")
    String removeFromCart(@PathVariable int id) {
        Cart cart = Cart.getInstance();
        String temp = cart.getShoppingCart(id).getName();
                cart.deleteShoppingCart(id);
        return String.format("%s has been removed from the shopping cart.", temp);

//        String temp = shoppingCart.get(id).getName();
//        shoppingCart.remove(id);
//        return String.format("\"%s\" has been removed from the shopping cart.", temp);
    }

    @RequestMapping("/cart")
    ArrayList<DoughnutCafeMenu> viewCart() {
        Cart cart = Cart.getInstance();
        return cart.getsShoppingCart();
    }

    @RequestMapping("/pay")
    String payment() {
        String name;
        String detail;
        Doughnut[] doughnut;
        Tea[] tea;
        String price;
        String allTea = "";
        String allDoughnut = "";
        String oldtext = "";
        String newtext = "";
        double total = 0;
        Cart cart = Cart.getInstance();
        ArrayList<DoughnutCafeMenu> shopping = cart.getsShoppingCart();
        for (DoughnutCafeMenu i : shopping) {
            total += i.getPrice();
        }
        try {
            String fileName = "output.txt";
            Path path = Paths.get(fileName);
            byte[] bytes = Files.readAllBytes(path);
            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String i:allLines) {
                oldtext = oldtext + i + System.lineSeparator();
            }

            FileWriter writer = new FileWriter("output.txt");
            for(DoughnutCafeMenu i: shopping) {
                name = i.getName();
                detail = i.getDetail();
                doughnut = i.getDoughnut();
                tea = i.getTea();
                price = i.getPrice() + "";
                for (Tea j: tea) {
                    allTea = allTea + ", " + j.getTea();
                }
                for (Doughnut k: doughnut) {
                    allDoughnut = allDoughnut + ", " + k.getDoughnuts();
                }
                newtext = newtext + "Name of promotion: " + name + "<br>" + System.lineSeparator() +
                        "Detail: "+ detail + "<br>" + System.lineSeparator() +
                                "Doughnut: "+ allDoughnut + "<br>" + System.lineSeparator() +
                                        "Tea: "+ allTea + "<br>" + System.lineSeparator() +
                        "Price: " + price + "<br>" + System.lineSeparator() +
                        "-----------end promotion-------" + "<br>" + System.lineSeparator();
            }
            writer.write( newtext + oldtext);
            writer.close();
        } catch (IOException e) {
            try {
                FileWriter writer = new FileWriter("output.txt");
                for(DoughnutCafeMenu i: shopping) {
                    name = i.getName();
                    detail = i.getDetail();
                    doughnut = i.getDoughnut();
                    tea = i.getTea();
                    price = i.getPrice() + "";
                    for (Tea j: tea) {
                        allTea = allTea + ", " + j.getTea();
                    }
                    for (Doughnut k: doughnut) {
                        allDoughnut = allDoughnut + ", " + k.getDoughnuts();
                    }
                    newtext = newtext + "Name of promotion: " + name + "<br>" + System.lineSeparator() +
                            "Detail: "+ detail + "<br>" + System.lineSeparator() +
                            "Doughnut: "+ allDoughnut + "<br>" + System.lineSeparator() +
                            "Tea: "+ allTea + "<br>" + System.lineSeparator() +
                            "Price: " + price + "<br>" + System.lineSeparator() +
                            "-----------end promotion-------" + "<br>" + System.lineSeparator();
                }
                writer.write( newtext);
                writer.close();
            }catch (IOException a){
                a.printStackTrace();

            }
        }
        cart.deleteAll();

        return "Total price is  " + Double.toString(total) + " THB.";
    }

    @RequestMapping("/cartlog")
    String Cartlog() {
        String oldtext = "";
        String fileName = "output.txt";
        try{
            Path path = Paths.get(fileName);
            byte[] bytes = Files.readAllBytes(path);
            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String i:allLines) {
                oldtext = oldtext + i + System.lineSeparator();
            }
        }catch(IOException e){
            e.printStackTrace();
            return "No data!!!";
        }

        return oldtext;
    }
}
