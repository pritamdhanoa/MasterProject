/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import org.jdesktop.swingx.JXDatePicker;

public class Utils {

	/*
	 * Show Information Dialog
	 */
	public static void infoBox(String infoMessage, String location) {
		JOptionPane.showMessageDialog(null, infoMessage,
				"InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Return Date Format
	 *
	 * @param datePicker
	 * @return
	 */
	public static String getDate(JXDatePicker datePicker) {
		String date = "";
		try {
			DateFormat sysDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			date = sysDate.format(datePicker.getDate()).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
