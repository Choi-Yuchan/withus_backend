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
	
	private int onumber;
	private int order_itemnumber;
	private int wid;
	private String wname;
	private int wprice;
	private int wcount;
	private int total_price;
	
	
}










