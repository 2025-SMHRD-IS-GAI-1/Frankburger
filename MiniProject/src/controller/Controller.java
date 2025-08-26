package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

	// [1] 로그인 [2] 회원가입 [3] 종료
	// [1]- [1] 상 [2] 하 [3] 좌 [4] 우 [5] 상태출력 [6] 종료
	// [1]- [1]~[4]
	// 맵 출력
	// 상점 만남 : [1]미끼사기 [2]낚시대 구매 [3]종료 >>
	// 보유금액 : ???원
	// [1]- [2]-
	// 1. 대나무낚시대 : 1000원
	// 2. ? 낚시대 : 10000원
	// 입력 >>
	// 낚시터 만남 : [1]낚시하기 [2] 확률보기 [3]종료
	// [1]- [5]-
	// 미끼 : 10개 , 포인트 : 10점, 보유금액 : 100원, 낚시대 : 대나무낚시대
	public void run() {
		
		String[][] map = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "F", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "S", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        };
		
		int x = 4;
		int y = 4;
		
		// 임시 입력 지워야 함
		Scanner sc = new Scanner(System.in);
		while (true) {
			// 메뉴 출력
			int input = view.showMenu();
			if (input == 1) {
				MemberVO loginVO = dao.login(view.showLogin());
				if (loginVO != null) {
					view.statusLogin(loginVO);

					while (true) {
						// 1. 뷰에게 현재 맵 상태를 출력하라고 요청
						view.printMap(map, x, y);

						int nowX = x;
						int nowY = y;

						String dir = view.showMapMenu();

						if (dir.equals("w")) {
							x--;
						} else if (dir.equals("s")) {
							x++;
						} else if (dir.equals("a")) {
							y--;
						} else if (dir.equals("d")) {
							y++;
						} else if (dir.equals("5")) {
							view.printStatus(loginVO);
						} else {
							break;
						}

						String event = view.eventStart(map, x, y);

						if (event != null) {
							if (event.equals("상점")) {
								while (true) { view.printStatus(loginVO);
								int value = view.showStoreMenu();
								
								if (value == 1) {
									// 미끼 사는거

									int count = view.buybait();

									if (loginVO.getGold() - (25 * count) >= 0) {
										loginVO.setBait(loginVO.getBait() + count);
										loginVO.setGold(loginVO.getGold() - (25 * count));
										view.bye(count);
									} else {
										view.NoGold();
									}

								} else if (value == 2) {
									// [2]낚시대 구매*****25일 6시23분
									view.showRodList(dao.getRodList());
									int rod = view.buyRod();
									RodVO rodVO = null;
									//// 여기
									if(rod ==1) { 
										//대나무 낚시대
										if(loginVO.getRodid() == 1) {
											view.cantBuy();
										}
											
										else {rodVO = new RodVO(1, "대나무 낚시대", 0);
										loginVO.setRodid(rodVO.getRodid());
										view.printBuyRod(rod);}
									}
									
									
									
									else if (rod == 2) {

										if(loginVO.getRodid() == 2) {
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
										if(loginVO.getRodid() == 3) {
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
									
										if(loginVO.getRodid() == 4) {
											view.cantBuy();
										}
										else if (loginVO.getGold() > 10000) {
											// 다이아몬드 낚시대
											loginVO.setGold(loginVO.getGold() - 10000);
											rodVO = new RodVO(4, "다이아몬드 낚시대", 10000);
											loginVO.setRodid(rodVO.getRodid());
											view.printBuyRod(rod);
										} else {

											view.NoGold();
										}

										

									} else {
										view.NoNum();
										// 번호 잘못 입력

									}

									} else if (value == 3) {

										// [3]종료
										x = nowX;
										y = nowY;
										break;
									} else {
										view.NoNum();
									}
								}
							} else if (event.equals("낚시터")) {
								while (true) {
									int menu4 = view.showFishingMenu();
									if (menu4 == 1) {
										// 낚시하기

										// 남은 미끼가 있는지 판단
										if (loginVO.getBait() <= 0) {
											view.alertBuyBait();
											continue;
										}

										boolean isHit = view.hit(loginVO);
										if (isHit) {
											HashMap<String, String> hm = view.fishing();

											String fishSizeName = hm.get("물고기크기");
											String isSuccess = hm.get("성공실패");
											int gold = 0;
											int point = 0;

											if (isSuccess.equals("success")) {
												if (fishSizeName.equals("2짜")) {
													gold = 100;
													point = 10;

												} else if (fishSizeName.equals("3짜")) {
													gold = 120;
													point = 25;
												} else if (fishSizeName.equals("4짜")) {
													gold = 150;
													point = 60;
												} else {
													gold = 5000;
													point = 500;
												}
												view.fishingSuccess(fishSizeName);
												loginVO.setGold(loginVO.getGold() + gold);
												loginVO.setPoint(loginVO.getPoint() + point);
												loginVO.setBait(loginVO.getBait() - 1);
											} else {
												loginVO.setBait(loginVO.getBait() - 1);
												view.fishingFail(fishSizeName);
											}
											System.out.println("gold = " + loginVO.getGold() + ", point = "
													+ loginVO.getPoint() + ", vait = " + loginVO.getBait());
										} else {
											view.hitFail();
											loginVO.setBait(loginVO.getBait() - 1);
										}
									} else if (menu4 == 2) {
										// 낚시터 확률보기
										view.getFishingSpotInfo();
									} else {
										x = nowX;
										y = nowY;
										break;
									}
									
									int finishPoint = loginVO.getPoint();
									
									if(finishPoint >= 100) {
									    dao.initialPoint(loginVO);
									    view.showEnding();
									    return;   // run() 메서드 종료 → 자연스럽게 프로그램 종료
									}
									
								}
							}
						}

					}
				} else {
					view.showLoginFail();
				}

			} else if (input == 2) {
				int row = dao.join(view.showJoin());
				view.showInfo(row, "회원가입"); // 성공/실패 출력(view)

			} else {
				break;
			}
		}

	}

}