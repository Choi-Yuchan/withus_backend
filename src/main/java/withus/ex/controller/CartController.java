package withus.ex.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import withus.ex.service.CartService;
import withus.ex.service.GetUserInfoService;
import withus.ex.vo.CartVO;
import withus.ex.vo.UsersVO;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/cart/*")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private GetUserInfoService getUserInfoService;
	
	//카트리스트
	@GetMapping("/cartList/{userNumber}")
	public List<CartVO> cartList(@PathVariable int userNumber){
		List<CartVO> cart = cartService.getCartList();
		
		return cart;
	}
	
	//카트삭제
	@GetMapping("/delete")
	public String delete(CartVO cart) {
		int rn = cartService.remove(cart);
		return "SUCCESS";
	}


} 