import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Shop extends JFrame {
	
	JRadioButton mana, heal;
	
	JRadioButton vol[] = new JRadioButton[6];	//양
	JRadioButton amoun[] = new JRadioButton[6];	//갯수
	int[] num= {1,5,10,15,20,25};	//갯수
	
	JLabel label2;
	
	Mat m = new Mat();
	String CK;	//선택종류
	int CV, CA;	//선택양, 선택갯수
	
	JButton Jbuy, cancel;
	JTextArea total;
	int NG = 0, AM = 0;	//필요골드, 구매할 갯수
	
	public Shop() {
		this.setTitle("상점");
		this.setSize(510, 350);
		this.setLocation(600, 300);
		JPanel labelPanel = new JPanel();
		JLabel label1 = new JLabel("가격표");
		label1.setLocation(255, 5);
		label2 = new JLabel("보유 골드 : "+m.Gol);
		label2.setLocation(5, 10);
		labelPanel.add(label1);
		labelPanel.add(label2);
		this.add(labelPanel, BorderLayout.NORTH);
		this.add(new choice(), BorderLayout.CENTER);
		this.add(new buy(), BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	//가격표 선택
	class choice extends JPanel {
		private Border border;
		
		public choice() {
			setLayout(new GridLayout(0, 3));
			
			JPanel kinds = new JPanel(new GridLayout(2, 1));
			heal = new JRadioButton("체력포션");
			mana = new JRadioButton("마나포션");
			heal.addActionListener(new buy());
			mana.addActionListener(new buy());
			ButtonGroup kindsRB = new ButtonGroup();
			kindsRB.add(heal);
			kindsRB.add(mana);
			kinds.add(heal);
			kinds.add(mana);
			border = BorderFactory.createTitledBorder("종류");
			kinds.setBorder(border);
			
			JPanel volume = new JPanel(new GridLayout(6, 1));
			
			ButtonGroup volumeRB = new ButtonGroup();
			for(int i=0; i<6; i++) {
				vol[i]=new JRadioButton(m.Item[i] + " - 개당 " + m.NGol[i] + "골드");
				vol[i].addActionListener(new buy());
				volumeRB.add(vol[i]);
				volume.add(vol[i]);
			}
			
			border = BorderFactory.createTitledBorder("용량");
			volume.setBorder(border);
			
			ButtonGroup amountRB = new ButtonGroup();
			JPanel amount = new JPanel(new GridLayout(3, 1));
			for(int i=0; i<6; i++) {
				amoun[i]=new JRadioButton(num[i] + "개");
				amoun[i].addActionListener(new buy());
				amountRB.add(amoun[i]);
				amount.add(amoun[i]);
			}
			
			border = BorderFactory.createTitledBorder("갯수");
			amount.setBorder(border);
			
			this.add(kinds);
			this.add(volume);
			this.add(amount);
		}
		
	}
	
	//구매
	class buy extends JPanel implements ActionListener {

		public buy() {
			Jbuy = new JButton("구매");
			cancel = new JButton("돌아가기");
			Jbuy.addActionListener(this);
			cancel.addActionListener(this);
			total = new JTextArea(5, 45);
			total.setEditable(false);
			this.add(Jbuy);
			this.add(cancel);
			this.add(total);

		}

		public void actionPerformed(ActionEvent e) {
			Object ob = e.getSource();

			if(ob.equals(heal))
				CK="체력포션";
			else if(ob.equals(mana))
				CK="마나포션";
			
			for(int i=0; i<6; i++) {
			    if(ob.equals(vol[i]))
			    	CV=i;
			}
			
			for(int i=0; i<6; i++) {
			    if(ob.equals(amoun[i]))
			    	CA=i;
			}
			
			//구매 버튼 누를 때
			if(ob.equals(Jbuy))
			{
				AM=num[CA];
				NG=m.NGol[CV]*AM;
				if(m.Gol>=NG) {	//돈이 충분할 때
					if(CK.equals("체력포션"))
						m.HItem[CV]+=AM;
					else if(CK.equals("마나포션")) 
						m.MItem[CV]+=AM;
					m.Gol-=NG;
					total.setText("구매 완료\n남은 돈 : "+m.Gol+"골드");
					label2.setText("보유 골드 : "+m.Gol);
				}
				else	total.setText("돈이 부족합니다.\n부족한 돈 : "+(NG-m.Gol)+"골드");	//돈이 부족할 때
			}
			
			if (ob.equals(cancel)) {	//돌아가기 버튼 누를 때
				JOptionPane.showMessageDialog(null, "메뉴로 돌아갑니다.");
				dispose();
				new Menu();
			}
		}
	}
	
}
