package withus.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import withus.ex.mapper.CartMapper;
import withus.ex.page.Criteria;
import withus.ex.vo.CartVO;
import withus.ex.vo.LetterVO;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartMapper cartMapper;
	
	//장바구니 리스트
	@Override
	public List<CartVO> getCartList() {
		return cartMapper.listCart();
	}
	
	//장바구니 삭제
	@Override
	public int remove(CartVO cart) {
		return cartMapper.deleteCart(cart);
	}
	
	//장바구니 추가
	@Override
    public void addCart(CartVO cartItem) {
        cartMapper.addCart(cartItem);
    }


}


