/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.database;

import com.app.beans.LoadBean;
import java.sql.Connection;
import java.util.Vector;

/**
 *
 * @author vaibhav
 */
public interface LoadDatabaseDao {

	public boolean insertLoad(Connection connection, LoadBean bean);

	public boolean deleteLoad(Connection connection, int id);

	public boolean updateLoad(Connection connection, LoadBean bean);

	public Vector<LoadBean> getAllLoads(Connection connection);

}
