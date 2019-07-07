package ooptest;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyactionListener implements ActionListener {
	private CardLayout cardlayout;
	private JPanel mainPanel;

	//コンストラクタ
	public MyactionListener(CardLayout cardlayout,JPanel mainpanel) {
		this.cardlayout = cardlayout;
		this.mainPanel = mainpanel;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JOptionPane.showMessageDialog(null,cmd+"しました");
		cardlayout.show(this.mainPanel, cmd);
	}
}
