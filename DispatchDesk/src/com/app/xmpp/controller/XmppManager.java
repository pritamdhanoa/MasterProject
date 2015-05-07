/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.xmpp.controller;

import java.util.Collection;

import com.app.log.AppLog;
import com.app.utils.ConstantOfApp;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.RosterPacket.ItemStatus;

public class XmppManager {

    private static final int packetReplyTimeout = 500; // millis
    private static ConnectionConfiguration config;
    private static XMPPConnection connection;
    private static ChatManager chatManager;
    public static MessageListener messageListener;
    private static final String fromJIDUsername = "admin@localhost";
    private static final String fromJIDPassword = "admin";

    public static XMPPConnection getConnection() throws XMPPException {

        if (connection == null) {
            SmackConfiguration.setPacketReplyTimeout(packetReplyTimeout);
            config = new ConnectionConfiguration(ConstantOfApp.host, ConstantOfApp.port);
            config.setSASLAuthenticationEnabled(true);
            config.setSecurityMode(SecurityMode.disabled);
            connection = new XMPPConnection(config);
            connection.connect();
            AppLog.success("XmppManager Connected:", connection.isConnected());
            performLogin(fromJIDUsername, fromJIDPassword);
            chatManager = connection.getChatManager();
            messageListener = new MyMessageListener();
        }
        return connection;
    }

    public static void performLogin(String username, String password) throws XMPPException {

        if (connection != null && connection.isConnected()) {
            connection.login(username, password);
        }
    }

    public static void destroy() {
        if (connection != null && connection.isConnected()) {
            connection.disconnect();
        }
    }

    public static void sendMessage(String message, String buddyJID) throws XMPPException {
        AppLog.success("XmppManager:sendMessage===message", message);
        AppLog.success("XmppManager:sendMessage===buddyJID", buddyJID);
        Chat chat = chatManager.createChat(buddyJID, messageListener);
        chat.sendMessage(message);
    }

    static class MyMessageListener implements MessageListener {

        @Override
        public void processMessage(Chat chat, Message message) {
            String from = message.getFrom();
            String body = message.getBody();
            AppLog.success("XmppManager:Received Message===From", from);
            AppLog.success("XmppManager:Received Message===body", body);
        }
    }
    
    public String printRoster(String user) throws Exception {
    	String status = null;
    	Roster roster = connection.getRoster();
    	Collection<RosterEntry> entries = roster.getEntries(); 
    	for (RosterEntry entry : entries) {
    		if(entry.getName() == user)
    				status = entry.getStatus().toString();
    	}
    	return status;
    }

}
