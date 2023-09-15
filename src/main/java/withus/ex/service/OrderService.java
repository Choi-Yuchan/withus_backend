package withus.ex.service;

import java.util.List;

import withus.ex.vo.OrderPageItemVO;
import withus.ex.vo.OrderVO;

public interface OrderService {

	/* 주문 정보 */
	public List<OrderPageItemVO> getOrderInfo();
	
}
