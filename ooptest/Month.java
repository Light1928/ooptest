package ooptest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Month extends JFrame {

	private JPanel month_Pane;
	private JButton meisai,shinkisub,deletesub,tukisub,logoutsub;
	private JComboBox year,month;
	/**
	 * Create the frame.
	 */
	public Month() {
		setTitle("月選択");
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		month_Pane = new JPanel();
		month_Pane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(month_Pane);
		month_Pane.setLayout(null);

		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015",
																 "2014", "2013", "2012", "2011", "2010"}));
		year.setBounds(100, 135, 101, 35);
		month_Pane.add(year);

		month = new JComboBox();
		month.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6",
																   "7", "8", "9", "10", "11", "12"}));
		month.setBounds(346, 135, 101, 35);
		month_Pane.add(month);

		meisai = new JButton("明細");
		meisai.setBounds(400, 309, 116, 40);
		meisai.setActionCommand("明細");
		month_Pane.add(meisai);
		meisai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Meisai meisai = new Meisai();
				if(cmd.equals("明細")) {
					meisai.setVisible(true);
					setVisible(false);
				}
			}
		}
		);


		JLabel lblNewLabel = new JLabel("年");
		lblNewLabel.setBounds(211, 144, 57, 16);
		month_Pane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("月");
		lblNewLabel_1.setBounds(459, 144, 57, 16);
		month_Pane.add(lblNewLabel_1);




		 shinkisub = new JButton("新規登録");
		 shinkisub.setActionCommand("新規登録");
		 shinkisub.setBounds(620, 10, 125, 19);
		 shinkisub.setBackground(new Color(255,153,0));
			month_Pane.add(shinkisub);

		shinkisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Shinki_registration new_Account = new Shinki_registration();
				if(cmd.equals("新規登録")) {
					new_Account.setVisible(true);
					setVisible(false);
				}
			}
		}
		);


		deletesub = new JButton("アカウント削除");
		deletesub.setBounds(750, 10, 125, 19);
		deletesub.setActionCommand("アカウント削除");
		deletesub.setBackground(new Color(24,180,0));
		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		}
		);
		month_Pane.add(deletesub);


		 tukisub = new JButton("月選択");
		 tukisub.setBounds(620, 32, 125, 19);
		 tukisub.setBackground(new Color(24,180,0));
		month_Pane.add(tukisub);
		tukisub.addActionListener(new ActionListener() {
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

		 logoutsub = new JButton("ログアウト");
		 logoutsub.setActionCommand("ログアウト");
		 logoutsub.setBounds(750, 32, 125, 19);
		 logoutsub.setBackground(new Color(255,153,0));
	     month_Pane.add(logoutsub);

		 logoutsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				JFrame frame = new JFrame();

				//移動したいページのインスタンス生成
				Log_in login = new Log_in();
				if(cmd.equals("ログアウト") ) {
					int ans = JOptionPane.showConfirmDialog(null, "ログアウトしますか？","ログアウト",
							JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );
					//0がYes、１がNo
					if(ans == 0){
						JOptionPane.showMessageDialog(frame,cmd+"しました","メッセージ",JOptionPane.PLAIN_MESSAGE);
						login.setVisible(true);
						setVisible(false);
					}
				}
			}
		}
		);
	}
}
