/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.database;

public class DatabaseQuery {

	/**
	 * *************************Login
	 * Authentication**********************************************
	 */
	public static final String ISLOGINCHECK = "SELECT username,encryptedPassword FROM ofuser WHERE NAME=?";

	/**
	 * *****************DRIVER DATABASE QUERY**********************************
	 */
	public static final String INSERT_DRIVER_INFO = "INSERT INTO driverinfo(driver_id,username,password,phoneNo,firstName,"
			+ "lastName,email,tractor,trailor) " + "VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_DRIVER_INFO = "UPDATE driverinfo SET phoneNo=?,firstName=?,"
			+ "lastName=?,email=?,tractor=?,trailor=? WHERE driver_id=?";
	public static final String DELETE_DRIVER_INFO = "DELETE FROM driverinfo WHERE driver_id=?";
	public static final String GET_DRIVER_INFO_BY_ID = "SELECT * FROM driverinfo WHERE driver_id=?";
	public static final String SELECT_DRIVER_INFO = "SELECT * FROM driverinfo";

	/**
	 * **********************LOAD DATABASE QUERY*******************************
	 */
	public static final String INSERT_LOAD_INFO = "INSERT INTO loadinfo(company_name,company_phone,"
			+ "pickup_name_of_place,pickup_street_address,"
			+ "pickup_city,pickup_state,pickup_zip_code,pickup_date,"
			+ "delivery_name_of_place,delivery_street_address,delivery_city,delivery_state,delivery_zip_code,"
			+ "delivery_date,driver_assigned_id,driver_name,status)"
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_LOAD_INFO = "UPDATE loadinfo SET company_name=?,company_phone=?,"
			+ "pickup_name_of_place=?,pickup_street_address=?,"
			+ "pickup_city=?,pickup_state=?,pickup_zip_code=?,pickup_date=?,"
			+ "delivery_name_of_place=?,delivery_street_address=?,delivery_city=?,"
			+ "delivery_state=?,delivery_zip_code=?,"
			+ "delivery_date=?,driver_assigned_id=?,driver_name=?,status=? "
			+ "WHERE Id=?";
	public static final String DELETE_LOAD_INFO = "DELETE FROM loadinfo WHERE Id=?";
	public static final String GET_LOAD_INFO_BY_ID = "SELECT * FROM loadinfo WHERE Id=?";
	public static final String SELECT_LOAD_INFO = "SELECT * FROM loadinfo";
}
