package com.coupon.CouponSpring.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firsName;
    private String lastName;
    private String email;
    private String password;

    @ManyToMany
    @Singular
    private final List<Coupon> coupons = new ArrayList<>();
}
