package 프로젝트;

import java.awt.Color;

import javax.swing.JFrame;

public class ProgramFrame extends JFrame {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static String url = "https://youtube.com/embed/ILTHidJwGkA?fs=0&modestbranding=1";	// KUeq__RmAjE
	public ProgramMainPanel panel = new ProgramMainPanel();
	public Youtube youtube = new Youtube();
	public String id;

	public ProgramFrame(String id) {
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setUndecorated(true);
		setSize(WIDTH, HEIGHT);
		setBackground(new Color(0, 0, 0, 0));
		setLocationRelativeTo(null);
		setResizable(false);
		youtube.browserUI.setBounds(50, 65, 720, 405);
		panel.setBounds(0, 0, WIDTH, HEIGHT);
		add(youtube.browserUI);
		add(panel);
		setVisible(true);
	}
}
