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
import javax.swing.SwingConstants;

public class Meisai extends JFrame {

	private JPanel contentPane;
	private JLabel titlenameLabel,nameLabel,normal,night,
				   over,normal_time,night_time,over_time,
			normal_money,night_money,over_money,total_money;
	private JButton shinkisub,deletesub,tukisub,logoutsub,back;


	public Meisai() {
		setSize(1100,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		titlenameLabel = new JLabel("SalaPay");
		titlenameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlenameLabel.setBounds(266, 33, 322, 75);
		titlenameLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		contentPane.add(titlenameLabel);

		nameLabel = new JLabel("名前：");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 21));
		nameLabel.setBounds(286, 169, 312, 29);
		contentPane.add(nameLabel);

		normal = new JLabel("基本時給：");
		normal.setHorizontalAlignment(SwingConstants.CENTER);
		normal.setBounds(208, 222, 134, 29);
		contentPane.add(normal);

		night = new JLabel("深夜時給：");
		night.setHorizontalAlignment(SwingConstants.CENTER);
		night.setBounds(371, 222, 134, 29);
		contentPane.add(night);

		over = new JLabel("残業時給：");
		over.setHorizontalAlignment(SwingConstants.CENTER);
		over.setBounds(549, 222, 134, 29);
		contentPane.add(over);

		normal_time = new JLabel("基本時間：");
		normal_time.setHorizontalAlignment(SwingConstants.CENTER);
		normal_time.setBounds(208, 288, 134, 29);
		contentPane.add(normal_time);

		night_time = new JLabel("深夜時間：");
		night_time.setHorizontalAlignment(SwingConstants.CENTER);
		night_time.setBounds(371, 288, 134, 29);
		contentPane.add(night_time);

		over_time = new JLabel("残業時間：");
		over_time.setHorizontalAlignment(SwingConstants.CENTER);
		over_time.setBounds(549, 288, 134, 29);
		contentPane.add(over_time);

		normal_money = new JLabel("基本給料：");
		normal_money.setHorizontalAlignment(SwingConstants.CENTER);
		normal_money.setBounds(208, 356, 134, 29);
		contentPane.add(normal_money);

		night_money = new JLabel("深夜給料：");
		night_money.setHorizontalAlignment(SwingConstants.CENTER);
		night_money.setBounds(371, 356, 134, 29);
		contentPane.add(night_money);

		over_money = new JLabel("残業給料：");
		over_money.setHorizontalAlignment(SwingConstants.CENTER);
		over_money.setBounds(549, 356, 134, 29);
		contentPane.add(over_money);

		total_money = new JLabel("総支給額：");
		total_money.setHorizontalAlignment(SwingConstants.CENTER);
		total_money.setBounds(208, 413, 317, 50);
		contentPane.add(total_money);

		//サブボタン作成  新規・削除・月選択・ログアウト
		 shinkisub = new JButton("新規登録");
		 shinkisub.setActionCommand("新規登録");
		 shinkisub.setBounds(620, 10, 125, 19);
		 shinkisub.setBackground(new Color(255,153,0));
		 contentPane.add(shinkisub);

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

			deletesub = new JButton("アカウント削除");
			deletesub.setBounds(750, 10, 125, 19);
			deletesub.setActionCommand("アカウント削除");
			deletesub.setBackground(new Color(255,153,0));
			contentPane.add(deletesub);
			deletesub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Delete_account new_Account = new Delete_account();
				if(cmd.equals("アカウント削除") && Log_in.permission == true) {
					//新規登録画面へ
					new_Account.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"権限がないためアクセスを拒否します","メッセージ",
							JOptionPane.PLAIN_MESSAGE);
				}

				}
			}
			);

		 tukisub = new JButton("月選択");
		 tukisub.setBounds(620, 32, 125, 19);
		 tukisub.setBackground(new Color(255,153,0));
		 contentPane.add(tukisub);

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
		 contentPane.add(logoutsub);

	     //ログアウトサブボタンを押した場合の処理
		 logoutsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Log_in login = new Log_in();
				if(cmd.equals("ログアウト") ) {
					int ans = JOptionPane.showConfirmDialog(null, "ログアウトしますか？",
							"ログアウト",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );
					//0がYes、１がNo
					if(ans == 0){
						JOptionPane.showMessageDialog(null,cmd+"しました","メッセージ",
								JOptionPane.PLAIN_MESSAGE);
						//ログイン画面へ
						login.setVisible(true);
						setVisible(false);
					}
				}
			}
		}
		);

		back = new JButton("Back");
		back.setBounds(549, 426, 101, 25);
		contentPane.add(back);


		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成）　
				Month month = new Month();
				if(cmd.equals("Back")) {
					//月選択画面へ
					month.setVisible(true);
					setVisible(false);
				}
			}
		});

	}
}
