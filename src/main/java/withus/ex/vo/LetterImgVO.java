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
public class LetterImgVO {
	
	private int uuid;
	private int wid;
	private String filename;
	private String uploadpath;	
	   
}
