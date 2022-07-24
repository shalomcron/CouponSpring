package com.coupon.CouponSpring.utils;

/**
 * Created by kobis on 10 Jul, 2022
 */
public class Print {
    public static void printMainCaption(String text) {
        System.out.println("\n@@@@@@@@  " + text + "    @@@@@@@@");
    }

    public static void printCaption(String text){
        System.out.println("@@@@" + text);
    }

    public static void printSubCaption(String text) {
        System.out.println("    @" + text);
    }

    public static void printException(String desc, Exception e) {
        System.out.println(" - Ex - " + desc + ":" + e.getMessage());
    }

}
