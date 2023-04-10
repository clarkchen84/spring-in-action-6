package sizhe.chen.component;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sizhe.chen.model.Ingredient;
import sizhe.chen.repository.IngredientRepository;

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
@AllArgsConstructor
public class IngredientConverter implements Converter<String, Ingredient> {
    private  final IngredientRepository ingredientRepository;
    @Override
    public Ingredient convert(String s) {

        return ingredientRepository.findById(s).orElse(null);
    }
}
