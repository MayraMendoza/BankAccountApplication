package BankAccountApplication;

//checking Account
public class CheckingAccount extends Account {
    //Abstract method -are those types of methods that do not require implementation for declaration.

    /**
     * Function to deposit funds into the account as long as the amount parameter is greater than 0
     *Apply transaction fee for checkingAccount
     *  @param amount value to be deposited
     *
     */
    public void deposit (double amount){

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

    }
}
