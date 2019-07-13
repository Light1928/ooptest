package ooptest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	protected JLabel titlelabel,userlabel,passlabel,namelabel;
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

		titlelabel = new JLabel("新規登録");
		titlelabel.setFont(new Font("MS UI Gothic", Font.BOLD, 55));
		titlelabel.setBounds(447, 117, 232, 99);
		contentPane.add(titlelabel);

		userlabel = new JLabel("ユーザID");
		userlabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		userlabel.setBounds(361, 297, 101, 34);
		contentPane.add(userlabel);

		passlabel = new JLabel("パスワード");
		passlabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		passlabel.setBounds(361, 386, 101, 34);
		contentPane.add(passlabel);

		namelabel = new JLabel("名前");
		namelabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		namelabel.setBounds(392, 467, 59, 34);
		contentPane.add(namelabel);

		userID = new JTextField(20);
		userBorder = new LineBorder(new Color(29,161,242), 1, true);
		userID.setBorder(userBorder);
		userID.setBounds(508, 300, 333, 34);
		contentPane.add(userID);

		pass = new JPasswordField();
		passBorder = new LineBorder(new Color(29,161,242), 1, true);
		pass.setBorder(passBorder);
		pass.setBounds(508, 386, 333, 34);
		contentPane.add(pass);

		name = new JTextField();
		nameBorder = new LineBorder(new Color(29,161,242), 1, true);
		name.setBorder(nameBorder);
		name.setBounds(508, 470, 333, 34);
		contentPane.add(name);

		regist = new JButton("登録");
		regist.setBounds(624, 567, 110, 40);
		contentPane.add(regist);
		regist.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		regist.setActionCommand("登録");
		regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if(cmd.equals("登録") ) {
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

		login = new JButton("ログイン画面へ");
		login.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		login.setBounds(361, 567, 110, 40);
		contentPane.add(login);
		login.setActionCommand("ログイン");
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
