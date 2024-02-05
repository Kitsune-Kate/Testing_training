package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        Food food = new Food();
        food.setName("Маракуйя");
        food.setType("FRUIT");
        food.setExotic(true);

        CRUDUtils.addProduct(food);

        System.out.println();
        ArrayList<Food> products = CRUDUtils.getProductData();
        for (Food f : products) {
            System.out.println(f);

        }

        System.out.println();
        CRUDUtils.clear(4);

        System.out.println();
        ArrayList<Food> products1 = CRUDUtils.getProductData();
        for (Food f : products1) {
            System.out.println(f);

        }







    }
}