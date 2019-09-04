package com.sop.smartshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@SpringBootApplication
public class SmartshopApplication {
    private static ArrayList<DoughnutCafeMenu> shoppingCart = new ArrayList<>();


    public static void main(String[] args) {
        SpringApplication.run(SmartshopApplication.class, args);
    }
    @RequestMapping("/")
    String home(){
        return String.format("Welcom to my Doughnut Cafe \n  how to use this site" +
                "\n add /promotion behind localhost:8080 to see all promotion" +
                "\n add /promotion/{anynumber} behind localhost:8080 to see specific promotion" +
                "\n add /promotion/add/{anynumber} behind localhost:8080 to add promotion to shopping cart" +
                "\n add /promotion/remove/{anynumber} behind localhost:8080 to remove promotion from shopping cart" +
                "\n add /cart behind localhost:8080 to see all promotion in shopping cart" +
                "\n add /pay behind localhost:8080 to pay all promotion in shopping cart");
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
        shoppingCart.add(DoughnutCafeMenuFactory.getMenu(id));
        return String.format("\"%s\" has been added to the shopping cart.", DoughnutCafeMenuFactory.getMenu(id).getName());
    }

    @RequestMapping("/promotion/remove/{id}")
    String removeFromCart(@PathVariable int id) {
        String temp = shoppingCart.get(id).getName();
        shoppingCart.remove(id);
        return String.format("\"%s\" has been removed from the shopping cart.", temp);
    }

    @RequestMapping("/cart")
    ArrayList<DoughnutCafeMenu> viewCart() {
        return SmartshopApplication.shoppingCart;
    }

    @RequestMapping("/pay")
    String payment() {
        double total = 0;
        for (DoughnutCafeMenu i : SmartshopApplication.shoppingCart) {
            total += i.getPrice();
        }
        SmartshopApplication.shoppingCart.clear();

        return "Total price is  " + Double.toString(total) + " THB.";
    }
}
