package com.coupon.CouponSpring.bean;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String firsName;
    @Column(length = 100, nullable = false)
    private String lastName;
    @Column(length = 30, nullable = false)
    private String email;
    @Column(length = 30, nullable = false)
    private String password;

    @ManyToMany(
            cascade={CascadeType.ALL}
    )
    @JoinTable(
            name = "customer_coupons",
            joinColumns = { @JoinColumn(name = "customer_id") },
            inverseJoinColumns = { @JoinColumn(name = "coupon_id") }
    )
    @Singular
    // private List<Coupon> coupons = new ArrayList<>();
    private Set<Coupon> coupons = new HashSet<>();

}
