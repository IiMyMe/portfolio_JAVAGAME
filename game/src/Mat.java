import javax.swing.*;

public class Mat {
	static int Lv=1;	//레벨
	static int Hp=0;	//기준 체력
	static int hp=0;	//변동될 체력
	static int Mp=0;	//기준 마나
	static int mp=0;	//마나
	static int Op=0;	//공격력
	static int Exp=0;	//경험지
	static int Gol=0;	//돈
	int NExp=Lv*10;	//필요경험치
	int GExp[]= {5,15,25,35,45,55,65,75,85,95};	//몬스터별 얻는 경험치/돈 범위
	int MHp[]= {10,20,30,40,50,60,70,80,90,100};	//몬스터 피/공격력
	int Item[]= {10,30,50,100,150,200};	//아이템 증가 효과
	int NGol[]= {5,10,25,40,75,110};	//필요한 돈
	static int HItem[]= {0,0,0,0,0,0};	//가지고 있는 힐링템 갯수
	static int MItem[]= {0,0,0,0,0,0};	//가지고 있는 마나템 갯수
	String[] Mna= {
		"머쉬맘",	"셰이드","스노우맨","그리프","와이번","아라클로소","모스퀸","히드라","발타루시스","사탄"
	};	//몬스터 이름
	
	//몬스터 이미지
	ImageIcon img[]= {
			new ImageIcon("./img/머쉬맘.png"),
			new ImageIcon("./img/셰이드.png"),
			new ImageIcon("./img/스노우맨.png"),
			new ImageIcon("./img/그리프.png"),
			new ImageIcon("./img/와이번.png"),
			new ImageIcon("./img/아라클로소.PNG"),
			new ImageIcon("./img/모스퀸.PNG"),
			new ImageIcon("./img/히드라.PNG"),
			new ImageIcon("./img/발타루시스.PNG"),
			new ImageIcon("./img/사탄.png")
	};	
	
	
	//레벨업
	public void lvup() {
		Lv++;
		Exp=0;
		Hp+=10;
		Mp+=10;
		Op+=10;
		hp=Hp;
		mp=Mp;
		if(Lv==11) {
			JOptionPane.showMessageDialog(null, "최고레벨인 11레벨이 되었습니다!\n축하합니다!\n종료합니다.");
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null, "레벨이 올랐다!\n체력이 "+Hp+", 마나는 "+Mp+", 공격력은 "+Op+"로 증가했다!\n체력이 모두 회복됐다!");
	}

}
