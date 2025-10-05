package org.example;

import java.util.Scanner;

public class TicketSystem {
    public static double calculateDiscount(int age, int quantity,String ticketType, String paymentMethod) {
        double discount = 0.0;
        boolean isVIP = ticketType.equalsIgnoreCase("VIP");
        boolean isOnline = paymentMethod.equalsIgnoreCase("Online");
        boolean isUnder22 = age < 22;
        if (isOnline) {
            if (isVIP) {
                // VIP + Online: discount = 20
                discount = 20.0;
                // VIP + Online + under 22: discount = 28
                if (isUnder22) discount += 8.0;
            } else {
                // Standard + Online: discount = 10
                discount = 10.0;
                // Standard + Online + under 22: discount = 18
                if (isUnder22) discount += 8.0;
            }
        } else { // Offline
            if (isVIP) {
                //Offline + VIP + Under 22: discount  15
                discount = isUnder22 ? 15.0 : 0.0;
            } else {
                // Standard + Offline + Under 22: discount = 8
                discount = isUnder22 ? 8.0 : 0.0;
            }
        }

        return discount;
    }
    public static void main(String[] args) {
        System.out.println(calculateDiscount(25,1, "Standard", "Offline")); // 0
        System.out.println(calculateDiscount(20,2, "Standard", "Offline")); // 8
        System.out.println(calculateDiscount(30, 3,"Standard", "Online"));  // 10
        System.out.println(calculateDiscount(18, 9,"Standard", "Online"));  // 18
        System.out.println(calculateDiscount(20, 10,"VIP", "Offline"));      // 15
        System.out.println(calculateDiscount(30, 7,"VIP", "Online"));       // 20
        System.out.println(calculateDiscount(18, 7,"VIP", "Online"));       // 28
    }
}
