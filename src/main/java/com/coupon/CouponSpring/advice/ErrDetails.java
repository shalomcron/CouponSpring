package com.coupon.CouponSpring.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by kobis on 10 Jul, 2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrDetails {

    private final String title = "ErrDetails";
    private String description;
}
