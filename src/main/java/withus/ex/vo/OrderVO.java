package withus.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderVO {
	
	/* 주문 번호 */
	private int onumber;
	/* 상품 번호 */
    private int wid;
	/* 주문 수량 */
    private int wcount;
	/* vam_orderItem 기본키 */
    private int order_itemnumber;
	/* 상품 한 개 가격 */
    private int wprice;
	/* 총 가격(할인 적용된 가격 * 주문 수량) */
    private int total_price;
    
	
	
}










