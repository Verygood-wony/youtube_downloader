package 프로젝트;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;

public class LoginPanel extends JPanel implements ActionListener {
	public String id = "";
	public String password = "";
	private Image backgroundImg = new ImageIcon(LoginFrame.class.getResource("../로그인화면/로그인배경.png")).getImage(); // 배경화면
	private Image logoImg = new ImageIcon(LoginFrame.class.getResource("../로그인화면/로고.png")).getImage();
	private Image titleImg = new ImageIcon(LoginFrame.class.getResource("../로그인화면/제목.png")).getImage();
	private Image disconnect = new ImageIcon(LoginFrame.class.getResource("../로그인화면/서버끊김.png")).getImage();
	private ImageIcon exitbtnImg = new ImageIcon(LoginFrame.class.getResource("../로그인화면/닫기버튼.png"));
	private ImageIcon exitbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../로그인화면/닫기버튼클릭.png"));
	private ImageIcon loginbtnImg = new ImageIcon(LoginFrame.class.getResource("../로그인화면/로그인버튼.png"));
	private ImageIcon loginbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../로그인화면/로그인버튼클릭.png"));
	private ImageIcon signupbtnImg = new ImageIcon(LoginFrame.class.getResource("../로그인화면/회원가입버튼.png"));
	private ImageIcon signupbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../로그인화면/회원가입버튼클릭.png"));
	private ImageIcon wronglogin = new ImageIcon(LoginFrame.class.getResource("../로그인화면/로그인오류.png"));
	private JButton exitbutton = new JButton(exitbtnImg);
	private JButton loginbutton = new JButton(loginbtnImg);
	private JButton signupbutton = new JButton(signupbtnImg);
	private JTextField idfield = new JTextField();
	private JPasswordField pwfield = new JPasswordField();
	private Timer timer;
	private int x = 145;
	private boolean visible = false;
	public JLabel wrong = new JLabel(wronglogin);

	public LoginPanel() {
		setSize(LoginFrame.WIDTH, LoginFrame.HEIGHT);
		setBackground(new Color(255, 255, 255, 255));
		setLayout(null);

		exitbutton.setBounds(415, 5, 30, 30);
		exitbutton.setContentAreaFilled(false);
		exitbutton.setBorderPainted(false);
		exitbutton.setFocusPainted(false);
		exitbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitbutton.setIcon(exitbtnImgClicked);
				exitbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitbutton.setIcon(exitbtnImg);
				exitbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					System.exit(0);
				}
			}
		});

		loginbutton.setBounds(150, 410, 150, 60);
		loginbutton.setContentAreaFilled(false);
		loginbutton.setBorderPainted(false);
		loginbutton.setFocusPainted(false);
		loginbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginbutton.setIcon(loginbtnImgClicked);
				loginbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginbutton.setIcon(loginbtnImg);
				loginbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					//login();
					id = idfield.getText();
					password = pwfield.getText();
					//System.out.println(id + " / " + password + " / " + password.length());
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								LoginFrame.client.login(id, password);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								System.out.println("로그인 오류!");
							}
						}
					}).start();
				}
			}
		});

		signupbutton.setBounds(150, 500, 150, 60);
		signupbutton.setContentAreaFilled(false);
		signupbutton.setBorderPainted(false);
		signupbutton.setFocusPainted(false);
		signupbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signupbutton.setIcon(signupbtnImgClicked);
				signupbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				signupbutton.setIcon(signupbtnImg);
				signupbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					//회원가입
					wrong.setVisible(false);
					idfield.setText("");
					pwfield.setText("");
					LoginFrame.loginFrame.panel.setVisible(false);
					LoginFrame.loginFrame.spanel.setVisible(true);
				}
			}
		});

		Border border = BorderFactory.createEmptyBorder(0, 5, 0, 0);
		idfield.setFont(new Font("맑은고딕", Font.BOLD, 30));
		idfield.setBackground(new Color(255, 255, 255, 150));
		idfield.setForeground(new Color(0, 0, 0, 255));
		idfield.setBorder(border);
		pwfield.setFont(new Font("맑은고딕", Font.PLAIN, 25));
		pwfield.setBackground(new Color(255, 255, 255, 150));
		pwfield.setForeground(new Color(0, 0, 0, 255));
		pwfield.setBorder(border);
		idfield.setBounds(120, 212, 295, 60);
		pwfield.setBounds(120, 310, 295, 60);
		pwfield.setEchoChar('●');

		idfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					//login();
					id = idfield.getText();
					password = pwfield.getText();
					//System.out.println(id + " / " + password + " / " + password.length());
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								LoginFrame.client.login(id, password);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								System.out.println("로그인 오류!");
							}
						}
					}).start();
				}
			}
		});

		pwfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					//login();
					id = idfield.getText();
					password = pwfield.getText();
					//System.out.println(id + " / " + password + " / " + password.length());
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								LoginFrame.client.login(id, password);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								System.out.println("로그인 오류!");
							}
						}
					}).start();
				}
			}
		});

		wrong.setBounds(0, 365, 450, 48);
		wrong.setVisible(false);

		addMouseMotionListener(new MouseAdapter() { // 창 이동
			@Override
			public void mouseDragged(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					if (e.getY() <= 100) {
						LoginFrame.loginFrame.setLocation(e.getXOnScreen() - 225, e.getYOnScreen() - 30);
					}
				}
			}
		});

		add(exitbutton);
		add(loginbutton);
		add(signupbutton);
		add(idfield);
		add(pwfield);
		add(wrong);

		timer = new Timer(5, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (x == 45) {
			timer.stop();
			visible = true;
		} else {
			x--;
		}
	}

	private void login() {
		id = idfield.getText();
		password = pwfield.getText();
		System.out.println(id + " / " + password + " / " + password.length());
		if (id.equals("admin") && password.equals("1234")) {
			LoginFrame.loginFrame.dispose();
			LoginFrame.programFrame = new ProgramFrame(id);
		} else {
			wrong.setVisible(true);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImg, 0, 0, null);
		g.drawImage(logoImg, x, 60, null);
		if(visible) {
			g.drawImage(titleImg, 180, 60, null);
		}
		if(LoginFrame.disconnect) {
			g.drawImage(disconnect, 10, 570, null);
		}
		repaint();
	}
}
