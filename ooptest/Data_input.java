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
import javax.swing.JTextField;

public class Data_input extends JFrame {
	private JButton regist,shinkisub,deletesub,mainsub,logoutsub;
	private JComboBox year,month,day;
	private JPanel contentPane;
	private JLabel titleLabel,dataIn,normal,normaltime,night,over;
	private JTextField normal_money,night_money,over_money;



	public Data_input() {
		setTitle("給与入力");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,255,255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dataIn = new JLabel("データ入力");
		dataIn.setFont(new Font("MS UI Gothic", Font.PLAIN, 50));
		dataIn.setBounds(438, 82, 231, 64);
		contentPane.add(dataIn);

	 normal = new JLabel("通常時給");
		normal.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		normal.setBounds(348, 283, 97, 29);
		contentPane.add(normal);

		 normaltime = new JLabel("勤務時間");
		normaltime.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		normaltime.setBounds(348, 349, 81, 27);
		contentPane.add(normaltime);

		JLabel label_3 = new JLabel("労働時間");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_3.setBounds(348, 414, 87, 26);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("年月日");
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_4.setBounds(348, 204, 81, 22);
		contentPane.add(label_4);

		normal_money = new JTextField();
		normal_money.setBounds(562, 286, 123, 28);
		contentPane.add(normal_money);
		normal_money.setColumns(10);

		night_money = new JTextField();
		night_money.setBounds(562, 351, 123, 29);
		contentPane.add(night_money);
		night_money.setColumns(10);

		over_money = new JTextField();
		over_money.setBounds(562, 428, 123, 29);
		contentPane.add(over_money);
		over_money.setColumns(10);

		JComboBox year = new JComboBox();
		year.setBounds(421, 190, 32, 22);
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015",
																 "2014", "2013", "2012", "2011", "2010"}));
		contentPane.add(year);

		JComboBox month = new JComboBox();
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



		JLabel label_5 = new JLabel("年");
		label_5.setBounds(525, 210, 17, 16);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("月");
		label_6.setBounds(647, 216, 22, 16);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("日");
		label_7.setBounds(740, 215, 22, 19);
		contentPane.add(label_7);


		 over = new JLabel("残業時間");
		over.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		over.setBounds(354, 487, 81, 28);
		contentPane.add(over);

		JTextField normal_money_3 = new JTextField();
		normal_money_3.setBounds(562, 490, 123, 29);
		contentPane.add(normal_money_3);
		normal_money_3.setColumns(10);

		titleLabel = new JLabel("データ入力");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));

		regist = new JButton("登録");
		regist.setForeground(Color.BLACK);
		regist.setFont(new Font("Helvetica Neue",Font.BOLD,30));
		regist.setBounds(487,585,100,30);
		regist.setActionCommand("登録");
		contentPane.add(regist);
		regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
			}
		});
/*		regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if(cmd.equals("登録") ) {
					String year1 = (String)year.getSelectedItem();
					String month1 = (String)month.getSelectedItem();
					String day1 = (String)day.getSelectedItem();

					Log_in.userid = userID.getText();
					new_name = name.getText();
					char[] passwordchar = pass.getPassword();
					Log_in.passwordstr = new String(passwordchar);
					int ans = JOptionPane.showConfirmDialog(null, "登録しますか？","新規登録",
							JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );
					//0がYes、１がNo
					if(ans == 0) {
						boolean sqlans = Mysql.ans(1);
						if(sqlans == true && Log_in.record == 1) {
						JOptionPane.showMessageDialog(null,cmd+"しました","メッセージ",
													 JOptionPane.PLAIN_MESSAGE);
						}else {
							userID.setText(null);
							pass.setText(null);
							name.setText(null);
							JOptionPane.showMessageDialog(null,"既に同じユーザIDが登録されています","メッセージ",
								 JOptionPane.PLAIN_MESSAGE);
						}
					}
				}
			}
		 }
	     );*/

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
