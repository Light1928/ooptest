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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Shinki_registration extends JFrame  {

	private JPanel contentPane;
	private JLabel titlelabel,userlabel,passlabel,namelabel;
	private JTextField userID,name;
	private JPasswordField password;
	private JButton regist,shinkisub,deletesub,tukisub,logoutsub;
	private LineBorder userBorder,passBorder,nameBorder;

	public Shinki_registration() {
		setTitle("新規登録");
		setSize(900,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255,255,255));

		titlelabel = new JLabel("新規登録");
		titlelabel.setFont(new Font("MS UI Gothic", Font.BOLD, 55));
		titlelabel.setBounds(295, 53, 232, 99);
		contentPane.add(titlelabel);

		userlabel = new JLabel("ユーザID");
		userlabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		userlabel.setBounds(191, 187, 101, 34);
		contentPane.add(userlabel);

		passlabel = new JLabel("パスワード");
		passlabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		passlabel.setBounds(191, 275, 101, 34);
		contentPane.add(passlabel);

		namelabel = new JLabel("名前");
		namelabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		namelabel.setBounds(213, 362, 59, 34);
		contentPane.add(namelabel);

		userID = new JTextField(20);
		userBorder = new LineBorder(new Color(29,161,242), 1, true);
		userID.setBorder(userBorder);
		userID.setBounds(298, 187, 333, 34);
		contentPane.add(userID);

		password = new JPasswordField();
		passBorder = new LineBorder(new Color(29,161,242), 1, true);
		password.setBorder(passBorder);

		password.setBounds(298, 275, 333, 34);
		contentPane.add(password);

		name = new JTextField();
		nameBorder = new LineBorder(new Color(29,161,242), 1, true);
		name.setBorder(nameBorder);
		name.setBounds(298, 362, 333, 34);
		contentPane.add(name);

		regist = new JButton("登録");//test
		regist.setFont(new Font("Dialog", Font.BOLD, 17));

		 regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				JFrame frame = new JFrame();

				//移動したいページのインスタンス生成
				Main_menu main_menu = new Main_menu();
				if(cmd.equals("ログアウト") ) {
					int ans = JOptionPane.showConfirmDialog(null, "登録しますか？","新規登録",
							JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE );
					//0がYes、１がNo
					if(ans == 0){
						JOptionPane.showMessageDialog(frame,cmd+"しました","メッセージ",JOptionPane.PLAIN_MESSAGE);
						main_menu.setVisible(true);
						setVisible(false);
					}
				}
			}
		 }
		 );



		regist.setBounds(361, 436, 87, 25);
		contentPane.add(regist);

		 shinkisub = new JButton("新規登録");
		 shinkisub.setActionCommand("新規登録");
		 shinkisub.setBounds(620, 10, 125, 19);
		 shinkisub.setBackground(new Color(255,153,0));
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
		shinkisub.setBounds(629, 0, 113, 19);
		contentPane.add(shinkisub);

		deletesub = new JButton("アカウント削除");
		deletesub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deletesub.setBounds(754, 0, 128, 19);
		contentPane.add(deletesub);

		tukisub = new JButton("月選択");
		tukisub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tukisub.setBounds(629, 32, 113, 19);
		contentPane.add(tukisub);

		logoutsub = new JButton("ログアウト");
		logoutsub.setBounds(754, 32, 128, 19);
		contentPane.add(logoutsub);
	}
}
