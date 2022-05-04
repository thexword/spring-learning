package com.example.tacocloud.controller;

import com.example.tacocloud.domain.Ingredient;
import com.example.tacocloud.domain.Taco;
import com.example.tacocloud.dao.IngredientDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes(value = {"taco", "tacoOrder"})
public class DesignTacoController {

    private final IngredientDao ingredientDao;

    @Autowired
    public DesignTacoController(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = ingredientDao.findAllIngredients();

        String[] types = new String[] {
                "WRAP", "PROTEIN", "VEGGIES", "CHEESE", "SAUCE"
        };

        for (String type : types) {
            model.addAttribute(type.toLowerCase(), filterByType(ingredients, type));
        }
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, String type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing taco: " + taco);
        return "redirect:/orders/current";
    }

}
