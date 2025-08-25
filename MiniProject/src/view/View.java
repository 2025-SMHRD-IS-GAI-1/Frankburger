package view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.RodVO;
import model.MemberVO;

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
		System.out.print("[1]미끼사기 [2]낚시대 구매 [3]종료 >>");
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

//		MemberVO mvo = new MemberVO(); 
		return null;

	}

	// 로그인 성공 여부 출력하는 메서드
	public void statusLogin(MemberVO loginVO) {
		if (loginVO != null) {
			System.out.println("로그인 성공");
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
		System.out.println("이름 입력 : ");
		String name = sc.next();
		System.out.println("나이 입력 : ");
		int age = sc.nextInt();

//		MemberVO mvo = new MemberVO();
		
		return null;
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
	public int buybait(int count) {
		return 1;
	}
	
	// 낚시대 구매 출력
	public int buyRod() {
		return 1;
	}
	
	// 낚시하기 
	public void fishing(MemberVO loginVO) {
		
	}
	



}
