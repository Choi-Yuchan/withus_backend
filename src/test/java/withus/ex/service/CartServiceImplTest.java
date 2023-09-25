package withus.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.vo.CartVO;
import withus.ex.vo.OrderPageItemVO;

@SpringBootTest
class CartServiceImplTest {
	
	@Autowired
	private CartService cartService;

	@Test
	void testGetCartList() {
		System.out.println("Cart Service" + cartService);
		System.out.println("Cart List" + cartService.getCartList());
		
		//반복문으로 리스트 불러오기
		for(CartVO vo : cartService.getCartList()) {
			System.out.println("Cart: " + vo);
		}
	}
	
	@Test
	void testAddCart() {
		assertNotNull(cartService);
		
		CartVO cart = new CartVO();
		cart.setCnumber(1);
		cart.setWid(1);
		cart.setWcount(30);
		
		assertEquals(1, cart.getCnumber());
		assertEquals(1, cart.getWid());
		assertEquals(30, cart.getWcount());
	}
	
	@Test
	void testRemove() {
		CartVO cart = new CartVO();
		int userNumber = 1;
		cartService.remove(cart);
		
	}

}
