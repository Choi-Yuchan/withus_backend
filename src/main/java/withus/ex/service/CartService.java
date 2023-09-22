package withus.ex.service;

import java.util.List;

import withus.ex.vo.CartVO;


public interface CartService {
	
	//장바구니 리스트
	public List<CartVO> getCartList();
	
	//장바구니 삭제
	public int remove(CartVO cart);
	
	// 카트 담기
	public void addCart(CartVO cartitem);
	

}


