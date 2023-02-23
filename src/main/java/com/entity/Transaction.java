package com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

	private Long customerId;
	private LocalDate transactionDate;
    private BigDecimal amount;
    
    public Transaction(Long customerId, LocalDate transactionDate, BigDecimal amount) {
		this.customerId = customerId;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}
    
    public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


}
