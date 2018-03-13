package com.nashtech.utils.databases;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSetMetaData;
import com.nashtech.common.Common;
import com.nashtech.utils.report.Log;
import com.nashtech.utils.report.TestngLogger;

public class SqlServerJDBC extends Common {

	/**
	 * Get connection from jdbc
	 * 
	 * @return A connection instance that connect to jdbc
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {

		Connection conn = null;
		try {
			String sqlServerName = Common.getConfigValue("DatabaseServerName");
			String sqlServerDbName = Common.getConfigValue("DatabaseName");
			String sqlServerUser = Common.getConfigValue("DatabaseUserName");
			String sqlServerPwd = Common.getConfigValue("DatabasePassword");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://"
					+ sqlServerName + ":1433;databaseName=" + sqlServerDbName
					+ ";user=" + sqlServerUser + ";password=" + sqlServerPwd);

		} catch (Exception e) {
			Log.error(e.getMessage());
			TestngLogger.writeLog(e.getMessage());
			throw (e);
		}

		return conn;
	}

	/**
	 * Execute query command
	 * 
	 * @param query
	 *            The sql command
	 * @throws Exception
	 */
	public static void executeQuery(String query) throws Exception {

		try {
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			st.execute(query);
		} catch (Exception e) {
			Log.error(e.getMessage());
			TestngLogger.writeLog(e.getMessage());
			throw (e);

		}

	}

	/**
	 * Perform query command and get value of a column
	 * 
	 * @param query
	 *            The sql command used to query value
	 * @param columnName
	 *            The column that want to get value
	 * @return
	 * @throws Exception
	 */
	public static String getValueInDatabase(String query, String columnName)
			throws Exception {
		String data = null;

		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				data = rs.getString(columnName);
			}

		} catch (Exception e) {

			Log.error(e.getMessage());
			TestngLogger.writeLog(e.getMessage());
			throw (e);

		}

		return data;
	}

	/**
	 * Perform query command and get all value of a column
	 * 
	 * @param query
	 *            The sql command used to query values
	 * @param columnName
	 *            The column that want to get values
	 * @return
	 * @throws Exception
	 */
	public static List<String> getListValueInDatabase(String query, String columnName) throws Exception {
		String data = null;
		List<String> result = new ArrayList<String>();
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				data = rs.getString(columnName);
				result.add(data);
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			TestngLogger.writeLog(e.getMessage());
			throw (e);
		}
		return result;
	}

	/**
	 * Perform query command with input string and get value of a column
	 * 
	 * @param query
	 *            The sql command used to query value
	 * @param columnName
	 *            The column that want to get value
	 * @return
	 * @throws Exception
	 */
	public static String getValueWithInput(String query, String columnName,
			String input) throws Exception {
		String data = null;
		String newquery = null;
		try {

			Connection con = getConnection();
			Statement st = con.createStatement();
			newquery = query + "'" + input + "'";
			ResultSet rs = st.executeQuery(newquery);
			while (rs.next()) {
				data = rs.getString(columnName);
			}

		} catch (Exception e) {

			Log.error(e.getMessage());
			TestngLogger.writeLog(e.getMessage());
			throw (e);

		}

		return data;
	}

	/**
	 * Perform query command and return count number of column
	 * 
	 * @param query
	 *            The sql command used to query value
	 * @param columnName
	 *            The column that want to get value
	 * @return
	 * @throws Exception
	 */
	public static Integer getColumnCount(String query, String columnName)
			throws Exception {
		int columnsNumber = 0;
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			columnsNumber = rsmd.getColumnCount();

		} catch (Exception e) {

			Log.error(e.getMessage());
			TestngLogger.writeLog(e.getMessage());
			throw (e);
		}

		return columnsNumber;
	}
}
