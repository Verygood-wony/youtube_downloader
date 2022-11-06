package 프로젝트;

import java.awt.Color;

import javax.swing.JFrame;

public class LoginFrame extends JFrame {
	public static LoginFrame loginFrame;
	public static ProgramFrame programFrame;
	public static final int WIDTH = 450;
	public static final int HEIGHT = 620;
	public static Client client;
	public static boolean disconnect = false;
	public LoginSignPanel spanel = new LoginSignPanel();
	public LoginPanel panel = new LoginPanel();

	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(WIDTH, HEIGHT);
		setBackground(new Color(0, 0, 0, 0));
		setLocationRelativeTo(null);
		setResizable(false);
		add(spanel);
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			client = new Client();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("클라이언트 클래스 실행 실패");
			disconnect = true;
		}
		loginFrame = new LoginFrame();
	}
}
