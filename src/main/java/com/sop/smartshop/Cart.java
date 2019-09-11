package com.sop.smartshop;

import java.util.ArrayList;

public class Cart {
        private ArrayList<DoughnutCafeMenu> shoppingCart = new ArrayList<>();

        private static Cart instance;

        private Cart() {

        }

        public static Cart getInstance() {
            if (instance == null)
                instance = new Cart();
            return instance;
        }

    public ArrayList<DoughnutCafeMenu> getsShoppingCart() {
        return shoppingCart;
    }

    public DoughnutCafeMenu getShoppingCart(int id){
            return shoppingCart.get(id);
    }

    public void setShoppingCart(DoughnutCafeMenu item) {
        this.shoppingCart.add(item);
    }

    public void deleteShoppingCart(int id){
            this.shoppingCart.remove(id);
    }

    public void deleteAll(){
            this.shoppingCart.clear();
    }
}
