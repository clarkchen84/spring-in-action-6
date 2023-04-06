package sizhe.chen.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: sizhe.chen
 * @Date: Create in 9:26 PM 2023/4/6
 * @Description:
 * @Modified:
 * @Version:
 */
@Data
public class Taco {
    private String name;
    private List<Ingredient> ingredients;
}
