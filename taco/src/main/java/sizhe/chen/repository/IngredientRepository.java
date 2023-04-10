package sizhe.chen.repository;

import sizhe.chen.model.Ingredient;

import java.util.Optional;

/**
 * @Author: sizhe.chen
 * @Date: Create in 11:44 PM 2023/4/10
 * @Description:
 * @Modified:
 * @Version:
 */

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
