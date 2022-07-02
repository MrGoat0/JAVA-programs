package account;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AccountCurrentTest {
    private AccountCurrent account;
    private void setup(){
        account = new AccountCurrent("123-456", LocalDate.of(2015, Month.DECEMBER, 15), 300_000, 200_000);
    }

    @Test
    void withDraw() {
        setup();
        assertTrue(account.withDraw(350_000));
        assertEquals(-50_000, account.getBalance());
        assertFalse(account.withDraw(200_000));
    }
}