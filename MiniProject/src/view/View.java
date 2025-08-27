package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
		System.out.println("════════════════════════════════════════════════");
		System.out.println("              🎣 번호를 입력해주세요 !🎣");
		System.out.print("                        ");
		String menu = sc.next();
		return menu;
	}

	// 메인메뉴 출력문
	public String showMapMenu() {
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                  🎮 조작 안내 🎮");
		System.out.println("════════════════════════════════════════════════");
		System.out.println("     ↑  w : 위로 이동    【  ←  a : 왼쪽 이동");
		System.out.println("     ↓  s : 아래로 이동    】 →  d : 오른쪽 이동");
		System.out.println("════════════════════════════════════════════════");
		System.out.println();
		System.out.println("                  📋 게임 메뉴 📋");
		System.out.println();
		System.out.println("           ╭─────╮   ╭─────╮   ╭─────╮");
		System.out.println("           │  1  │   │  2  │   │  3  │");
		System.out.println("           ╰─────╯   ╰─────╯   ╰─────╯");
		System.out.println("            현재상태     저장       종료");
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.print("             👉 메뉴 번호를 입력하세요: ");
		String input = sc.next();
		System.out.println("════════════════════════════════════════════════");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(); // 전체 화면 창에 맞는 여백 마지막단

		return input;
	}

	public String showStoreMenu() {
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                    🛒 상점 🛒");
		System.out.println("════════════════════════════════════════════════");
		System.out.println("            🎣 필요한 아이템을 구매하세요! 🎣");
		System.out.println();
		System.out.println("           ╭─────╮   ╭─────╮   ╭─────╮");
		System.out.println("           │  1  │   │  2  │   │  3  │");
		System.out.println("           ╰─────╯   ╰─────╯   ╰─────╯");
		System.out.println("           미끼 구매   낚시대 구매   나가기");
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.print("             👉 메뉴 번호를 입력하세요: ");
		String input = sc.next();
		System.out.println("════════════════════════════════════════════════");
		System.out.println();

		return input;
	}

	public MemberVO showLogin() {
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                   🔒 로그인 🔒");
		System.out.println("════════════════════════════════════════════════");

		System.out.println();

		// 아이디 입력
		System.out.print("            🔑 아이디를 입력해주세요: ");
		String id = sc.next();
		System.out.println();

		// 비밀번호 입력
		System.out.print("            🔒 비밀번호를 입력해주세요: ");
		String pw = sc.next();
		System.out.println();

		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id); // 입력받은 ID 저장
		mvo.setPw(pw); // 입력받은 PW 저장
		return mvo; // Controller → DAO로 전달

	}

	// 로그인 성공 여부 출력하는 메서드
	public void statusLogin(MemberVO loginVO) {
		if (loginVO != null) {
			System.out.println("════════════════════════════════════════════════");
			System.out.println("                 🎉 로그인 성공! 🎉");
			System.out.println("════════════════════════════════════════════════");
			System.out.println("        🐡₊‧.°.                          🐟𓂃⊹ ִֶָ");
			System.out.println("                ✨ " + loginVO.getName() + " 님, 환영합니다! ✨");
			System.out.println("             오늘도 큰 물고기를 낚아보세요! ");
			System.out.println("  🐠=~                                🐡.·˖*·⑅♡");
			System.out.println("            ◁:0€             🐟~-  ");
			System.out.println("════════════════════════════════════════════════");
			System.out.println("                  <  게임 설명  >");
			System.out.println("오늘의 주인공 홍길동(29세,여친없음) 배스왕이 되면 여자친구를 사귈 수 있겠지?");
			System.out.println("오늘도 열심히 낚시를 해보자!!");
			System.out.println("낚시터 : 🎣");
			System.out.println("상점 : 🏪");
			System.out.println("point 2000점 획득시 배스왕이 될 수 있습니다 ");
			System.out.println("(미끼와 돈이 모두 없으면 배드앤딩으로 종료됩니다)");
			System.out.println("tip: 낚시터마다 출현하는 배스크기와 확률이 다르므로");
			System.out.println("낚시터 확률을 꼭 확인하세요!");
			System.out.println();

		} else {
			System.out.println("════════════════════════════════════════════════");
			System.out.println("                 🚫 로그인 실패 🚫");
			System.out.println("════════════════════════════════════════════════");
			System.out.println("        🔑 아이디 또는 비밀번호를 확인해주세요!");
			System.out.println("           🎣 다시 로그인 시도해보세요! 🎣");
			System.out.println("════════════════════════════════════════════════");
		}
	}

	// 회원가입 출력하는 메서드
	public MemberVO showJoin() {
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                 📝 회원가입 📝");
		System.out.println("════════════════════════════════════════════════");
		System.out.println();

		// 아이디 입력
		System.out.print("           🔑 아이디를 입력해주세요: ");
		String id = sc.next();
		System.out.println();
		// 비밀번호 입력
		System.out.print("           🔒 비밀번호를 입력해주세요: ");
		String pw = sc.next();
		System.out.println();
		// 이름 입력
		System.out.print("           🧑 이름을 입력해주세요: ");
		String name = sc.next();
		System.out.println();

		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setPw(pw);
		mvo.setName(name);

		return mvo;
	}

	// 회원가입 성공 여부 출력 메소드
	public void showInfo(int row) {
		if (row == 1) {
			System.out.println();
			System.out.println("           🎉 회원가입이 완료되었습니다! 🎉");
		} else {
			System.out.println();
			System.out.println("          🚫 회원가입에 실패하셨습니다! 🚫");

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
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                 👤 현재 상태 👤");
		System.out.println("════════════════════════════════════════════════");
		System.out.println();
		System.out.println("      🏆 점수  ➤  " + mvo.getPoint() + "   💰 소지금  ➤  " + mvo.getGold() + " G");
		System.out.println();
		System.out.println("  🐛 미끼  ➤  " + mvo.getBait() + "    🎣 낚시대  ➤  " + rodName);
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println();
	}

	// 나가기 메뉴
	public String RealQuitMsg() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                   😢 나가기 😢  ");
		System.out.println("════════════════════════════════════════════════");
		System.out.println("         💾 저장되지 않은 데이터는 삭제됩니다.💾");
		System.out.println();
		System.out.println("              ╭─────╮       ╭─────╮");
		System.out.println("              │  1️  │       │  2️  │");
		System.out.println("              ╰─────╯       ╰─────╯");
		System.out.println("                종료           취소");
		System.out.println();
		System.out.println("              👉 번호를 입력해주세요! ");
		System.out.print("                         "); // 커서 위치 조정
		String input = sc.next();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		return input;
	}

	// 나가기 출력
	public void Real() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                 🐟 로그아웃 🐟");
		System.out.println("════════════════════════════════════════════════");
		System.out.println("       🐡₊‧.°.                          🐟𓂃⊹ ִֶָ");
		System.out.println("             🐟 오늘의 낚시를 마칩니다! 🎣");
		System.out.println("  🐠=~                                🐡.·˖*·⑅♡");
		System.out.println("            ◁:0€             🐟~-  ");
		System.out.println("════════════════════════════════════════════════");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}

	public String showFishingMenu() {

		System.out.println("           .              .     🐡     ~       o  ");
		System.out.println("     ~              .   .                         ");
		System.out.println("          . o                                  ");
		System.out.println("   .   🐙             .          ~           .   ");
		System.out.println("                 🐟             o             ~ ");
		System.out.println("                                              ");
		System.out.println("════════════════════════════════════════════════");
		System.out.println(" 	           🎣 낚시터 🎣");
		System.out.println("════════════════════════════════════════════════");
		System.out.println("            ╭─────╮ ╭─────╮ ╭─────╮");
		System.out.println("            │  1️  │ │  2️  │ │  3️  │");
		System.out.println("            ╰─────╯ ╰─────╯ ╰─────╯");
		System.out.println("             낚시하기  확률보기  나가기");
		System.out.println();
		System.out.println("             🎣 번호를 입력해주세요! 🎣");
		System.out.print("                        "); // 커서 위치 조정
		String input = sc.next();
		return input;
	}

	// 미끼 사기 출력
	public int buybait() {
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("            🦐 새우 미끼 : 25 Gold");
		System.out.println("════════════════════════════════════════════════");
		System.out.print("           👉 몇 개를 구매하시겠습니까? : ");
		int count = sc.nextInt();

		return count;
	}

	// 미끼 사고 인사하기
	public void bye(int a) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                  💰 구매 완료! 💰");
		System.out.println();
		System.out.println("                     -" + a * 25 + " G");
		System.out.println("════════════════════════════════════════════════");
	}

	// 골드 부족
	public void NoGold() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                 💰 소지금 부족! 💰");
		System.out.println("          더 많은 골드를 벌어서 구매해보세요 ");
		System.out.println("════════════════════════════════════════════════");
	}

	// 낚시대 구매 출력
	public int buyRod() {
		int rod = sc.nextInt();
		return rod;

	}

	public void printBuyRod(int rowId) {
		if (rowId == 1) {
			System.out.println("════════════════════════════════════════════════");
			System.out.println("           🎣 대나무 낚시대를 구매하셨습니다!");
			System.out.println("════════════════════════════════════════════════");
		}

		else if (rowId == 2) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("════════════════════════════════════════════════");
			System.out.println("           🎣 다이소 낚시대를 구매하셨습니다!");
			System.out.println();
			System.out.println("            💰 1000 골드를 사용하셨습니다.");
			System.out.println("════════════════════════════════════════════════");
		} else if (rowId == 3) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("════════════════════════════════════════════════");
			System.out.println("            🎣 카본 낚시대를 구매하셨습니다!");
			System.out.println();
			System.out.println("            💰 3000 골드를 사용하셨습니다.");
			System.out.println("════════════════════════════════════════════════");
		} else if (rowId == 4) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("════════════════════════════════════════════════");
			System.out.println("           🎣 다이아몬드 낚시대를 구매하셨습니다!");
			System.out.println();
			System.out.println("           💰 10000 골드를 사용하셨습니다.");
			System.out.println("════════════════════════════════════════════════");
		} else {
			System.out.println("════════════════════════════════════════════════");
			System.out.println("            🚫 번호를 잘못 입력하셨습니다!");
			System.out.println("════════════════════════════════════════════════");
		}
	}

	public void fishingSuccess(String fishSizeName) {
		System.out.println("                " + fishSizeName + " 낚시에 성공하셨습니다.");
		System.out.println();

	}

	// 낚시 실패
	public void fishingFail(String fishName) {
		System.out.println("════════════════════════════════════════════════");
		System.out.println("              💀 " + fishName + " 낚시에 실패했습니다! 💀");
		System.out.println("          물고기가 도망갔어요… 다시 해봅시다! 🎣");
		System.out.println("════════════════════════════════════════════════");
	}

	// 찌 맞추기 실패
	public void hitFail() {
		System.out.println("════════════════════════════════════════════════");
		System.out.println("               💥 찌 맞추기 실패! 💥");
		System.out.println("         타이밍을 조금 더 정확히 맞춰보세요 🎣");
		System.out.println("════════════════════════════════════════════════");
	}

	public void getFishingSpotInfo(LinkedHashMap<String, Integer> fishChances) {
		System.out.println("════════════════════════════════════════════════");
		System.out.println("               🐠 물고기 등장 확률 🐠           ");
		System.out.println("════════════════════════════════════════════════");
		System.out.println("┌──────┬────────┐");
		System.out.println("│ Size │ Chance │");
		System.out.println("├──────┼────────┤");

		for (String size : fishChances.keySet()) {
			System.out.printf("│ %-4s │ %-6s │\n", size, fishChances.get(size) + "%");
		}
		System.out.println("└──────┴────────┘");

		System.out.println("════════════════════════════════════════════════");
		System.out.println("               🎣 낚시 확률 🎣                  ");
		System.out.println("════════════════════════════════════════════════");
		System.out.println("┌──────┬──────────┬────────┬──────────┐");
		System.out.println("│ Size │ Catch %  │ Score  │ Earned W │");
		System.out.println("├──────┼──────────┼────────┼──────────┤");
		System.out.println("│ S    │ 100%     │ 10 pts │ W1.00    │");
		System.out.println("│ M    │ 50%      │ 25 pts │ W1.20    │");
		System.out.println("│ L    │ 25%      │ 60 pts │ W1.50    │");
		System.out.println("│ Boss │ 10%      │ 500 pts│ W50.00   │");
		System.out.println("└──────┴──────────┴────────┴──────────┘");
	}

	// 상점 안내
	public void alertBuyBait() {
		System.out.println("════════════════════════════════════════════════");
		System.out.println("              🐛 미끼가 부족합니다! 🐛");
		System.out.println("          🏪 상점에 가서 미끼를 구매해주세요!");
		System.out.println("════════════════════════════════════════════════");
	}

	public boolean hit(int length) {
		boolean isHit = false;

		int barLength = 30; // 바 길이
		int targetStart = 0; // 성공 구간 시작
		int targetEnd = length; // 성공 구간 끝
		int middlePoint = barLength / 2;
		boolean forward = true;

		while (true) {
			// 바 그리기

			StringBuilder sb = new StringBuilder("═════════ Press Enter ═════════");
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
						System.out.println("════════════════════════════════════════════════");
						System.out.println("                 🐟 찌 맞추기 성공!🐟");
						isHit = true;
					} else {
						System.out.println("════════════════════════════════════════════════");
						System.out.println("               💥 찌 맞추기 실패! 💥");
						System.out.println("        타이밍을 조금 더 정확히 맞춰보세요 🎣");
						System.out.println("════════════════════════════════════════════════");
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

	public String eventStart(String[][] map, int x, int y) {
		String result = null;

		if (map[x][y].startsWith("STORE_")) {
			result = "상점";
		} else if (map[x][y].startsWith("FISH_")) {
			result = map[x][y];
		}

		return result;
	}

	public void showLoginFail() {
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                 🚫 로그인 실패 🚫");
		System.out.println("════════════════════════════════════════════════");
		System.out.println("        🔑 아이디 또는 비밀번호를 확인해주세요!");
		System.out.println("           🎣 다시 로그인 시도해보세요! 🎣");
		System.out.println("════════════════════════════════════════════════");

	}

	public void showRodList(ArrayList<RodVO> rodList) {
		for (RodVO rvo : rodList) {
			System.out.print(rvo.getRodid() + "번");
			System.out.print("\t" + rvo.getName());
			System.out.print("\t" + rvo.getPrice() + "원");
			System.out.println();
		}

	}

	public void cantBuy() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("════════════════════════════════════════════════");
		System.out.println("        사용하고 있는 낚시대는 구매하실 수 없습니다");
		System.out.println("════════════════════════════════════════════════");

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
			System.out.println("════════════════════════════════════════════════");
			System.out.println("                 ☁ 오늘의 날씨 ☁");
			System.out.println("                      맑 음");
			System.out.println("════════════════════════════════════════════════");
			System.out.println();
		} else {
			System.out.println("════════════════════════════════════════════════");
			System.out.println("                 ☀ 오늘의 날씨 ☀");
			System.out.println("                      폭 우 ");
			System.out.println("════════════════════════════════════════════════");
			System.out.println();

		}

	}

	// 낚시후 상태 보여주기
	public void showFishingStatus(MemberVO mvo) {
		System.out.println("                     현재 상태 ");
		System.out.println("           소지금 : " + mvo.getGold() + ", 점수 : " + mvo.getPoint() + ", 미끼 : " + mvo.getBait());
	}

	public void wrongInput() {
		System.out.println("════════════════════════════════════════════════");
		System.out.println("           잘못 입력하셨습니다. 다시 입력해 주세요.");
		System.out.println("════════════════════════════════════════════════");

	}

	public void saveDB() {
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                  데이터 저장 완료!");
		System.out.println("════════════════════════════════════════════════");
	}

	public void nsaveDB() {
		System.out.println("════════════════════════════════════════════════");
		System.out.println("                  데이터 저장 실패!");
		System.out.println("════════════════════════════════════════════════");
	}

}