package ooptest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Meisai extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meisai frame = new Meisai();
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
	public Meisai() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSalapay = new JLabel("SalaPay");
		lblSalapay.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalapay.setBounds(181, 13, 322, 75);
		lblSalapay.setFont(new Font("MS ゴシック",Font.BOLD,80));
		panel.add(lblSalapay);
		
		JLabel label = new JLabel("名前：");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 21));
		label.setBounds(181, 115, 312, 29);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("基本時給：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 168, 134, 29);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("深夜時給：");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(266, 168, 134, 29);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("残業時給：");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(444, 168, 134, 29);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("基本時間：");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(103, 234, 134, 29);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("深夜時間：");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(266, 234, 134, 29);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("残業時間：");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(444, 234, 134, 29);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("基本給料：");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(103, 302, 134, 29);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("深夜給料：");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(266, 302, 134, 29);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("残業給料：");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(444, 302, 134, 29);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("総支給額：");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(103, 359, 317, 50);
		panel.add(label_9);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(444, 372, 101, 25);
		panel.add(btnNewButton);
	}
}
