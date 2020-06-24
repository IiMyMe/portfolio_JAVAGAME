import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Bag extends JFrame {
	
	JRadioButton item[] = new JRadioButton[12];
	JRadioButton amoun[] = new JRadioButton[6];
	int[] num= {1,5,10,15,20,25};
	
	Mat m = new Mat();
	int CV, CA, AM = 0;
	
	JButton use, cancel;
	JTextArea total;
	
	
	public Bag() {
		this.setTitle("가방");
		this.setSize(550, 350);
		this.setLocation(600, 300);
		JPanel labelPanel = new JPanel();
		JLabel label1 = new JLabel("보유 골드 : "+m.Gol);
		labelPanel.add(label1);
		this.add(labelPanel, BorderLayout.NORTH);
		this.add(new choice(), BorderLayout.CENTER);
		this.add(new Use(), BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	//사용할 아이템 선택
	class choice extends JPanel {
		private Border border;
		
		public choice() {
			setLayout(new GridLayout(0, 3));
			
			JPanel Heal = new JPanel(new GridLayout(6, 1));
			
			ButtonGroup itemRB = new ButtonGroup();
			for(int i=0; i<6; i++) {
				item[i]=new JRadioButton(m.Item[i] + "회복포션 - " + m.HItem[i] + "개 보유");
				item[i].addActionListener(new Use());
				itemRB.add(item[i]);
				Heal.add(item[i]);
			}
			
			border = BorderFactory.createTitledBorder("보유 회복포션");
			Heal.setBorder(border);
			
			JPanel Mana = new JPanel(new GridLayout(6, 1));
			
			for(int i=6;i<12; i++) {
				item[i]=new JRadioButton(m.Item[i%6] + "마나포션 - " + m.MItem[i%6] + "개 보유");
				item[i].addActionListener(new Use());
				itemRB.add(item[i]);
				Mana.add(item[i]);
			}
			
			border = BorderFactory.createTitledBorder("보유 마나포션");
			Mana.setBorder(border);
			
			ButtonGroup amountRB = new ButtonGroup();
			JPanel amount = new JPanel(new GridLayout(3, 1));
			for(int i=0; i<6; i++) {
				amoun[i]=new JRadioButton(num[i] + "개");
				amoun[i].addActionListener(new Use());
				amountRB.add(amoun[i]);
				amount.add(amoun[i]);
			}
			
			border = BorderFactory.createTitledBorder("갯수");
			amount.setBorder(border);
			
			this.add(Heal);
			this.add(Mana);
			this.add(amount);
		}
		
	}
	
	//사용
	class Use extends JPanel implements ActionListener {

		public Use() {
			use = new JButton("사용");
			cancel = new JButton("돌아가기");
			use.addActionListener(this);
			cancel.addActionListener(this);
			total = new JTextArea(5, 48);
			total.setEditable(false);
			this.add(use);
			this.add(cancel);
			this.add(total);

		}

		public void actionPerformed(ActionEvent e) {
			Object ob = e.getSource();
			
			for(int i=0; i<12; i++) {
			    if(ob.equals(item[i]))
			    	CV=i;
			}
			
			for(int i=0; i<6; i++) {
			    if(ob.equals(amoun[i]))
			    	CA=i;
			}
			
			//사용 버튼 누를 때
			if(ob.equals(use))
			{
				AM=num[CA];
				if(CV>=0 && CV<6) {	//체력포션 선택할 때
					if(m.HItem[CV]>=AM) {
						m.HItem[CV]-=AM;
						m.hp+=m.Item[CV]*AM;
						if(m.hp>m.Hp)	m.hp=m.Hp;
						total.setText("사용 완료\n남은 아이템 : "+m.HItem[CV]+"개");
					}
					else	total.setText("아이템이 부족합니다.\n부족한 아이템의 갯수 : "+(AM-m.HItem[CV])+"개");
				}
				else if(CV>5 && CV<12) {	//마나포션 선택할 때
					if(m.MItem[CV%6]>=AM) {
						m.MItem[CV%6]-=AM;
						m.mp+=m.Item[CV%6]*AM;
						if(m.mp>m.Mp)	m.mp=m.Mp;
						total.setText("사용 완료\n남은 아이템 : "+m.MItem[CV%6]+"개");
					}
					else	total.setText("아이템이 부족합니다.\n부족한 아이템의 갯수 : "+(AM-m.MItem[CV%6])+"개");
				}
				else	total.setText("아이템 또는 갯수를 선택하세요.");
			}
			
			if (e.getSource() == cancel) {	//돌아가기 버튼 누를 때
				JOptionPane.showMessageDialog(null, "돌아갑니다.");
				dispose();
			}
		}
	}
	
}
