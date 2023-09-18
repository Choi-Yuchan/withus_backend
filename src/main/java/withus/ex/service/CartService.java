package withus.ex.service;

import java.util.List;

import withus.ex.page.Criteria;
import withus.ex.vo.CartVO;
import withus.ex.vo.LetterVO;


public interface CartService {
	
	//장바구니 리스트
	public List<CartVO> getCartList();
	
	//장바구니 삭제
	public int remove(CartVO cartVO);
}


