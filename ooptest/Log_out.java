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


public class Log_out extends JFrame implements ActionListener {
	
	private JPanel logoutPanel;
	private JLabel titleLabel,passLabel;
	private JTextField pass;
	private JButton log_out;

	//コンストラクタ
	Log_out(){
		
		//フレームの設定
		setTitle("ログアウト");
		setSize(900,600);//Frameの左上ｘ座標、ｙ座標、幅、高さを設定
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//xボタンを押されたら終了
		
		//コンテナ作成
		Container contentPane = getContentPane();
		
		logoutPanel = new JPanel();
		titleLabel = new JLabel("ログアウト");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		passLabel = new JLabel("パスワード");
		pass = new JPasswordField(20);
		log_out = new JButton("ログアウト");
		log_out.setActionCommand("ログアウト");
		log_out.addActionListener(this);
		
//		背景色をつける場合の文法
		//logoutPanel.setBackground(new Color(255,255,255));
		titleLabel.setBounds(250,50,600,200);
		passLabel.setBounds(330,300,100,30);
		pass.setBounds(410, 300, 150, 30);
		log_out.setBounds(459,350,100,30);

		//ログアウトパネルに貼り付け
		logoutPanel.add(titleLabel);
		logoutPanel.add(passLabel);
		logoutPanel.add(pass);
		logoutPanel.add(log_out);
		contentPane.add(logoutPanel);
		
		//レイアウトマネージャ無効にして配置を自由に
		logoutPanel.setLayout(null);

	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JFrame frame = new JFrame();

		//移動したいページのインスタンス生成
		Log_in login = new Log_in();
		if(cmd.equals("ログアウト") ) {
			int ans = JOptionPane.showConfirmDialog(null, "ログアウトしますか？","ログアウト", 		
					JOptionPane.YES_NO_OPTION , JOptionPane.QUESTION_MESSAGE);
			//0がYes、１がNo
			if(ans == 0){
			JOptionPane.showMessageDialog(frame,cmd+"しました","メッセージ",JOptionPane.PLAIN_MESSAGE);
			login.setVisible(true);
			setVisible(false);
			}
		}
	}
}