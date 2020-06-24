import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Fig extends JFrame implements ActionListener {
	
	Random r=new Random();
	Mat m=new Mat();
	int x, z=r.nextInt(m.Lv);	// z : 몬스터 레벨에 맞춰 나올 수 있는 몬스터들 랜덤으로 등장
	JLabel Mon,Mn,Mh,H;
	int mh=m.MHp[z];
	
	JButton a, b, c;
	//        공격,가방,도망
	ImageIcon img[]= {
			new ImageIcon("./img/공격.PNG"),
			new ImageIcon("./img/가방.PNG"),
			new ImageIcon("./img/도망.PNG")
	};
	
	public Fig() {
		super("사냥");
		Container ct=new Container();
		ct.setBackground(new Color(0xE0E0E0));
		setSize(480, 480);
		setLocation(600,300);
		
		Mon=new JLabel(m.img[z]);
		Mon.setBounds(43, 50, 378, 378);
		Mn=new JLabel("몬스터 이름 : " + m.Mna[z]);
		Mn.setFont(new Font("돋움", Font.BOLD, 15));
		Mn.setBounds(50, 10, 300, 20);
		Mh=new JLabel("남은 몬스터의 체력 : " + mh);
		Mh.setFont(new Font("돋움", Font.BOLD, 15));
		Mh.setBounds(50, 30, 300, 20);
		H=new JLabel("남아있는 당신의 체력 : " + m.hp);
		H.setFont(new Font("돋움", Font.BOLD, 15));
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
		if(ob==a) {		//공격
			x=r.nextInt(m.Op)+1;
			mh-=x;
			JOptionPane.showMessageDialog(null, x+"의 데미지를 입혔다!");
			Mh.setText("남은 몬스터의 체력 : " + mh);
			if(mh<=0) {		//몬스터 피가 0이하일 때 승리
				int q=r.nextInt(m.GExp[z])+1;
				int s=r.nextInt(m.GExp[z]);
				JOptionPane.showMessageDialog(null, "승리했다!\n"+q+"만큼의 경험치를 얻었다!\n"+s+"만큼의 돈을 얻었다!");
				m.Exp+=q;
				m.Gol+=s;
				if(m.Exp>=m.NExp) m.lvup();
				dispose();
				new Hunt();
			}
			else {		//아닐 때 데미지를 입음
				x=r.nextInt(m.MHp[z])+1;
				m.hp-=x;
				JOptionPane.showMessageDialog(null, x+"의 데미지를 입었다!");
				H.setText("남아있는 당신의 체력 : " + m.hp);
				if(m.hp<=0) {
					JOptionPane.showMessageDialog(null, "Game Over..");
					System.exit(0);
				}
			}
		}
		else if(ob==b) {	//가방
			new Bag();
		}
		else if(ob==c)	{	//도망가기
			if(r.nextInt(5)==2) {	// 1/5확률로 도망 가능
				JOptionPane.showMessageDialog(null, "도망치는데 성공했다!\n남은 체력 : "+ m.hp);
				dispose();
				new Hunt();
			}
			else {		//도망치는데 실패시 데미지를 입음
				JOptionPane.showMessageDialog(null, "도망치는데 실패했다..");
				x=r.nextInt(m.MHp[z])+1;
				m.hp-=x;
				JOptionPane.showMessageDialog(null, x+"의 데미지를 입었다!");
				H.setText("남아있는 당신의 체력 : " + m.hp);
				if(m.hp<=0) {
					JOptionPane.showMessageDialog(null, "Game Over..");
					System.exit(0);
				}
			}
		}
	}
	
}
