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
import javax.swing.border.EmptyBorder;

public class Delete_account extends JFrame {

	private JPanel deletePane;
	private JLabel titleLabel,userLabel,passLabel;
	private JTextField userID;
	private JPasswordField pass;
	private JButton delete,shinkisub,mainsub,tukisub,logoutsub;


	public Delete_account() {
		setTitle("アカウント削除");
		setSize(1100,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		deletePane = new JPanel();
		deletePane.setBackground(new Color(255,255,255));
		deletePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(deletePane);
		deletePane.setLayout(null);

		titleLabel = new JLabel();
		titleLabel.setBounds(357,95,601,200);
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("Helvetica Neue",Font.BOLD,100));
		deletePane.add(titleLabel);

		userID = new JTextField();
		userID.setBounds(220, 104, 106, 22);
		deletePane.add(userID);
		userID.setColumns(10);

		pass = new JPasswordField();
		pass.setBounds(220, 206, 106, 22);
		deletePane.add(pass);
		pass.setColumns(10);

		delete = new JButton("削除");
		delete.setBounds(356, 340, 101, 25);
		deletePane.add(delete);
		delete.setActionCommand("削除");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if(cmd.equals("削除") ) {
					Log_in.userid = userID.getText();
					char[] passwordchar = pass.getPassword();
					Log_in.passwordstr = new String(passwordchar);
					int ans = JOptionPane.showConfirmDialog(null, "本当に削除しますか？",
							"削除",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );
					//0がYes、１がNo
					if(ans == 0){
						boolean sqlans = Mysql.ans(2);
						if(sqlans == true && Log_in.record == 1) {
						JOptionPane.showMessageDialog(null,cmd+"しました","メッセージ",
								JOptionPane.PLAIN_MESSAGE);
						}else {
							userID.setText(null);
							pass.setText(null);
							JOptionPane.showMessageDialog(null,"削除できませんでした","メッセージ",
									JOptionPane.PLAIN_MESSAGE);

						}
					}
				}
			}
		}
		);

		userLabel = new JLabel("ID");
		userLabel.setBounds(151, 107, 57, 16);
		deletePane.add(userLabel);

		passLabel = new JLabel("pass");
		passLabel.setBounds(151, 209, 57, 16);
		deletePane.add(passLabel);

		//サブボタン作成  新規・削除・月選択・ログアウト
		 shinkisub = new JButton("新規登録");
		 shinkisub.setActionCommand("新規登録");
		 shinkisub.setBounds(620, 10, 125, 19);
		 shinkisub.setBackground(new Color(255,153,0));
		 deletePane.add(shinkisub);

		 //新規サブボタンを押した場合の処理
		 shinkisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Shinki_registration_Sub new_Account = new Shinki_registration_Sub();
				if(cmd.equals("新規登録")) {
					//新規登録画面へ
					new_Account.setVisible(true);
					setVisible(false);
				}
			}
		}
		);

		//削除サブボタンを押した場合の処理
		 mainsub = new JButton("メインメニュー");
		 mainsub.setBounds(750, 10, 125, 19);
			mainsub.setBackground(new Color(255,153,0));
			deletePane.add(mainsub);
			mainsub.setActionCommand("メインメニュー");
			mainsub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();

					//メインメニューページのインスタンス生成
					Main_menu main = new Main_menu();
					if(cmd.equals("メインメニュー")) {
						//メインメニューページに遷移
						main.setVisible(true);
						setVisible(false);
					}
				}
			}
			);

		 tukisub = new JButton("月選択");
		 tukisub.setBounds(620, 32, 125, 19);
		 tukisub.setBackground(new Color(255,153,0));
		 deletePane.add(tukisub);

		 //月サブボタンを押した場合の処理
		 tukisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成）　
				Month month = new Month();
				if(cmd.equals("月選択")) {
					//月選択画面へ
					month.setVisible(true);
					setVisible(false);
				}
			}
		}
		);

		 logoutsub = new JButton("ログアウト");
		 logoutsub.setActionCommand("ログアウト");
		 logoutsub.setBounds(750, 32, 125, 19);
		 logoutsub.setBackground(new Color(255,153,0));
	     deletePane.add(logoutsub);

	     //ログアウトサブボタンを押した場合の処理
		 logoutsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				JFrame frame = new JFrame();
				//遷移したいページのインスタンス生成
				Log_in login = new Log_in();
				if(cmd.equals("ログアウト") ) {
					int ans = JOptionPane.showConfirmDialog(null, "ログアウトしますか？",
							"ログアウト",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );
					//0がYes、１がNo
					if(ans == 0){
						JOptionPane.showMessageDialog(frame,cmd+"しました","メッセージ",
								JOptionPane.PLAIN_MESSAGE);
						//ログイン画面へ
						login.setVisible(true);
						setVisible(false);
					}
				}
			}
		}
		);
	}

}
