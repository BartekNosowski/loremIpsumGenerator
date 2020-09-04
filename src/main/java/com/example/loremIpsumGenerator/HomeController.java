package com.example.loremIpsumGenerator;

import de.svenjacobs.loremipsum.LoremIpsum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
        // to oznacza, że mamy ścieżkę localhost:8080-> następnie wywołaj metodę home
        @GetMapping("/")
        public String home(ModelMap map){
            map.put("name", "Bartek Nosowski");
            // w html widoczna jest zmienna
            // name
            return "hi";
            // wyświetl html resources/templates/hi.html
        }
        @GetMapping("/form")
        public String getForm(){
            return "form";
        }
        @GetMapping("/result")
        public String getResult(@RequestParam Integer count, ModelMap map){
            // LoremIpsum pochodzi z dependencies
            // getWords - generuje tekst z iloscia slow
            LoremIpsum lorem = new LoremIpsum();
            map.put("count", lorem.getWords(count));
            return "result";
        }

    }
