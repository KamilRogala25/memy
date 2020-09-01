package com.example.memy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Category {

    private String name;

    public static java.util.List<Category> categoryList = new ArrayList<>();

    static {
        categoryList.add(new Category("bot"));
        categoryList.add(new Category("funny"));
        categoryList.add(new Category("cowboy"));
    }

}
