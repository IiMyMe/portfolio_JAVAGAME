import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Hunt extends JFrame implements ActionListener {

	JButton a, b;
	//	     탐색, 돌아가기
	Random r=new Random();
	
	ImageIcon img[]= {
			new ImageIcon("./img/탐색.PNG"),
			new ImageIcon("./img/집.PNG")	
	};
	
	public Hunt() {
		super("사냥터");
		Container ct=new Container();
		ct.setBackground(new Color(0xC1FFC9));
		setSize(197, 190);
		setLocation(700,300);
		
		a=new JButton(img[0]);
		a.setBounds(20, 20, 145, 50);
		b=new JButton(img[1]);
		b.setBounds(20, 82, 147, 51);
		
		a.addActionListener(this);
		b.addActionListener(this);
		
		ct.add(a);
		ct.add(b);
		this.add(ct);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==a) {	//탐색하기 버튼 누를 때
			if(r.nextInt(5)==2)	JOptionPane.showMessageDialog(null, "아무것도 없었다..");	// 1/5확률로 몬스터가 안 나옴
			else {
				JOptionPane.showMessageDialog(null, "몬스터가 나타났다!");
				dispose();
				new Fig();
			}
		}
		else if(ob==b) {	//돌아가기 버튼 누를 때
			JOptionPane.showMessageDialog(null, "메뉴로 돌아갑니다.");
			dispose();
			new Menu();
		}
	}
	
}
