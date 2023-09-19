package withus.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.OrderMapper;
import withus.ex.page.Criteria;
import withus.ex.vo.OrderPageItemVO;
import withus.ex.vo.OrderVO;

@Slf4j
@Service
public class OrderServicelmpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<OrderPageItemVO> getOrderInfo() {
		return orderMapper.getGoodsInfo();
	}

	@Override
	public void enrollItem(OrderVO order) {
		orderMapper.insertItem(order);
	}

	@Override
	public int getTotal() {
		return orderMapper.getTotalCount();
	}

	@Override
	public List<OrderPageItemVO> getListOrPaging(Criteria cri) {
		return orderMapper.getOrderPaging(cri);
	}

	


	


	

}
