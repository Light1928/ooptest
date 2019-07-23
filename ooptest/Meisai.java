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
	private JLabel titlenameLabel,nameLabel,normal,
				   normal_time,over_time,
			normal_money,over_money,total_money,


			name,normalmoney,normaltime,overtime,
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
		nameLabel.setBounds(263, 239, 95, 29);
		contentPane.add(nameLabel);
		
		name = new JLabel(Log_in.username);
		name.setFont(new Font("Helvetica Neue",Font.PLAIN,21));
		name.setBounds(353,222,234,67);
		contentPane.add(name);

		normal = new JLabel("基本時給：");
		normal.setHorizontalAlignment(SwingConstants.CENTER);
		normal.setBounds(204, 356, 124, 41);
		normal.setFont(new Font("Helvetica Neue",Font.BOLD,21));
		contentPane.add(normal);

		normalmoney = new JLabel(String.format("%,d",(int)(Mysql.normal_money))+"円");
		normalmoney.setFont(new Font("Helvetica Neue",Font.PLAIN,21));
		normalmoney.setBounds(350,351,146,50);
		contentPane.add(normalmoney);
		
		
		
		normaltime =new JLabel(String.format("%,d",(int)(Mysql.total_normal_time))+"時間");
		normaltime.setFont(new Font("Helvetica Neue",Font.PLAIN,21));
		normaltime.setBounds(350,400,146,50);
		contentPane.add(normaltime);
		
		
		totalnormalmoney = new JLabel(String.format("%,d",(int)(Mysql.total))+"円");
		totalnormalmoney.setFont(new Font("Helvetica Neue",Font.PLAIN,21));
		totalnormalmoney.setBounds(350,450,146,50);
		contentPane.add(totalnormalmoney);
		
		overtime = new JLabel(String.format("%,d",(int)(Mysql.over_time)));
		overtime.setFont(new Font("Helvetica Neue",Font.PLAIN,21));
		overtime.setBounds(350,500,146,50);
		contentPane.add(overtime);
		
		totalovermoney = new JLabel(String.format("%,d",(int)(Mysql.salary)));
		totalovermoney.setFont(new Font("Helvetica Neue",Font.PLAIN,21));
		totalovermoney.setBounds(350,550,146,50);
		contentPane.add(totalovermoney);
		
		totalmoney = new JLabel(String.format("%,d",(int)(Mysql.total)));
		totalmoney.setFont(new Font("Helvetic Neue",Font.PLAIN,21));
		totalmoney.setBounds(600,550,146,50);
		contentPane.add(totalmoney);
		
		
		normal_time = new JLabel("基本時間 ：");
		normal_time.setHorizontalAlignment(SwingConstants.CENTER);
		normal_time.setBounds(194, 411, 134, 29);
		normal_time.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(normal_time);


		over_time = new JLabel("残業時間 ：");
		over_time.setHorizontalAlignment(SwingConstants.CENTER);
		over_time.setBounds(194, 511, 134, 29);
		over_time.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(over_time);

		normal_money = new JLabel("基本給料 ：");
		normal_money.setHorizontalAlignment(SwingConstants.CENTER);
		normal_money.setBounds(194, 461, 134, 29);
		normal_money.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(normal_money);



		over_money = new JLabel("残業給料 ：");
		over_money.setHorizontalAlignment(SwingConstants.CENTER);
		over_money.setBounds(194, 561, 134, 29);
		over_money.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(over_money);

		total_money = new JLabel("総支給額：");
		total_money.setHorizontalAlignment(SwingConstants.CENTER);
		total_money.setBounds(428, 550, 159, 50);
		total_money.setFont(new Font("MS UI Gothic",Font.BOLD,21));
		contentPane.add(total_money);


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
		back.setBounds(692, 659, 125, 41);
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
