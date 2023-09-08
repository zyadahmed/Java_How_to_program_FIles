import java.io.Serializable;

public class Account implements Serializable {
    private int accountNumber;
    private double balance;
    private String name;
    public Account(int accountNumber,  double balance , String name) {
        setAccountNumber(accountNumber);
        setBalance(balance);
        this.name = name;


    }

    private void setAccountNumber(int accountNumber) {
        if (accountNumber > 0)
            this.accountNumber = accountNumber;
        else
            throw new IllegalArgumentException("Account Number not valid");

    }

    private void setBalance(double balance) {
        if (balance > 0 )
            this.balance = balance;
        else
            throw  new IllegalArgumentException("balance can not be negative");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Name: " + name + ", Balance: " + balance;
    }
    public void combine(TransactionRecord transaction) {
        this.balance += transaction.getAmount();
    }
}
