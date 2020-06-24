import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	JButton ma,mb,mc,md,me;
	//		사냥,정보,가방,상점,종료
	ImageIcon img[]= {
			new ImageIcon("./img/사냥.PNG"),
			new ImageIcon("./img/정보.PNG"),
			new ImageIcon("./img/가방.PNG"),
			new ImageIcon("./img/상점.PNG"),
			new ImageIcon("./img/종료.PNG")
	};
	
	public Menu() {
		super("메뉴");
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
		if(ob==ma)	{	//사냥
			new Hunt();
			dispose();
		}
		else if(ob==mb)	{	//정보
			new Info();
			dispose();
		}
		else if(ob==mc)	new Bag();	//가방
		else if(ob==md)	{	//상점
			new Shop();
			dispose();
		}
		else if(ob==me) {	//종료
			JOptionPane.showMessageDialog(null, "종료합니다.");
			System.exit(0);
		}
	}
	
	
	
}
