package account;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ManagentAccountTest {
    private ManagentAccount mngAccount;
    private void setup(){
        mngAccount = new ManagentAccount();
        mngAccount.addAccount(new AccountDeposit("123-456", LocalDate.of(2017, Month.DECEMBER, 16), 100_000,  2.0, true));
        mngAccount.addAccount(new AccountCurrent("159-753", LocalDate.of(2016, Month.DECEMBER, 16), 500_000,  200_000));
    }
    @Test
    void findAccount() {
        setup();
        assertEquals(2, mngAccount.getAccounts().size());
        assertNotNull(mngAccount.findAccount("123-456"));
        assertNotNull(mngAccount.findAccount("159-753"));
        assertNull(mngAccount.findAccount("456-789"));
        assertEquals("123-456", mngAccount.findAccount("123-456").getNumber());

    }

    @Test
    void addAccount() {
        setup();
        mngAccount.addAccount(new AccountDeposit("123-456", LocalDate.of(2017, Month.DECEMBER, 16), 100_000,  2.0, true));
        assertEquals(3, mngAccount.getAccounts().size());
    }

    @Test
    void deposit() {
        setup();
        mngAccount.deposit(mngAccount.findAccount("123-456"), 150_000);
        assertEquals(250_000, mngAccount.findAccount("123-456").getBalance());
    }

    @Test
    void withDraw() {
        setup();
        //pruebas cuentas de deposito
        assertFalse(mngAccount.withDraw(mngAccount.findAccount("123-456"), 60_000));
        assertTrue(mngAccount.withDraw(mngAccount.findAccount("123-456"), 10_000));
        assertEquals( 90_000, mngAccount.findAccount("123-456").getBalance());

        //pruebas cuentas corrientes
        assertFalse(mngAccount.withDraw(mngAccount.findAccount("159-753"), 700_001));
        assertTrue(mngAccount.withDraw(mngAccount.findAccount("159-753"), 700_000));
        assertEquals(-200_000, mngAccount.findAccount("159-753").getBalance());
    }

    @Test
    void transferAccount() {
        setup();
        AccountDeposit account = new AccountDeposit("456-789", LocalDate.of(2018, Month.DECEMBER, 16), 300_000,  2.0, true);
        AccountDeposit target = (AccountDeposit) mngAccount.findAccount("123-456");
        assertTrue(mngAccount.transferAccount(account, target, 80_000));
        assertEquals(180_000, mngAccount.findAccount("123-456").getBalance());
        assertEquals(220_000, account.getBalance());
    }
}