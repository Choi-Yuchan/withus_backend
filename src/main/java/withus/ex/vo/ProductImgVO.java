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

public class ProductImgVO {
	
	   private int product_number;
	   private int product_img_number;
	   private String image_type;
	   private String file_name;
	   

	   
}