package com.app.dialog;

import com.app.log.AppLog;

import static com.app.utils.ChatConstants.ANGRY;
import static com.app.utils.ChatConstants.BYE;
import static com.app.utils.ChatConstants.COFFEE;
import static com.app.utils.ChatConstants.COOL;
import static com.app.utils.ChatConstants.CRY;
import static com.app.utils.ChatConstants.DEVIL;
import static com.app.utils.ChatConstants.EQUISMILE;
import static com.app.utils.ChatConstants.LAUGH;
import static com.app.utils.ChatConstants.LOVE;
import static com.app.utils.ChatConstants.MEAN;
import static com.app.utils.ChatConstants.QUESTION;
import static com.app.utils.ChatConstants.SAD;
import static com.app.utils.ChatConstants.SHY;
import static com.app.utils.ChatConstants.SMILE;
import static com.app.utils.ChatConstants.SURPRISE;
import static com.app.utils.ChatConstants.TONGUE;
import static com.app.utils.ChatConstants.WINK;

import com.app.utils.Utils;
import com.app.xmpp.controller.XmppManager;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLEditorKit;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class ChatScreen extends javax.swing.JDialog {

	private String buddyJID;
	private static ChatScreen chatScreen;

	public String getBuddyJID() {
		return buddyJID;
	}

	public void setBuddyJID(String buddyJID) {
		this.buddyJID = buddyJID;
	}

	public static ChatScreen getInstance(java.awt.Frame parent,
			String chatUserName) {
		if (chatScreen == null) {
			chatScreen = new ChatScreen(parent, true, chatUserName);
		}
		chatScreen.setBuddyJID(chatUserName + "@localhost");
		return chatScreen;
	}

	/**
	 * Creates new form ChatScreen
	 * @wbp.parser.constructor
	 */
	public ChatScreen(java.awt.Frame parent, boolean modal, String chat_username) {
		super(parent, modal);
		initComponents();
		recv.setEditorKit(new HTMLEditorKit());
		recv.setEditable(false);
		buddyJID = chat_username + "@localhost";
	}

	private ChatScreen(JFrame jFrame, boolean b) {
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
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		recv = new javax.swing.JEditorPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		type = new javax.swing.JTextArea();
		send = new JButton("SEND");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);

		jPanel1.setBackground(Color.DARK_GRAY);

		jPanel2.setBackground(new Color(135, 206, 235));

		jLabel1.setFont(new Font("Cambria Math", Font.BOLD, 24)); // NOI18N
		jLabel1.setForeground(Color.BLACK);
		jLabel1.setText("Chat");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(183)
					.addComponent(jLabel1)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel2.setLayout(jPanel2Layout);

		recv.setEditable(false);
		recv.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
		jScrollPane1.setViewportView(recv);

		type.setColumns(20);
		type.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
		type.setLineWrap(true);
		type.setRows(5);
		type.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				typeKeyPressed(evt);
			}
		});
		jScrollPane2.setViewportView(type);

		send.setText("Send");
		send.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				sendMouseClicked(evt);
			}
		});
		send.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendActionPerformed(evt);
			}
		});
		send.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				sendKeyPressed(evt);
			}
		});

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
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																420,
																Short.MAX_VALUE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				327,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				send,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
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
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												197,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																0,
																Short.MAX_VALUE)
														.addComponent(
																send,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																41,
																Short.MAX_VALUE))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 16, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void sendActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sendActionPerformed
		// TODO add your handling code here:
		// clickOnSend();
	}// GEN-LAST:event_sendActionPerformed

	private void sendMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sendMouseClicked
		// TODO add your handling code here:
		clickOnSend();
		type.setText("");
	}// GEN-LAST:event_sendMouseClicked

	private void sendKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_sendKeyPressed
		// TODO add your handling code here:
	}// GEN-LAST:event_sendKeyPressed

	private void typeKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_typeKeyPressed
		// TODO add your handling code here:
		keyPressListener(evt);
	}// GEN-LAST:event_typeKeyPressed

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
			java.util.logging.Logger.getLogger(ChatScreen.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ChatScreen.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ChatScreen.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ChatScreen.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ChatScreen dialog = new ChatScreen(new javax.swing.JFrame(),
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
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JEditorPane recv;
	private javax.swing.JButton send;
	private javax.swing.JTextArea type;

	// End of variables declaration//GEN-END:variables

	/**
	 * Sending and Receiving Message
	 */
	private void clickOnSend() {

		String msg = type.getText();
		if (!msg.equals("")) {
			try {
				XMPPConnection connection = XmppManager.getConnection();
				if (connection != null) {
					Chat chat = connection.getChatManager().createChat(
							buddyJID, new MessageListener() {

								@Override
								public void processMessage(Chat chat,
										Message message) {

									String from = message.getFrom();
									String body = message.getBody();
									appendData(from, body, false);
								}
							});
					chat.sendMessage(msg);
					appendData(connection.getUser(), msg, true);
				}
			} catch (XMPPException ex) {
				Logger.getLogger(ChatScreen.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}

	/**
	 * Message append
	 *
	 * @param user
	 * @param str
	 * @param received
	 */
	private void appendData(String user, String str, boolean received) {
		StringBuffer bfr = new StringBuffer(str);

		while (str.indexOf("X(") != -1) {
			int index = str.indexOf("X(");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + ANGRY + "\">");
			str = bfr.toString();
		}
		while (str.indexOf("x(") != -1) {
			int index = str.indexOf("x(");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + ANGRY + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":))") != -1) {
			int index = str.indexOf(":))");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + LAUGH + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":((") != -1) {
			int index = str.indexOf(":((");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + CRY + "\">");
			str = bfr.toString();
		}
		while (str.indexOf("B-)") != -1) {
			int index = str.indexOf("B-)");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + COOL + "\">");
			str = bfr.toString();
		}
		while (str.indexOf("=;") != -1) {
			int index = str.indexOf("=;");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + BYE + "\">");
			str = bfr.toString();
		}

		while (str.indexOf(">:)") != -1) {
			int index = str.indexOf(">:)");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + DEVIL + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":|") != -1) {
			int index = str.indexOf(":|");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + EQUISMILE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":-|") != -1) {
			int index = str.indexOf(":-|");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + EQUISMILE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":-P") != -1) {
			int index = str.indexOf(":-P");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + TONGUE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":P") != -1) {
			int index = str.indexOf(":P");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + TONGUE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":-o") != -1) {
			int index = str.indexOf(":-o");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + SURPRISE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":-O") != -1) {
			int index = str.indexOf(":-O");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + SURPRISE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf("~0)") != -1) {
			int index = str.indexOf("~0)");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + COFFEE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf("~o)") != -1) {
			int index = str.indexOf("~o)");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + COFFEE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":>") != -1) {
			int index = str.indexOf(":>");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + MEAN + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":->") != -1) {
			int index = str.indexOf(":->");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + MEAN + "\">");
			str = bfr.toString();
		}

		while (str.indexOf(":\">") != -1) {
			int index = str.indexOf(":\">");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + SHY + "\">");
			str = bfr.toString();
		}

		while (str.indexOf(":-/") != -1) {
			int index = str.indexOf(":-/");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + QUESTION + "\">");
			str = bfr.toString();
		}

		while (str.indexOf(":O") != -1) {
			int index = str.indexOf(":O");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + SURPRISE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":o") != -1) {
			int index = str.indexOf(":o");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + SURPRISE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":(") != -1) {
			int index = str.indexOf(":(");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + SAD + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":-(") != -1) {
			int index = str.indexOf(":-(");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + SAD + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":)") != -1) {
			int index = str.indexOf(":)");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + SMILE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":-)") != -1) {
			int index = str.indexOf(":-)");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + SMILE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(";)") != -1) {
			int index = str.indexOf(";)");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + WINK + "\">");
			str = bfr.toString();
		}

		while (str.indexOf(";-)") != -1) {
			int index = str.indexOf(";-)");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + WINK + "\">");
			str = bfr.toString();
		}

		while (str.indexOf(":x") != -1) {
			int index = str.indexOf(":x");
			bfr.replace(index, index + 2, "<IMG SRC=\"" + LOVE + "\">");
			str = bfr.toString();
		}
		while (str.indexOf(":-x") != -1) {
			int index = str.indexOf(":-x");
			bfr.replace(index, index + 3, "<IMG SRC=\"" + LOVE + "\">");
			str = bfr.toString();
		}

		if (user != null) {
			if (received) {
				if (str.contains("http")) {
					AppLog.success("ChatScreen", "In Http Sending");
					str = "'" + str + "'";
					AppLog.success("URL", str);
					str = "<FONT COLOR='red' STYLE='font-size:10pt;font-family:Arial'>"
							+ user
							+ ": </FONT><FONT STYLE='font-size:10pt;font-family:Arial'>"
							+ "<a href=" + str + ">" + str + "</a>";

				} else {
					str = "<FONT COLOR='red' STYLE='font-size:10pt;font-family:Arial'>"
							+ user
							+ ": </FONT><FONT STYLE='font-size:10pt;font-family:Arial'>"
							+ str;
				}

			} else {
				if (str.contains("http")) {
					AppLog.success("ChatScreen", "In Http Reciving");
					str = "'" + str + "'";
					AppLog.success("URL", str);
					str = "<FONT COLOR='blue' STYLE='font-size:10pt;font-family:Arial'>"
							+ user
							+ ": </FONT><FONT STYLE='font-size:10pt;font-family:Arial'>"
							+ "<a href=" + str + ">" + str + "</a>";
				} else {
					str = "<FONT COLOR='blue' STYLE='font-size:10pt;font-family:Arial'>"
							+ user
							+ ": </FONT><FONT STYLE='font-size:10pt;font-family:Arial'>"
							+ str;
				}
			}
		} else {
			str = "<FONT COLOR='red' STYLE='font-size:10pt;font-family:Arial'><B>"
					+ str;
		}

		str += "</FONT>";// Line break

		try {
			((HTMLEditorKit) recv.getEditorKit()).read(
					new java.io.StringReader(str), recv.getDocument(), recv
							.getDocument().getLength());
			recv.setCaretPosition(recv.getDocument().getLength());
			recv.addHyperlinkListener(new HyperlinkListener() {

				@Override
				public void hyperlinkUpdate(HyperlinkEvent e) {
					if (HyperlinkEvent.EventType.ACTIVATED.equals(e
							.getEventType())) {
						System.out.println(e.getURL());
						counter++;
						Desktop desktop = Desktop.getDesktop();
						try {
							if (counter < 2) {
								desktop.browse(e.getURL().toURI());
							} else {
								counter = 0;
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			});
		} catch (Exception e) {
		}
	}

	int counter = 0;

	private void keyPressListener(KeyEvent ke) {

		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			if (type.getText().length() == 0) {
				return;
			}
			clickOnSend();
			type.setText("");
		}
	}
}
