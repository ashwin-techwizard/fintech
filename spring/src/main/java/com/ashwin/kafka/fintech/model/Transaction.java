package com.ashwin.kafka.fintech.model;
public class Transaction {

    private String transaction_id;
    private String account_number;
    private String transaction_reference;

    private String  transaction_datetime;
    private double amount;

    public Transaction(String transaction_id, String account_number, String transaction_reference, String  transaction_datetime, double amount) {
        this.transaction_id = transaction_id;
        this.account_number = account_number;
        this.transaction_reference = transaction_reference;
        this.transaction_datetime = transaction_datetime;
        this.amount = amount;
    }



    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getTransaction_reference() {
        return transaction_reference;
    }

    public void setTransaction_reference(String transaction_reference) {
        this.transaction_reference = transaction_reference;
    }

    public String getTransaction_datetime() {
        return transaction_datetime;
    }

    public void setTransaction_datetime(String transaction_datetime) {
        this.transaction_datetime = transaction_datetime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
