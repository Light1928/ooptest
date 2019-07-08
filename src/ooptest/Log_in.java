package ooptest;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;


public class Log_in extends JFrame implements ActionListener {
	private JPanel loginPanel;
	private JLabel titleLabel,userLabel,passLabel;
	private JTextField userID,pass;
	private JButton log_in;
	//コンストラクタ
	Log_in(){
		setTitle("ログイン");
		setSize(900,600);//Frameの左上ｘ座標、ｙ座標、幅、高さを設定
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//xボタンを押されたら終了
		Container contentPane = getContentPane();
		//遷移用パネル
		loginPanel = new JPanel();

		//ログイン画面描画
		titleLabel = new JLabel("SalaPay");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		userLabel = new JLabel("ユーザID");
		passLabel = new JLabel("パスワード");
		userID = new JTextField(20);
		pass = new JTextField(20);
		log_in = new JButton("ログイン");
		log_in.setActionCommand("ログイン");
		//ボタンを押した時の処理をMyactionlistenerに渡す
	//	log_in.addActionListener(new MyactionListener());
		log_in.addActionListener(this);
		titleLabel.setBounds(300,50,600,200);
		userLabel.setBounds(330,250,100,30);
		passLabel.setBounds(330,300,100,30);
		userID.setBounds(410, 250, 150, 30);
		pass.setBounds(410, 300, 150, 30);
		log_in.setBounds(473,350,100,30);

		//ログインパネルに貼り付け
		loginPanel.add(titleLabel,BorderLayout.CENTER);
		loginPanel.add(userLabel,BorderLayout.CENTER);
		loginPanel.add(passLabel,BorderLayout.CENTER);
		loginPanel.add(userID,BorderLayout.CENTER);
		loginPanel.add(pass,BorderLayout.CENTER);
		loginPanel.add(log_in,BorderLayout.CENTER);
		contentPane.add(loginPanel);
		//レイアウトマネージャ無効にして配置を自由に
		loginPanel.setLayout(null);
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JFrame frame = new JFrame();
		Log_out logout = new Log_out();
		JOptionPane.showMessageDialog(frame,cmd+"しました","メッセージ",JOptionPane.PLAIN_MESSAGE);
		if(cmd.equals("ログイン")) {
			setVisible(false);
			logout.setVisible(true);
			
		}
	}

}