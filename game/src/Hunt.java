import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Hunt extends JFrame implements ActionListener {

	JButton a, b;
	//	     Ž��, ���ư���
	Random r=new Random();
	
	ImageIcon img[]= {
			new ImageIcon("./img/Ž��.PNG"),
			new ImageIcon("./img/��.PNG")	
	};
	
	public Hunt() {
		super("�����");
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
		if(ob==a) {	//Ž���ϱ� ��ư ���� ��
			if(r.nextInt(5)==2)	JOptionPane.showMessageDialog(null, "�ƹ��͵� ������..");	// 1/5Ȯ���� ���Ͱ� �� ����
			else {
				JOptionPane.showMessageDialog(null, "���Ͱ� ��Ÿ����!");
				dispose();
				new Fig();
			}
		}
		else if(ob==b) {	//���ư��� ��ư ���� ��
			JOptionPane.showMessageDialog(null, "�޴��� ���ư��ϴ�.");
			dispose();
			new Menu();
		}
	}
	
}
