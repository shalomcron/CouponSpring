package com.coupon.CouponSpring.bean;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String email;
    @Column(length = 30, nullable = false)
    private String password;

    @OneToMany(
            mappedBy = "company",
             // TODO: ASK FOR cascade options
            // cascade = CascadeType.PERSIST,
            cascade = CascadeType.ALL
    )
    @Singular
    private List<Coupon> coupons = new ArrayList<>();

}
