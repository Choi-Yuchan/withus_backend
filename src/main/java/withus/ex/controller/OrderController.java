package withus.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.OrderService;
import withus.ex.vo.OrderPageVO;

@Slf4j
@Controller
@RequestMapping("/product/*")
public class OrderController{
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/{user_number}")
	public String orderPageGET(@PathVariable("user_number") String user_number,OrderPageVO opd, Model model) {
		log.info("orderPageGET() ..");
		
		model.addAttribute("orderList", orderService.getGoodsInfo(opd.getOrders()));
		
		return "/order";//
	}
}
