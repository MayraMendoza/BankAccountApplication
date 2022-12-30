package BankAccountApplication;
//child class
// interest rate
// a method to apply interest
public class SavingsAccount extends Account {
    //interest rare
    private double interestRate;

    //default free (for transaction)
    private static double Fee =2.5;

    //default constructor
    public SavingsAccount(){
        super();
    }

    /**
     *
     * parameter constructor to initialize savings account
     * with a custom account number and interest rate.
     *
     */
    public SavingsAccount(int accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate= interestRate;


    }

    public double getInterestRate(){
        return this.interestRate;
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public double calculateInterest(){
        return balance * interestRate;
    }

    public void applyInterest(){
       double interest = calculateInterest();
       System.out.printf("Interest amount %.2f added to balance%n", interest );
       deposit(interest);
    }

    /**
     * Function to deposit funds into the account as long as the amount parameter is greater than 0
     *Apply transaction fee for checkingAccount
     *  @param amount value to be deposited
     *
     */
    public void deposit (double amount){
        //check amount
        if(amount <0) {
            System.out.println("A negative amount cannot be deposited ");
        }else{
            balance+= amount;
            System.out.printf("Amount %.2f deposited %n", amount);
            System.out.printf("Current %.2f balance: %n", balance);



        }

    }


    /**
     * Function to withdraw funds from the account as long as
     * 1.amount to withdraw must be greater than 0
     * 2. Amount to withdraw must be less than or equal to balance
     * (no overdrafts)
     * @param amount value to be withdrawn
     *
     */
    public void withdraw(double amount){

        //check amount is greater than 0
        if(amount >0){
            // check if there is a sufficient balance
            if((amount)<= balance ){
                System.out.printf("Amount %.2f withdrawn from account%n", amount);
                balance -= amount;
                System.out.printf("Current Balance is: %.2f%n", balance);
            }

        }else{
            System.out.print("A negative amount cannot be withdrawn");
        }

    }
}
