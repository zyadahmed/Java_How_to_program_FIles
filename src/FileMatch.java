import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileMatch {
    public static void chechking(String oldfile, String newFile, String transactionFile, String logFile) {
        PrintWriter logData = null;

        try {
            if (!Files.exists(Paths.get(newFile))) {
                Files.createFile(Paths.get(newFile));
            }

            List<Account> master = FIleHandler.readAccounts(oldfile);
            List<TransactionRecord> transactionRecords = FIleHandler.readTransactions(transactionFile);
            List<Account> newData = new ArrayList<>();
            logData = new PrintWriter(new File(logFile));

            for (TransactionRecord transactionRecord : transactionRecords) {
                int accountNum = transactionRecord.getAccountNumber();
                Account matched = null;
                boolean exist = false;

                for (Account account : master) {
                    if (account.getAccountNumber() == accountNum) {
                        account.combine(transactionRecord);
                        exist = true;
                        matched = account;
                        break;
                    }
                }

                if (matched != null) {
                    newData.add(matched);
                }

                if (!exist) {
                    logData.println(transactionRecord.failedToString());
                }
            }
            FIleHandler.writeAccounts(newData,newFile);


        } catch (EOFException e) {
            System.out.println("Reached end of file.");
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            if (logData != null) {
                logData.close();
            }
        }
    }
}
