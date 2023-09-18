package withus.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import withus.ex.mapper.CartMapper;
import withus.ex.mapper.OrderMapper;
import withus.ex.mapper.UserMapper;
import withus.ex.vo.CartVO;
import withus.ex.vo.OrderPageItemVO;
import withus.ex.vo.OrderVO;
import withus.ex.vo.UsersVO;

@Slf4j
@Service
public class OrderServicelmpl implements OrderService{
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<OrderPageItemVO> getOrderInfo() {
		return orderMapper.getGoodsInfo();
	}

			
			
		



	


	

}
