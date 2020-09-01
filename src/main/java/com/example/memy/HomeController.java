package com.example.memy;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(ModelMap map) {
        map.put("gifs", Gif.GIFS);
        return "home";
    }

    // name jest zmienny
    @GetMapping("/gif/{name}")
    public String getGif(@PathVariable String name, ModelMap map) {
        Gif gif = Gif.GIFS.stream().
                filter(g -> g.getName().equals(name)).findFirst().get();
        map.put("gif", gif);
        //@Pathvariable zmienia automatycznie ze ścieżki na zmienną javową name
        return "gif-details";
    }

    @GetMapping("/favorites")
    public String getFavorites(ModelMap map) {
        map.put("gifs", Gif.GIFS.stream().filter(g -> g.isFavorite()).collect(Collectors.toList()));
        return "favorites";
    }

    @GetMapping("/categories")
    public String getCategories(ModelMap map) {
        map.put("categories", Category.categoryList);
        return "categories";
    }

    @GetMapping("/category/{name}")
    public String getGifFromCategory(@PathVariable String name, ModelMap map) {
        map.put("category", Category.categoryList.stream().filter(category -> category.getName().equals(name)).findFirst().get());
        map.put("gifs", Gif.GIFS.stream().filter(gif -> gif.getCategory().getName().equals(name)).collect(Collectors.toList()));
        return "category";
    }


}
