package com.coupon.CouponSpring.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(length = 100, nullable = false)
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private double price;
    private String image;


    @ToString.Exclude
    @JsonIgnore
    @ManyToOne()
    Company company;

    @ToString.Exclude
    @JsonIgnore
    @Singular
    @ManyToMany()
    @JoinTable(
            name = "customers_vs_coupons",
            joinColumns = { @JoinColumn(name = "coupon_id") },
            inverseJoinColumns = { @JoinColumn(name = "customer_id") }
    )
    List<Customer> customers = new ArrayList<>();
}
