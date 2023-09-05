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
public class ProductVO {
	
	   private int product_number;
	   private int product_img_number;
	   private String product_name;
	   private String product_img;
	   private int price;
	   private int order_quantity;
	   private String explanation;
	   private List<ProductImgVO> imgList;
	  
	   

	   
}
