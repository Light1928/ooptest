package ooptest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Font;

public class Main_menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	

	
	public Main_menu() {
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton button = new JButton("月選択");
		button.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(245, 259, 149, 70);
		panel.add(button);
		
		JButton button_1 = new JButton("新規登録");
		button_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		button_1.setBounds(490, 259, 154, 70);
		panel.add(button_1);
		
		JButton button_2 = new JButton("新規登録");
		button_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(629, 10, 113, 19);
		panel.add(button_2);
		
		JButton button_3 = new JButton("アカウント削除");
		button_3.setBounds(744, 10, 128, 19);
		panel.add(button_3);
		
		JButton button_4 = new JButton("月選択");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setBounds(629, 32, 113, 19);
		panel.add(button_4);
		
		JButton logout = new JButton("ログアウト");
		logout.addActionListener(this);
		logout.setActionCommand("ログアウト");
		logout.setBounds(744, 32, 128, 19);
		panel.add(logout);
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		//遷移したいページのインスタンス生成
		Log_out logout = new Log_out();
		if(cmd.equals("ログアウト")) {
			logout.setVisible(true);
			setVisible(false);
		}
	}
}
