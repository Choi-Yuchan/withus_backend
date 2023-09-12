package withus.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.OrderMapper;
import withus.ex.vo.OrderPageItemVO;

@Slf4j
@Service
public class OrderServicelmpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<OrderPageItemVO> getOrderInfo() {
		return orderMapper.getGoodsInfo();
	}

	


	


	

}
