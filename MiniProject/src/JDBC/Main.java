package JDBC;



import controller.Controller;
import model.DAO;
import view.View;

// 실행만 하는 역할
public class Main {

	public static void main(String[] args) {
		
//		DAO dao = new DAO();
//		MemberView view = new MemberView(); 
//		
//		
//		// 동작을 시키기 위해서 컨트롤러를 생성
//		MemberController controller = new MemberController(view, dao);
//		controller.run();
		
		new Controller(new View(), new DAO()).run();
	}

}
