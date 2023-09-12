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
public class CartVO {
	
    private int cnumber;
    private int userNumber;
    private int wid;
    private int wcount;
    
    //letter
    private String wname;
    private int wprice;	//상품 한개 가격
    
    // 추가
    private int total_price;	//판매가격 x 수량

}
