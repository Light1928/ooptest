package ooptest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Data_input extends JFrame {

	static String yeardata,monthdata1,daydata1,money,starttime,endtime;

	private JButton regist,shinkisub,deletesub,mainsub,logoutsub;
	private JComboBox year,month,day;
	private JPanel contentPane;
	private JLabel titleLabel,normal,normaltime,leaving_work,date,
				   year_label,month_label,day_label,login_name;
	private JTextField normal_money,start_time,end_time;

	public Data_input() {
		setTitle("給与入力");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		titleLabel = new JLabel("データ入力");
		titleLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 50));
		titleLabel.setBounds(438, 82, 247, 64);
		contentPane.add(titleLabel);

	    normal = new JLabel("通常時給");
		normal.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		normal.setBounds(384, 302, 97, 29);
		contentPane.add(normal);

		normaltime = new JLabel("出勤時間");
		normaltime.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		normaltime.setBounds(384, 396, 97, 27);
		contentPane.add(normaltime);

		leaving_work = new JLabel("退勤時間");
		leaving_work.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		leaving_work.setBounds(384, 493, 87, 26);
		contentPane.add(leaving_work);

		date = new JLabel("年月日");
		date.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		date.setBounds(348, 204, 81, 22);
		contentPane.add(date);

		normal_money = new JTextField();
		normal_money.setBounds(581, 305, 123, 28);
		contentPane.add(normal_money);
		normal_money.setColumns(10);

		start_time = new JTextField();
		start_time.setBounds(581, 398, 123, 29);
		contentPane.add(start_time);
		start_time.setColumns(10);

		end_time = new JTextField();
		end_time.setBounds(581, 495, 123, 29);
		contentPane.add(end_time);
		end_time.setColumns(10);

		year = new JComboBox();
		year.setBounds(421, 190, 32, 22);
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015",
																 "2014", "2013", "2012", "2011", "2010"}));
		contentPane.add(year);


		 month = new JComboBox();
		month.setBounds(486, 190, 32, 22);
		month = new JComboBox();
		month.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6",
																   "7", "8", "9", "10", "11", "12"}));
		contentPane.add(month);

		day = new JComboBox();
		day.setBounds(686, 204, 46, 29);
		day.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12",
				"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",}));
		contentPane.add(day);

		year.setBounds(429, 205, 84, 27);
		month.setBounds(583, 204, 52, 28);

		year_label = new JLabel("年");
		year_label.setBounds(525, 210, 28, 16);
		year_label.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		contentPane.add(year_label);

		month_label = new JLabel("月");
		month_label.setBounds(647, 204, 22, 28);
		month_label.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		contentPane.add(month_label);

		day_label = new JLabel("日");
		day_label.setBounds(740, 204, 22, 30);
		day_label.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		contentPane.add(day_label);


		regist = new JButton("登録");
		regist.setForeground(Color.BLACK);
		regist.setFont(new Font("Helvetica Neue",Font.BOLD,30));
		regist.setForeground(new Color(255,255,255));
		regist.setBackground(new Color(29,161,242));
		regist.setBounds(487,585,100,39);
		regist.setActionCommand("登録");
		contentPane.add(regist);

		regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.contentEquals("登録")) {
					Pattern pattern = Pattern.compile("[0-9a-zA-Z]+$");
					starttime= start_time.getText();
					endtime=end_time.getText();
					money = normal_money.getText();
					 yeardata = (String)year.getSelectedItem();;
					 monthdata1 = (String)month.getSelectedItem();
					 daydata1 = (String)day.getSelectedItem();
					 Matcher match_starttime = pattern.matcher(starttime);
					 Matcher match_endtime = pattern.matcher(endtime);
					 Matcher match_money = pattern.matcher(money);
					 int ans =JOptionPane.showConfirmDialog(null, "登録しますか？","データ入力"
								,JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);

					 if(ans == 0) {

						 if(starttime.equals("") || endtime.equals("") || money.equals("") ) {
							 JOptionPane.showMessageDialog(null,"全て入力してください","メッセージ",
										JOptionPane.PLAIN_MESSAGE);
						 }else if(match_starttime.find() == true && match_endtime.find() == true &&
								  match_money.find() == true) {

						 boolean sqlans = Mysql.ans(3);
						 if(sqlans ==true) {
							 JOptionPane.showMessageDialog(null, cmd+"しました","メッセージ",
									 JOptionPane.PLAIN_MESSAGE);
						 }
					 }else {

						 JOptionPane.showMessageDialog(null,"半角英数字で入力してください","メッセージ",
									JOptionPane.PLAIN_MESSAGE);
							start_time.setText(null);
							end_time.setText(null);
							normal_money.setText(null);
					 }
					 }
				}
			}
		}
		);
		login_name = new JLabel(Log_in.username+" 様");
		login_name.setFont(new Font("Helvetica Neue",Font.PLAIN,15));
		login_name.setBounds(20,5,125,19);
		contentPane.add(login_name);

	    shinkisub = new JButton("新規登録");
		shinkisub.setActionCommand("新規登録");
		shinkisub.setBounds(827, 10, 125, 19);
		shinkisub.setBackground(new Color(255,153,0));
		contentPane.add(shinkisub);

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
		contentPane.add(deletesub);
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
		contentPane.add(mainsub);
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
		 contentPane.add(logoutsub);

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
}