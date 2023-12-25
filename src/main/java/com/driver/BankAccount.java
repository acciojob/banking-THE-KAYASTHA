package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.balance=balance;
        this.minBalance=minBalance;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits <= 0) {
            throw new  Exception("Account Number can not be generated");
        }

        if (sum < 0 || sum > digits * 9) {
            throw new  Exception("Account Number can not be generated");
        }

        String ans="";

        while(sum>=9){
            ans+=9;
            sum-=9;
        }
            if(sum!=0){
                ans+=sum;
                sum=0;
            }
            while(ans.length()!=digits){
                ans+=0;
            }

        return ans;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance=balance+amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance-=amount;
    }

}