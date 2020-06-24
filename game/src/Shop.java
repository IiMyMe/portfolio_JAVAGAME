import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Shop extends JFrame {
	
	JRadioButton mana, heal;
	
	JRadioButton vol[] = new JRadioButton[6];	//��
	JRadioButton amoun[] = new JRadioButton[6];	//����
	int[] num= {1,5,10,15,20,25};	//����
	
	JLabel label2;
	
	Mat m = new Mat();
	String CK;	//��������
	int CV, CA;	//���þ�, ���ð���
	
	JButton Jbuy, cancel;
	JTextArea total;
	int NG = 0, AM = 0;	//�ʿ���, ������ ����
	
	public Shop() {
		this.setTitle("����");
		this.setSize(510, 350);
		this.setLocation(600, 300);
		JPanel labelPanel = new JPanel();
		JLabel label1 = new JLabel("����ǥ");
		label1.setLocation(255, 5);
		label2 = new JLabel("���� ��� : "+m.Gol);
		label2.setLocation(5, 10);
		labelPanel.add(label1);
		labelPanel.add(label2);
		this.add(labelPanel, BorderLayout.NORTH);
		this.add(new choice(), BorderLayout.CENTER);
		this.add(new buy(), BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	//����ǥ ����
	class choice extends JPanel {
		private Border border;
		
		public choice() {
			setLayout(new GridLayout(0, 3));
			
			JPanel kinds = new JPanel(new GridLayout(2, 1));
			heal = new JRadioButton("ü������");
			mana = new JRadioButton("��������");
			heal.addActionListener(new buy());
			mana.addActionListener(new buy());
			ButtonGroup kindsRB = new ButtonGroup();
			kindsRB.add(heal);
			kindsRB.add(mana);
			kinds.add(heal);
			kinds.add(mana);
			border = BorderFactory.createTitledBorder("����");
			kinds.setBorder(border);
			
			JPanel volume = new JPanel(new GridLayout(6, 1));
			
			ButtonGroup volumeRB = new ButtonGroup();
			for(int i=0; i<6; i++) {
				vol[i]=new JRadioButton(m.Item[i] + " - ���� " + m.NGol[i] + "���");
				vol[i].addActionListener(new buy());
				volumeRB.add(vol[i]);
				volume.add(vol[i]);
			}
			
			border = BorderFactory.createTitledBorder("�뷮");
			volume.setBorder(border);
			
			ButtonGroup amountRB = new ButtonGroup();
			JPanel amount = new JPanel(new GridLayout(3, 1));
			for(int i=0; i<6; i++) {
				amoun[i]=new JRadioButton(num[i] + "��");
				amoun[i].addActionListener(new buy());
				amountRB.add(amoun[i]);
				amount.add(amoun[i]);
			}
			
			border = BorderFactory.createTitledBorder("����");
			amount.setBorder(border);
			
			this.add(kinds);
			this.add(volume);
			this.add(amount);
		}
		
	}
	
	//����
	class buy extends JPanel implements ActionListener {

		public buy() {
			Jbuy = new JButton("����");
			cancel = new JButton("���ư���");
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
				CK="ü������";
			else if(ob.equals(mana))
				CK="��������";
			
			for(int i=0; i<6; i++) {
			    if(ob.equals(vol[i]))
			    	CV=i;
			}
			
			for(int i=0; i<6; i++) {
			    if(ob.equals(amoun[i]))
			    	CA=i;
			}
			
			//���� ��ư ���� ��
			if(ob.equals(Jbuy))
			{
				AM=num[CA];
				NG=m.NGol[CV]*AM;
				if(m.Gol>=NG) {	//���� ����� ��
					if(CK.equals("ü������"))
						m.HItem[CV]+=AM;
					else if(CK.equals("��������")) 
						m.MItem[CV]+=AM;
					m.Gol-=NG;
					total.setText("���� �Ϸ�\n���� �� : "+m.Gol+"���");
					label2.setText("���� ��� : "+m.Gol);
				}
				else	total.setText("���� �����մϴ�.\n������ �� : "+(NG-m.Gol)+"���");	//���� ������ ��
			}
			
			if (ob.equals(cancel)) {	//���ư��� ��ư ���� ��
				JOptionPane.showMessageDialog(null, "�޴��� ���ư��ϴ�.");
				dispose();
				new Menu();
			}
		}
	}
	
}
