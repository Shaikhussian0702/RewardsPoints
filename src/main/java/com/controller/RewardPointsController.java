package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Transaction;
import com.service.RewardPointsService;

@RestController
public class RewardPointsController {
	/*[ 
	    {        "customerId": 1,        "transactionDate": "2022-01-15",        "amount": 150    },    
	 
		{        "customerId": 1,        "transactionDate": "2022-01-30",        "amount": 70    },  
		{        "customerId": 1,        "transactionDate": "2022-02-01",        "amount": 80    }, 
		{        "customerId": 1,        "transactionDate": "2022-03-20",        "amount": 200    },  
		{        "customerId": 1,        "transactionDate": "2022-03-31",        "amount": 50    }
	]
	*/
	
    @PostMapping("/calculateRewardPoints")
    public ResponseEntity<Map<String, Integer>> calculateRewardPoints(@RequestBody List<Transaction> transactions) {
        RewardPointsService rewardPointsService = new RewardPointsService();
        Map<String, Integer> rewardPoints = rewardPointsService.calculateRewardPoints(transactions);
        return new ResponseEntity<>(rewardPoints, HttpStatus.OK);
    }
}


/*"JANUARY": 230,
"FEBRUARY": 80,
"MARCH": 404,
"total": 714
} */
