package ooptest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
public class Shinki_registration_Main extends JFrame  {

	static String new_name;
	protected JPanel contentPane;
	protected JLabel titleLabel,userLabel,passLabel,nameLabel,message1,message2;
	protected JTextField userID,name;
	protected JPasswordField pass;
	protected JButton regist,login;
	protected LineBorder userBorder,passBorder,nameBorder;

	Shinki_registration_Main() {
		setTitle("新規登録");
		setSize(1100,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255,255,255));

		titleLabel = new JLabel("新規登録");
		titleLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 55));
		titleLabel.setBounds(424, 117, 232, 99);
		contentPane.add(titleLabel);

		userLabel = new JLabel("ユーザID");
		userLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		userLabel.setBounds(333, 297, 101, 34);
		contentPane.add(userLabel);

		passLabel = new JLabel("パスワード");
		passLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		passLabel.setBounds(333, 383, 101, 34);
		contentPane.add(passLabel);

		nameLabel = new JLabel("名前");
		nameLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		nameLabel.setBounds(344, 467, 59, 34);
		contentPane.add(nameLabel);

		userID = new JTextField(20);
		userBorder = new LineBorder(new Color(29,161,242), 1, true);
		userID.setBorder(userBorder);
		userID.setBounds(460, 300, 299, 34);
		contentPane.add(userID);

		pass = new JPasswordField();
		passBorder = new LineBorder(new Color(29,161,242), 1, true);
		pass.setBorder(passBorder);
		pass.setBounds(460, 386, 299, 34);
		contentPane.add(pass);

		name = new JTextField();
		nameBorder = new LineBorder(new Color(29,161,242), 1, true);
		name.setBorder(nameBorder);
		name.setBounds(460, 470, 299, 34);
		contentPane.add(name);

		regist = new JButton("登録");
		regist.setBounds(603, 573, 143, 54);
		regist.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		regist.setForeground(new Color(255,255,255));
		regist.setBackground(new Color(29,161,242));
		regist.setActionCommand("登録");
		contentPane.add(regist);
		regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if(cmd.equals("登録") ) {
					Log_in.userid = userID.getText();
					new_name = name.getText();
					char[] passwordchar = pass.getPassword();
					Log_in.passwordstr = new String(passwordchar);
					Pattern pattern = Pattern.compile("[0-9a-zA-Z]+$");
					Matcher match_userid = pattern.matcher(Log_in.userid);
					Matcher match_password = pattern.matcher(Log_in.passwordstr);

					int ans = JOptionPane.showConfirmDialog(null, "登録しますか？","新規登録",
							JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );
					//0がYes、１がNo
					if(ans == 0) {
						//TextFieldに何も入力されていなかったら
						if(Log_in.userid.equals("") || Log_in.passwordstr.equals("") ||
								new_name.equals("")) {
							JOptionPane.showMessageDialog(null,"全て入力してください","メッセージ",
									JOptionPane.PLAIN_MESSAGE);

						//入力した文字が半角英数字か判断
						}else if(match_userid.find() == true && match_password.find() == true) {

							boolean sqlans = Mysql.ans(1);
							if(sqlans == true && Log_in.record == 1) {
								JOptionPane.showMessageDialog(null,cmd+"しました","メッセージ",
										JOptionPane.PLAIN_MESSAGE);
								Log_in login = new Log_in();
								login.setVisible(true);
								setVisible(false);

							}else {
						//IDが重複または文字数が超えたら
								JOptionPane.showMessageDialog(null,"既に同じユーザIDが登録されているか、文字数が超えています",
										"メッセージ",JOptionPane.PLAIN_MESSAGE);
								userID.setText(null);
								pass.setText(null);
								name.setText(null);
							}
						}else {
						//半角英数字以外だったら
							JOptionPane.showMessageDialog(null,"半角英数字で入力してください","メッセージ",
									JOptionPane.PLAIN_MESSAGE);
							userID.setText(null);
							pass.setText(null);
							name.setText(null);
						}

					}
				}
			}
		}
				);

		login = new JButton("ログイン画面へ");
		login.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		login.setBounds(357, 573, 209, 54);
		login.setForeground(new Color(255,255,255));
		login.setBackground(new Color(29,161,242));
		login.setActionCommand("ログイン");
		contentPane.add(login);

		message1 = new JLabel("※半角数字30文字以下");
		message1.setBounds(460, 347, 188, 16);
		contentPane.add(message1);

		message2 = new JLabel("※半角数字30文字以下");
		message2.setBounds(460, 433, 188, 16);
		contentPane.add(message2);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("ログイン")) {
					Log_in login = new Log_in();
					login.setVisible(true);
					setVisible(false);
				}
			}
		}
		);
	}
}