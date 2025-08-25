package controller;

import java.util.ArrayList;

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
		while (true) {
			// 메뉴 출력
			int input = view.showMenu();
			if (input == 1) {
				MemberVO loginVO = dao.login(view.showLogin());
				view.statusLogin(loginVO);

				int dir = 0;

				if (dir == 0) {
					while (true) {
						int value = view.showMenu3();
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
							// [2]낚시대 구매

							int rod = view.buyRod();
							RodVO rodVO = null;

							if (rod == 1) {
								if (loginVO.getGold() > 1000) {
									// 다이소 낚시대
									loginVO.setGold(loginVO.getGold() - 1000);
									rodVO = new RodVO(2, "다이소 낚시대", 1000);
									loginVO.setRodid(rodVO.getRodid());
									view.printBuyRod(rod);
								} else {
									view.NoGold();

								}

							} else if (rod == 2) {
								if (loginVO.getGold() > 3000) {
									// 카본 낚시대
									loginVO.setGold(loginVO.getGold() - 3000);
									rodVO = new RodVO(3, "카본 낚시대", 3000);
									loginVO.setRodid(rodVO.getRodid());
									view.printBuyRod(rod);
								} else {

									view.NoGold();
								}

							} else if (rod == 3) {
								if (loginVO.getGold() > 10000) {
									// 카본 낚시대
									loginVO.setGold(loginVO.getGold() - 10000);
									rodVO = new RodVO(4, "다이아몬드 낚시대", 10000);
									loginVO.setRodid(rodVO.getRodid());
									view.printBuyRod(rod);
								} else {

									view.NoGold();
								}

								// 다이아몬드 낚시대

							} else {
								view.NoNum();
								// 번호 잘못 입력

							}

						} else if (value == 3) {

							// [3]종료

							break;
						} else {
							view.NoNum();
							;
						}
					}

				}

			} else if (input == 2) {
//				int row = dao.join(view.showJoin());
//				view.statusMenu(row, "회원가입");
				int row = dao.join(view.showJoin());
				view.showInfo(row, "회원가입"); // 성공/실패 출력(view)

			} else {
				break;
			}
		}

	}

}
