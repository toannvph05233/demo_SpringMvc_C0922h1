package com.example.demospringmvc.service;


import com.example.demospringmvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> products = new ArrayList<>();

    static  {
        products.add(new Product(1,"BimBim","https://noithatbinhminh.com.vn/wp-content/uploads/2022/08/anh-dep-56.jpg",10, true));
    }

    public static void delete(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                products.remove(i);
            }
        }
    }
}
