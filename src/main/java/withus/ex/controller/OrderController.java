package withus.ex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.page.Criteria;
import withus.ex.page.PageVO;
import withus.ex.service.CartService;
import withus.ex.service.GetUserInfoService;
import withus.ex.service.OrderService;
import withus.ex.vo.CartVO;
import withus.ex.vo.OrderPageItemVO;
import withus.ex.vo.OrderVO;
import withus.ex.vo.UsersVO;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequestMapping("/product/*")
public class OrderController{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private GetUserInfoService getUserInfoService;
	
	@Autowired
	private CartService cartService;
	
	//장바구니 -> 주문
	@GetMapping("/order/{userNumber}")
	public List<Object> orderPageCart(@PathVariable int userNumber){
		List<Object> combined = new ArrayList<>();
		List<CartVO> ordercart = cartService.getCartList();
		UsersVO user = getUserInfoService.getUserInfoList(userNumber);
		
		combined.addAll(ordercart);
		combined.add(user);
		
		return combined;
	}
	
	//주문정보
	@GetMapping("/orderList/{userNumber}")
	public List<Object> orderPageGetList(@PathVariable int userNumber){
		List<Object> combinedList = new ArrayList<>();
		List<OrderPageItemVO> orderList = orderService.getOrderInfo();
		UsersVO users = getUserInfoService.getUserInfoList(userNumber);
		
		combinedList.addAll(orderList);
		combinedList.add(users);
		
		return combinedList;
	}
	
	
	//마이페이지 주문조회
	@GetMapping("/myOrder/{userNumber}")
	public List<OrderPageItemVO> myOrder(@PathVariable int userNumber){
		List<OrderPageItemVO> ordered = orderService.getOrderInfo();
		
		return ordered;
	}
		
	
	//주문넣기
	@GetMapping("/buy")
	public String buy(OrderVO order) {
		orderService.enrollItem(order);
		return "SUCCESS";
	}
	
	//페이징처리
	@GetMapping("/list")	//get 메소드로 처리하도록
	public String list(Criteria cri, Model model) {
		log.info("cri: " +cri+ "model: " + model);
		model.addAttribute("OrderList", orderService.getListOrPaging(cri)); //글 10개 가져오는 부분
		
		int total = orderService.getTotal();
		model.addAttribute("pageMaker", new PageVO(cri, total)); //페이지버튼그리기위한 정보
		return "SUCCESS";
	}
	
	
}
