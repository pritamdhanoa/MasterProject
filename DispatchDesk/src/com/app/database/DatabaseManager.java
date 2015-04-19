/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.database;

import com.app.beans.DriverBean;
import com.app.beans.LoadBean;
import com.app.log.AppLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DatabaseManager implements DriverDatabaseDao, LoadDatabaseDao {

	private static DatabaseManager dm = null;
	private Vector<LoadBean> loadArrayList;
	private Vector<DriverBean> driverArrayList;

	public static DatabaseManager getInstance() {
		if (dm == null) {
			dm = new DatabaseManager();
		}
		return dm;
	}

	@Override
	public boolean insertDriver(Connection connection, DriverBean bean) {

		boolean flag = false;
		PreparedStatement pstmt = null; // Prepare Statement

		try {

			// Creates a PreparedStatement object for sending parameterized SQL
			// statements to the database
			pstmt = connection
					.prepareStatement(DatabaseQuery.INSERT_DRIVER_INFO);
			pstmt.setInt(1, Integer.parseInt(bean.getDriverId()));
			pstmt.setString(2, bean.getUsername());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getPhone());
			pstmt.setString(5, bean.getFirstname());
			pstmt.setString(6, bean.getLastname());
			pstmt.setString(7, bean.getEmail());
			pstmt.setString(8, bean.getTractor());
			pstmt.setString(9, bean.getTrailor());

			// Executes the SQL statement in this PreparedStatement object
			int success = pstmt.executeUpdate();
			if (success == 1) {
				flag = true;
				return flag;
			}
		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteDriver(Connection connection, int driverId) {

		PreparedStatement pstmt = null; // Prepare Statement

		boolean flag = false;

		try {

			// Creates a PreparedStatement object for sending parameterized SQL
			// statements to the database
			pstmt = connection
					.prepareStatement(DatabaseQuery.DELETE_DRIVER_INFO);
			pstmt.setInt(1, driverId);

			// Executes the SQL statement in this PreparedStatement object
			flag = pstmt.execute();
			return flag;
		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateDriver(Connection connection, DriverBean bean) {

		boolean flag = false;
		PreparedStatement pstmt = null; // Prepare Statement

		try {

			AppLog.success("UPDATE DRIVER INFO",
					DatabaseQuery.UPDATE_DRIVER_INFO);
			// Creates a PreparedStatement object for sending parameterized SQL
			// statements to the database
			pstmt = connection
					.prepareStatement(DatabaseQuery.UPDATE_DRIVER_INFO);
			pstmt.setString(1, bean.getPhone());
			pstmt.setString(2, bean.getFirstname());
			pstmt.setString(3, bean.getLastname());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getTractor());
			pstmt.setString(6, bean.getTrailor());
			pstmt.setInt(7, Integer.parseInt(bean.getDriverId()));

			// Executes the SQL statement in this PreparedStatement object
			int success = pstmt.executeUpdate();
			if (success == 1) {
				flag = true;
				return flag;
			}
		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Vector<DriverBean> getAllDrivers(Connection connection) {

		Statement stmt = null; // statement object
		ResultSet rs = null; // result set object

		try {
			driverArrayList = new Vector<DriverBean>();
			// Creates a Statement object for sending SQL statements to the
			// database
			stmt = connection.createStatement();

			// Executes the given SQL statement, which returns a single
			// ResultSet object.
			rs = stmt.executeQuery(DatabaseQuery.SELECT_DRIVER_INFO);

			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String driver_id = rs.getString("driver_id");
				String user_name = rs.getString("username");
				String phoneNo = rs.getString("phoneNo");
				String first_name = rs.getString("firstName");
				String last_name = rs.getString("lastName");
				String email = rs.getString("email");
				String tractor = rs.getString("tractor");
				String trailor = rs.getString("trailor");

				DriverBean bean = new DriverBean();
				bean.setDriverId(driver_id);
				bean.setUsername(user_name);
				bean.setPhone(phoneNo);
				bean.setFirstname(first_name);
				bean.setLastname(last_name);
				bean.setEmail(email);
				bean.setTractor(tractor);
				bean.setTrailor(trailor);

				driverArrayList.add(bean);
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return driverArrayList;
	}

	@Override
	public boolean insertLoad(Connection connection, LoadBean bean) {

		boolean flag = false;
		PreparedStatement pstmt = null; // Prepare Statement
		try {

			// Creates a PreparedStatement object for sending parameterized SQL
			// statements to the database
			pstmt = connection.prepareStatement(DatabaseQuery.INSERT_LOAD_INFO);
			pstmt.setString(1, bean.getCompany_name());
			pstmt.setString(2, bean.getCompany_phone());
			pstmt.setString(3, bean.getPickup_name_of_place());
			pstmt.setString(4, bean.getPickup_street_address());
			pstmt.setString(5, bean.getPickup_city());
			pstmt.setString(6, bean.getPickup_state());
			pstmt.setString(7, bean.getPickup_zip_code());
			pstmt.setString(8, bean.getPickup_date());
			pstmt.setString(9, bean.getDelivery_name_of_place());
			pstmt.setString(10, bean.getDelivery_street_address());
			pstmt.setString(11, bean.getDelivery_city());
			pstmt.setString(12, bean.getDelivery_state());
			pstmt.setString(13, bean.getDelivery_zip_code());
			pstmt.setString(14, bean.getDelivery_date());
			pstmt.setString(15, bean.getDriver_assigned_id());
			pstmt.setString(16, bean.getDriver_assigned_name());
			pstmt.setString(17, bean.getStatus());

			// Executes the SQL statement in this PreparedStatement object
			int success = pstmt.executeUpdate();
			if (success == 1) {
				flag = true;
				return flag;
			}
		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteLoad(Connection connection, int id) {

		PreparedStatement pstmt = null; // Prepare Statement

		boolean flag = false;

		try {
			// Creates a PreparedStatement object for sending parameterized SQL
			// statements to the database
			pstmt = connection.prepareStatement(DatabaseQuery.DELETE_LOAD_INFO);
			pstmt.setInt(1, id);

			// Executes the SQL statement in this PreparedStatement object
			flag = pstmt.execute();
			return flag;

		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateLoad(Connection connection, LoadBean bean) {

		PreparedStatement pstmt = null; // Prepare Statement

		boolean flag = false;

		try {
			// Creates a PreparedStatement object for sending parameterized SQL
			// statements to the database
			pstmt = connection.prepareStatement(DatabaseQuery.UPDATE_LOAD_INFO);
			pstmt.setString(1, bean.getCompany_name());
			pstmt.setString(2, bean.getCompany_phone());
			pstmt.setString(3, bean.getPickup_name_of_place());
			pstmt.setString(4, bean.getPickup_street_address());
			pstmt.setString(5, bean.getPickup_city());
			pstmt.setString(6, bean.getPickup_state());
			pstmt.setString(7, bean.getPickup_zip_code());
			pstmt.setString(8, bean.getPickup_date());
			pstmt.setString(9, bean.getDelivery_name_of_place());
			pstmt.setString(10, bean.getDelivery_street_address());
			pstmt.setString(11, bean.getDelivery_city());
			pstmt.setString(12, bean.getDelivery_state());
			pstmt.setString(13, bean.getDelivery_zip_code());
			pstmt.setString(14, bean.getDelivery_date());
			pstmt.setString(15, bean.getDriver_assigned_id());
			pstmt.setString(16, bean.getDriver_assigned_name());
			pstmt.setString(17, bean.getStatus());
			pstmt.setInt(18, bean.getId());

			// Executes the SQL statement in this PreparedStatement object
			int success = pstmt.executeUpdate();
			if (success == 1) {
				flag = true;
				return flag;
			}
		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Vector<LoadBean> getAllLoads(Connection connection) {
		Statement stmt = null; // statement object
		ResultSet rs = null; // result set object

		try {
			loadArrayList = new Vector<LoadBean>();
			// Creates a Statement object for sending SQL statements to the
			// database
			stmt = connection.createStatement();

			// Executes the given SQL statement, which returns a single
			// ResultSet object.
			rs = stmt.executeQuery(DatabaseQuery.SELECT_LOAD_INFO);

			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String id = rs.getString("Id");
				String company_name = rs.getString("company_name");
				String company_phone = rs.getString("company_phone");
				String pickup_name_of_place = rs
						.getString("pickup_name_of_place");
				String pickup_street_address = rs
						.getString("pickup_street_address");
				String pickup_city = rs.getString("pickup_city");
				String pickup_state = rs.getString("pickup_state");
				String pickup_zip_code = rs.getString("pickup_zip_code");
				String pickup_date = rs.getString("pickup_date");
				String delivery_name_of_place = rs
						.getString("delivery_name_of_place");
				String delivery_street_address = rs
						.getString("delivery_street_address");
				String delivery_city = rs.getString("delivery_city");
				String delivery_state = rs.getString("delivery_state");
				String delivery_zip_code = rs.getString("delivery_zip_code");
				String delivery_date = rs.getString("delivery_date");
				String driver_assigned_id = rs.getString("driver_assigned_id");
				String driver_name = rs.getString("driver_name");
				String status = rs.getString("status");

				LoadBean bean = new LoadBean();
				bean.setId(Integer.parseInt(id));

				bean.setCompany_name(company_name);
				bean.setCompany_phone(company_phone);
				bean.setPickup_name_of_place(pickup_name_of_place);
				bean.setPickup_street_address(pickup_street_address);
				bean.setPickup_state(pickup_state);
				bean.setPickup_city(pickup_city);
				bean.setPickup_zip_code(pickup_zip_code);
				bean.setPickup_date(pickup_date);
				bean.setDelivery_name_of_place(delivery_name_of_place);
				bean.setDelivery_state(delivery_state);
				bean.setDelivery_street_address(delivery_street_address);
				bean.setDelivery_city(delivery_city);
				bean.setDelivery_zip_code(delivery_zip_code);
				bean.setDelivery_date(delivery_date);
				bean.setDriver_assigned_id(driver_assigned_id);
				bean.setDriver_assigned_name(driver_name);
				bean.setStatus(status);
				loadArrayList.add(bean);
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return loadArrayList;
	}

}
