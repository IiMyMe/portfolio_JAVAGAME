import javax.swing.*;

public class Mat {
	static int Lv=1;	//����
	static int Hp=0;	//���� ü��
	static int hp=0;	//������ ü��
	static int Mp=0;	//���� ����
	static int mp=0;	//����
	static int Op=0;	//���ݷ�
	static int Exp=0;	//������
	static int Gol=0;	//��
	int NExp=Lv*10;	//�ʿ����ġ
	int GExp[]= {5,15,25,35,45,55,65,75,85,95};	//���ͺ� ��� ����ġ/�� ����
	int MHp[]= {10,20,30,40,50,60,70,80,90,100};	//���� ��/���ݷ�
	int Item[]= {10,30,50,100,150,200};	//������ ���� ȿ��
	int NGol[]= {5,10,25,40,75,110};	//�ʿ��� ��
	static int HItem[]= {0,0,0,0,0,0};	//������ �ִ� ������ ����
	static int MItem[]= {0,0,0,0,0,0};	//������ �ִ� ������ ����
	String[] Mna= {
		"�ӽ���",	"���̵�","������","�׸���","���̹�","�ƶ�Ŭ�μ�","����","�����","��Ÿ��ý�","��ź"
	};	//���� �̸�
	
	//���� �̹���
	ImageIcon img[]= {
			new ImageIcon("./img/�ӽ���.png"),
			new ImageIcon("./img/���̵�.png"),
			new ImageIcon("./img/������.png"),
			new ImageIcon("./img/�׸���.png"),
			new ImageIcon("./img/���̹�.png"),
			new ImageIcon("./img/�ƶ�Ŭ�μ�.PNG"),
			new ImageIcon("./img/����.PNG"),
			new ImageIcon("./img/�����.PNG"),
			new ImageIcon("./img/��Ÿ��ý�.PNG"),
			new ImageIcon("./img/��ź.png")
	};	
	
	
	//������
	public void lvup() {
		Lv++;
		Exp=0;
		Hp+=10;
		Mp+=10;
		Op+=10;
		hp=Hp;
		mp=Mp;
		if(Lv==11) {
			JOptionPane.showMessageDialog(null, "�ְ����� 11������ �Ǿ����ϴ�!\n�����մϴ�!\n�����մϴ�.");
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null, "������ �ö���!\nü���� "+Hp+", ������ "+Mp+", ���ݷ��� "+Op+"�� �����ߴ�!\nü���� ��� ȸ���ƴ�!");
	}

}
