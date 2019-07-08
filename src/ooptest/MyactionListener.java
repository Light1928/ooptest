package ooptest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyactionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JFrame parent = new JFrame();
		String cmd = e.getActionCommand();
		Log_out logout = new Log_out();
		Log_in login = new Log_in();
		JOptionPane.showMessageDialog(parent,cmd+"しました","メッセージ",JOptionPane.PLAIN_MESSAGE);
		if(cmd.equals("ログイン")) {
			login.setVisible(true);
			logout.setVisible(true);
			
		}else if(cmd.equals("ログアウト")) {
			logout.setVisible(false);
			login.setVisible(true);
			
		}
	}
}
