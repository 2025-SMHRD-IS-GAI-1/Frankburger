package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	// 필드 영역
	private PreparedStatement psmt = null;
	private Connection conn = null;
	ResultSet rs = null;

	private void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-cgi.smhrd.com:1524:xe";
			String user = "CGI_25IS_GA_P1_3";
			String password = "smhrd3";

			conn = DriverManager.getConnection(url, user, password);

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
	public MemberVO login(MemberVO mvo) {

		MemberVO loginVO = null;

		try {
			getConn();

			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND PW = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mvo.getMemberId());
			psmt.setString(2, mvo.getPw());

			rs = psmt.executeQuery();

			if (rs.next()) {
				// 로그인 성공 → rs에서 꺼낸 값으로 MemberVO 채우기
				loginVO = new MemberVO(rs.getString("MEMBER_ID"), rs.getString("PW"), rs.getString("NAME"),
						rs.getInt("ROD_ID"), rs.getInt("GOLD"), rs.getInt("POINT"), rs.getInt("BAIT"));
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

	// 저장 메소드
	public int save(MemberVO mvo) {

		int row = 0;

		try {
			getConn();
			String sql = "UPDATE MEMBER SET GOLD=?, POINT=?, BAIT=?, ROD_ID=? WHERE MEMBER_ID=?";

			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, mvo.getGold());
			psmt.setInt(2, mvo.getPoint());
			psmt.setInt(3, mvo.getBait());
			psmt.setInt(4, mvo.getRodid());
			psmt.setString(5, mvo.getMemberId());

			row = psmt.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return row;

	}

	// 낚시대 전체 조회
	public ArrayList<RodVO> getRodList() {
		ArrayList<RodVO> list = new ArrayList<>();
		try {
			getConn();

			String sql = "SELECT ROD_ID, NAME, PRICE FROM ROD";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				// RodVO는 생성자 값 아무거나 넣고, set으로 채움
				RodVO rvo = new RodVO(0, "", 0);
				rvo.setRodid(rs.getInt("ROD_ID"));
				rvo.setName(rs.getString("NAME"));
				rvo.setPrice(rs.getInt("PRICE"));
				list.add(rvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return list;
	}

	//
	public RodVO selectByRodId(MemberVO mvo) {
		RodVO rvo = new RodVO();

		try {
			getConn();

			String sql = "SELECT R.NAME FROM MEMBER M INNER JOIN ROD R " + "ON(M.ROD_ID = R.ROD_ID) "
					+ "WHERE M.MEMBER_ID = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mvo.getMemberId());

			rs = psmt.executeQuery();

			if (rs.next()) {

				rvo.setName(rs.getString("NAME"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return rvo;
	}

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

}