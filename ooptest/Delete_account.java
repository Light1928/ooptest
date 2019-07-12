package ooptest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Delete_account extends JFrame {

	private JPanel deletePane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton shinkisub,deletesub,tukisub,logoutsub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_account frame = new Delete_account();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Delete_account() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 507);
		deletePane = new JPanel();
		deletePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(deletePane);
		deletePane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(220, 104, 106, 22);
		deletePane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(220, 206, 106, 22);
		deletePane.add(textField_1);
		textField_1.setColumns(10);

		JButton button = new JButton("削除");
		button.setBounds(356, 340, 101, 25);
		deletePane.add(button);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(151, 107, 57, 16);
		deletePane.add(lblId);

		JLabel lblPass = new JLabel("pass");
		lblPass.setBounds(151, 209, 57, 16);
		deletePane.add(lblPass);

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
		deletesub = new JButton("アカウント削除");
		deletesub.setBounds(750, 10, 125, 19);
		deletesub.setActionCommand("アカウント削除");
		deletesub.setBackground(new Color(255,153,0));
		deletePane.add(deletesub);

		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
