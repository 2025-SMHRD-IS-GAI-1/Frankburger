package model;

// role == 사용자인 member를 나타내는 자료형
public class MemberVO {

	// field
	private String member;
	private String pw;
	private String name;
	private int rodid;
	private int gold;
	private int point;
	private int bait;
	private int x;
	private int y;

	// method
	public MemberVO(String member, String pw, String name, int rodid, int gold, int point, int bait, int x, int y) {
		super();
		this.member = member;
		this.pw = pw;
		this.name = name;
		this.rodid = rodid;
		this.gold = gold;
		this.point = point;
		this.bait = bait;
		this.x = x;
		this.y = y;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRodid() {
		return rodid;
	}

	public void setRodid(int rodid) {
		this.rodid = rodid;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getBait() {
		return bait;
	}

	public void setBait(int bait) {
		this.bait = bait;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public void upgrade(int rodid) {
		
	}
	
	public void buyBait(int count) {
		
	}
	public void FishingSucces() {
		
	}
	public void FishingFail() {
		
	}
	public void move(int dir) {
		
	}
	
	
}
