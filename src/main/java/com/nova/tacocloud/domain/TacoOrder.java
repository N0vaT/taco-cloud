package com.nova.tacocloud.domain;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "Taco_Order")
@Entity
public class TacoOrder {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Обязательное поле")
    @Column(name = "delivery_name")
    private String deliveryName;
    @NotBlank(message = "Обязательное поле")
    @Column(name = "delivery_street")
    private String deliveryStreet;
    @NotBlank(message = "Обязательное поле")
    @Column(name = "delivery_city")
    private String deliveryCity;
    @NotBlank(message = "Обязательное поле")
    @Column(name = "delivery_state")
    private String deliveryState;
    @NotBlank(message = "Обязательное поле")
    @Column(name = "delivery_zip")
    private String deliveryZip;
//    @CreditCardNumber(message = "Некорректный номер карты")
    @Column(name = "cc_number")
    private String ccNumber;
//    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Формат ввода - MM/YY. Пример - 23/24")
    @Column(name = "cc_expiration")
    private String ccExpiration;
    @Digits(integer = 3,fraction = 0, message = "Введите CVV. Пример - 123")
    @Column(name = "cc_CVV")
    private String ccCVV;

    @Column(name = "placed_at")
    private LocalDateTime placedAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "taco_order_id")
    private List<Taco> tacos = new ArrayList<>();


    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
