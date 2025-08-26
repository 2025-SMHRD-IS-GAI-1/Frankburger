package controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Map.Entry;

import model.DAO;
import model.MemberVO;
import model.RodVO;
import view.View;

public class Controller {
	// Controller 담당 : 전체적인 흐름, 로직 제어

	// 1. 필드
	private View view;
	private DAO dao;

	// 2. 메서드
	// 컨트롤러가 생성되는 순간에 MemberView와 dao를 초기화하는 생성자 메서드
	public Controller(View view, DAO dao) {
		this.view = view;
		this.dao = dao;
	}

	public void run() {

		while (true) {
			// 메뉴 출력
			String menu = view.showMenu();

			if (menu.equals("1")) {
				handleLogin();
			} else if (menu.equals("2")) {
				int row = dao.join(view.showJoin());
				view.showInfo(row, "회원가입"); // 성공/실패 출력(view)
			} else if (menu.equals("3")) {
				break;
			} else {
				view.wrongInput();
			}

		}

	}

	private void handleLogin() {
		MemberVO loginVO = dao.login(view.showLogin());
		if (loginVO != null) {
			view.statusLogin(loginVO);
			startGame(loginVO);
		} else {
			view.showLoginFail();
		}
	}

	private void startGame(MemberVO loginVO) {

		String[][] map = { { " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", "FISH_1", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", "FISH_2", " ", " ", " ", "STORE_1", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", "FISH_3", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " ", " ", " ", " " }, };

		int x = 4;
		int y = 4;
		Random rd = new Random();

		while (true) {
			// 1. 뷰에게 현재 맵 상태를 출력하라고 요청
			view.printMap(map, x, y);

			int nextX = x;
			int nextY = y;

			String dir = view.showMapMenu();

			// 경계 체크
			if (dir.equals("w")) {
				nextX--;
			} else if (dir.equals("s")) {
				nextX++;
			} else if (dir.equals("a")) {
				nextY--;
			} else if (dir.equals("d")) {
				nextY++;
			} else if (dir.equals("1")) { // 상태출력
				view.printStatus(loginVO);
			} else if (dir.equals("2")) { // 저장
				int v = dao.save(loginVO);
				if(v == 1) {
					view.saveDB();
				} else {
					view.nsaveDB();
				}
				continue;
			} else if (dir.equals("3")) { // 게임 종료 선택
				String exitMenu = view.RealQuitMsg(); // 메시지 출력

				if (exitMenu.equals("1")) { // 종료
					view.Real();
					break;
				} else if (exitMenu.equals("2")) { // 취소

				} else {
					view.wrongInput(); // 잘못 입력 시 메시지
				}

				continue; // ← 중요! 아래 else(NoNum)로 안 내려가게
			}

			if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) {
				System.out.println("맵을 넘어가면 안됩니다.");
				continue;

			}

			String event = view.eventStart(map, nextX, nextY);

			if (event != null) {
				if (event.equals("상점")) {
					handleStore(loginVO);
				} else if (event.startsWith("FISH_")) {
					handleFishing(loginVO, event, rd);
				}
			} else {
				x = nextX;
				y = nextY;
			}

		}
	}

	private void handleStore(MemberVO loginVO) {
		while (true) {
			view.printStatus(loginVO);
			String storeMenu = view.showStoreMenu();
			if (storeMenu.equals("1")) {
				// 미끼 사는거
				butBait(loginVO);
			} else if (storeMenu.equals("2")) {
				// [2]낚시대 구매
				buyRod(loginVO);
			} else if (storeMenu.equals("3")) {
				break;
			} else {
				view.wrongInput();
			}
		}
	}

	private void butBait(MemberVO loginVO) {
		int count = view.buybait();

		if (loginVO.getGold() - (25 * count) >= 0) {
			loginVO.setBait(loginVO.getBait() + count);
			loginVO.setGold(loginVO.getGold() - (25 * count));
			view.bye(count);
		} else {
			view.NoGold();
		}
	}

	private void buyRod(MemberVO loginVO) {
		view.showRodList(dao.getRodList());
		int rod = view.buyRod();
		RodVO rodVO = null;
		if (rod == 1) {
			// 대나무 낚시대
			if (loginVO.getRodid() == 1) {
				view.cantBuy();
			}

			else {
				rodVO = new RodVO(1, "대나무 낚시대", 0);
				loginVO.setRodid(rodVO.getRodid());
				view.printBuyRod(rod);
			}
		}

		else if (rod == 2) {

			if (loginVO.getRodid() == 2) {
				view.cantBuy();
			}

			else if (loginVO.getGold() > 1000) {
				// 다이소 낚시대
				loginVO.setGold(loginVO.getGold() - 1000);
				rodVO = new RodVO(2, "다이소 낚시대", 1000);
				loginVO.setRodid(rodVO.getRodid());
				view.printBuyRod(rod);
			} else {
				view.NoGold();

			}

		} else if (rod == 3) {
			if (loginVO.getRodid() == 3) {
				view.cantBuy();
			}

			else if (loginVO.getGold() > 3000) {
				// 카본 낚시대
				loginVO.setGold(loginVO.getGold() - 3000);
				rodVO = new RodVO(3, "카본 낚시대", 3000);
				loginVO.setRodid(rodVO.getRodid());
				view.printBuyRod(rod);
			} else {

				view.NoGold();
			}

		} else if (rod == 4) {

			if (loginVO.getRodid() == 4) {
				view.cantBuy();
			} else if (loginVO.getGold() > 10000) {
				// 다이아몬드 낚시대
				loginVO.setGold(loginVO.getGold() - 10000);
				rodVO = new RodVO(4, "다이아몬드 낚시대", 10000);
				loginVO.setRodid(rodVO.getRodid());
				view.printBuyRod(rod);
			} else {

				view.NoGold();
			}

		} else {
			// 번호 잘못 입력
			view.wrongInput();
		}

		// 미끼수가 0 이고 gold가 25보다 적을때 배드엔딩
		isBadEnding(loginVO);

	}

	private void handleFishing(MemberVO loginVO, String event, Random rd) {
		while (true) {

			LinkedHashMap<String, Integer> fishChances = setFishChances(event);

			// 1 ~ 2
			int weather = rd.nextInt(2) + 1;

			view.showWeather(weather);

			String fishingMenu = view.showFishingMenu();
			if (fishingMenu.equals("1")) {
				// 낚시하기
				doHit(loginVO, fishChances, weather);

			} else if (fishingMenu.equals("2")) {
				// 낚시터 확률보기
				view.getFishingSpotInfo(fishChances);
			} else {
				break;
			}

			int finishPoint = loginVO.getPoint();

			// 2000점 이상이면 굿엔딩
			if (finishPoint >= 2000) {
				dao.initialPoint(loginVO);
				view.showGoodEnding();
				System.exit(0); // run() 메서드 종료 → 자연스럽게 프로그램 종료
			}

			// 미끼수가 0 이고 gold가 25보다 적을때 배드엔딩
			isBadEnding(loginVO);
		}
	}
	
	private void isBadEnding(MemberVO loginVO) {
		int bait = loginVO.getBait();
		int gold = loginVO.getGold();

		if (bait == 0 && gold < 25) {
			dao.initialPoint(loginVO);
			view.showBadEnding();
			System.exit(0);
		}
	}

	private LinkedHashMap<String, Integer> setFishChances(String event) {
		LinkedHashMap<String, Integer> fishChances = new LinkedHashMap<String, Integer>();

		int SChance = 0;
		int MChance = 0;
		int LChance = 0;
		int BossChance = 0;

		event = event.replace("FISH_", "");

		if (event.equals("1")) {
			SChance = 40;
			MChance = 30;
			LChance = 20;
			BossChance = 10;
		} else if (event.equals("2")) {
			BossChance = 20;
		} else if (event.equals("3")) {
			MChance = 40;
			LChance = 40;
		}

		fishChances.put("S", SChance);
		fishChances.put("M", MChance);
		fishChances.put("L", LChance);
		fishChances.put("Boss", BossChance);

		return fishChances;
	}
	
	private void doHit(MemberVO loginVO, LinkedHashMap<String, Integer> fishChances, int weather) {
		// 남은 미끼가 있는지 판단
		if (loginVO.getBait() <= 0) {
			view.alertBuyBait();
			return;
		}
		
		int rodId = loginVO.getRodid();
		int length = 4;
		
		if (rodId == 1) {
			length = 4;
		} else if (rodId == 2) {
			length = 5;
		} else if (rodId == 3) {
			length = 6;
		} else if (rodId == 4) {
			length = 15;
		}

		boolean isHit = view.hit(length);
		
		if (isHit) {
			doFishing(loginVO, fishChances, weather);
		} else {
			view.hitFail();
			loginVO.setBait(loginVO.getBait() - 1);
		}
		
	}

	private void doFishing(MemberVO loginVO, LinkedHashMap<String, Integer> fishChances, int weather) {
		Random rd = new Random();

		int SChance = fishChances.get("S");
		int MChance = fishChances.get("M");
		int LChance = fishChances.get("L");
		int BossChance = fishChances.get("Boss");
		String isSuccess = "fail";

		// 1 ~ 100 사이 랜덤 뽑기
		int rand = rd.nextInt(100) + 1;

		String fishSizeName = "꽝!";
		int cumulative = 0;

		for (Entry<String, Integer> entry : fishChances.entrySet()) {
			cumulative += entry.getValue();
			if (rand <= cumulative) {
				fishSizeName = entry.getKey();
				break;
			}
		}
		
		// 기본 확률표 (맑은 날 기준)
		HashMap<String, Integer> baseProb = new HashMap<>();
		baseProb.put("S", 100);
		baseProb.put("M", 50);
		baseProb.put("L", 25);
		baseProb.put("Boss", 10);

		// 날씨에 따라 확률 조정
		double weatherFactor = (weather == 1) ? 1.0 : 0.8; // 맑음=1.0, 폭우=0.8

		if (!fishSizeName.equals("꽝!")) {
			Integer chance = baseProb.get(fishSizeName);

			if (chance != null) {
				int adjustedChance = (int) Math.round(chance * weatherFactor);
				int roll = rd.nextInt(100) + 1; // 1~100
				if (roll <= adjustedChance) {
					isSuccess = "success";
				}
			}
		}
		
		int gold = 0;
		int point = 0;

		if (isSuccess.equals("success")) {
			if (fishSizeName.equals("S")) {
				gold = 100;
				point = 10;

			} else if (fishSizeName.equals("M")) {
				gold = 120;
				point = 25;
			} else if (fishSizeName.equals("L")) {
				gold = 150;
				point = 60;
			} else {
				gold = 5000;
				point = 500;
			}
			loginVO.setGold(loginVO.getGold() + gold);
			loginVO.setPoint(loginVO.getPoint() + point);
			loginVO.setBait(loginVO.getBait() - 1);
			view.fishingSuccess(fishSizeName);
		} else {
			loginVO.setBait(loginVO.getBait() - 1);
			view.fishingFail(fishSizeName);
		}
		view.showFishingStatus(loginVO);
		
	}

}
