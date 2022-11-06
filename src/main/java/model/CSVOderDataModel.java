package model;

import com.opencsv.bean.CsvBindByName;

/**
 * This model will map the columns in csv to java variables
 */
public class CSVOderDataModel {
    @CsvBindByName(column = "Order ID", required = true)
    private int orderId;

    @CsvBindByName(column = "amount", required = true)
    private double amount;

    @CsvBindByName(column = "currency", required = true)
    private String currency;

    @CsvBindByName(column = "comment", required = true)
    private String comment;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CSVOderDataModel{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
