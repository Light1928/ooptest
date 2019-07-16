package ooptest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main_menu extends JFrame  {

	private JPanel contentPane,main_panel;
	private JLabel login_name;
	private JButton tukiselect,data_inputselect,shinkisub,
					deletesub,tukisub,logoutsub;

	 Main_menu() {
		setTitle("メインメニュー");
		setSize(1100,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		main_panel = new JPanel();
		main_panel.setBackground(new Color(255,255,255));
		contentPane.add(main_panel);
		main_panel.setLayout(null);

		//月選択ボタンの作成
		tukiselect = new JButton("月選択");
		tukiselect.setBounds(294, 306, 209, 108);
		tukiselect.setFont(new Font("Helvetica Neue",Font.BOLD,25));
		tukiselect.setForeground(new Color(255,255,255));
		tukiselect.setBackground(new Color(29,161,242));
		main_panel.add(tukiselect);

		//月選択ボタンを押した場合の処理
		tukiselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Month month = new Month();
				if(cmd.equals("月選択")) {
					//月選択画面へ
					month.setVisible(true);
					setVisible(false);
				}
			}
		}
		);

	    data_inputselect = new JButton("データ入力");
	    data_inputselect.setBounds(603, 306, 209, 108);
		data_inputselect.setFont(new Font("Helvetica Neue",Font.BOLD,25));
		data_inputselect.setForeground(new Color(255,255,255));
		data_inputselect.setBackground(new Color(29,161,242));
		main_panel.add(data_inputselect);
		data_inputselect.setActionCommand("データ入力");

		data_inputselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Data_input data_In = new Data_input();
				if(cmd.equals("データ入力")) {
					//新規登録画面へ
					data_In.setVisible(true);
					setVisible(false);
				}
			}
		}
		);

		login_name = new JLabel(Log_in.username+" 様");
		login_name.setFont(new Font("Helvetica Neue",Font.PLAIN,15));
		login_name.setBounds(20,5,125,19);
		main_panel.add(login_name);

		//サブボタン作成  新規・削除・月選択・ログアウト
		 shinkisub = new JButton("新規登録");
		 shinkisub.setActionCommand("新規登録");
		 shinkisub.setBounds(827, 10, 125, 19);
		 shinkisub.setBackground(new Color(255,153,0));
		 main_panel.add(shinkisub);

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
		deletesub = new JButton("アカウント削除");
		deletesub.setBounds(957, 10, 125, 19);
		deletesub.setActionCommand("アカウント削除");
		deletesub.setBackground(new Color(255,153,0));
		main_panel.add(deletesub);

		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成）　
				Delete_account delete = new Delete_account();
				if(cmd.equals("アカウント削除") && Log_in.permission == true) {
					//月選択画面へ
					delete.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null,"権限がないためアクセスを拒否します","メッセージ",
							JOptionPane.PLAIN_MESSAGE);

				}
			}
		}
		);

		 tukisub = new JButton("月選択");
		 tukisub.setBounds(827, 32, 125, 19);
		 tukisub.setBackground(new Color(255,153,0));
		 main_panel.add(tukisub);

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
		 logoutsub.setBounds(957, 32, 125, 19);
		 logoutsub.setBackground(new Color(255,153,0));
	     main_panel.add(logoutsub);

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
	}
}
