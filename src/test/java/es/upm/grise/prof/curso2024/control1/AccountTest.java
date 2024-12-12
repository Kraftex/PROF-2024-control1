package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AccountTest {
    @Test
    public void testGetCurrentBalance () {
        final Transaction[] transactions = {
        		mock(Transaction.class),
        		mock(Transaction.class),
        		mock(Transaction.class)
        };
        when(transactions[0].getAmount()).thenReturn(500f);
        when(transactions[1].getAmount()).thenReturn(540f);
        when(transactions[2].getAmount()).thenReturn(-340f);
        final List<Transaction> transacsList = Arrays.asList(transactions);

        final float currentBalance = (float) transacsList.stream().mapToDouble(Transaction::getAmount).sum();
        final Account acc = new Account("ramon-cajal", 0f);
        assertEquals(currentBalance, acc.getCurrentBalance(), "The balance would be the sum of the transactions!");
    }
}
