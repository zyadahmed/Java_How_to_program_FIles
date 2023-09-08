import java.io.Serializable;

public class TransactionRecord implements Serializable {
    private int accountNumber;
    private double amount;
    public  TransactionRecord(int accountNumber,double amount){
        setAccountNumber(accountNumber);
        setAmount(amount);

    }

    private void setAccountNumber(int accountNumber) {
        if (accountNumber > 0)
            this.accountNumber = accountNumber;
        else
            throw new IllegalArgumentException("Account Number not valid");

    }

    private void setAmount(double amount) {
        if (amount > 0 )
        this.amount = amount;
        else
            throw  new IllegalArgumentException("Amount can not be negative");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Amount: " + amount;
    }
    public String failedToString(){
        return "Unmatched transaction record for account number: " + accountNumber + ", Amount: " + amount;
    }

}
