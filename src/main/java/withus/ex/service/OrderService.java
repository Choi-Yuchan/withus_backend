package withus.ex.service;

import java.util.List;

import withus.ex.page.Criteria;
import withus.ex.vo.OrderPageItemVO;
import withus.ex.vo.OrderVO;

public interface OrderService {

	/* 주문 정보 */
	public List<OrderPageItemVO> getOrderInfo();
	
	void enrollItem(OrderVO order); //바로구매 
	
	//페이징처리
	public int getTotal();
	public List<OrderPageItemVO> getListOrPaging(Criteria cri);
}
