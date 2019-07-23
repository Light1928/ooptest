package ooptest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Month extends JFrame {
	private String yeardata,monthdata;
	private JPanel month_Pane;
	private JLabel yearLabel,monthLabel;
	private JButton meisai,shinkisub,deletesub,mainsub,logoutsub;
	private JComboBox year,month;


     Month() {
		setTitle("月選択");
		setSize(1100,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		month_Pane = new JPanel();
		month_Pane.setBackground(new Color(255,255,255));
		month_Pane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(month_Pane);
		month_Pane.setLayout(null);

		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015",
																 "2014", "2013", "2012", "2011", "2010"}));
		year.setBounds(318, 232, 125, 55);
		
		month_Pane.add(year);

		month = new JComboBox();
		month.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6",
																   "7", "8", "9", "10", "11", "12"}));
		month.setBounds(605, 232, 125, 55);
		 
		month_Pane.add(month);

		meisai = new JButton("明細");
		meisai.setBounds(445, 506, 164, 62);
		meisai.setFont(new Font("Helvetica Neue",Font.BOLD,25));
		meisai.setForeground(new Color(255,255,255));
		meisai.setBackground(new Color(29,161,242));
		meisai.setActionCommand("明細");
		month_Pane.add(meisai);
		meisai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				//明細ページのインスタンス生成
				Meisai meisai = new Meisai();
				if(cmd.equals("明細")) {
					yeardata = (String)year.getSelectedItem();
					monthdata = (String)month.getSelectedItem();
					boolean ans = Mysql.ans(4);

					//明細ページに遷移
					meisai.setVisible(true);
					setVisible(false);
				}
			}
		}
		);

		yearLabel = new JLabel("年");
		yearLabel.setBounds(455, 247, 57, 28);
		month_Pane.add(yearLabel);

		monthLabel = new JLabel("月");
		monthLabel.setBounds(742, 247, 57, 24);
		month_Pane.add(monthLabel);

	    shinkisub = new JButton("新規登録");
		shinkisub.setActionCommand("新規登録");
		shinkisub.setBounds(827, 10, 125, 19);
		shinkisub.setBackground(new Color(255,153,0));
		month_Pane.add(shinkisub);

		shinkisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				//新規登録ページのインスタンス生成
				Shinki_registration_Sub new_Account = new Shinki_registration_Sub();
				if(cmd.equals("新規登録")) {

					//新規登録ページに遷移
					new_Account.setVisible(true);
					setVisible(false);

				}
			}
		}
		);


		deletesub = new JButton("アカウント削除");
		deletesub.setBounds(957, 10, 125, 19);
		deletesub.setActionCommand("アカウント削除");
		deletesub.setBackground(new Color(255,153,0));
		month_Pane.add(deletesub);
		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			//遷移したいページのインスタンス生成
			Delete_account new_Account = new Delete_account();
			if(cmd.equals("アカウント削除") && Log_in.permission == true) {
				//新規登録画面へ
				new_Account.setVisible(true);
				setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null,"権限がないためアクセスを拒否します","メッセージ",
						JOptionPane.PLAIN_MESSAGE);
			}

			}
		}
		);


		mainsub = new JButton("メインメニュー");
		mainsub.setBounds(827, 32, 125, 19);
		mainsub.setBackground(new Color(255,153,0));
		month_Pane.add(mainsub);
		mainsub.setActionCommand("メインメニュー");
		mainsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				//メインメニューページのインスタンス生成
				Main_menu main = new Main_menu();
				if(cmd.equals("メインメニュー")) {

					//メインメニューページに遷移
					main.setVisible(true);
					setVisible(false);
				}
			}
		}
		);

		 logoutsub = new JButton("ログアウト");
		 logoutsub.setActionCommand("ログアウト");
		 logoutsub.setBounds(957, 32, 125, 19);
		 logoutsub.setBackground(new Color(255,153,0));
	     month_Pane.add(logoutsub);

		 logoutsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//ログインページのインスタンス生成
				Log_in login = new Log_in();
				if(cmd.equals("ログアウト") ) {
					int ans = JOptionPane.showConfirmDialog(null, "ログアウトしますか？","ログアウト",
							JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );

					//0がYes、１がNo
					if(ans == 0){
						JOptionPane.showMessageDialog(null,cmd+"しました","メッセージ",JOptionPane.PLAIN_MESSAGE);

						//ログインページに遷移
						login.setVisible(true);
						setVisible(false);
					}
				}
			}
		}
		);
	}
     Month(String title){}
     
     public String getYeardata() {
    	 return this.yeardata;
     }
     
     public  String getMonthdata() {
    	 return this.monthdata;
     }
}
