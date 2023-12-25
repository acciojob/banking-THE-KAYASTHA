package com.driver;

import java.util.HashMap;
import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean check=true;

        for(int i=0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                check=false;
                break;
            }
        }
        if(!check){
            HashMap<Character,Integer> hmap=new HashMap<>();
            int n=tradeLicenseId.length();
            for(char c:tradeLicenseId.toCharArray()){
                hmap.put(c, hmap.getOrDefault(c,0)+1);
            } //calculating the frequency of characters
            PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b) ->{
               return hmap.get(b)-hmap.get(a);
            }); //setting character in queue according to whichever os smaller
            maxHeap.addAll(hmap.keySet());
            StringBuilder res=new StringBuilder();
            while(maxHeap.size()>=2){
                char ch1= maxHeap.poll();
                char ch2= maxHeap.poll();

                res.append(ch1);
                res.append(ch2);

                hmap.put(ch1,hmap.get(ch1)-1);
                hmap.put(ch2,hmap.get(ch2)-1);
                if(hmap.get(ch1)>0) maxHeap.add(ch1);
                if(hmap.get(ch2)>0) maxHeap.add(ch2);




            }
            if(!maxHeap.isEmpty()){
                char ch= maxHeap.poll();
                if(hmap.get(ch)>1) throw new  Exception("Valid License can not be generated");
                res.append(ch);
            }
            this.tradeLicenseId=res.toString();






        }

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
    public String getName() {
        return super.getName();
    }

    @Override
    public void setBalance(double balance) {
        super.setBalance(balance);
    }

    @Override
    public void setMinBalance(double minBalance) {
        super.setMinBalance(minBalance);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
