package ooptest;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Log_in extends MainFrame implements Title {
	Log_in(String title) {
		//MainFrameコンストラクタ呼び出し
		super(title);
	}
	@Override
	public void content() {
		//タイトルメソッド呼び出し（実行されるわけではないコードの省略）
		super.content();
		//追加
		JLabel userLabel = new JLabel("ユーザID");
		JLabel passwordLabel = new JLabel("パスワード");
		JTextField userID = new JTextField(20);
		JTextField password = new JTextField(20);
		JButton sign_in = new JButton("サインイン");
		JButton sign_up = new JButton("サインアップ");
		userLabel.setBounds(330,250,100,30);
		passwordLabel.setBounds(330,300,100,30);
        userID.setBounds(410, 250, 150, 30);
        password.setBounds(410, 300, 150, 30);
        sign_in.setBounds(473,350,90,30);
        super.getContentPane().add(userLabel,BorderLayout.CENTER);
        super.getContentPane().add(passwordLabel,BorderLayout.CENTER);
        super.getContentPane().add(userID,BorderLayout.CENTER);
        super.getContentPane().add(password,BorderLayout.CENTER);
        super.getContentPane().add(sign_in,BorderLayout.CENTER);
	}
}
