package withus.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderPageItemVOTest {

	@Test
	void testOrderPageItemVO() {
		OrderPageItemVO ord = new OrderPageItemVO();
		
		assertNotNull(ord);
		
		ord.setProductNumber(1);
		ord.setPrice(1000);
		
		assertEquals(1, ord.getProductNumber());
		assertEquals(1000, ord.getPrice());
		
		System.out.println(ord.getProductNumber());
		System.out.println(ord);
	}

}
