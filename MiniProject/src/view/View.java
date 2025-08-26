package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

import model.MemberVO;
import model.RodVO;

// View 역할 : 입출력 담당
public class View {

	// 1. 필드
	private Scanner sc = new Scanner(System.in);

	// 2. 메서드
	// 메뉴 보여주는 메서드
	public String showMenu() {
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("       	    🐟 BASS FISHING GAME 🐟");
		System.out.println("════════════════════════════════════════════════");
		System.out.println("           ╭─────╮   ╭─────╮   ╭─────╮");
		System.out.println("           │  1️  │   │  2️  │   │  3  │");
		System.out.println("           ╰─────╯   ╰─────╯   ╰─────╯");
		System.out.println("            로그인     회원가입     종료");
		System.out.println();
		// System.out.println("════════════════════════════════════════════════");
		System.out.println("              🎣 번호를 입력해주세요 !🎣");
		System.out.print("                        ");
		String menu = sc.next();
//		System.out.println();
//		System.out.println("        🐠      🐟      🐡      🐟      🐠");
		return menu;
	}

	public String showMapMenu() {
		System.out.print("[w] 상 [s] 하 [a] 좌 [d] 우 [1]현재상태 [2]저장 [3]종료 >>");
		String input = sc.next();
		return input;
	}

	public String showStoreMenu() {
		System.out.println();
	    System.out.println("      ══════════════════════════════════════════");
	    System.out.println("                 🏪 FISHING SHOP 🏪");
	    System.out.println("      ══════════════════════════════════════════");
	    System.out.println();
	    System.out.println("            ═══════════════════════════════");
	    System.out.println("               1️ 미끼 구매                  ");
	    System.out.println("               2 낚시대 구매                ");
	    System.out.println("               3 나가기                      ");
	    System.out.println("            ═══════════════════════════════");
	    System.out.println();
	    System.out.println("              🎣 원하시는 번호를 입력해주세요! 🎣");
	    System.out.print("                        ");
	    
		String input = sc.next();
	    
	    return input; 
	}

	public String showFishingMenu() {
		System.out.print("[1]낚시하기 [2]확률보기 [3]나가기 >>");
		String input = sc.next();
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
		mvo.setMemberId(id); // 입력받은 ID 저장
		mvo.setPw(pw); // 입력받은 PW 저장
		return mvo; // Controller → DAO로 전달

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

	// 맵 출력
		public void printMap(String[][] map, int x, int y) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j].startsWith("STORE_")) {
						System.out.print("🏪");
					} else if (map[i][j].startsWith("FISH_")) {
						System.out.print("🎣");
					} else if (i == x && j == y) {
						System.out.print("🧍");
					} else {
						System.out.print("⬜");
					}

				}
				System.out.println();
			}
		}

	// 상태 출력
	public void printStatus(MemberVO mvo) {
		System.out.println();
		System.out.println("<  현재 나의 정보  >");
		System.out.println("  점 수 : " + mvo.getPoint());
		System.out.println("  골 드 : " + mvo.getGold());
		System.out.println("  미 끼 : " + mvo.getBait());
		String rodName = "";
		int rodId = mvo.getRodid();
		if (rodId == 1) {
			rodName = "대나무 낚시대";
		} else if (rodId == 2) {
			rodName = "다이소 낚시대";
		} else if (rodId == 3) {
			rodName = "카본 낚시대";
		} else if (rodId == 4) {
			rodName = "다이아몬드 낚시대";
		}
		System.out.println("  낚시대 : " + rodName);
	}

	public String RealQuitMsg() {
		System.out.println();
		System.out.println("정말 나가시겠습니까?");
		System.out.println("저장되지 않은 데이터는 삭제됩니다.");
		System.out.println("[1]종료 [2]취소");
		String answer = sc.next();
		return answer;
	}

	// 정말 나가시겠습니까?
	public void Real() {
		System.out.println("게임을 종료하고 로그인 화면으로 돌아갑니다.");
	}

	// 미끼 사기 출력
	public int buybait() {
		 System.out.println();
		    System.out.println("════════════════════════════════════════════════");
		    System.out.println("            🦐 새우 미끼 : 25 Gold");
		    System.out.println("════════════════════════════════════════════════");
		    System.out.print("👉 몇 개를 구매하시겠습니까? : ");
			int count = sc.nextInt();

		    return count;
	}

	// 미끼 사고 인사하기 - 수호가 추가

	public void bye(int a) {
		System.out.println("미끼를" + a + "개 사셨습니다");
		System.out.println(a * 25 + "골드를 사용하셨습니다");
	}

	// 돈이 부족합니다 -- 수호가 추가
	public void NoGold() {
		System.out.println("돈이 없습니다 돈을 더 벌어오세요!");
	}

	// 낚시대 구매 출력-- 수호가 추가 근데 DB로 해야하나?
	public int buyRod() {
		int rod = sc.nextInt();
		return rod;

	}

	public void printBuyRod(int rowId) {
		if (rowId == 1) {// **********25일 변경
			System.out.println("대나무 낚시대를 구매하셨습니다");
		}

		else if (rowId == 2) {
			System.out.println("다이소 낚시대를 구매하셨습니다");
			System.out.println("1000골드를 사용하셨습니다");
		} else if (rowId == 3) {
			System.out.println("카본 낚시대를 구매하셨습니다");
			System.out.println("3000골드를 사용하셨습니다");
		} else if (rowId == 4) {
			System.out.println("다이아몬들 낚시대를 구매하셨습니다");
			System.out.println("10000골드를 사용하셨습니다");
		} else {
			System.out.println("번호를 잘못 입력하셨습니다");
		}
	}

	public void fishingSuccess(String fishSizeName) {
		System.out.println(fishSizeName + " 낚시에 성공하셨습니다.");

	}

	public void fishingFail(String fishSizeName) {
		System.out.println(fishSizeName + " 낚시에 실패하셨습니다.");
	}

	public void hitFail() {
		System.out.println("찌 맞추기에 실패하셨습니다.");
	}

	public void getFishingSpotInfo(LinkedHashMap<String, Integer> fishChances) {
		System.out.println("물고기 등장 확률");
		System.out.println("┌──────┬────────┐");
		System.out.println("│ Size │ Chance │");
		System.out.println("├──────┼────────┤");

		for (String size : fishChances.keySet()) {
			System.out.printf("│ %-4s │ %-6s │\n", size, fishChances.get(size) + "%");
		}
		System.out.println("└──────┴────────┘");

		System.out.println();
		System.out.println("낚을 확률");
		System.out.println("┌──────┬──────────┬────────┬──────────┐");
		System.out.println("│ Size │ Catch %  │ Score  │ Earned W │");
		System.out.println("├──────┼──────────┼────────┼──────────┤");
		System.out.println("│ S    │ 100%     │ 10 pts │ W1.00    │");
		System.out.println("│ M    │ 50%      │ 25 pts │ W1.20    │");
		System.out.println("│ L    │ 25%      │ 60 pts │ W1.50    │");
		System.out.println("│ Boss │ 10%      │ 500 pts│ W50.00   │");
		System.out.println("└──────┴──────────┴────────┴──────────┘");
	}

	public void alertBuyBait() {
		System.out.println("미끼가 부족합니다. 상점에 가서 사오세요.");

	}

	public boolean hit(MemberVO loginVO) {
		int rodId = loginVO.getRodid();
		boolean isHit = false;

		int barLength = 30; // 바 길이
		int targetStart = 0; // 성공 구간 시작
		int targetEnd = 0; // 성공 구간 끝
		int middlePoint = barLength / 2;
		boolean forward = true;

		if (rodId == 1) {
			targetEnd = 4;
		} else if (rodId == 2) {
			targetEnd = 5;
		} else if (rodId == 3) {
			targetEnd = 6;
		} else if (rodId == 4) {
			targetEnd = 7;
		}

		while (true) {
			// 바 그리기

			StringBuilder sb = new StringBuilder("=== 엔터 입력으로 타이밍 맞추기 ===");
			sb.append("\n");
			for (int i = 0; i < barLength; i++) {
				if (i == middlePoint)
					sb.append("↓");
				else
					sb.append(" ");
			}
			sb.append("\n");

			sb.append("[");
			for (int i = 0; i < barLength; i++) {
				if (i >= targetStart && i <= targetEnd)
					sb.append("=");
				else
					sb.append(" ");
			}
			sb.append("]");

			System.out.println("\r" + sb);

			// 방향 전환
			if (forward) {
				targetStart++;
				targetEnd++;
			} else {
				targetStart--;
				targetEnd--;
			}

			if (targetEnd == barLength - 1) {
				forward = false;
			}

			if (targetStart == 0) {
				forward = true;
			}

			try {
				// 움직임 속도
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 입력 감지 (간단히 Enter로 처리)
			try {
				if (System.in.available() > 0) { // 키 입력 대기 확인
					String input = sc.nextLine();
					if (middlePoint >= targetStart && middlePoint <= targetEnd) {
						System.out.println("\n🎉 찌 맞추기 성공!");
						isHit = true;
					} else {
						System.out.println("\n💀 찌 맞추기 실패!");
						isHit = false;
					}
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return isHit;
	}

	public HashMap<String, String> fishing(int weather, LinkedHashMap<String, Integer> fishChances) {
		HashMap<String, String> map = new HashMap<String, String>();

		Random rd = new Random();

		int SChance = fishChances.get("S");
		int MChance = fishChances.get("M");
		int LChance = fishChances.get("L");
		int BossChance = fishChances.get("Boss");
		String isSuccess = "fail";

		// 1 ~ 100 사이 랜덤 뽑기
		int rand = rd.nextInt(100) + 1;

		String fishSizeName = "꽝";
		int cumulative = 0;

		for (Entry<String, Integer> entry : fishChances.entrySet()) {
			cumulative += entry.getValue();
			if (rand <= cumulative) {
				fishSizeName = entry.getKey();
				break;
			}
		}

		map.put("물고기크기", fishSizeName);

		// 기본 확률표 (맑은 날 기준)
		HashMap<String, Integer> baseProb = new HashMap<>();
		baseProb.put("S", 100);
		baseProb.put("M", 50);
		baseProb.put("L", 25);
		baseProb.put("Boss", 10);

		// 날씨에 따라 확률 조정
		double weatherFactor = (weather == 1) ? 1.0 : 0.8; // 맑음=1.0, 폭우=0.8

		if (!fishSizeName.equals("꽝")) {
			Integer chance = baseProb.get(fishSizeName);

			if (chance != null) {
				int adjustedChance = (int) Math.round(chance * weatherFactor);
				int roll = rd.nextInt(100) + 1; // 1~100
				if (roll <= adjustedChance) {
					isSuccess = "success";
				}
			}
		}

		if (isSuccess.equals("success")) {
			System.out.println("\n🎉 " + fishSizeName + " 낚시 성공!");
		} else {
			System.out.println("\n💀 " + fishSizeName + " 낚시 실패!");
		}

		map.put("성공실패", isSuccess);

		return map;
	}

	public String eventStart(String[][] map, int x, int y) {
		// TODO Auto-generated method stub
		String result = null;

		if (map[x][y].startsWith("STORE_")) {
			result = "상점";
		} else if (map[x][y].startsWith("FISH_")) {
			result = map[x][y];
		}

		return result;
	}

	public void showLoginFail() {
		System.out.println("로그인이 안되었습니다. 아이디와 비밀번호를 확인해주세요.");

	}

	public void showRodList(ArrayList<RodVO> rodList) {//// 825
		for (RodVO rvo : rodList) {
			System.out.print(rvo.getRodid() + "번");
			System.out.print("\t" + rvo.getName());
			System.out.print("\t" + rvo.getPrice() + "원");
			System.out.println();
		}

	}

	public void cantBuy() {/// 825
		System.out.println("사용하고 있는 낚시대는 구매하실 수 없습니다");

	}

	public void showGoodEnding() {
		System.out.println("최고의 낚싯대를 손에 쥔 김수호, 마침내 전설의 배스를 낚아 올렸다.");
		System.out.println("이제 낚시터 사람들은 그를 이렇게 부른다… ‘배스킹(🐟👑)’.");
		System.out.println("오늘도... 여친은 없다. 게임 클리어!");
	}

	public void showBadEnding() {
		System.out.println("여전히 혼자인 그의 처지를 안타까워했다...");
		System.out.println("오늘도... 여친은 없다. 게임 오버.");
	}

	public void showWeather(int weather) {
		if (weather == 1) {
			System.out.println(" 오늘은 맑음!!!");
		} else {
			System.out.println("폭우임 우르르쾅쾅!!");
			System.out.println("폭우면 잡힐확률 20%감소!");
		}

	}

	// 낚시후 상태 보여주기
	public void showFishingStatus(MemberVO mvo) {
		System.out.println("gold = " + mvo.getGold() + ", point = " + mvo.getPoint() + ", vait = " + mvo.getBait());
	}

	public void wrongInput() {
		System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
		
	}

}