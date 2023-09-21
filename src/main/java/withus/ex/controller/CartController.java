package withus.ex.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import withus.ex.service.CartService;
import withus.ex.service.GetUserInfoService;
import withus.ex.vo.CartVO;
import withus.ex.vo.UsersVO;
@Slf4j
@CrossOrigin("http://localhost:3000")
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
	


//	@DeleteMapping("/delete/{cnumber}")
//	public String delete(@PathVariable("cnumber") int cnumber) {
//     CartVO cart = new CartVO();
//	    cart.setCnumber(cnumber);
//	    int rn = cartService.remove(cart);
//	    return "SUCCESS";
//	
//	}
	
	
	//복수의 상품 삭제
	@DeleteMapping("/delete")
	public String delete(@RequestParam("cnumbers") List<Integer> cnumbers) {
	    // 여기서 cnumbers 리스트에는 삭제하려는 cnumber들이 포함됩니다.
		 if (cnumbers == null || cnumbers.isEmpty()) {
		        return "INVALID_REQUEST"; // 클라이언트에게 잘못된 요청을 알립니다.
		    }
	    // 삭제를 수행할 때 반복문을 사용하여 각 cnumber를 처리합니다.
	    for (Integer cnumber : cnumbers) {
	        CartVO cart = new CartVO();
	        cart.setCnumber(cnumber);
	        int rn = cartService.remove(cart);
	    }

	    return "SUCCESS";
	}
	
    // 카트에 상품 추가 처리
    @PostMapping("/add")
    public String addToCart(@RequestParam("wid") int wid,
                            @RequestParam("userNumber") int userNumber,
                            @RequestParam("wcount") int wcount) {

        CartVO cartItem = new CartVO();
        cartItem.setWid(wid);
        cartItem.setUserNumber(userNumber);
        cartItem.setWcount(wcount);

        cartService.addCart(cartItem);


        return "SUCCESS";

    }

	
} 