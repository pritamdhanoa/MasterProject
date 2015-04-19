/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.database;

import com.app.beans.DriverBean;
import java.sql.Connection;
import java.util.Vector;

public interface DriverDatabaseDao {

	public boolean insertDriver(Connection connection, DriverBean bean);

	public boolean deleteDriver(Connection connection, int id);

	public boolean updateDriver(Connection connection, DriverBean bean);

	public Vector<DriverBean> getAllDrivers(Connection connection);
}
