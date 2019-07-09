package ooptest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JButton;

public class Shinki_registration extends JFrame  {

	private JPanel contentPane;
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
		
		JLabel titlelabel = new JLabel("新規登録");
		titlelabel.setFont(new Font("MS UI Gothic", Font.BOLD, 55));
		titlelabel.setBounds(295, 53, 232, 99);
		contentPane.add(titlelabel);
		
		JLabel userlabel = new JLabel("ユーザID");
		userlabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		userlabel.setBounds(191, 187, 101, 34);
		contentPane.add(userlabel);
		
		JLabel label_1 = new JLabel("パスワード");
		label_1.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		label_1.setBounds(191, 275, 101, 34);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("名前");
		label_2.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		label_2.setBounds(213, 362, 59, 34);
		contentPane.add(label_2);
		
		JTextField userID = new JTextField(20);
		 userBorder = new LineBorder(new Color(29,161,242), 1, true);
		userID.setBorder(userBorder);
		userID.setBounds(298, 187, 333, 34);
		contentPane.add(userID);
		
		JTextField password = new JTextField();
		passBorder = new LineBorder(new Color(29,161,242), 1, true);
		password.setBorder(passBorder);
		
		password.setBounds(298, 275, 333, 34);
		contentPane.add(password);
		
		JTextField name = new JTextField();
		nameBorder = new LineBorder(new Color(29,161,242), 1, true);
		name.setBorder(nameBorder);
		name.setBounds(298, 362, 333, 34);
		contentPane.add(name);
		
		Button registration = new Button("登録");
		registration.setFont(new Font("Dialog", Font.BOLD, 17));
		registration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		registration.setBounds(361, 436, 87, 25);
		contentPane.add(registration);
		
		JButton button_1 = new JButton("新規登録");
		button_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(629, 0, 113, 19);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("アカウント削除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(754, 0, 128, 19);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("月選択");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(629, 32, 113, 19);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("ログアウト");
		button_4.setBounds(754, 32, 128, 19);
		contentPane.add(button_4);
	}
}
