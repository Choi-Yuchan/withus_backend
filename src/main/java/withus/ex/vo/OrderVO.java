package withus.ex.vo;

import java.util.List;

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
	/* 최종 가격 */
    private int final_price;
    
    // 주문페이지
    private List<OrderPageItemVO> checkOrd;
    
	
	
}










