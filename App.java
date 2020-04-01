
/************************************************************/
/*Program:  Chp-8_Saving_Account_Class                      */
/*CIS163AA                                                  */
/*Edward Muniz                                              */
/*2020-03-30                                                */
/*Practice with Java!                                       */
/************************************************************/
import java.text.DecimalFormat;

public class App {
    public static void main(String[] args) throws Exception {
        // instantiate two savingsAccount objects as saver1 and saver2
        SavingAccount saver1 = new SavingAccount(2000.00);
        SavingAccount saver2 = new SavingAccount(3000.00);
        // set annualInterestRate to 4%
        saver1.modifyInterestRate(.04);
        saver2.modifyInterestRate(.04);
        // creating decimal formatter object
        DecimalFormat df = new DecimalFormat("#.00");
        // some space for our table
        System.out.print("\n\n");
        // ouput message
        System.out.println("Monthly balances for one year at 4%");
        System.out.println("Balances:");
        // table headers
        System.out.format("%15s", "");
        System.out.format("%15s", "Saver 1");
        System.out.format("%15s", "Saver 2\n");
        // initial balances
        System.out.format("%15s", "Base:");
        System.out.format("%15s", df.format(saver1.getSavingsBalance()));
        System.out.format("%15s", df.format(saver2.getSavingsBalance()) + "\n");
        // calculate the monthly interest for each of 12 months and print the new
        // balances for both savers
        for (int i = 1; i <= 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.format("%15s", "Month " + i);
            System.out.format("%15s", df.format(saver1.getSavingsBalance()));
            System.out.format("%15s", df.format(saver2.getSavingsBalance()) + "\n");
        }
        // some space for our table
        System.out.print("\n\n");
        // set the annualInterestRate to 5%, calculate the next month’s interest
        saver1.modifyInterestRate(.05);
        saver2.modifyInterestRate(.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        // message output
        System.out.println("After setting interest rate to 5% and calculating intrest balances for Month 13");
        // print the new balances for both savers.
        System.out.format("%15s", "Saver 1");
        System.out.format("%15s", "Saver 2\n");
        System.out.format("%15s", df.format(saver1.getSavingsBalance()));
        System.out.format("%15s", df.format(saver2.getSavingsBalance()) + "\n");

    }
}

public class SavingAccount {
    private static Double annualInterestRate;
    private Double savingsBalance;

    // constructor
    public SavingAccount(Double initBalance) {
        savingsBalance = initBalance;
    }

    // method to calculate interest and add to savingsBalance
    public void calculateMonthlyInterest() {
        savingsBalance += savingsBalance * annualInterestRate / 12;
    }

    // set method for the interest rate
    public void modifyInterestRate(Double newVal) {
        annualInterestRate = newVal;
    }

    // get method for the interest rate
    public Double getInterestRate() {
        return annualInterestRate;
    }

    // get method for savings balance
    public Double getSavingsBalance() {
        return savingsBalance;
    }
}