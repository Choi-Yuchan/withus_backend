package withus.ex.vo;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*이름           널?       유형           
------------ -------- ------------ 
USER_NUMBER  NOT NULL NUMBER       
USER_ID      NOT NULL VARCHAR2(20) 
PASSWORD     NOT NULL VARCHAR2(20) 
PHONE_NUMBER          VARCHAR2(11) 
BIRTH                 DATE         
EMAIL                 VARCHAR2(20) 
GENDER                CHAR(1)      
USER_NAME             VARCHAR2(20) */


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsersVO {
	private int userNumber;
	private String userName;
	private String userId;
	private String password;
	private String phoneNumber;
	private String addr1;
	private String addr2;
	private String addr3;	
	private Date birth;
	private String gender;
	
	
	//private int enabled;
	// DB에있는 테이블 받아오기 (유저1:권한N)위해 권한atuhVO를 리스트로 만든다.
	//private List<AuthVO> authList;

}
