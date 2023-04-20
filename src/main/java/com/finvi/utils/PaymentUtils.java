package com.finvi.utils;

import com.finvi.exception.InsufficientBalanceException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("account1", 10000.00);
        paymentMap.put("account2", 12000.00);
        paymentMap.put("account3", 14000.00);
        paymentMap.put("account4", 15000.00);
    }

    public static boolean validateCreditLimit(String accNo, double paidAmount) {
        if (paidAmount > paymentMap.get(accNo)) {
            throw new InsufficientBalanceException("Insufficent Balance");
        } else {
            return true;
        }
    }
}
