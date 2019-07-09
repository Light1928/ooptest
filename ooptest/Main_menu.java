package ooptest;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;

public class Main_menu extends JFrame  {

	private JPanel contentPane,panel;
	private JButton tukiselect,shinkiselect,shinkisub,deletesub,tukisub,logoutsub;
	
	public Main_menu() {
		setTitle("メインメニュー");
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		 tukiselect = new JButton("月選択");
		tukiselect.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		tukiselect.setBounds(245, 259, 154, 70);
		panel.add(tukiselect);
		
		//月選択ボタンを押した場合の処理
		tukiselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Month month = new Month();
				if(cmd.equals("月選択")) {
					month.setVisible(true);
					setVisible(false);
				}
			}	
		}
		);
		
		shinkiselect = new JButton("新規登録");
		shinkiselect.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		shinkiselect.setBounds(500, 259, 154, 70);
		panel.add(shinkiselect);
		
		shinkiselect.setActionCommand("新規登録");
		shinkiselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Shinki_registration new_Account = new Shinki_registration();
				if(cmd.equals("新規登録")) {
					new_Account.setVisible(true);
					setVisible(false);
				}
			}
		}
		);
		
		 shinkisub = new JButton("新規登録");
		 shinkisub.setActionCommand("新規登録");
		 shinkisub.setBounds(620, 10, 125, 19);
			panel.add(shinkisub);
			
		shinkisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Shinki_registration new_Account = new Shinki_registration();
				if(cmd.equals("新規登録")) {
					new_Account.setVisible(true);
					setVisible(false);	
				}
			}
		}
		);
		
		
		deletesub = new JButton("アカウント削除");
		deletesub.setBounds(750, 10, 125, 19);
		deletesub.setActionCommand("アカウント削除");
		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		}
		);
		panel.add(deletesub);
		
		
		 tukisub = new JButton("月選択");
		 tukisub.setBounds(620, 32, 125, 19);
		panel.add(tukisub);
		tukisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Month month = new Month();
				if(cmd.equals("月選択")) {
					month.setVisible(true);
					setVisible(false);
				
				}
			}
		}
		);
		
		
		 logoutsub = new JButton("ログアウト");
		 logoutsub.setActionCommand("ログアウト");
		 logoutsub.setActionCommand("ログアウト");
			logoutsub.setBounds(750, 32, 125, 19);
			panel.add(logoutsub);
		 
		logoutsub.addActionListener(new ActionListener() {
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
		);	
	}
}
