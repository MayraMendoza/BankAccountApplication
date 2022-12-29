package BankAccountApplication;


//Base class
//abstract
public abstract class Account {

    //Account Number
    public int accountNumber;

    //Balance
    //A protected keyword is an access modifier used for attributes, methods and constructors,
    //making them accessible in the same package and subclass.
    protected double balance;

    // Default constructor - initialize the attributes of the object with their default values
    public Account(){

    }

    public Account(int accountNumber){
        this.accountNumber= accountNumber;
        balance=0;

    }
    //getter methods
    public double getBalance(){
        return this.balance;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    //Abstract method -are those types of methods that do not require implementation for declaration.

    /**
     * Function to deposit funds into the account as long as the amount parameter is greater than 0
     *Apply transaction fee for checkingAccount
     *  @param amount value to be deposited
     *
     */
    public abstract void deposit (double amount);


    /**
     * Function to withdraw funds from the account as long as
     * 1.amount to withdraw must be greater than 0
     * 2. Amount to withdraw must be less than or equal to balance
     * (no overdrafts)
     * @param amount value to be withdrawn
     *
     */
    public abstract void withdraw(double amount);

}
