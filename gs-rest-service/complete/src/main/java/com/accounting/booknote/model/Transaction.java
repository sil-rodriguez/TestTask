package com.accounting.booknote.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Model class to represent transactions
 */
public class Transaction implements Comparable{

    private String id;
    private String type;
    private double amount;
    private Date timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @JsonIgnore
    public boolean isCreditTransaction() {
        return "credit".equals(type);
    }

    @Override
    public int compareTo(Object o) {
        return this.getTimestamp().compareTo(((Transaction)o).getTimestamp());
    }
}
