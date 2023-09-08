import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String oldMasterFile = "oldmast.txt";
        String transactionFile = "trans.txt";
        String newMasterFile = "newmast.txt";
        String logFile = "log.txt";

        List<Account> accounts =  new java.util.ArrayList<>();
        accounts.add(new Account(100, 1500, "Ziad Ahmed"));
        accounts.add(new Account(101, 1500, "mo Ahmed"));

        List<TransactionRecord> transactionRecords =  new java.util.ArrayList<>();
        transactionRecords.add(new TransactionRecord(100, 70));
        transactionRecords.add(new TransactionRecord(100, 40));
        transactionRecords.add(new TransactionRecord(20,500));

        try {
            FIleHandler.writeAccounts(accounts, oldMasterFile);
            FIleHandler.writeTransactions(transactionRecords, transactionFile);

            List<Account> readAccounts = FIleHandler.readAccounts(oldMasterFile);
            System.out.println("Accounts:");
            for (Account account : readAccounts) {
                System.out.println(account);
            }

            List<TransactionRecord> readTransactions = FIleHandler.readTransactions(transactionFile);
            System.out.println("Transactions:");
            for (TransactionRecord transaction : readTransactions) {
                System.out.println(transaction);
            }

            FileMatch.chechking(oldMasterFile, newMasterFile, transactionFile, logFile);

            List<Account> newMasterAccounts = FIleHandler.readAccounts(newMasterFile);
            System.out.println("New Master Accounts:");
            for (Account account : newMasterAccounts) {
                System.out.println(account);
            }

            List<String> logData = Files.readAllLines(Paths.get(logFile));
            System.out.println("Log Data:");
            for (String log : logData) {
                System.out.println(log);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
