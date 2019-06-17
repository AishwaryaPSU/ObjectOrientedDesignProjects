package bankapplication;

public abstract class Account implements IBaseRate{
    //List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;
    protected String accountNumber;
    protected double rate;
    private static int index =10000;

    //Constructor to set base properties and initialize the account
    public Account(String name,String sSN,double initDeposit){
        this.name=name;
        this.sSN=sSN;
        this.balance=initDeposit;
        index++;
        this.accountNumber=setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2,sSN.length());
        int uniqueID = index;
        int rand3Digit =(int)(Math.random()*Math.pow(10,3));
        return lastTwoOfSSN+uniqueID+rand3Digit;
    }

    public void compound(){
        double accrude_interest = balance * (rate/100);
        balance=balance+accrude_interest;
        System.out.println("Accrude Interest : $"+accrude_interest);
        printBalance();
    }

    //List common methods - transactions
    public void deposit(double amount){
        balance = balance+amount;
        System.out.println("Depositing $"+amount);
        printBalance();
    };

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $"+amount);
        printBalance();
    };

    public void transfer(String toWhere,double amount){
        balance = balance-amount;
        System.out.println("Transferring $"+amount+" to "+toWhere );
        printBalance();
    };
    public void printBalance(){
        System.out.println("Your Balance is now : "+balance);
    }

    public  void showInfo(){
        System.out.println("Name : "+name+
                "\nSSN : "+sSN+
        "\nBalance : "+balance+
                "\nAccount Number : "+accountNumber+
        "\nRate : "+rate);
    };
}
