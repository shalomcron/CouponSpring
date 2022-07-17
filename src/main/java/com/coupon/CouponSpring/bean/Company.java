package com.coupon.CouponSpring.bean;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
// TODO: Warning:(12, 1)
//  Using @Data for JPA entities is not recommended. It can cause severe performance and memory consumption issues.
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    @OneToMany
    @Singular
    private final List<Coupon> coupons = new ArrayList<>();
}
