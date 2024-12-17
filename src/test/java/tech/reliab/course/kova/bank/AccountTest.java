import bank.entity.Account;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testAccountInitialization() {
        Account account = new Account("123456789", 1000.0);

        assertEquals("123456789", account.getAccountNumber(), "Номер счета должен совпадать");
        assertEquals(1000.0, account.getBalance(), 0.001, "Баланс должен совпадать");
    }

    @Test
    public void testBalanceUpdate() {
        Account account = new Account();
        account.setBalance(500.0);

        assertEquals(500.0, account.getBalance(), 0.001, "Баланс должен быть обновлен");
    }

    @Test
    public void testAccountNumberSetter() {
        Account account = new Account();
        account.setAccountNumber("987654321");

        assertEquals("987654321", account.getAccountNumber());
    }
}
