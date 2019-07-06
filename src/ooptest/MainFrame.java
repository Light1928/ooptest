package ooptest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JPanel  {


	  public void content(){
		Container contentPane = getRootPane();



		JLabel centerLabel = new JLabel("SalaPay");
		//文字のカラー設定
		centerLabel.setForeground(Color.BLACK);
		//文字のフォント、幅、サイズ設定
		centerLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		//centerLabel.setSize(centerLabel.getPreferredSize()); //文字の大きさの最適化
		//HorizontailAlignment...水平位置 VerticalAlignment...垂直位置
		contentPane.setLayout(null);
		centerLabel.setBounds(300,50,600,200);


		contentPane.add(centerLabel,BorderLayout.CENTER);
	}

}