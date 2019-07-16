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
	private JButton regist;
	private JComboBox year,month,day;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JTextField normal_money,night_money,over_money;
	


	public Data_input() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1100, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("データ入力");
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 50));
		label.setBounds(318, 74, 274, 63);
		contentPane.add(label);

		JLabel label_1 = new JLabel("通常時給");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_1.setBounds(276, 248, 97, 29);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("勤務時間");
		label_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_2.setBounds(276, 310, 81, 27);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("労働時間");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_3.setBounds(276, 371, 87, 26);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("年月日");
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_4.setBounds(276, 187, 81, 22);
		contentPane.add(label_4);

		normal_money = new JTextField();
		normal_money.setBounds(419, 251, 123, 28);
		contentPane.add(normal_money);
		normal_money.setColumns(10);

		night_money = new JTextField();
		night_money.setBounds(419, 312, 123, 29);
		contentPane.add(night_money);
		night_money.setColumns(10);

		over_money = new JTextField();
		over_money.setBounds(419, 373, 123, 29);
		contentPane.add(over_money));
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
		day.setBounds(553, 187, 41, 29);
		day.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12",
				"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",}));
		contentPane.add(day);



		year.setBounds(391, 187, 62, 27);


		month.setBounds(480, 187, 41, 28);



		JLabel label_5 = new JLabel("年");
		label_5.setBounds(465, 193, 17, 16);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("月");
		label_6.setBounds(533, 193, 22, 16);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("日");
		label_7.setBounds(606, 192, 22, 19);
		contentPane.add(label_7);


		JLabel label_8 = new JLabel("残業時間");
		label_8.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_8.setBounds(276, 431, 81, 28);
		contentPane.add(label_8);

		normal_money_3 = new JTextField();
		normal_money_3.setBounds(419, 434, 123, 29);
		contentPane.add(normal_money_3);
		normal_money_3.setColumns(10);

		titleLabel = new JLabel("データ入力");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		
		regist = new JButton("登録");
		regist.setForeground(Color.BLACK);
		regist.setFont(new Font("Helvetica Neue",Font.BOLD,30));
		regist.setBounds(300,500,100,30);
		regist.setActionCommand("登録");
		contentPane.add(regist);
		regist.addActionListener(new ActionListener() {
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
	     );

	}
}
