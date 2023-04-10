package sizhe.chen.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sizhe.chen.model.Ingredient;
import sizhe.chen.model.Taco;
import sizhe.chen.model.TacoOrder;
import sizhe.chen.repository.IngredientRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @Author: sizhe.chen
 * @Date: Create in 9:37 PM 2023/4/6
 * @Description:
 * @Modified:
 * @Version:
 */
@Slf4j
@Controller
@SessionAttributes("tacoOrder")
@RequestMapping("/design")
@AllArgsConstructor
public class DesignTacoController {
    private final IngredientRepository ingredientRepository;

    @ModelAttribute
    public void addIngredientToMode(Model model) {
        Iterable<Ingredient> ingredients= ingredientRepository.findAll();
        for(Ingredient.Type type : Ingredient.Type.values()){
            model.addAttribute(type.toString().toLowerCase(),
                    findIngredientByType(ingredients,type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return  new TacoOrder();
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder order){
        if(errors.hasErrors()){
            return "design";
        }
        order.addTacos(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }
    private Iterable<Ingredient> findIngredientByType(Iterable<Ingredient> ingredients, Ingredient.Type type){
        return StreamSupport.stream(ingredients.spliterator(),false).filter(item-> item.getType().equals(type))
                .collect(Collectors.toList());
    }

}
