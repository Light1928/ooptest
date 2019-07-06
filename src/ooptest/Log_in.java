package ooptest;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Log_in extends JFrame implements Title,ActionListener {
	public JPanel loginPanel;
	private JPanel mainPanel;
	private JLabel titleLabel,userLabel,passLabel;
	private JTextField userID,pass;
	private JButton sign_in;
	private CardLayout cardlayout;

	//コンストラクタ
	Log_in(){
		loginPanel = new JPanel();
		loginPanel.setLayout(this.cardlayout);
	}

	Log_in(String title) {

		setTitle(title);
		setBounds(100,100,900,600);//Frameの左上ｘ座標、ｙ座標、幅、高さを設定
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//xボタンを押されたら終了
	}
	@Override
	public void panelSet() {
		Container contentPane = getContentPane();

		//遷移用パネル
		loginPanel = new JPanel();
		Log_out logout = new Log_out();
		 logout.panelSet();

		//カードレイアウト登録
		mainPanel = new JPanel();
		cardlayout = new CardLayout();
		mainPanel.setLayout(cardlayout);
		mainPanel.add(loginPanel,"サインイン");
		mainPanel.add(logout.logoutPanel,"ログアウト");
		contentPane.add(mainPanel);

		//ログイン画面描画
		titleLabel = new JLabel("SalaPay");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		userLabel = new JLabel("ユーザID");
		passLabel = new JLabel("パスワード");
		userID = new JTextField(20);
		pass = new JTextField(20);
		sign_in = new JButton("サインイン");
		sign_in.setActionCommand("ログアウト");
		sign_in.addActionListener(this);
		titleLabel.setBounds(300,50,600,200);
		userLabel.setBounds(330,250,100,30);
		passLabel.setBounds(330,300,100,30);
       userID.setBounds(410, 250, 150, 30);
       pass.setBounds(410, 300, 150, 30);
       sign_in.setBounds(473,350,90,30);

       //ログインパネルに貼り付け
       loginPanel.add(titleLabel,BorderLayout.CENTER);
       loginPanel.add(userLabel,BorderLayout.CENTER);
       loginPanel.add(passLabel,BorderLayout.CENTER);
       loginPanel.add(userID,BorderLayout.CENTER);
       loginPanel.add(pass,BorderLayout.CENTER);
       loginPanel.add(sign_in,BorderLayout.CENTER);
       //レイアウトマネージャ無効にして配置を自由に
       loginPanel.setLayout(null);
	}
	//ボタンを押した時の処理
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		cardlayout.show(this.mainPanel,cmd);
	}
}