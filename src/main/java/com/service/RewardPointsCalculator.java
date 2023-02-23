package com.service;

import java.math.BigDecimal;

public class RewardPointsCalculator {
    private static final BigDecimal THRESHOLD1 = BigDecimal.valueOf(50);
    private static final BigDecimal THRESHOLD2 = BigDecimal.valueOf(100);
    private static final int POINTS_PER_DOLLAR_TIER1 = 1;
    private static final int POINTS_PER_DOLLAR_TIER2 = 2;

    public static int calculate(BigDecimal amount) {
        int points = 0;
        BigDecimal amountOver100 = amount.subtract(THRESHOLD2);
        BigDecimal amountBetween50And100 = amountOver100.min(THRESHOLD1);

        if (amountOver100.compareTo(BigDecimal.ZERO) > 0) {
            points += amountOver100.multiply(BigDecimal.valueOf(POINTS_PER_DOLLAR_TIER2)).intValue();
        }

        if (amountBetween50And100.compareTo(BigDecimal.ZERO) > 0) {
            points += amountBetween50And100.multiply(BigDecimal.valueOf(POINTS_PER_DOLLAR_TIER1)).intValue();
        }

        return points;
    }
}

