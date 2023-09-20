package withus.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class VOTest {
	
	//OrderVO Test
	@Test
	void testOrderVO() {
		OrderVO ord = new OrderVO();
		assertNotNull(ord);
		
		ord.setOrder_itemnumber(1);
		ord.setWid(100);
		ord.setWcount(10);
		ord.setOnumber(1);
		
		assertEquals(1, ord.getOrder_itemnumber());
		assertEquals(100, ord.getWid());
		assertEquals(10, ord.getWcount());
		assertEquals(1, ord.getOnumber());
		
		System.out.println(ord);
		System.out.println(ord.getOrder_itemnumber());
		System.out.println(ord.getWid());
		System.out.println(ord.getWcount());
		System.out.println(ord.getOnumber());
		
	}
	
	//letterVO Test
	@Test
	void testLetterVO() {
		LetterVO letter = new LetterVO();
		
		assertNotNull(letter);
		
		letter.setWid(100);
		letter.setWname("홍길동");
		letter.setWprice(10000);
		letter.setWdetailed("이 편지는 영국에서 시작됐고,");
		
		assertEquals(100, letter.getWid());
		assertEquals("홍길동", letter.getWname());
		assertEquals(10000, letter.getWprice());
		assertEquals("이 편지는 영국에서 시작됐고,", letter.getWdetailed());
		
		System.out.println(letter);
		System.out.println(letter.getWid());
		System.out.println(letter.getWname());
		System.out.println(letter.getWprice());
		System.out.println(letter.getWdetailed());
		
	}
	
	//letterImgVO Test
	@Test
	void testLetterImgVO() {
		LetterImgVO image = new LetterImgVO();
		assertNotNull(image);
		
		image.setUuid(100);
		image.setWid(100);
		image.setFilename("100.jpg");
		image.setUploadpath("c://user/user/image");
		
		assertEquals(100, image.getUuid());
		assertEquals(100, image.getWid());
		assertEquals("100.jpg", image.getFilename());
		assertEquals("c://user/user/image", image.getUploadpath());
		
		System.out.println(image);
		System.out.println(image.getUuid());
		System.out.println(image.getWid());
		System.out.println(image.getFilename());
		System.out.println(image.getUploadpath());
		
	}
	
	//OrderPageItemVO Test
	@Test
    void testOrderPageItemVO() {
        OrderPageItemVO order = new OrderPageItemVO();
        assertNotNull(order);
        order.setOrder_itemnumber(100);
        order.setWid(100);
        order.setWname("청첩장100");
        order.setWprice(1000);
        order.setWcount(30);
        order.setTotal_price(30000);
        order.setOnumber(1);
        
        assertEquals(100, order.getOrder_itemnumber());
        assertEquals(100, order.getWid());
        assertEquals("청첩장100", order.getWname());
        assertEquals(1000, order.getWprice());
        assertEquals(30, order.getWcount());
        assertEquals(30000, order.getTotal_price());
        assertEquals(1, order.getOnumber());
        
        System.out.println(order);
        System.out.println(order.getOrder_itemnumber());
        System.out.println(order.getWid());
        System.out.println(order.getWname());
        System.out.println(order.getWprice());
        System.out.println(order.getWcount());
        System.out.println(order.getTotal_price());
        System.out.println(order.getOnumber());
    }
	
	//CartVO Test
	@Test
	void testCartVO() {
		CartVO cart = new CartVO();
		assertNotNull(cart);
		
		cart.setCnumber(123);
		cart.setUserNumber(1);
		cart.setWid(100);
		cart.setWcount(30);
		cart.setWname("청첩장100");
		cart.setWprice(1000);
		cart.setTotal_price(30000);
		
		assertEquals(123, cart.getCnumber());
		assertEquals(1, cart.getUserNumber());
		assertEquals(100, cart.getWid());
		assertEquals(30, cart.getWcount());
		assertEquals("청첩장100", cart.getWname());
		assertEquals(1000, cart.getWprice());
		assertEquals(30000, cart.getTotal_price());
		
		System.out.println(cart);
		System.out.println(cart.getCnumber());
		System.out.println(cart.getUserNumber());
		System.out.println(cart.getWid());
		System.out.println(cart.getWcount());
		System.out.println(cart.getWname());
		System.out.println(cart.getWprice());
		System.out.println(cart.getTotal_price());
	}
	
	//UsersVO Test
	@Test
	void testUsersVO() throws ParseException {
		UsersVO users = new UsersVO();
		assertNotNull(users);
		users.setUserNumber(1000);
		users.setUserName("홍길동");
		users.setUserId("globalin123");
		users.setPassword("globalin123");
		users.setPhoneNumber("010-1234-5678");
		users.setAddr1("서울시");
		users.setAddr2("동작구 대방동");
		users.setAddr3("여의대방로 44길 10");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = dateFormat.parse("2023-09-20");
        users.setBirth(birthDate);
		users.setGender("남");
		
		assertEquals(1000, users.getUserNumber());
		assertEquals("홍길동", users.getUserName());
		assertEquals("globalin123", users.getUserId());
		assertEquals("globalin123", users.getPassword());
		assertEquals("010-1234-5678", users.getPhoneNumber());
		assertEquals("서울시", users.getAddr1());
		assertEquals("동작구 대방동", users.getAddr2());
		assertEquals("여의대방로 44길 10", users.getAddr3());
		assertEquals(birthDate, users.getBirth());
		assertEquals("남", users.getGender());
		
		System.out.println(users);
		System.out.println(users.getUserNumber());
		System.out.println(users.getUserName());
		System.out.println(users.getUserId());
		System.out.println(users.getPassword());
		System.out.println(users.getPhoneNumber());
		System.out.println(users.getAddr1());
		System.out.println(users.getAddr2());
		System.out.println(users.getAddr3());
		System.out.println(users.getBirth());
		System.out.println(users.getGender());
	}
	
	//AuthVO Test
	@Test
	void testAuthVO() {
		AuthVO auth = new AuthVO();
		assertNotNull(auth);
		auth.setUserNumber(11);
		auth.setAuthority("ROLE_USER");
		
		assertEquals(11, auth.getUserNumber());
		assertEquals("ROLE_USER", auth.getAuthority());
		
		System.out.println(auth);
		System.out.println(auth.getUserNumber());
		System.out.println(auth.getAuthority());
	}
	
	
	
	

}
