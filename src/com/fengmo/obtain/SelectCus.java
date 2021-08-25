package com.fengmo.obtain;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.fengmo.configration.JDBCUtils;


public class SelectCus {
	public 	<T> T selectCus(Class<T> clazz,String sql, Object...args) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        conn = JDBCUtils.getConnection();
	        ps = conn.prepareStatement(sql);

	        for (int i = 0; i < args.length; i++) {
	            ps.setObject(i + 1, args[i]);
	        }
	        rs = ps.executeQuery();
	        //获取结果集的元数据 ResultSetMetaData
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columnCount = rsmd.getColumnCount();
//	        Customer cust = null;
	        if (rs.next()) {
	           T t = clazz.newInstance();
	            for (int i = 0; i < columnCount; i++) {
	                Object cloumvalue = rs.getObject(i + 1);

	                String columnLabel = rsmd.getColumnLabel(i + 1);
	                Field field = clazz.getDeclaredField(columnLabel);	            
					field.setAccessible(true);
	                field.set(t, cloumvalue);;
	            }
	            return t;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	        JDBCUtils.closeResource(conn,ps,rs);
	    }
	    return null;
	}
}
