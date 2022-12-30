package BankAccountApplication;

//checking Account (Child class of account).
public class CheckingAccount extends Account {

    //default free (for transaction)
    private static double Fee =2.5;
    
    //default constructor 
    public CheckingAccount(){
        super();
    }

    /**
     *
     * parameter constructor to initialize checkingAccount
     * with a account number and transaction fee.
     *
     */
    public CheckingAccount(int accountNumber, double fee){
        super(accountNumber);
        Fee=fee;

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
            // add transaction fee
            balance -= Fee;
            System.out.printf("Fee %.2f applied: %n", Fee);
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
            if((amount+Fee)<= balance ){
                System.out.printf("Amount %.2f withdrawn from account%n", amount);
                balance -= amount;
                balance -= Fee;
                System.out.printf("Fee of %.2f applied", Fee);
                System.out.printf("Current Balance is: %.2f%n", balance);
            }

        }else{
            System.out.print("A negative amount cannot be withdrawn");
        }

    }
}
