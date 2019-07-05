package ooptest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame  {
	  MainFrame(String title) {
		setTitle(title);
		setBounds(100,100,900,600);//Frameの左上ｘ座標、ｙ座標、幅、高さを設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//xボタンを押されたら終了
	  }
	  public void content(){
		Container contentPane = getContentPane();

		JPanel mainPanel = new JPanel();
	    mainPanel.setBackground(new Color(240,240,240));

		JLabel centerLabel = new JLabel("SalaPay");
		//文字のカラー設定
		centerLabel.setForeground(Color.BLACK);
		//文字のフォント、幅、サイズ設定
		centerLabel.setFont(new Font("MS ゴシック",Font.BOLD,80));
		//centerLabel.setSize(centerLabel.getPreferredSize()); //文字の大きさの最適化
		//HorizontailAlignment...水平位置 VerticalAlignment...垂直位置
		contentPane.setLayout(null);
		centerLabel.setBounds(300,50,600,200);

	//	contentPane.add(headerPanel,BorderLayout.NORTH);
		contentPane.add(mainPanel,BorderLayout.CENTER);
		contentPane.add(centerLabel,BorderLayout.CENTER);
	}
}