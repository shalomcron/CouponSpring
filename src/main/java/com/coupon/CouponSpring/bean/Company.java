package com.coupon.CouponSpring.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Companies")
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
    // private final List<Coupon> coupons = new ArrayList<>();
}
