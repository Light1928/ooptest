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
	private JLabel yearLabel,monthLabel;
	private JButton meisai,shinkisub,deletesub,mainsub,logoutsub;
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
		year.setBounds(246, 135, 101, 35);
		month_Pane.add(year);

		month = new JComboBox();
		month.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6",
																   "7", "8", "9", "10", "11", "12"}));
		month.setBounds(477, 135, 101, 35);
		month_Pane.add(month);

		meisai = new JButton("明細");
		meisai.setBounds(362, 327, 116, 40);
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

		yearLabel = new JLabel("年");
		yearLabel.setBounds(359, 144, 57, 16);
		month_Pane.add(yearLabel);

		monthLabel = new JLabel("月");
		monthLabel.setBounds(620, 144, 57, 16);
		month_Pane.add(monthLabel);

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
		month_Pane.add(deletesub);
		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		}
		);


		mainsub = new JButton("メインメニュー");
		mainsub.setBounds(620, 32, 125, 19);
		mainsub.setBackground(new Color(24,180,0));
		month_Pane.add(mainsub);
		mainsub.setActionCommand("メインメニュー");
		mainsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				//遷移したいページのインスタンス生成
				Main_menu main = new Main_menu();
				if(cmd.equals("メインメニュー")) {
					main.setVisible(true);
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
