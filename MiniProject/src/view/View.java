package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
	public int showMenu() {
		System.out.print("[1] 로그인 [2] 회원가입 [3] 종료 >>");
		int input = sc.nextInt();
		return input;
	}

	public String showMapMenu() {
		System.out.print("[w] 상 [s] 하 [a] 좌 [d] 우 [5] 상태출력 [6] 종료");
		String input = sc.next();
		return input;
	}

	public int showStoreMenu() {
		System.out.println("[1]미끼사기 [2]낚시대 구매 [3]종료 >>");
		int input = sc.nextInt();
		return input;
	}

	public int showFishingMenu() {
		System.out.print("[1]낚시하기 [2]확률보기 [3]종료 >>");
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
	public void printMap(String[][] map, int x, int y) {
		for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
            	if(map[i][j].equals("S")) {
            		System.out.print("🏪");
            	} else if(map[i][j].equals("F")) {
            		System.out.print("🎣");
            	} else if(i == x && j == y) {
            		System.out.print("🧍");
            	} else {
            		System.out.print("⬜");
            	}
                
            }
            System.out.println();
        }
	}

	//상태 출력
    public void printStatus(MemberVO mvo) {
        System.out.println("  점 수 : " + mvo.getPoint());
        System.out.println("  골 드 : " + mvo.getGold());
        System.out.println("  미 끼 : " + mvo.getBait());
        String rodName = "";
        int rodId = mvo.getRodid();
        if(rodId == 1) {
        	rodName = "대나무 낚시대";
        } else if(rodId == 2) {
        	rodName = "다이소 낚시대";
        } else if(rodId == 3) {
        	rodName = "카본 낚시대";
        } else if(rodId == 4){
        	rodName = "다이아몬드 낚시대";
        }
        System.out.println("  낚시대 : " + rodName);
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

	public void fishingSuccess(String fishSizeName) {
		System.out.println(fishSizeName + " 낚시에 성공하셨습니다.");
		
	}

	public void fishingFail(String fishSizeName) {
		System.out.println(fishSizeName + " 낚시에 실패하셨습니다.");
	}

	public void hitFail() {
		System.out.println("찌 맞추기에 실패하셨습니다.");
	}

	public void getFishingSpotInfo() {
		System.out.println("물고기 등장 확률");
		System.out.println("┌──────┬────────┐");
		System.out.println("│ Size │ Chance │");
		System.out.println("├──────┼────────┤");
		System.out.println("│ S    │ 40%    │");
		System.out.println("│ M    │ 30%    │");
		System.out.println("│ L    │ 20%    │");
		System.out.println("│ Boss │ 10%    │");
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
		
		int barLength = 30;   // 바 길이
        int targetStart = 0; // 성공 구간 시작
        int targetEnd = 0;   // 성공 구간 끝
        int middlePoint = barLength / 2;
        boolean forward = true;
        
        if(rodId == 1) {
        	targetEnd = 4;
        } else if(rodId == 2) {
        	targetEnd = 5;
        } else if(rodId == 3) {
        	targetEnd = 6;
        } else if(rodId == 4) {
        	targetEnd = 7;
        }

        while (true) {
            // 바 그리기
        	
        	StringBuilder sb = new StringBuilder("=== 엔터 입력으로 타이밍 맞추기 ===");
        	sb.append("\n");
        	for (int i = 0; i < barLength; i++) {
        	    if (i == middlePoint) sb.append("↓");
        	    else sb.append(" ");
        	}
        	sb.append("\n");
        	
            sb.append("[");
            for (int i = 0; i < barLength; i++) {
                if (i >= targetStart && i <= targetEnd) sb.append("=");
                else sb.append(" ");
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
				if (System.in.available() > 0) {  // 키 입력 대기 확인
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

	public HashMap<String, String> fishing() {
		HashMap<String, String> map = new HashMap<String, String>();
		
		Random rd = new Random();
		
		// 랜덤 값 1 ~ 10 물고기 크기 정함
		int fishSize = rd.nextInt(10) + 1;
		String fishSizeName = null;
		String isSuccess = null;
		
		// 물고기 크기 값 정함
		if(fishSize >= 1 && fishSize <= 4) {
			fishSizeName = "2짜";
		} else if(fishSize >= 5 && fishSize <= 7) {
			fishSizeName = "3짜";
		} else if(fishSize >= 8 && fishSize <= 9) {
			fishSizeName = "4짜";
		} else {
			fishSizeName = "런커";
		}
		
		map.put("물고기크기", fishSizeName);
		
		// 물고기 크기에 따른 낚을 확률 정함
		int hitRatio = 0;
		
		if(fishSizeName.equals("2짜")) {
			// 100%
			isSuccess = "success";
		} else if(fishSizeName.equals("3짜")) {
			// 50%
			hitRatio = rd.nextInt(2) + 1;
			if(hitRatio == 1) {
				isSuccess = "success";
			} else {
				isSuccess = "fail";
			}
		} else if(fishSizeName.equals("4짜")) {
			// 25%
			hitRatio = rd.nextInt(4) + 1;
			if(hitRatio == 1) {
				isSuccess = "success";
			} else {
				isSuccess = "fail";
			}
		} else {
			// 10%
			hitRatio = rd.nextInt(10) + 1;
			if(hitRatio == 1) {
				isSuccess = "success";
			} else {
				isSuccess = "fail";
			}
		}
		
		if(isSuccess.equals("success")) {
			System.out.println("\n🎉 " + isSuccess + " 낚시 성공!");
		} else {
			System.out.println("\n💀 " + isSuccess + " 낚시 실패!");
		}
		
		map.put("성공실패", isSuccess);
				
		return map;
	}

	public String eventStart(String[][]map, int x, int y) {
		String result = null;
		
		if(map[x][y].equals("S")) {
			result = "상점";
		} else if(map[x][y].equals("F")) {
			result = "낚시터";
		}
		
		return result;
	}

	public void showLoginFail() {
		System.out.println("로그인이 안되었습니다. 아이디와 비밀번호를 확인해주세요.");
		
	}

}
