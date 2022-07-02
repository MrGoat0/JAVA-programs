package account;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ControllTest {
    private Controll controll;
    private void setup(){
        controll = new Controll();
        controll.addAccount("123-456", LocalDate.of(2010, Month.DECEMBER, 21), 100_000, 2.0, true );
        controll.addAccount("456-789", LocalDate.of(2010, Month.DECEMBER, 21), 500_000, 200_000 );

    }

    @Test
    void deposit() {
        setup();
        assertFalse(controll.deposit("159-753", 50_000));
        assertTrue(controll.deposit("123-456", 50_000));
        Object[] account = controll.findAccount("123-456");
        assertEquals(150_000.0, account[2]);
        assertTrue(controll.deposit("456-789", 100_000));
        Object[] account2 = controll.findAccount("456-789");
        assertEquals(600_000.0, account2[2]);

    }

    @Test
    void findAccount() {
        setup();
        assertEquals(5, controll.findAccount("123-456").length);
        assertEquals(4, controll.findAccount("456-789").length);
        assertNull(controll.findAccount("159-753"));
    }

    @Test
    void addAccount() {
        setup();


    }

    @Test
    void testAddAccount() {
    }

    @Test
    void withDraw() {
    }

    @Test
    void transferAccount() {
    }
}