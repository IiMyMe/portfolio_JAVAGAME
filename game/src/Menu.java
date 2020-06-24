import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	JButton ma,mb,mc,md,me;
	//		���,����,����,����,����
	ImageIcon img[]= {
			new ImageIcon("./img/���.PNG"),
			new ImageIcon("./img/����.PNG"),
			new ImageIcon("./img/����.PNG"),
			new ImageIcon("./img/����.PNG"),
			new ImageIcon("./img/����.PNG")
	};
	
	public Menu() {
		super("�޴�");
		Container ct=new Container();
		ct.setBackground(new Color(0xC4E6FF));
		setSize(200, 372);
		setLocation(700,300);
		
		ma=new JButton(img[0]);
		ma.setBounds(50, 20, 85, 52);
		mb=new JButton(img[1]);
		mb.setBounds(50, 82, 86, 52);
		mc=new JButton(img[2]);
		mc.setBounds(50, 144, 85, 49);
		md=new JButton(img[3]);
		md.setBounds(50, 204, 85, 50);
		me=new JButton(img[4]);
		me.setBounds(50, 264, 84, 49);
		
		ma.addActionListener(this);
		mb.addActionListener(this);
		mc.addActionListener(this);
		md.addActionListener(this);
		me.addActionListener(this);
		
		ct.add(ma);
		ct.add(mb);
		ct.add(mc);
		ct.add(md);
		ct.add(me);
		this.add(ct);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==ma)	{	//���
			new Hunt();
			dispose();
		}
		else if(ob==mb)	{	//����
			new Info();
			dispose();
		}
		else if(ob==mc)	new Bag();	//����
		else if(ob==md)	{	//����
			new Shop();
			dispose();
		}
		else if(ob==me) {	//����
			JOptionPane.showMessageDialog(null, "�����մϴ�.");
			System.exit(0);
		}
	}
	
	
	
}
