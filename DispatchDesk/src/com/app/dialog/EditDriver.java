/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dialog;

import com.app.beans.DriverBean;
import com.app.database.DatabaseManager;
import com.app.database.DatabaseQuery;
import com.app.database.DbConnectionManager;
import com.app.frame.ApplicationFrame;
import com.app.log.AppLog;
import com.app.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

public class EditDriver extends javax.swing.JDialog {

	private ApplicationFrame frame;

	/**
	 * Creates new form EditDriver
	 * @wbp.parser.constructor
	 */
	public EditDriver(java.awt.Frame parent, boolean modal,
			Connection connection, int driver_id) {
		super(parent, modal);
		frame = (ApplicationFrame) parent;
		initComponents();
		selectDriverListById(connection, driver_id);
	}

	private EditDriver(JFrame jFrame, boolean b) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		driverId_txtfield = new javax.swing.JTextField();
		phone_txtfield = new javax.swing.JTextField();
		email_txtfield = new javax.swing.JTextField();
		tractor_txtfield = new javax.swing.JTextField();
		save_button = new JButton("Add");
		jLabel7 = new javax.swing.JLabel();
		trailor_txtfield = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		username_txtfield = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		firstname_txtfield = new javax.swing.JTextField();
		lastname_txtfield = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);

		jPanel1.setBackground(Color.DARK_GRAY);

		jPanel2.setBackground(new Color(135, 206, 235));

		jLabel6.setFont(new Font("Cambria Math", Font.BOLD, 24)); // NOI18N
		jLabel6.setText("Edit Driver");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(144)
					.addComponent(jLabel6)
					.addContainerGap(152, Short.MAX_VALUE))
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(22)
					.addComponent(jLabel6)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		jPanel2.setLayout(jPanel2Layout);

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel1.setText("Driver Id");

		jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel3.setText("Phone No");

		jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel4.setText("Email Id");

		jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel5.setText("Tractor");

		driverId_txtfield.setEditable(false);
		driverId_txtfield.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

		phone_txtfield.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

		email_txtfield.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

		tractor_txtfield.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

		save_button.setText("Save");
		save_button.setFocusable(false);
		save_button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				save_buttonMouseClicked(evt);
			}
		});

		jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel7.setText("Trailor");

		trailor_txtfield.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

		jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel8.setText("UserName");

		username_txtfield.setEditable(false);
		username_txtfield.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

		jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel9.setText("FirstName");

		jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel10.setText("LastName");

		firstname_txtfield.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
		firstname_txtfield
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						firstname_txtfieldActionPerformed(evt);
					}
				});

		lastname_txtfield.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3Layout.setHorizontalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGap(37)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel1)
						.addGroup(jPanel3Layout.createSequentialGroup()
							.addGap(1)
							.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
									.addComponent(jLabel9)
									.addComponent(jLabel8)
									.addComponent(jLabel10)
									.addComponent(jLabel3))
								.addGroup(jPanel3Layout.createSequentialGroup()
									.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(jLabel5)
										.addComponent(jLabel4)
										.addComponent(jLabel7))
									.addGap(10)))))
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(trailor_txtfield)
						.addComponent(tractor_txtfield)
						.addComponent(username_txtfield)
						.addComponent(firstname_txtfield)
						.addComponent(driverId_txtfield)
						.addComponent(lastname_txtfield)
						.addComponent(phone_txtfield)
						.addComponent(email_txtfield, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addGap(50))
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGap(173)
					.addComponent(save_button, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(178, Short.MAX_VALUE))
		);
		jPanel3Layout.setVerticalGroup(
			jPanel3Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(driverId_txtfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(username_txtfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel8))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstname_txtfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel9))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lastname_txtfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel10))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(phone_txtfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(email_txtfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tractor_txtfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5))
					.addGap(10)
					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(trailor_txtfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel7))
					.addGap(35)
					.addComponent(save_button)
					.addGap(62))
		);
		jPanel3.setLayout(jPanel3Layout);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jPanel3,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel3,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_save_buttonMouseClicked
		// TODO add your handling code here:
		saveDriver();
	}// GEN-LAST:event_save_buttonMouseClicked

	private void firstname_txtfieldActionPerformed(
			java.awt.event.ActionEvent evt) {// GEN-FIRST:event_firstname_txtfieldActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_firstname_txtfieldActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(EditDriver.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EditDriver.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EditDriver.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EditDriver.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				EditDriver dialog = new EditDriver(new javax.swing.JFrame(),
						true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextField driverId_txtfield;
	private javax.swing.JTextField email_txtfield;
	private javax.swing.JTextField firstname_txtfield;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JTextField lastname_txtfield;
	private javax.swing.JTextField phone_txtfield;
	private javax.swing.JButton save_button;
	private javax.swing.JTextField tractor_txtfield;
	private javax.swing.JTextField trailor_txtfield;
	private javax.swing.JTextField username_txtfield;

	// End of variables declaration//GEN-END:variables

	/**
	 * Update Driver Informations into database
	 */
	private void saveDriver() {

		if (DatabaseManager.getInstance() != null) {
			try {
				if (DbConnectionManager.getConnection() != null) {
					DriverBean bean = new DriverBean();
					bean.setDriverId(driverId_txtfield.getText());
					bean.setEmail(email_txtfield.getText());
					bean.setFirstname(firstname_txtfield.getText());
					bean.setLastname(lastname_txtfield.getText());
					bean.setPhone(phone_txtfield.getText());
					bean.setTractor(tractor_txtfield.getText());
					bean.setTrailor(trailor_txtfield.getText());

					boolean flag = DatabaseManager.getInstance().updateDriver(
							DbConnectionManager.getConnection(), bean);
					AppLog.success("Update Driver", flag);
					if (flag) {
						frame.updateDriverList();
						frame.updateChatUserList();
						Utils.infoBox("Update Successfully",
								"DRIVER INFORMATIONS");
					} else {
						Utils.infoBox("Update Error", "DRIVER INFORMATIONS");
					}
					EditDriver.this.dispose();
				}
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(EditDriver.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}

	/**
	 * Select DriverList Data ById
	 * 
	 * @param connection
	 * @param id
	 */
	private void selectDriverListById(Connection connection, int id) {

		PreparedStatement ps;
		ResultSet rs = null;
		try {

			ps = connection
					.prepareStatement(DatabaseQuery.GET_DRIVER_INFO_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			// Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String driver_id = rs.getString("driver_id");
				String phoneNo = rs.getString("phoneNo");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String tractor = rs.getString("tractor");
				String trailor = rs.getString("trailor");
				String username = rs.getString("username");

				username_txtfield.setText(username);
				driverId_txtfield.setText(driver_id);
				phone_txtfield.setText(phoneNo);
				firstname_txtfield.setText(firstName);
				lastname_txtfield.setText(lastName);
				email_txtfield.setText(email);
				tractor_txtfield.setText(tractor);
				trailor_txtfield.setText(trailor);
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
}
