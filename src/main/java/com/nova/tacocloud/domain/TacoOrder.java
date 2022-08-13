package com.nova.tacocloud.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {

    @NotBlank(message = "Обязательное поле")
    private String deliveryName;
    @NotBlank(message = "Обязательное поле")
    private String deliveryStreet;
    @NotBlank(message = "Обязательное поле")
    private String deliveryCity;
    @NotBlank(message = "Обязательное поле")
    private String deliveryState;
    @NotBlank(message = "Обязательное поле")
    private String deliveryZip;
    @CreditCardNumber(message = "Некорректный номер карты")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Формат ввода - MM/YY. Пример - 23/24")
    private String ccExpiration;
    @Digits(integer = 3,fraction = 0, message = "Введите CVV. Пример - 123")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
