package BankAccountApplication;

import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create an array of accounts
        Account accounts [ ] =  new Account[10];
        int numberOfAccounts=0;

        int userResponse;
        do{
            userResponse= menu(scanner);
            System.out.println();


            if (userResponse ==1){
                accounts[numberOfAccounts++]= createAccount(scanner);



            } else if(userResponse==2){
                deposits(accounts, numberOfAccounts, scanner);

            } else if ( userResponse ==3){
                withdraw(accounts, numberOfAccounts, scanner);
            }else if(userResponse ==4){
                applyInterest(accounts, numberOfAccounts, scanner );
            }else{
                System.out.println("Have a nice day! goodbye.");
            }
            System.out.println();
        }while(userResponse!=5);

        }

    /**
     * Account choice
     * @param scanner
     * @return choice
     */
    public static int accountMenu(Scanner scanner){
        System.out.println("SelectAccount Type");
        System.out.println("1. Checking Account");
        System.out.println("2. savings Account");

        int userResponse;
        do{
            System.out.print("Enter choice: ");
            userResponse = scanner.nextInt();

        }while(userResponse<1 || userResponse>2);
        return userResponse;


    }
    public static int searchAccount(Account accounts[], int count, int accountNumber ){

        for(int i=0; i<count; i++){
            if(accounts[i].getAccountNumber() == accountNumber){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * function to perform deposit on user selected account.
     */
    public static void deposits(Account accounts [], int count, Scanner scanner){
        // get account number
        System.out.print("\n Please enter account number: ");
        int accountNumber = scanner.nextInt();

        // search for Account
        int index = searchAccount(accounts, count, accountNumber);

        if(index>=0 ){
            //Amount
            System.out.print("Please enter deposit amount: ");
            double amount = scanner.nextDouble();

            accounts[index].deposit(amount);

        }else {
            System.out.println("No account exists with account Number:" + accountNumber  );
        }

    }

    /**
     *
     * function is going to search for account number (find index)
     * then it will withdraw amount.
     */
    public static void withdraw(Account accounts[], int count, Scanner scanner){
        // get account number
        System.out.print("\n Please enter account number: ");
        int accountNumber = scanner.nextInt();

        // search for Account
        int index = searchAccount(accounts, count, accountNumber);

        if(index>=0 ){
            //Amount
            System.out.print("Please enter withdraw amount: ");
            double amount = scanner.nextDouble();

            accounts[index].withdraw(amount);

        }else {
            System.out.println("No account exists with account Number:" + accountNumber  );
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner scanner){
        // get account number
        System.out.print("\n Please enter account number: ");
        int accountNumber = scanner.nextInt();

        // search for Account
        int index = searchAccount(accounts, count, accountNumber);

        if(index>=0 ){
            //Amount

            if(accounts[index] instanceof SavingsAccount){
                ((SavingsAccount)accounts[index]).applyInterest();
            }



        }else {
            System.out.println("No account exists with account Number:" + accountNumber  );
        }

    }





    public static Account createAccount(Scanner scanner){
        Account account = null;
        int userResponse = accountMenu(scanner);

        int accountNumber;
        System.out.print("Enter Account Number: ");
        accountNumber = scanner.nextInt();

        if(userResponse ==1){
            //user picked checkings account
            System.out.print("Enter transaction Fee: ");
            double fee = scanner.nextDouble();

            account = new CheckingAccount(accountNumber, fee);


        }else {
            //user picked savings account
            System.out.print("Please enter interest Rate: ");
            double interestRate = scanner.nextDouble();
            account = new SavingsAccount(accountNumber, interestRate);

        }
        return account;

    }

    /**
     * Menu display
     * get user selection
     * @param scanner
     * @return userResponse
     */

    public static int menu(Scanner scanner ){
        System.out.println("Bank Account Menu");
        System.out.println("1. create new account ");
        System.out.println("2. deposit funds");
        System.out.println("3. withdraw funds");
        System.out.println("4. Apply Interest");
        System.out.println("5.quit");

        int userResponse;

        do {
            System.out.print("Enter Choice: :");
            userResponse = scanner.nextInt();
        }while(userResponse <1|| userResponse>5);
        return userResponse;



    }
}
