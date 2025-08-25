package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	// Model 역할

	// 필드 영역(메서드에서 공통으로 사용하는 객체를 필드로 빼줌)
	private PreparedStatement psmt = null;
	private Connection conn = null;
	ResultSet rs = null;

	// 메서드 영역
	// 드라이버 동적로딩 ~ DB연결을 getConn()이라는 하나의 메서드로 처리
	private void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_3";
			String password = "smhrd3";

			conn = DriverManager.getConnection(url, user, password);
			// conn : Java와 DB 사이의 통로를 열어줌

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 자원 반납하는 메서드
	private void getClose() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 1. 로그인 메서드 생성
	// 매개변수를 VO 자체로 넣어버리면 일일이 집어넣을 필요 x
	public MemberVO login(MemberVO mvo) {
		// 로그인 한 사용자의 비밀번호를 뺀 나머지 모든 정보 리턴
		MemberVO loginVO = null;

		try {
			getConn();

			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND PW = ?";

			psmt = conn.prepareStatement(sql);
			// psmt : sql문을 담아서 DB에 보내줌

			// ? 인자 채워주기
			psmt.setString(1, mvo.getMemberId());
			psmt.setString(2, mvo.getPw());

			rs = psmt.executeQuery();

			if (rs.next()) {
			    // 로그인 성공 → rs에서 꺼낸 값으로 MemberVO 채우기
			    loginVO = new MemberVO(
			        rs.getString("MEMBER_ID"),
			        rs.getString("PW"),
			        rs.getString("NAME"),
			        rs.getInt("ROD_ID"),
			        rs.getInt("GOLD"),
			        rs.getInt("POINT"),
			        rs.getInt("BAIT"),
			        0,
			        0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return loginVO;
	}

	// 회원가입 메소드
	public int join(MemberVO mvo) {

		int row = 0;

		try {
			getConn();

			String sql = "INSERT INTO MEMBER(MEMBER_ID, PW, NAME) VALUES(?, ?, ?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, mvo.getMemberId());
			psmt.setString(2, mvo.getPw());
			psmt.setString(3, mvo.getName());

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			getClose();
		}
		return row;
	}

	// 낚시대 전체 조회
	public ArrayList<RodVO> getRodList() {
		return null;
	}

}
