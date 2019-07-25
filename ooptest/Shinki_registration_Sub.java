package ooptest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Shinki_registration_Sub extends Shinki_registration_Main {

	private JButton mainsub,deletesub,tukisub,logoutsub;
	private JLabel login_name;

	 Shinki_registration_Sub(){
		super();
		mainsub = new JButton("メインメニュー");
		mainsub.setBounds(827, 10, 125, 19);
		mainsub.setBackground(new Color(255,153,0));
		contentPane.add(mainsub);
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

		deletesub = new JButton("アカウント削除");
		deletesub.setBounds(957, 10, 125, 19);
		deletesub.setActionCommand("アカウント削除");
		deletesub.setBackground(new Color(255,153,0));
		contentPane.add(deletesub);
		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			//遷移したいページのインスタンス生成
			Delete_account delete = new Delete_account();
			if(cmd.equals("アカウント削除") && Log_in.permission == true) {
				//新規登録画面へ
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
		 contentPane.add(tukisub);
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
		 logoutsub.setBounds(957, 32, 125, 19);
		 logoutsub.setBackground(new Color(255,153,0));
		 contentPane.add(logoutsub);

		 logoutsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				JFrame frame = new JFrame();

				//移動したいページのインスタンス生成
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


						login_name = new JLabel(Log_in.username+" 様");
						login_name.setFont(new Font("Helvetica Neue",Font.PLAIN,15));
						login_name.setBounds(20,5,125,19);
						contentPane.add(login_name);

					}
				}
			}
		}
		);
	}
}
