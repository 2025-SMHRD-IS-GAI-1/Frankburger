package Main;



import controller.Controller;
import model.DAO;
import view.View;

// 실행만 하는 역할
public class Main {

	public static void main(String[] args) {		
		new Controller(new View(), new DAO()).run();
	}

}
