package ooptest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MyactionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Log_out logout = new Log_out();
		Log_in login = new Log_in();
		JOptionPane.showMessageDialog(null,cmd+"しました");
		if(cmd.equals("ログイン")) {	
			//.setVisible(false);
			logout.setVisible(true);
		}else if(cmd.equals("ログアウト")) {
			login.setVisible(true);
			//logout.setVisible(false);
		}
	}
}
