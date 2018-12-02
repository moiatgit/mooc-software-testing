package tudelft.discount;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DiscountApplierTest {
	
	@Test
	public void properDiscountOnHomeCategory() {
		Product homeProduct = new Product("p1", 100, "HOME");
		double homeExpected = 90.0;
		ProductDao dao = Mockito.mock(ProductDao.class);
		Mockito.when(dao.all()).thenReturn(Arrays.asList(homeProduct));
		new DiscountApplier(dao).setNewPrices();
		double homeActual = homeProduct.getPrice();
		Assertions.assertEquals(homeExpected,homeActual, 0.000001);
	}

	
	@Test
	public void properDiscountOnBusinessCategory() {
		Product businessProduct = new Product("p2", 100, "BUSINESS");
		double businessExpected = 110.0;
		ProductDao dao = Mockito.mock(ProductDao.class);
		Mockito.when(dao.all()).thenReturn(Arrays.asList(businessProduct));
		new DiscountApplier(dao).setNewPrices();
		double businessActual = businessProduct.getPrice();
		Assertions.assertEquals(businessExpected,businessActual, 0.000001);
	}
	
}
