package sizhe.chen.component;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sizhe.chen.model.Ingredient;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: sizhe.chen
 * @Date: Create in 10:20 PM 2023/4/6
 * @Description:
 * @Modified:
 * @Version:
 */

@Component
public class IngredientConverter implements Converter<String, Ingredient> {
    @Override
    public Ingredient convert(String s) {
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
        return ingredients.stream().filter(ingredient -> ingredient.getId().equals(s)).findAny().orElse(null);
    }
}
