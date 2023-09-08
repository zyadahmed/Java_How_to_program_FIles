import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FIleHandler {
    public static void writeAccounts(List<Account> accounts, String filename) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename))) ;
            for (Account account: accounts) {
                outputStream.writeObject(account);
            }

    }
    public  static void writeTransactions(List<TransactionRecord> transactionRecords, String filename) throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename))) ;
        for (TransactionRecord transaction: transactionRecords) {
            outputStream.writeObject(transaction);
        }
    }
    public static List<Account> readAccounts(String filename) throws IOException, ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            while (true) {
                try {
                        Account account = (Account) inputStream.readObject();
                        accounts.add(account);

                } catch (EOFException e) {
                  break;
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    public static List<TransactionRecord> readTransactions(String filename) throws IOException, ClassNotFoundException {
        List<TransactionRecord> transactionRecords = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            while (true) {
                try {
                        TransactionRecord transaction = (TransactionRecord) inputStream.readObject();
                        transactionRecords.add(transaction);

                } catch (EOFException e) {
                    break;
                }
            }
        }
        return transactionRecords;
    }

}
