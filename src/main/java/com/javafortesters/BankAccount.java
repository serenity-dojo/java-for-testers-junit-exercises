package com.javafortesters;

/**
 * A simple bank account used in the Lecture 10 comprehensive exercise.
 * Covers everything from the JUnit 6 module in one class.
 */
public class BankAccount {

    private final String owner;
    private double balance;

    /**
     * Creates a new bank account.
     *
     * @throws IllegalArgumentException if initialBalance is negative
     */
    public BankAccount(String owner, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.owner = owner;
        this.balance = initialBalance;
    }

    /**
     * Deposits money into the account.
     *
     * @throws IllegalArgumentException if amount is zero or negative
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    /**
     * Withdraws money from the account.
     *
     * @throws IllegalArgumentException if amount is zero or negative
     * @throws IllegalStateException    if there are insufficient funds
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isEmpty() {
        return balance == 0.0;
    }
}
