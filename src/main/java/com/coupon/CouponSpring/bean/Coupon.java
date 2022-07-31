package com.coupon.CouponSpring.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne()
    @ToString.Exclude
    @JsonIgnore
    Company company;

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


    @ManyToMany(mappedBy = "coupons", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private Set<Customer> customers = new HashSet<>();
}
