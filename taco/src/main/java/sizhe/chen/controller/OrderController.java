package sizhe.chen.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import sizhe.chen.model.TacoOrder;

import javax.validation.Valid;

/**
 * OrderController
 *
 * @Author chensizhe
 * @Date 2023/4/7 8:19 PM
 */
@Slf4j
@Controller
@SessionAttributes("tacoOrder")
@RequestMapping("/orders")
public class OrderController {
    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus ){
        if(errors.hasErrors()){
            return "orderForm";
        }
        log.info("Taco Order {}", order);
        sessionStatus.setComplete();
        return "redirect:/design";
    }
}
