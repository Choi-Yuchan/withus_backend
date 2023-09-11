package withus.ex.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {
	
	private int pageNum; //페이지번호
	private int amount;	//한페이지당 몇개의 데이터 보여줄지
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}	
	
}
