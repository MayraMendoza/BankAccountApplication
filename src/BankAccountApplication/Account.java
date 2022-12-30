package BankAccountApplication;


//Base class - Abstract.
//implementation to all the methods in a class. We want to leave the implementation to a class that extends it.
// In such case we declare a class as abstract. To make a class abstract we use key word abstract.
// any class that contains one or more abstract methods is declared as abstract.
// if we don't declare class as abstract which contains abstract methods we get compile time error.

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
    // no set balance because we can only change balance by deposit /withdrawls.
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
