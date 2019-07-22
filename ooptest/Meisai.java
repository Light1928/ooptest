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
			normal_money,night_money,over_money,total_money,


			name,normalmoney,overmoney,normaltime,overtime,
			totalnormalmoney,totalovermoney,totalmoney;
	private JButton shinkisub,deletesub,tukisub,logoutsub,back;

//
	public Meisai() {
		setTitle("給与明細");
		setSize(1100,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		titlenameLabel = new JLabel("給与明細");
		titlenameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlenameLabel.setBounds(353, 56, 377, 115);
		titlenameLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		contentPane.add(titlenameLabel);

		nameLabel = new JLabel("名前：");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 21));
		nameLabel.setBounds(353, 247, 95, 29);
		contentPane.add(nameLabel);
		
		name = new JLabel(Log_in.username);
		name.setFont(new Font("Helvetica Neue",Font.PLAIN,21));
		name.setBounds(450,210,300,115);
		contentPane.add(name);

//		normal = new JLabel("基本時給：");
//		normal.setHorizontalAlignment(SwingConstants.CENTER);
//		normal.setBounds(230, 336, 134, 29);
//		normal.setFont(new Font("MS UI Gothic",Font.BOLD,21));
//		contentPane.add(normal);

		normalmoney = new JLabel(String.valueOf(Mysql.normal_money));
		normalmoney.setFont(new Font("Helvetica Neue",Font.PLAIN,21));
		normalmoney.setBounds(480,210,300,115);
		contentPane.add(normalmoney);
//		night = new JLabel("深夜時給：");
//		night.setHorizontalAlignment(SwingConstants.CENTER);
//		night.setBounds(438, 336, 134, 29);
//		night.setFont(new Font("MS UI Gothic",Font.BOLD,21));
//		contentPane.add(night);

//		over = new JLabel("残業時給：");
//		over.setHorizontalAlignment(SwingConstants.CENTER);
//		over.setBounds(670, 336, 134, 29);
//		over.setFont(new Font("MS UI Gothic",Font.BOLD,21));
//		contentPane.add(over);

		normal_time = new JLabel("基本時間：");
		normal_time.setHorizontalAlignment(SwingConstants.CENTER);
		normal_time.setBounds(230, 433, 134, 29);
		normal_time.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(normal_time);

//		night_time = new JLabel("深夜時間：");
//		night_time.setHorizontalAlignment(SwingConstants.CENTER);
//		night_time.setBounds(438, 433, 134, 29);
//		night_time.setFont(new Font("MS UI Gothic",Font.BOLD,21));
//		contentPane.add(night_time);

		over_time = new JLabel("残業時間：");
		over_time.setHorizontalAlignment(SwingConstants.CENTER);
		over_time.setBounds(670, 433, 134, 29);
		over_time.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(over_time);

		normal_money = new JLabel("基本給料：");
		normal_money.setHorizontalAlignment(SwingConstants.CENTER);
		normal_money.setBounds(230, 527, 134, 29);
		normal_money.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(normal_money);

//		night_money = new JLabel("深夜給料：");
//		night_money.setHorizontalAlignment(SwingConstants.CENTER);
//		night_money.setBounds(438, 527, 134, 29);
//		night_money.setFont(new Font("MS UI Gothic",Font.BOLD,21));
//		contentPane.add(night_money);

		over_money = new JLabel("残業給料：");
		over_money.setHorizontalAlignment(SwingConstants.CENTER);
		over_money.setBounds(670, 527, 134, 29);
		over_money.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(over_money);

		total_money = new JLabel("総支給額：");
		total_money.setHorizontalAlignment(SwingConstants.CENTER);
		total_money.setBounds(411, 607, 199, 50);
		total_money.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(total_money);

		
		
		
	//	normalmoney = new JLabel


































		//サブボタン作成  新規・削除・月選択・ログアウト
		 shinkisub = new JButton("新規登録");
		 shinkisub.setActionCommand("新規登録");
		 shinkisub.setBounds(827, 10, 125, 19);
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
			deletesub.setBounds(957, 10, 125, 19);
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
		 tukisub.setBounds(827, 33, 125, 19);
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
		 logoutsub.setBounds(957, 33, 125, 19);
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
		back.setBounds(827, 695, 125, 41);
		back.setFont(new Font("Helvetica Neue",Font.BOLD,25));
		back.setForeground(new Color(255,255,255));
		back.setBackground(new Color(29,161,242));
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
