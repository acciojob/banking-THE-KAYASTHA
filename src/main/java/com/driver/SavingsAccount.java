package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");

        }
        if(amount>super.getBalance()){
            throw new Exception("Insufficient Balance");
        }
        super.setBalance(super.getBalance()-amount);


    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double SI=(this.getBalance()*years*rate)/100;

        return SI;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundInterest = this.getBalance() * Math.pow(1 + (rate /100* times), times * years) - this.getBalance();
            return compoundInterest;
    }

    @Override
    public String generateAccountNumber(int digits, int sum) throws Exception {
        return super.generateAccountNumber(digits, sum);
    }

    @Override
    public double getMinBalance() {
        return super.getMinBalance();
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }
}
