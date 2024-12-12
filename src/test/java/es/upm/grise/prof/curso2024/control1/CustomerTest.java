package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class CustomerTest {

    @Test
    public void testThrowErrorNoAccount () {
        final Customer customer = new Customer();
        assertThrows(
                NoAccountsException.class,
                () -> customer.getAccountWithHighestBalance(),
                "An exception must be thrown!"
        );
    }

    @Test
    public void testGetHighestBalance () throws NoAccountsException {
        final Account[] accounts = {
            new Account("1234-7890", 300.23f),
            new Account("4321-0987", 900f),
            new Account("qwer-0983", 0.0f),
            new Account("8763-kjsd", .5f)
        };
        final List<Account> accsList = Arrays.asList(accounts);
        final Account MAX_BALANCE_ACC = accsList.stream()
                                        .max(Comparator.comparing(Account::getCurrentBalance))
                                        .orElseThrow(NoSuchElementException::new);
        final Customer customer = new Customer();
        customer.setAccounts(accsList);
        assertEquals(MAX_BALANCE_ACC.getAccountNumber(), customer.getAccountWithHighestBalance(),
                "The number of the maximum balance must be provide.");
    }
}
