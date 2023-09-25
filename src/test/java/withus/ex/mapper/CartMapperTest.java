package withus.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.service.CartService;
import withus.ex.vo.CartVO;
import withus.ex.vo.OrderPageItemVO;
import withus.ex.vo.OrderVO;

@SpringBootTest
class CartMapperTest {
	
	@Autowired
	private CartMapper cartMapper;

	
	@Test
	void testListCart() {
		System.out.println("Cart Mapper" + cartMapper);
		System.out.println("Cart List" + cartMapper.listCart());
		
		//반복문으로 리스트 불러오기
		for(CartVO vo : cartMapper.listCart()) {
			System.out.println("Cart: " + vo);
		}
	}
	
	
	
	
	@Test
	void testAddCart() {
		int cnumber = 1;
		int wid = 1;
		int wcount = 1;
		
		CartVO cart = new CartVO();
		cart.setCnumber(cnumber);
		cart.setWid(wid);
		cart.setWcount(wcount);
		
		int result = 0;
		try {
			CartVO cartItem = null;
			result = cartMapper.addCart(cartItem);
		} catch (Exception e) {
			System.out.println("에러 발생");
		}
		
		System.out.println("결과 : " + result);
	}
	
	
	@Test
	void testDeleteCart() {
		CartVO cart = new CartVO();
		int userNumber = 1;
		cartMapper.deleteCart(cart);
		
	}

}
