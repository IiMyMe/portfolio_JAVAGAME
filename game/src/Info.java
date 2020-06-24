import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Info extends JFrame implements ActionListener {
	
	Mat m=new Mat();
	JButton a;
	JLabel hp,mp,op,exp,lv,gol;
	ImageIcon img=new ImageIcon("./img/Áý.PNG");
	
	public Info() {
		super("Á¤º¸Ã¢");
		Container ct=new Container();
		ct.setBackground(new Color(0xC4E6FF));
		setSize(200, 300);
		setLocation(700,300);
		
		lv=new JLabel("·¹º§ : " + m.Lv);
		lv.setFont(new Font("µ¸¿ò", Font.BOLD, 15));
		lv.setBounds(10, 10, 100, 30);
		hp=new JLabel("Ã¼·Â : " + m.hp);
		hp.setFont(new Font("µ¸¿ò", Font.BOLD, 15));
		hp.setBounds(10,30, 100, 30);
		mp=new JLabel("¸¶³ª : " + m.Mp);
		mp.setFont(new Font("µ¸¿ò", Font.BOLD, 15));
		mp.setBounds(10, 50, 100, 30);
		op=new JLabel("°ø°Ý·Â : " + m.Op);
		op.setFont(new Font("µ¸¿ò", Font.BOLD, 15));
		op.setBounds(10, 70, 100, 30);
		exp=new JLabel("°æÇèÄ¡ : " + m.Exp);
		exp.setFont(new Font("µ¸¿ò", Font.BOLD, 15));
		exp.setBounds(10, 90, 100, 30);
		gol=new JLabel("º¸À¯ °ñµå : " + m.Gol);
		gol.setFont(new Font("µ¸¿ò", Font.BOLD, 15));
		gol.setBounds(10, 110, 200, 30);
		
		a=new JButton(img);
		a.setBounds(20,195, 147, 51);
		
		a.addActionListener(this);
		
		ct.add(lv);
		ct.add(mp);
		ct.add(exp);
		ct.add(hp);
		ct.add(op);
		ct.add(gol);
		ct.add(a);
		this.add(ct);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==a) {
			JOptionPane.showMessageDialog(null, "¸Þ´º·Î µ¹¾Æ°©´Ï´Ù.");
			dispose();
			new Menu();	
		}
	}
	
}
