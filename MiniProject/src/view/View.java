package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.MemberVO;
import model.RodVO;

// View 역할 : 입출력 담당
public class View {

	// 1. 필드
	private Scanner sc = new Scanner(System.in);
	private String[][] map = new String[10][10];

	// 2. 메서드
	// 메뉴 보여주는 메서드
	public int showMenu() {
		System.out.print("[1] 로그인 [2] 회원가입 [3] 종료 >>");
		int input = sc.nextInt();
		return input;
	}

	public int showMenu2() {
		System.out.print("[1] 상 [2] 하 [3] 좌 [4] 우 [5] 상태출력 [6] 종료");
		int input = sc.nextInt();
		return input;
	}

	public int showMenu3() {
		System.out.println("[1]미끼사기 [2]낚시대 구매 [3]종료 >>");
		int input = sc.nextInt();
		return input;
	}

	public int showMenu4() {
		System.out.print("[1]낚시하기 [2]종료 >>");
		int input = sc.nextInt();
		return input;
	}

	// 로그인 출력하는 메서드
	public MemberVO showLogin() {
		System.out.println("==== 로그인 ====");
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pw = sc.next();
		MemberVO mvo = new MemberVO();
	    mvo.setMemberId(id);  // 입력받은 ID 저장
	    mvo.setPw(pw);        // 입력받은 PW 저장
	    return mvo;           // Controller → DAO로 전달

	}

	// 로그인 성공 여부 출력하는 메서드
	public void statusLogin(MemberVO loginVO) {
		if (loginVO != null) {
			System.out.println("로그인 성공");
			System.out.println(loginVO.getName() + "님 환영합니다!");
			// loginVO
			// 사용자냐 관리자냐에 따라 호출되는게 다름(오버라이딩 했으니까)
		} else {
			System.out.println("로그인 실패");
		}
	}

	// 회원가입 출력하는 메서드
	public MemberVO showJoin() {
		System.out.println("==== 회원가입 ====");
		System.out.print("ID 입력 : ");
		String id = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pw = sc.next();
		System.out.print("이름 입력 : ");
		String name = sc.next();

		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setPw(pw);
		mvo.setName(name);

		return mvo;
	}

	// 회원가입 성공 여부 출력 메소드
	public void showInfo(int row, String msg) {
		if (row == 1) {
			System.out.println(msg + " 성공!");
		} else { // msg: "회원가입"
			System.out.println(msg + " 실패!");
		}
	}

	// 회원 정보들을 출력하는 메서드
	public void showMembers(ArrayList<RodVO> list) {

	}

	// 맵 출력
	public void printMap() {

	}

	// 상태 출력
	public void printStatus() {

	}

	// 미끼 사기 출력
	public int buybait() {
		System.out.print("미끼를 몇개 구매 하시겠습니까?");
		int count = sc.nextInt();
		return count;

	}

	
	
	// 낚시하기
	public void fishing(MemberVO loginVO) {

	}//미끼 사고 인사하기 - 수호가 추가
	public void bye(int a) {
		System.out.println("미끼를"+a +"개 사셨습니다");
		System.out.println(a*25+"골드를 사용하셨습니다");
	}
	// 돈이 부족합니다 -- 수호가 추가
	public void NoGold() {
		System.out.println("돈이 없습니다 돈을 더 벌어오세요!");
	}
	
	
	// 낚시대 구매 출력-- 수호가 추가 근데 DB로 해야하나?
	public int buyRod() {
		System.out.println("[1]다이소 낚시대 1000원 [2]카본 낚시대 3000원 [3] 다이아몬드 낚시대 10000원");
		int rod=sc.nextInt();
		
		
		return rod;
	}
	
	public void NoNum() {//수호가 추가
		System.out.println("번호를 잘 못 입력 하셨습니당");
	}
	
	public void printBuyRod(int rowId) {
		if(rowId == 1) {
			System.out.println("다이소 낚시대를 구매하셨습니다");
			System.out.println("1000골드를 사용하셨습니다");
		}else if(rowId==2) {
			System.out.println("카본 낚시대를 구매하셨습니다");
			System.out.println("3000골드를 사용하셨습니다");
		}else if(rowId==3) {
			System.out.println("다이아몬들 낚시대를 구매하셨습니다");
			System.out.println("10000골드를 사용하셨습니다");
		}else{System.out.println("번호를 잘못 입력하셨습니다");}
	}

}
