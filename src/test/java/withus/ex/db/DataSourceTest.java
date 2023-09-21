package withus.ex.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;


@Slf4j //log를 위한 
@SpringBootTest
class DataSourceTest {

   @Autowired
   private DataSource datasource; //커넥션풀
   
   @Test
   void testDataSource() throws Exception {
      assertNotNull(datasource); //주입제대로됐는지확인
      
      System.out.println("DS=" + datasource);
      
      try(Connection conn = datasource.getConnection()){
         
         System.out.println("Cooooooooooo=" + conn);
         assertThat(conn).isInstanceOf(Connection.class);
         
         //3종세트불러옴
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("select 100 from dual");
      
         if(rs.next()) { //받아오는 함수
            assertEquals(100, rs.getLong(1));
         }
      }
      
   }
   
   //DataSource Connection 확인
   @Test
   public void TestConnection() {
	   try(Connection conn = datasource.getConnection()){
		   System.out.println("DB Connection Success" + conn);
	   }catch (Exception e) {
		   System.out.println("DB Connection fail");
		   e.printStackTrace();
	}
   }
}