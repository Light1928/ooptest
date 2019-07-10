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

	protected JPanel contentPane;
	protected JLabel titlelabel,userlabel,passlabel,namelabel;
	protected JTextField userID,name;
	protected JPasswordField password;
	protected JButton regist;//,mainsub,deletesub,tukisub,logoutsub;
	protected LineBorder userBorder,passBorder,nameBorder;

	 Shinki_registration_Main() {
		setTitle("新規登録");
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255,255,255));

		titlelabel = new JLabel("新規登録");
		titlelabel.setFont(new Font("MS UI Gothic", Font.BOLD, 55));
		titlelabel.setBounds(295, 53, 232, 99);
		contentPane.add(titlelabel);

		userlabel = new JLabel("ユーザID");
		userlabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		userlabel.setBounds(191, 187, 101, 34);
		contentPane.add(userlabel);

		passlabel = new JLabel("パスワード");
		passlabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		passlabel.setBounds(191, 275, 101, 34);
		contentPane.add(passlabel);

		namelabel = new JLabel("名前");
		namelabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		namelabel.setBounds(213, 362, 59, 34);
		contentPane.add(namelabel);

		userID = new JTextField(20);
		userBorder = new LineBorder(new Color(29,161,242), 1, true);
		userID.setBorder(userBorder);
		userID.setBounds(298, 187, 333, 34);
		contentPane.add(userID);

		password = new JPasswordField();
		passBorder = new LineBorder(new Color(29,161,242), 1, true);
		password.setBorder(passBorder);

		password.setBounds(298, 275, 333, 34);
		contentPane.add(password);

		name = new JTextField();
		nameBorder = new LineBorder(new Color(29,161,242), 1, true);
		name.setBorder(nameBorder);
		name.setBounds(298, 362, 333, 34);
		contentPane.add(name);

		regist = new JButton("登録");

		regist.setBounds(361, 436, 87, 25);
		contentPane.add(regist);
		regist.setFont(new Font("Helvetica Neue", Font.BOLD, 20));


		 regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				JFrame frame = new JFrame();

				//移動したいページのインスタンス生成
				Log_in login = new Log_in();
				if(cmd.equals("登録") ) {
					int ans = JOptionPane.showConfirmDialog(null, "登録しますか？","新規登録",
							JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );
					//0がYes、１がNo
					if(ans == 0){
						JOptionPane.showMessageDialog(frame,cmd+"しました","メッセージ",
													 JOptionPane.PLAIN_MESSAGE);
						login.setVisible(true);
						setVisible(false);
					}
				}
			}
		 }
		 );
		
	}
}
