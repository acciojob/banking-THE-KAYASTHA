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
    public void withdraw(double amount) throws Exception, minbalException {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>maxWithdrawalLimit){
            throw new maxwithException("Maximum Withdraw Limit Exceeded");

        }
        if(amount>getBalance()){
            throw  new minbalException("Insufficient Balance");
        }
        setBalance(getBalance()-amount);


    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        double bal=getBalance();
        double interest=(bal*rate*years)/100;
        return bal+interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double bal=getBalance();
        double term=rate/(100*times);
        double mult=Math.pow(1+term,times*years);
        return mult*bal;

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
