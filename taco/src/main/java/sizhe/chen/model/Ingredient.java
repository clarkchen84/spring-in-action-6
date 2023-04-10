package sizhe.chen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: sizhe.chen
 * @Date: Create in 9:13 PM 2023/4/6
 * @Description:
 * @Modified:
 * @Version:
 */

@Data
@Builder
@AllArgsConstructor
public class Ingredient {
    private String id;
    private String name;
    private Type type;
    public enum Type{
        WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
    }
}
