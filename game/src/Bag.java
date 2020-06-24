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
		this.setTitle("����");
		this.setSize(550, 350);
		this.setLocation(600, 300);
		JPanel labelPanel = new JPanel();
		JLabel label1 = new JLabel("���� ��� : "+m.Gol);
		labelPanel.add(label1);
		this.add(labelPanel, BorderLayout.NORTH);
		this.add(new choice(), BorderLayout.CENTER);
		this.add(new Use(), BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	//����� ������ ����
	class choice extends JPanel {
		private Border border;
		
		public choice() {
			setLayout(new GridLayout(0, 3));
			
			JPanel Heal = new JPanel(new GridLayout(6, 1));
			
			ButtonGroup itemRB = new ButtonGroup();
			for(int i=0; i<6; i++) {
				item[i]=new JRadioButton(m.Item[i] + "ȸ������ - " + m.HItem[i] + "�� ����");
				item[i].addActionListener(new Use());
				itemRB.add(item[i]);
				Heal.add(item[i]);
			}
			
			border = BorderFactory.createTitledBorder("���� ȸ������");
			Heal.setBorder(border);
			
			JPanel Mana = new JPanel(new GridLayout(6, 1));
			
			for(int i=6;i<12; i++) {
				item[i]=new JRadioButton(m.Item[i%6] + "�������� - " + m.MItem[i%6] + "�� ����");
				item[i].addActionListener(new Use());
				itemRB.add(item[i]);
				Mana.add(item[i]);
			}
			
			border = BorderFactory.createTitledBorder("���� ��������");
			Mana.setBorder(border);
			
			ButtonGroup amountRB = new ButtonGroup();
			JPanel amount = new JPanel(new GridLayout(3, 1));
			for(int i=0; i<6; i++) {
				amoun[i]=new JRadioButton(num[i] + "��");
				amoun[i].addActionListener(new Use());
				amountRB.add(amoun[i]);
				amount.add(amoun[i]);
			}
			
			border = BorderFactory.createTitledBorder("����");
			amount.setBorder(border);
			
			this.add(Heal);
			this.add(Mana);
			this.add(amount);
		}
		
	}
	
	//���
	class Use extends JPanel implements ActionListener {

		public Use() {
			use = new JButton("���");
			cancel = new JButton("���ư���");
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
			
			//��� ��ư ���� ��
			if(ob.equals(use))
			{
				AM=num[CA];
				if(CV>=0 && CV<6) {	//ü������ ������ ��
					if(m.HItem[CV]>=AM) {
						m.HItem[CV]-=AM;
						m.hp+=m.Item[CV]*AM;
						if(m.hp>m.Hp)	m.hp=m.Hp;
						total.setText("��� �Ϸ�\n���� ������ : "+m.HItem[CV]+"��");
					}
					else	total.setText("�������� �����մϴ�.\n������ �������� ���� : "+(AM-m.HItem[CV])+"��");
				}
				else if(CV>5 && CV<12) {	//�������� ������ ��
					if(m.MItem[CV%6]>=AM) {
						m.MItem[CV%6]-=AM;
						m.mp+=m.Item[CV%6]*AM;
						if(m.mp>m.Mp)	m.mp=m.Mp;
						total.setText("��� �Ϸ�\n���� ������ : "+m.MItem[CV%6]+"��");
					}
					else	total.setText("�������� �����մϴ�.\n������ �������� ���� : "+(AM-m.MItem[CV%6])+"��");
				}
				else	total.setText("������ �Ǵ� ������ �����ϼ���.");
			}
			
			if (e.getSource() == cancel) {	//���ư��� ��ư ���� ��
				JOptionPane.showMessageDialog(null, "���ư��ϴ�.");
				dispose();
			}
		}
	}
	
}
