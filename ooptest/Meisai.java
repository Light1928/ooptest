package ooptest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Meisai extends JFrame {

	private JPanel contentPane;
	private JButton tukiselect,shinkiselect,shinkisub,
	deletesub,tukisub,logoutsub;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Meisai() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		/*JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);*/

		JLabel lblSalapay = new JLabel("SalaPay");
		lblSalapay.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalapay.setBounds(181, 13, 322, 75);
		lblSalapay.setFont(new Font("MS ゴシック",Font.BOLD,80));
		contentPane.add(lblSalapay);

		JLabel label = new JLabel("名前：");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 21));
		label.setBounds(181, 115, 312, 29);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("基本時給：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 168, 134, 29);
		contentPane.add(lblNewLabel);

		JLabel label_1 = new JLabel("深夜時給：");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(266, 168, 134, 29);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("残業時給：");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(444, 168, 134, 29);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("基本時間：");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(103, 234, 134, 29);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("深夜時間：");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(266, 234, 134, 29);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("残業時間：");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(444, 234, 134, 29);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("基本給料：");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(103, 302, 134, 29);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("深夜給料：");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(266, 302, 134, 29);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("残業給料：");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(444, 302, 134, 29);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("総支給額：");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(103, 359, 317, 50);
		contentPane.add(label_9);

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

		//削除サブボタンを押した場合の処理
		deletesub = new JButton("アカウント削除");
		deletesub.setBounds(750, 10, 125, 19);
		deletesub.setActionCommand("アカウント削除");
		deletesub.setBackground(new Color(255,153,0));
		contentPane.add(deletesub);

		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(444, 372, 101, 25);
		contentPane.add(btnNewButton);
	}
}
