package org.tricon.util.dbcompare;

public class Util {

	public static String getDriverClassName(String db_provider){
		String driver="";
		switch(db_provider.toLowerCase()){
		case "postgresql":
			driver= "org.postgresql.Driver";
			break;
		case "mysql":
			driver= "com.mysql.jdbc.Driver";
			break;
		case "oracle":
			driver= "oracle.jdbc.driver.OracleDriver";
			break;
		case "sqlserver":
			driver= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			break;
		}
		return driver;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getDriverClassName("mYsql"));
	}

}
