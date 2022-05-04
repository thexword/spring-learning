package com.example.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner dataLoader(IngredientDao ingredientDao) { // or ApplicationRunner
//        return args -> {
//            ingredientDao.saveIngredient(new Ingredient("FLTO", "Flour Tortilla", "WRAP"));
//            ingredientDao.saveIngredient(new Ingredient("COTO", "Corn Tortilla", "WRAP"));
//            ingredientDao.saveIngredient(new Ingredient("GRBF", "Ground Beef", "PROTEIN"));
//            ingredientDao.saveIngredient(new Ingredient("CARN", "Carnitas", "PROTEIN"));
//            ingredientDao.saveIngredient(new Ingredient("TMTO", "Diced Tomatoes", "VEGGIES"));
//            ingredientDao.saveIngredient(new Ingredient("LETC", "Lettuce", "VEGGIES"));
//            ingredientDao.saveIngredient(new Ingredient("CHED", "Cheddar", "CHEESE"));
//            ingredientDao.saveIngredient(new Ingredient("JACK", "Monterrey Jack", "CHEESE"));
//            ingredientDao.saveIngredient(new Ingredient("SLSA", "Salsa", "SAUCE"));
//            ingredientDao.saveIngredient(new Ingredient("SRCR", "Sour Cream", "SAUCE"));
//        };
//    }


}
