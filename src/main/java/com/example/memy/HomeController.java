package com.example.memy;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collector;
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
    public String getFavorites(ModelMap map){
        map.put("gifs", Gif.GIFS.stream().filter(g -> g.isFavorite()).collect(Collectors.toList()));
        return "favorites";
    }


}
