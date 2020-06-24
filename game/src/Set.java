
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Set extends JFrame implements ActionListener {
	
	ImageIcon img[]= {
			new ImageIcon("./img/1.PNG"),
			new ImageIcon("./img/2.PNG"),
			new ImageIcon("./img/3.PNG")
	};
	JButton sa,sb,sc;
	
	public Set() {
		super("특성선택");
		Container ct=new Container();
		ct.setBackground(new Color(0xFFC3C3));
		setSize(445, 100);
		setLocation(750,400);
		
		sa=new JButton(img[0]);
		sa.setBounds(10, 10, 121, 43);
		sb=new JButton(img[1]);
		sb.setBounds(141, 10, 121, 44);
		sc=new JButton(img[2]);
		sc.setBounds(272, 10, 147, 44);
		
		sa.addActionListener(this);
		sb.addActionListener(this);
		sc.addActionListener(this);
		
		ct.add(sa);
		ct.add(sb);
		ct.add(sc);
		this.add(ct);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Mat m=new Mat();
		Object ob = e.getSource();
		if(ob==sa) {	//체력위주
			m.Hp=65;
			m.Mp=10;
			m.Op=5;
			m.hp=m.Hp;
			m.mp=m.Mp;
		}
		else if(ob==sb) {	//공격위주
			m.Hp=30;
			m.Mp=35;
			m.Op=15;
			m.hp=m.Hp;
			m.mp=m.Mp;
		}
		else if(ob==sc) {	//밸런스위주
			m.Hp=50;
			m.Mp=20;
			m.Op=10;
			m.hp=m.Hp;
			m.mp=m.Mp;
		}
		JOptionPane.showMessageDialog(null, "설정완료");
		dispose();
	}
	
	
	
}
