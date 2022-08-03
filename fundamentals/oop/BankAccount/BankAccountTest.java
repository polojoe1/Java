public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account1= new BankAccount();
        account1.depositChecking(100.0);
        account1.depositSavings(200.0);
        account1.status();
    }
}
