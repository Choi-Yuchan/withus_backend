package withus.ex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.GetUserInfoService;
import withus.ex.service.OrderService;
import withus.ex.vo.OrderPageItemVO;
import withus.ex.vo.OrderPageVO;
import withus.ex.vo.UsersVO;

@CrossOrigin("http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/product/*")
public class OrderController{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private GetUserInfoService getUserInfoService;
	
	@GetMapping("/order/{userNumber}")
	public List<OrderPageItemVO> orderPageGET(@PathVariable("userNumber") int userNumber) {
		List<OrderPageItemVO> orderpage = orderService.getGoodsInfo();
		
		return orderpage;//
	}
}
