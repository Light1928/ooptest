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


public class Log_in extends JFrame implements ActionListener {
	
	private JPanel loginPanel;
	private JLabel titleLabel,userLabel,passLabel;
	private JTextField userID,pass;
	private JButton log_in;
	
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

		//ログイン画面描画
		titleLabel = new JLabel("SalaPay");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		userLabel = new JLabel("ユーザID");
		passLabel = new JLabel("パスワード");
		userID = new JTextField(20);
		pass = new JPasswordField(20);
		log_in = new JButton("ログイン");
		log_in.setActionCommand("ログイン");
		
		//ボタンを押した時の処理をMyactionlistenerに渡す
		log_in.addActionListener(this);
		titleLabel.setBounds(300,50,600,200);
		userLabel.setBounds(330,250,100,30);
		passLabel.setBounds(330,300,100,30);
		userID.setBounds(410, 250, 150, 30);
		pass.setBounds(410, 300, 150, 30);
		log_in.setBounds(459,350,100,30);

		//ログインパネルに貼り付け
		loginPanel.add(titleLabel);
		loginPanel.add(userLabel);
		loginPanel.add(passLabel);
		loginPanel.add(userID);
		loginPanel.add(pass);
		loginPanel.add(log_in);
		contentPane.add(loginPanel);
		
		//レイアウトマネージャ無効にして配置を自由に
		loginPanel.setLayout(null);
	}
	
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