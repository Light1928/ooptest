package ooptest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Log_in extends JFrame  {
	private LineBorder userBorder,passBorder;
	private JPanel loginPanel;
	private JLabel titleLabel,userLabel,passLabel,signupLabel;
	private JTextField userID,pass;
	private JButton log_in,sign_up;

	//コンストラクタ
	Log_in(){

		//フレームの設定
		setTitle("SalaPay-ログイン");
		setSize(900,600);//Frameの左上ｘ座標、ｙ座標、幅、高さを設定
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//xボタンを押されたら終了

		//コンテナ作成
		Container contentPane = getContentPane();

		//ログインパネル
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(255,255,255));

		//ログイン画面描画
		titleLabel = new JLabel("SalaPay");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Helvetica Neue",Font.BOLD,80));

		userLabel = new JLabel("ユーザID");
		userLabel.setFont(new Font("Helvetica Neue",Font.BOLD,13));

		passLabel = new JLabel("パスワード");
		setFont(new Font("Helvetica Neue",Font.BOLD,13));

		signupLabel = new JLabel("アカウントをお持ちでない方はこちら");

		userID = new JTextField(20);
		userBorder = new LineBorder(new Color(29,161,242), 1, true);
		userID.setBorder(userBorder);

		pass = new JPasswordField(20);
	    passBorder = new LineBorder(new Color(29,161,242), 1, true);
		pass.setBorder(passBorder);

		log_in = new JButton("ログイン");
		log_in.setForeground(new Color(255,255,255));
		log_in.setBackground(new Color(29,161,242));
		log_in.setFont(new Font("Helvetica Neue",Font.BOLD,13));
		log_in.setActionCommand("ログイン");

		//ボタンを押したら時の処理
	    log_in.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String cmd = e.getActionCommand();
	    		//遷移したいページのインスタンス生成
	    		Main_menu main_menu = new Main_menu();
	    		if(cmd.equals("ログイン")) {
	    			main_menu.setVisible(true);
	    			setVisible(false);
	    		}
	    	}
	    }
	);

		sign_up = new JButton("新規登録");
		sign_up.setForeground(new Color(255,255,255));
		sign_up.setBackground(new Color(0,181,0));
		sign_up.setFont(new Font("Helvetica Neue",Font.BOLD,13));
		sign_up.setActionCommand("新規登録");

		//ボタンを押した時の処理をMyactionlistenerに渡す
		sign_up.addActionListener(new ActionListener() {
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
		titleLabel.setBounds(300,50,600,200);
		userLabel.setBounds(330,250,100,30);
		passLabel.setBounds(330,300,100,30);
		signupLabel.setBounds(330,380,250,30);
		userID.setBounds(410, 250, 150, 30);
		pass.setBounds(410, 300, 150, 30);
		log_in.setBounds(459,350,100,30);
		sign_up.setBounds(459,410,100,30);

		//ログインパネルに貼り付け
		loginPanel.add(titleLabel);
		loginPanel.add(userLabel);
		loginPanel.add(passLabel);
		loginPanel.add(signupLabel);
		loginPanel.add(userID);
		loginPanel.add(pass);
		loginPanel.add(log_in);
		loginPanel.add(sign_up);
		contentPane.add(loginPanel);

		//レイアウトマネージャ無効にして配置を自由に
		loginPanel.setLayout(null);
	}

}