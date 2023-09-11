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
public class OrderPageItemVO {
	
	/* 뷰로부터 전달받을 값 */
	private int wid;
	private int wcount;
	
	/* DB로부터 꺼내올 값 */
	private String wname;
	private int wprice;
	
	/* 만들어 낼 값 */
	private int total_price;
	
}










