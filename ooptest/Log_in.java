package ooptest;

import java.awt.Color;
import java.awt.Container;
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


public class Log_in extends JFrame  {

	static int record;
	static String userid,passwordstr,username;
	static boolean ans,permission;
	private Container contentPane;
	private JPanel loginPanel;
	private JLabel titleLabel,userLabel,passLabel,signupLabel;
	private JTextField userID;
	private JPasswordField pass;
	private LineBorder userBorder,passBorder;
	private JButton log_in,sign_up;

	Log_in(){

		//フレームの設定
		setTitle("SalaPay-ログイン");
		setSize(1100,800);//Frameの左上ｘ座標、ｙ座標、幅、高さを設定
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = getContentPane();

		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255,255,255));
		//レイアウトマネージャ無効にして配置を自由に
		loginPanel.setLayout(null);

		//ログイン画面描画
		titleLabel = new JLabel("SalaPay");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Helvetica Neue",Font.BOLD,100));
		titleLabel.setBounds(370,95,601,200);
		loginPanel.add(titleLabel);
		contentPane.add(loginPanel);

		userLabel = new JLabel("ユーザID");
		userLabel.setFont(new Font("Helvetica Neue",Font.BOLD,16));
		userLabel.setBounds(424,333,100,30);
		loginPanel.add(userLabel);

		passLabel = new JLabel("パスワード");
		passLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		passLabel.setBounds(424,390,100,30);
		loginPanel.add(passLabel);

		signupLabel = new JLabel("アカウントをお持ちでない方はこちら");
		signupLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		signupLabel.setBounds(450,495,250,30);
		loginPanel.add(signupLabel);

		userID = new JTextField(30);
		userBorder = new LineBorder(new Color(29,161,242), 1, true);
		userID.setBorder(userBorder);
		userID.setBounds(536, 334, 150, 30);
		loginPanel.add(userID);

		pass = new JPasswordField(30);
		passBorder = new LineBorder(new Color(29,161,242), 1, true);
		pass.setBounds(536, 391, 150, 30);
		pass.setBorder(passBorder);
		loginPanel.add(pass);

		log_in = new JButton("ログイン");
		log_in.setForeground(new Color(255,255,255));
		log_in.setBackground(new Color(29,161,242));
		log_in.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		log_in.setBounds(570,446,117,35);
		loginPanel.add(log_in);

		log_in.setActionCommand("ログイン");

		//ログインボタンを押したら時の処理
		log_in.addActionListener(new ActionListener() {
			//private String userid;

			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if(cmd.equals("ログイン")) {
				    userid = userID.getText();
					//passをchar型配列で取得してからString型に変換
					char[] passwordchar = pass.getPassword();
				    passwordstr = new String(passwordchar);
				   boolean ans = Mysql.ans(0);
				    if(ans == true) {
						Main_menu main_menu = new Main_menu();
						main_menu.setVisible(true);
						setVisible(false);
					}else {
						userID.setText(null);
						pass.setText(null);
						JOptionPane.showMessageDialog(null,"アカウントが登録されていない、"
								+ "またはユーザID、パスワードが違います","メッセージ",
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		}
		);

		sign_up = new JButton("新規登録");
		sign_up.setForeground(new Color(255,255,255));
		sign_up.setBackground(new Color(0,181,0));
		sign_up.setFont(new Font("Helvetica Neue",Font.BOLD,13));
		sign_up.setBounds(570,537,117,35);
		loginPanel.add(sign_up);
		sign_up.setActionCommand("新規登録");

		//新規登録ボタンを押した時の処理
		sign_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成（新規登録画面へ）
				Shinki_registration_Main new_Account = new Shinki_registration_Main();
				if(cmd.equals("新規登録")) {
					new_Account.setVisible(true);
					setVisible(false);
				}
			}
		}
		);

	}

}
