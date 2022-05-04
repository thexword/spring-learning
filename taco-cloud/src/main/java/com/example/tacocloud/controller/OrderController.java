package com.example.tacocloud.controller;

import com.example.tacocloud.dao.IngredientRefDao;
import com.example.tacocloud.dao.OrderDao;
import com.example.tacocloud.dao.TacoDao;
import com.example.tacocloud.domain.Ingredient;
import com.example.tacocloud.domain.TacoOrder;
import com.example.tacocloud.domain.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes(value = {"taco", "tacoOrder"})
public class OrderController {

    private OrderDao orderDao;
    private TacoDao tacoDao;
    private IngredientRefDao ingredientRefDao;

    @Autowired
    public OrderController(OrderDao orderDao, TacoDao tacoDao, IngredientRefDao ingredientRefDao) {
        this.orderDao = orderDao;
        this.tacoDao = tacoDao;
        this.ingredientRefDao = ingredientRefDao;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        Taco taco = (Taco) model.getAttribute("taco");
        log.info("taco: " + taco);

        TacoOrder tacoOrder = (TacoOrder) model.getAttribute("tacoOrder");
        if (tacoOrder == null) {
            tacoOrder = new TacoOrder();
        }
        tacoOrder.addTaco(taco);
        model.addAttribute("tacoOrder", tacoOrder);
        return "orderForm";
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        try {
            orderDao.saveOrder(tacoOrder);
            List<Taco> tacos = tacoOrder.getTacos();
            for (int i = 0; i < tacos.size(); i++) {
                Taco taco = tacos.get(i);tacoDao.saveTaco(taco, tacoOrder.getId(), (long) i);
                log.info("insertedTacoId: " + taco.getId());

                List<Ingredient> ingredients = taco.getIngredients();
                for (int j = 0; j < ingredients.size(); j++) {
                    Ingredient ingredient = ingredients.get(j);
                    ingredientRefDao.saveIngredientRef(taco.getId(), ingredient.getId(), (long) j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        sessionStatus.setComplete();

        log.info("Order submitted: " + tacoOrder);
        return "redirect:/";
    }
}
