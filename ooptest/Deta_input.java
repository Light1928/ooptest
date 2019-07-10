package ooptest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Deta_input extends JFrame {
	
	private JComboBox year,month,day;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public Deta_input() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("データ入力");
		label.setFont(new Font("MS UI Gothic", Font.PLAIN, 50));
		label.setBounds(318, 74, 274, 63);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("通常時給");
		label_1.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_1.setBounds(276, 248, 97, 29);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("勤務時間");
		label_2.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_2.setBounds(276, 310, 81, 27);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("労働時間");
		label_3.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_3.setBounds(276, 371, 87, 26);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("年月日");
		label_4.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_4.setBounds(276, 187, 81, 22);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setBounds(419, 251, 123, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(419, 312, 123, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(419, 373, 123, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox year = new JComboBox();
		year.setBounds(421, 190, 32, 22);
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015",
																 "2014", "2013", "2012", "2011", "2010"}));
		contentPane.add(year);
		
		JComboBox month = new JComboBox();
		month.setBounds(486, 190, 32, 22);
		month = new JComboBox();
		month.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6",
																   "7", "8", "9", "10", "11", "12"}));
		contentPane.add(month);
		
		day = new JComboBox();
		day.setBounds(553, 187, 41, 29);
		day.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5","6","7","8","9","10","11","12",
				"13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",}));
		contentPane.add(day);
		
		
		
		year.setBounds(391, 187, 62, 27);

		
		month.setBounds(480, 187, 41, 28);
		
		
		
		JLabel label_5 = new JLabel("年");
		label_5.setBounds(465, 193, 17, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("月");
		label_6.setBounds(533, 193, 22, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("日");
		label_7.setBounds(606, 192, 22, 19);
		contentPane.add(label_7);
		
		
		JLabel label_8 = new JLabel("残業時間");
		label_8.setFont(new Font("MS UI Gothic", Font.PLAIN, 20));
		label_8.setBounds(276, 431, 81, 28);
		contentPane.add(label_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(419, 434, 123, 29);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		titleLabel = new JLabel("データ入力");
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
	}
}
