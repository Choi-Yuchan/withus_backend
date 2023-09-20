package withus.ex.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataSourceTest {

	@Autowired
	private DataSource datasource; // 커넥션 풀

	@Test
	void testDataSource() throws Exception {
		assertNotNull(datasource);

		System.out.println("DS=" + datasource);

		try (Connection conn = datasource.getConnection()) {

			System.out.println("Cooooooooonn=" + conn);
			assertThat(conn).isInstanceOf(Connection.class);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select 100 from dual");
			if (rs.next()) {
				assertEquals(100, rs.getLong(1));
			}
		}

	}

}
