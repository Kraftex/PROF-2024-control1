package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void testGetHighestBalanceUsingMock () throws NoAccountsException {
        final Account[] accounts = {
            mock(Account.class),
            mock(Account.class),
            mock(Account.class),
            mock(Account.class)
        };
        when(accounts[0].getAccountNumber()).thenReturn("1234-7890");
        when(accounts[0].getCurrentBalance()).thenReturn(300.23f);
        when(accounts[1].getAccountNumber()).thenReturn("4321-0987");
        when(accounts[1].getCurrentBalance()).thenReturn(900f);
        when(accounts[2].getAccountNumber()).thenReturn("qwer-0983");
        when(accounts[2].getCurrentBalance()).thenReturn(0.0f);
        when(accounts[3].getAccountNumber()).thenReturn("8763-kjsd");
        when(accounts[3].getCurrentBalance()).thenReturn(.5f);
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
