package sizhe.chen.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sizhe.chen.model.Ingredient;
import sizhe.chen.model.Taco;
import sizhe.chen.model.TacoOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientToMode(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );
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
    public String processTaco(Taco taco, @ModelAttribute TacoOrder order){
        order.addTacos(taco);
        log.info("Processing taco: {}", taco);

        return "design";
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }
    private Iterable<Ingredient> findIngredientByType(List<Ingredient> ingredients, Ingredient.Type type){
        return ingredients.stream().filter(item-> item.getType().equals(type))
                .collect(Collectors.toList());
    }

}
