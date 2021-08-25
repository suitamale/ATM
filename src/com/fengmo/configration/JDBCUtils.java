package com.fengmo.configration;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.fengmo.simulation.Login;

public class JDBCUtils {
	public static Connection getConnection() throws Exception{
		//加载配置文件
		InputStream is = Login.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties pros = new Properties();
		pros.load(is);
		//读取配置
		String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driver = pros.getProperty("driver");
        //加载驱动
        Class.forName(driver);
        //获取连接
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
	}
	//关闭资源
	public static void closeResource(Connection conn,Statement ps) {
		try {
			if(conn != null)
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(ps != null)
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void closeResource(Connection conn,Statement ps,ResultSet rs) {
		try {
			if(conn != null)
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(ps != null)
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rs != null)
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
