package com.example.demospringmvc.service;


import com.example.demospringmvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();

    static  {
        products.add(new Product(1,"BimBim", 10, true));
        products.add(new Product(2,"Kẹo ke",20, false));
    }

    public static void delete(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                products.remove(i);
            }
        }
    }
}
