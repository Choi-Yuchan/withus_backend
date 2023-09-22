package withus.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import withus.ex.vo.CartVO;

@Mapper
public interface CartMapper {

	/* 카트 추가 */
	public List<CartVO> listCart();
	
	/* 카트 삭제 */
	public int deleteCart(CartVO cart);

	/* 카트 추가 */
	public void addCart(CartVO cartItem);
	
	int deleteCart(@Param("cnumbers") List<Integer> cnumbers);

}