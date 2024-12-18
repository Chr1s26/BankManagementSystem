package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PgSqlConnectionFactory implements ConnectionFactory {
	
	private static final String PROPERTIES_FILE = "src/resources/application.properties";
	private String url ;
	private String username ;
	private String password ;
	private Connection connection;
	
	public PgSqlConnectionFactory() {
		loadProperties();
	}
	
	public void loadProperties() {
		Properties properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(PROPERTIES_FILE);
			properties.load(fis);
			
			this.url = properties.getProperty("db.url");
			this.username = properties.getProperty("db.username");
			this.password = properties.getProperty("db.password");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Connection createConnection() throws SQLException {
		this.connection = DriverManager.getConnection(url,username,password);
		return this.connection;
	}

	
	@Override
	public void closeConnection() {
		try {
			this.connection.close();
		}catch(SQLException e){
			System.out.print(e.getMessage());
		}
	}

}
