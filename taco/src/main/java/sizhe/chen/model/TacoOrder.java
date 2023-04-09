package sizhe.chen.model;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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

    @NotBlank(message = "Delivery name is required")
    private String deliveryName;
    @NotBlank(message = "City is required")
    private String deliveryCity;
    @NotBlank(message = "Zip code is required")
    private String deliveryZip;
    @NotBlank(message = "Street is required")
    private String deliveryStreet;
    @NotBlank(message = "State is required")
    private String state;
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",      message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
    private List<Taco> tacos = new ArrayList<>();
    public void addTacos(Taco taco){
        this.tacos.add(taco);
    }
}
