package sizhe.chen.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sizhe.chen
 * @Date: Create in 9:33 PM 2023/4/6
 * @Description:
 * @Modified:
 * @Version:
 */
@Data
public class TacoOrder {

    private String deliveryName;
    private String deliveryCity;
    private String deliveryZip;
    private String deliveryStreet;
    private String state;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();
    public void addTacos(Taco taco){
        this.tacos.add(taco);
    }
}
