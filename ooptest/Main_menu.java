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
		
		JButton tukiselect = new JButton("月選択");
		tukiselect.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		tukiselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tukiselect.setBounds(245, 259, 154, 70);
		panel.add(tukiselect);
		
		JButton shinkiselect = new JButton("新規登録");
		shinkiselect.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		shinkiselect.setBounds(500, 259, 154, 70);
		panel.add(shinkiselect);
		
		JButton shinkisub = new JButton("新規登録");
		shinkisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		shinkisub.setBounds(620, 10, 125, 19);
		panel.add(shinkisub);
		
		JButton deletesub = new JButton("アカウント削除");
		deletesub.setBounds(750, 10, 125, 19);
		panel.add(deletesub);
		
		JButton tukisub = new JButton("月選択");
		tukisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tukisub.setBounds(620, 32, 125, 19);
		panel.add(tukisub);
		
		JButton logoutsub = new JButton("ログアウト");
		logoutsub.addActionListener(this);
		logoutsub.setActionCommand("ログアウト");
		logoutsub.setBounds(750, 32, 125, 19);
		panel.add(logoutsub);
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
