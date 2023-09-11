package withus.ex.service;

import java.util.List;

import withus.ex.vo.OrderPageItemVO;

public interface OrderService {

	/* 주문 정보 */
	public List<OrderPageItemVO> getGoodsInfo();
	

}
