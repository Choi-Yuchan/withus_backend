package withus.ex.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import withus.ex.mapper.OrderMapper;
import withus.ex.page.Criteria;
import withus.ex.vo.OrderPageItemVO;
import withus.ex.vo.OrderVO;

@SpringBootTest
class OrderServicelmplTest {

	@Autowired
	private OrderService orderService;

	@Test
	void testGetGoodsInfo() {
		System.out.println("Order Service" + orderService);
		System.out.println("Order List" + orderService.getOrderInfo());
		
		//반복문으로 리스트 불러오기
		for(OrderPageItemVO vo : orderService.getOrderInfo()) {
			System.out.println("Order: " + vo);
		}
	}
	
	
	@Test
	void testInsertItem() {
		int order_itemnumber = 1;
		int wid = 1;
		int wcount = 30;
		int onumber = 1;
		
		OrderVO order = new OrderVO();
		order.setOrder_itemnumber(order_itemnumber);
		order.setWid(wid);
		order.setWcount(wcount);
		order.setOnumber(onumber);
		
//		int result = 0;
//		try {
//			result = orderService.enrollItem(order);
//		} catch (Exception e) {
//			System.out.println("에러 발생");
//		}
//		
//		System.out.println("결과 : " + result);
	}
	
	
	
	@Test
	public void testGetOrderPaging() throws Exception{
		
		Criteria cri = new Criteria(1,10);	// 3페이지 & 10개 행 표시
		
		List<OrderPageItemVO> list = orderService.getListOrPaging(cri);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("list" + i + ".........." + list.get(i));
		}
		
	}
	
	

}
