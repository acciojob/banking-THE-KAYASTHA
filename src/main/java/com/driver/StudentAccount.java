package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name,balance,0);
        this.institutionName=institutionName;

    }

    public String getInstitutionName() {
        return institutionName;
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public double getMinBalance() {
        return super.getMinBalance();
    }

    @Override
    public String generateAccountNumber(int digits, int sum) throws Exception {
        return super.generateAccountNumber(digits, sum);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
