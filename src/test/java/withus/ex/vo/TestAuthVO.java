package withus.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAuthVO {
	@Test
	void AuthVO() {
		AuthVO auth = new AuthVO("sampleUserId", "ROLE_USER");
		assertNotNull(auth);
		
        System.out.println("AuthVO object: " + auth);
	
		//이 값들을 설정함
        auth.setUserId("newUserId");
        auth.setAuthority("ROLE_ADMIN");
		
        System.out.println("Updated AuthVO object: " + auth);

	}


}
