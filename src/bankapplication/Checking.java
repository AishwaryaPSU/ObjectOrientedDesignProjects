package bankapplication;

public class Checking extends Account{
    //List the properties specific to a checking account
    private int debitCardNumber;
    private int debitCardPIN;

    //Constructor to initialize the checking account properties
    public Checking(String name,String sSN,double initDeposit){
        super(name,sSN,initDeposit);
        accountNumber="2"+accountNumber;
        setDebitCardNumber();
    }

    @Override
    public void setRate(){
        rate = getBaseRate()*.15;
    }
    private void setDebitCardNumber(){
        debitCardNumber=(int)(Math.random()*Math.pow(10,12));
        debitCardPIN=(int)(Math.random()*Math.pow(10,4));
    }
    //List any methods specific to the checking account
    public void showInfo(){
        super.showInfo();
        System.out.println(
                " Your Checking Account Features" +
                        "\n  DebitCard Number : "+debitCardNumber+
                        "\n  DebitCard PIN : "+debitCardPIN
        );
    }
}
