package withus.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAuthVO {
    @Test
    void testAuthVO() {
        AuthVO auth = new AuthVO("sampleUserNumber", "ROLE_USER");
        assertNotNull(auth);
        
        System.out.println("AuthVO object: " + auth);
    
        // 값을 수정함
        auth.setUserId("newUserId");
        auth.setAuthority("ROLE_USER");
        
        System.out.println("Updated AuthVO object: " + auth);

        // 수정된 값과 예상한 값이 같은지 확인
        assertEquals("newUserId", auth.getUserId());
        assertEquals("ROLE_USER", auth.getAuthority());
    }
}
