import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Fig extends JFrame implements ActionListener {
	
	Random r=new Random();
	Mat m=new Mat();
	int x, z=r.nextInt(m.Lv);	// z : ���� ������ ���� ���� �� �ִ� ���͵� �������� ����
	JLabel Mon,Mn,Mh,H;
	int mh=m.MHp[z];
	
	JButton a, b, c;
	//        ����,����,����
	ImageIcon img[]= {
			new ImageIcon("./img/����.PNG"),
			new ImageIcon("./img/����.PNG"),
			new ImageIcon("./img/����.PNG")
	};
	
	public Fig() {
		super("���");
		Container ct=new Container();
		ct.setBackground(new Color(0xE0E0E0));
		setSize(480, 480);
		setLocation(600,300);
		
		Mon=new JLabel(m.img[z]);
		Mon.setBounds(43, 50, 378, 378);
		Mn=new JLabel("���� �̸� : " + m.Mna[z]);
		Mn.setFont(new Font("����", Font.BOLD, 15));
		Mn.setBounds(50, 10, 300, 20);
		Mh=new JLabel("���� ������ ü�� : " + mh);
		Mh.setFont(new Font("����", Font.BOLD, 15));
		Mh.setBounds(50, 30, 300, 20);
		H=new JLabel("�����ִ� ����� ü�� : " + m.hp);
		H.setFont(new Font("����", Font.BOLD, 15));
		H.setBounds(240, 30, 300, 20);
		
		a=new JButton(img[0]);
		a.setBounds(48, 380, 82, 48);
		b=new JButton(img[1]);
		b.setBounds(189, 380, 85, 49);
		c=new JButton(img[2]);
		c.setBounds(330, 380, 83, 50);
		
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		
		ct.add(Mn);
		ct.add(Mh);
		ct.add(H);
		ct.add(a);
		ct.add(b);
		ct.add(c);
		ct.add(Mon);
		this.add(ct);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==a) {		//����
			x=r.nextInt(m.Op)+1;
			mh-=x;
			JOptionPane.showMessageDialog(null, x+"�� �������� ������!");
			Mh.setText("���� ������ ü�� : " + mh);
			if(mh<=0) {		//���� �ǰ� 0������ �� �¸�
				int q=r.nextInt(m.GExp[z])+1;
				int s=r.nextInt(m.GExp[z]);
				JOptionPane.showMessageDialog(null, "�¸��ߴ�!\n"+q+"��ŭ�� ����ġ�� �����!\n"+s+"��ŭ�� ���� �����!");
				m.Exp+=q;
				m.Gol+=s;
				if(m.Exp>=m.NExp) m.lvup();
				dispose();
				new Hunt();
			}
			else {		//�ƴ� �� �������� ����
				x=r.nextInt(m.MHp[z])+1;
				m.hp-=x;
				JOptionPane.showMessageDialog(null, x+"�� �������� �Ծ���!");
				H.setText("�����ִ� ����� ü�� : " + m.hp);
				if(m.hp<=0) {
					JOptionPane.showMessageDialog(null, "Game Over..");
					System.exit(0);
				}
			}
		}
		else if(ob==b) {	//����
			new Bag();
		}
		else if(ob==c)	{	//��������
			if(r.nextInt(5)==2) {	// 1/5Ȯ���� ���� ����
				JOptionPane.showMessageDialog(null, "����ġ�µ� �����ߴ�!\n���� ü�� : "+ m.hp);
				dispose();
				new Hunt();
			}
			else {		//����ġ�µ� ���н� �������� ����
				JOptionPane.showMessageDialog(null, "����ġ�µ� �����ߴ�..");
				x=r.nextInt(m.MHp[z])+1;
				m.hp-=x;
				JOptionPane.showMessageDialog(null, x+"�� �������� �Ծ���!");
				H.setText("�����ִ� ����� ü�� : " + m.hp);
				if(m.hp<=0) {
					JOptionPane.showMessageDialog(null, "Game Over..");
					System.exit(0);
				}
			}
		}
	}
	
}
