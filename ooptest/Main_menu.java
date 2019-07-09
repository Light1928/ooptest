package ooptest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main_menu extends JFrame  {

	private JPanel contentPane,main_panel;
	private JButton tukiselect,shinkiselect,shinkisub,
					deletesub,tukisub,logoutsub;
//コンストラクタ
	 Main_menu() {
		setTitle("メインメニュー");
		setSize(900,600);
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
		tukiselect.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		tukiselect.setBounds(245, 259, 154, 70);
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
					month.setVisible(true);
					setVisible(false);
				}
			}
		}
		);

	    shinkiselect = new JButton("新規登録");
		shinkiselect.setFont(new Font("MS UI Gothic", Font.PLAIN, 25));
		shinkiselect.setBounds(500, 259, 154, 70);
		shinkiselect.setForeground(new Color(255,255,255));
		shinkiselect.setBackground(new Color(29,161,242));
		main_panel.add(shinkiselect);
		shinkiselect.setActionCommand("新規登録");

		shinkiselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成（新規登録画面へ）
				Shinki_registration new_Account = new Shinki_registration();
				if(cmd.equals("新規登録")) {
					new_Account.setVisible(true);
					setVisible(false);
				}
			}
		}
		);

		//サブボタン作成  新規・削除・月選択・ログアウト
		 shinkisub = new JButton("新規登録");
		 shinkisub.setActionCommand("新規登録");
		 shinkisub.setBounds(620, 10, 125, 19);
		 shinkisub.setBackground(new Color(255,153,0));
		 main_panel.add(shinkisub);

		 //新規サブボタンを押した場合の処理
		 shinkisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成（新規登録画面へ）
				Shinki_registration new_Account = new Shinki_registration();
				if(cmd.equals("新規登録")) {
					new_Account.setVisible(true);
					setVisible(false);
				}
			}
		}
		);
		 
		//削除サブボタンを押した場合の処理
		deletesub = new JButton("アカウント削除");
		deletesub.setBounds(750, 10, 125, 19);
		deletesub.setActionCommand("アカウント削除");
		deletesub.setBackground(new Color(255,153,0));
		main_panel.add(deletesub);

		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		}
		);
		 
		
		 tukisub = new JButton("月選択");
		 tukisub.setBounds(620, 32, 125, 19);
		 tukisub.setBackground(new Color(255,153,0));
		 main_panel.add(tukisub);
		 
		 //月サブボタンを押した場合の処理
		 tukisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成(月選択画面へ）　
				Month month = new Month();
				if(cmd.equals("月選択")) {
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
	     main_panel.add(logoutsub);

	     //ログアウトサブボタンを押した場合の処理
		 logoutsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				JFrame frame = new JFrame();
				//遷移したいページのインスタンス生成（ログイン画面へ）
				Log_in login = new Log_in();
				if(cmd.equals("ログアウト") ) {
					int ans = JOptionPane.showConfirmDialog(null, "ログアウトしますか？",
							"ログアウト",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );
					//0がYes、１がNo
					if(ans == 0){
						JOptionPane.showMessageDialog(frame,cmd+"しました","メッセージ",
								JOptionPane.PLAIN_MESSAGE);
						login.setVisible(true);
						setVisible(false);
					}
				}
			}
		}
		);
	}
}
