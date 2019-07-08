package ooptest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Log_out extends JFrame {
	private JPanel logoutPanel;
	private JLabel titleLabel,userLabel,passLabel;
	private JTextField userID,pass;
	private JButton log_out;

	//コンストラクタ
	Log_out(){
		setTitle("ログアウト");
		setSize(900,600);//Frameの左上ｘ座標、ｙ座標、幅、高さを設定
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//xボタンを押されたら終了
		Container contentPane = getContentPane();
		logoutPanel = new JPanel();
		titleLabel = new JLabel("ログアウト");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		userLabel = new JLabel("ユーザID");
		passLabel = new JLabel("パスワード");
		userID = new JTextField(20);
		pass = new JTextField(20);
		log_out = new JButton("ログアウト");
		log_out.setActionCommand("ログアウト");
		log_out.addActionListener(new MyactionListener());
		titleLabel.setBounds(250,50,600,200);
		userLabel.setBounds(330,250,100,30);
		passLabel.setBounds(330,300,100,30);
		userID.setBounds(410, 250, 150, 30);
		pass.setBounds(410, 300, 150, 30);
		log_out.setBounds(473,350,100,30);

		//ログアウトパネルに貼り付け
		logoutPanel.add(titleLabel,BorderLayout.CENTER);
		logoutPanel.add(userLabel,BorderLayout.CENTER);
		logoutPanel.add(passLabel,BorderLayout.CENTER);
		logoutPanel.add(userID,BorderLayout.CENTER);
		logoutPanel.add(pass,BorderLayout.CENTER);
		logoutPanel.add(log_out,BorderLayout.CENTER);
		contentPane.add(logoutPanel);
		//レイアウトマネージャ無効にして配置を自由に
		logoutPanel.setLayout(null);
	}
}