package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Transaction;

public class RewardPointsService {
    public Map<String, Integer> calculateRewardPoints(List<Transaction> transactions) {
        Map<String, Integer> rewardPointsByMonth = new HashMap<>();

        for (Transaction transaction : transactions) {
            int rewardPoints = RewardPointsCalculator.calculate(transaction.getAmount());
            String month = transaction.getTransactionDate().getMonth().toString();

            rewardPointsByMonth.put(month, rewardPointsByMonth.getOrDefault(month, 0) + rewardPoints);
        }

        int totalRewardPoints = rewardPointsByMonth.values().stream().mapToInt(Integer::intValue).sum();
        rewardPointsByMonth.put("total", totalRewardPoints);

        return rewardPointsByMonth;
    }
}
