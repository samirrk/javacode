package com.zoomifier.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AnalyticsQueryMain 
{
	private static final String dbClassName = "com.mysql.jdbc.Driver";

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
		{
		    Class.forName(dbClassName);
		    Connection analyticsConn = null;
		    //String connectionString = ConfigHelper.getInstance().getProperty(COMPONENT.ANALYTICS_SERVER, "DATABASE");
		    String connectionString = "jdbc:mysql://127.0.0.1/ZANALYTICS?user=root&password=root";
		    analyticsConn = DriverManager.getConnection(connectionString);
			
		    String query = "INSERT INTO AGGREGATE " +
					"(AGGREGATE_TYPE, OBJECT1_ID, OBJECT2_ID, AGGREGATE_VALUE,START_DATE,END_DATE, CLIENT_ID, CONTENT_TYPE) "
					+ "SELECT 1,DOCUMENT_ID, OBJECT2_ID,COUNT(DISTINCT OBJECT2_ID) EVENTCOUNT, EVENT_DATE, EVENT_DATE, CLIENT_ID, CONTENT_TYPE "
					+ "FROM BACKUP_RAW_EVENTS WHERE EVENT_TYPE=3 AND EVENT_DATE<=__END_DATE__ AND EVENT_DATE>__START_DATE__ "
					+ "GROUP BY EVENT_DATE, DOCUMENT_ID "
					+ "UNION "
					+ "SELECT 1,DOCUMENT_ID, OBJECT2_ID,COUNT(DISTINCT OBJECT2_ID) EVENTCOUNT, EVENT_DATE, EVENT_DATE, CLIENT_ID, CONTENT_TYPE "
				    + "FROM BACKUP_RAW_EVENTS WHERE EVENT_TYPE=1 AND CONTENT_TYPE!='DOCUMENT' AND EVENT_DATE<=__END_DATE__ AND EVENT_DATE>__START_DATE__ "
				    + "GROUP BY EVENT_DATE, DOCUMENT_ID";
		    String qry = query.replaceAll("__START_DATE__", "'2013-11-14'").replaceAll("__END_DATE__", "'2013-11-15'");
			execQuery(analyticsConn, qry);
			analyticsConn.close();
		} 
		catch (SQLException e)
		{
			System.err.println("doPerform():"+e.getMessage());
		} 
		catch (ClassNotFoundException e)
		{
			System.err.println("doPerform():"+e.getMessage());
		} 

	}
		
		
	public static void execQuery(Connection conn, String query )
	{
		Statement s;
		
		try 
		{
			s = conn.createStatement ();
			s.executeUpdate (query);
			s.close ();
			
		} 
		catch (SQLException e) 
		{
			System.err.println("Query:"+query);
			System.err.println("execQuery():"+e.getMessage());
		}
	}


}
