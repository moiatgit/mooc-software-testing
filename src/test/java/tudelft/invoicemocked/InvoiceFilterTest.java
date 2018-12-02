package tudelft.invoicemocked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class InvoiceFilterTest {
    @Test
    void filterInvoices() {

        Invoice mauricio = new Invoice("Mauricio", 20.0);
        Invoice arie = new Invoice("Arie", 300.0);
        Invoice moises = new Invoice("Moises", 23.0);

        InvoiceDao dao = Mockito.mock(InvoiceDao.class);

        List<Invoice> results = Arrays.asList(mauricio, arie, moises);
        Mockito.when(dao.all()).thenReturn(results);

        InvoiceFilter filter = new InvoiceFilter(dao);
        List<Invoice> result = filter.filter();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(mauricio, result.get(0));
        Assertions.assertEquals(moises, result.get(1));
    }

}
