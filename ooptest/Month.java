package ooptest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class Month extends JFrame implements ActionListener{

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Month() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015",
																 "2014", "2013", "2012", "2011", "2010"}));
		comboBox.setBounds(100, 135, 101, 35);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6",
																   "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(346, 135, 101, 35);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("明細");
		btnNewButton.setBounds(400, 309, 116, 40);
		btnNewButton.setActionCommand("明細");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("年");
		lblNewLabel.setBounds(211, 144, 57, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("月");
		lblNewLabel_1.setBounds(459, 144, 57, 16);
		contentPane.add(lblNewLabel_1);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
