package withus.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import withus.ex.page.Criteria;
import withus.ex.vo.CartVO;
import withus.ex.vo.LetterVO;

@Mapper
public interface CartMapper {

	/* 카트 추가 */
	public List<CartVO> listCart();
	
	/* 카트 삭제 */
	public int deleteCart(CartVO cart);
	
	

}