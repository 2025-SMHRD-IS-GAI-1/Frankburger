# 내일은 배스왕!!🎣
>낚시 게임 프로그램  

</br>
## 1. 제작 기간 & 참여 인원
- 2025년 08월 22일 ~ 08월 27일
- 미니 프로젝트

</br>

## 2. 사용 기술
#### `Back-end`
  - Java 11
  - Oracle
  - JDBC

</br>

## 3. ERD 설계
<img width="817" height="344" alt="Image" src="https://github.com/user-attachments/assets/2d9a6074-03f7-41a2-b123-7fc32ee816c9" />


## 4. 핵심 기능
이 게임의 핵심 기능은 콘솔에서 낚시를 할 수 있는 기능입니다. 
사용자는 맵 안에서 상하좌우로 움직일 수 있고 낚시터에 들어가면 타이밍에 맞게 찌를 맞추는 기능으로 
실제 낚시를 하는 느낌을 구현했으며, 상점도 이용할 수 있습니다.

<details>
<summary><b>핵심 기능 설명 펼치기</b></summary>
<div markdown="1">

### 4.1. 전체 흐름
<img width="1247" height="771" alt="Image" src="https://github.com/user-attachments/assets/e08e300e-f566-4a58-b8fc-fc57ae277836" />

### 4.2. 사용자 요청
<img width="916" height="589" alt="Image" src="https://github.com/user-attachments/assets/fad2e0da-24c3-453d-bad0-869f2feec613" />

### 4.3. Controller

<img width="631" height="670" alt="Image" src="https://github.com/user-attachments/assets/b6d8913d-c9f0-497b-8adb-32da8b151cfa" />

- **요청 처리** 
  - Controller에서는 View와 Dao에서 입출력을 받아와서 기능을 구현한다.

- **결과 응답** 
  - Dao를 통해 DB에 업데이트 합니다.
  - View에서 결과를 출력합니다.

### 4.4. View
<img width="823" height="551" alt="Image" src="https://github.com/user-attachments/assets/533f8fef-f145-4b4b-aceb-9b42bbabaa3d" />

- **요청 처리** 
  - View에서는 입출력을 처리합니다.

- **결과 응답** 
  - Controller에 데이터를 넘겨주기도 하고 로직 처리 후 콘솔에 출력한다.

### 4.5. DAO
<img width="789" height="498" alt="Image" src="https://github.com/user-attachments/assets/1af5a524-b0ad-4933-ad2f-fb5735b253b7" />

- **요청 처리** 
  - DB와 연결을 담당하는 기능

- **결과 응답** 
  - DB를 업데이트, 조회합니다.

</div>
</details>

</br>

## 5. 핵심 트러블 슈팅
### 5.1. JDBC update시 commit 안되는 오류
- 아래 **기존 코드**를 실행했을 떄 psmt.executeUpdate(); 실행후 안넘어가는 오류가 발생했었습니다.
- Chat GPT와 블로그 서칭을 통해 Oracle에서는 update 시 auto commit이 안된다는 것을 인지하였다.
<details>
<summary><b>기존 코드</b></summary>
<div markdown="1">

~~~java
/**
 * psmt.executeUpdate(); 실행 후 안넘어감
 */
// 엔딩시 골드, 미끼수 초기화
	public void initialPoint(MemberVO mvo) {

		try {
			getConn();

			String sql = "UPDATE MEMBER SET GOLD = 0, BAIT = 10 WHERE MEMBER_ID = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, mvo.getMemberId());

			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			getClose();
		}

	}
~~~

</div>
</details>

- Oracle에서는 update 시 auto commit이 안되므로 에러가 나왔다.
- 커밋을 시켜주기 위해 conn.commit();을 추가하였고 SQLDEVELOPER에 들어가서 commit을 하니 정상적으로 작동되었다.

<details>
<summary><b>개선된 코드</b></summary>
<div markdown="1">

~~~java

// 엔딩시 골드, 미끼수 초기화
	public void initialPoint(MemberVO mvo) {

		try {
			getConn();

			String sql = "UPDATE MEMBER SET GOLD = 0, BAIT = 10 WHERE MEMBER_ID = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, mvo.getMemberId());

			psmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			getClose();
		}

	}
~~~

</div>
</details>

</br>

## 6. 그 외 트러블 슈팅
<details>
<summary>문자열 입력 시 오류</summary>
<div markdown="1">

- int로 받아서 리턴하는 변수에 문자열을 입력했을 때 Exception 발생
- int -> String으로 바꿔줌

</div>
</details>

<details>
<summary>Git 충돌 오류</summary>
<div markdown="1">
  
  - pull 받을 때 내 로컬 파일이랑 다르면 충돌 오류남
  - push 후 공유를 한명씩 확인하며 충돌 방지
  
</div>
</details>




    
</br>

## 6. 회고 / 느낀점
>프로젝트 개발 회고 글: [https://zuminternet.github.io/ZUM-Pilot-integer/](https://www.notion.so/sdtunit032526/6-KPT-256ae0eec9558112bb09c5aec09f1909)
