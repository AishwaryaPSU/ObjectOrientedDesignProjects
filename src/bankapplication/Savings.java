package bankapplication;

public class Savings extends Account {
    //List properties specific to the savings accounts
    private int safetyDepositBoxId;
    private int getSafetyDepositBoxKey;

    //constructor to initialize settings for the savings properties
    public Savings(String name,String sSN,double initDeposit){
        super(name,sSN,initDeposit);
        accountNumber="1"+accountNumber;
        setSafetyDepositBox();
    }
    @Override
    public void setRate(){
        rate = getBaseRate()-0.25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxId = (int)(Math.random()*Math.pow(10,3));
        getSafetyDepositBoxKey = (int)(Math.random()*Math.pow(10,4));
    }

    //list any methods specific to savings account
    public void showInfo(){
        super.showInfo();
        System.out.println(
                " Your Savings Account Features" +
                "\n  Safety Deposit Box ID : "+safetyDepositBoxId+
                "\n  Safety Deposit Box Key : "+getSafetyDepositBoxKey
        );
    }
}
