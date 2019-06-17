package bankapplication;

import sun.rmi.log.LogInputStream;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        String file = "/Users/aishwaryagm/Downloads/NewBankAccounts.csv";
        //Read a CSV file and create new accounts based on that data
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolders){
            //System.out.println("NEW ACCOUNT");
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            System.out.println(name+" "+sSN+" "+accountType+" $"+initDeposit);
            if(accountType.equals("Savings")){
                accounts.add(new Savings(name,sSN,initDeposit));
            }else if(accountType.equals("Checking")){
                accounts.add(new Checking(name,sSN,initDeposit));
            }else{
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }
        for(Account acc : accounts){
            System.out.println("\n************");
            acc.showInfo();
        }

//
//        Checking chkacc1 = new Checking("Tom Wilson","321456879",1500);
//
//        Savings savacc1 = new Savings("Rich Lowe","456657897",2500);
//        savacc1.compound();
//        savacc1.showInfo();
//        System.out.println("-----------------------");
//        chkacc1.showInfo();
//
//        System.out.println("*****************");





    }
}
