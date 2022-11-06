package 프로젝트;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginSignPanel extends JPanel {
	public String id = "";
	public String password = "";
	public String name = "";
	public String phone = "";
	private Image idImg = new ImageIcon(LoginFrame.class.getResource("../로그인회원가입화면/아이디.png")).getImage();
	private Image pwImg = new ImageIcon(LoginFrame.class.getResource("../로그인회원가입화면/암호.png")).getImage();
	private Image nameImg = new ImageIcon(LoginFrame.class.getResource("../로그인회원가입화면/성명.png")).getImage();
	private Image phoneImg = new ImageIcon(LoginFrame.class.getResource("../로그인회원가입화면/휴대폰.png")).getImage();
	private ImageIcon exitbtnImg = new ImageIcon(LoginFrame.class.getResource("../로그인화면/닫기버튼.png"));
	private ImageIcon exitbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../로그인화면/닫기버튼클릭.png"));
	private ImageIcon backbtnImg = new ImageIcon(LoginFrame.class.getResource("../로그인회원가입화면/뒤로가기버튼.png"));
	private ImageIcon backbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../로그인회원가입화면/뒤로가기버튼클릭.png"));
	private ImageIcon signupbtnImg = new ImageIcon(LoginFrame.class.getResource("../로그인화면/회원가입버튼.png"));
	private ImageIcon signupbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../로그인화면/회원가입버튼클릭.png"));
	private JButton exitbutton = new JButton(exitbtnImg);
	private JButton backbutton = new JButton(backbtnImg);
	private JButton signupbutton = new JButton(signupbtnImg);
	private JTextField idfield = new JTextField();
	private JPasswordField pwfield = new JPasswordField();
	private JTextField namefield = new JTextField();
	private JTextField phonefield = new JTextField();

	public LoginSignPanel() {
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
		
		backbutton.setBounds(150, 440, 150, 60);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorderPainted(false);
		backbutton.setFocusPainted(false);
		backbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backbutton.setIcon(backbtnImgClicked);
				backbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backbutton.setIcon(backbtnImg);
				backbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					idfield.setText("");
					pwfield.setText("");
					namefield.setText("");
					phonefield.setText("");
					LoginFrame.loginFrame.spanel.setVisible(false);
					LoginFrame.loginFrame.panel.setVisible(true);
				}
			}
		});
		
		signupbutton.setBounds(150, 520, 150, 60);
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
					id = idfield.getText();
					password = pwfield.getText();
					name = namefield.getText();
					phone = phonefield.getText();
					if(id.length()<16 && password.length()<16 && name.length()<5 && phone.length()<14) {
						new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									LoginFrame.client.signup(id, password, name, phone);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									System.out.println("회원가입 오류!");
								}
							}
						}).start();
					}else {
						if(id.length()>=16) {
							System.out.println("아이디는 최대 15글자까지 허용합니다.");
						}if(password.length()>=16) {
							System.out.println("암호는 최대 15글자까지 허용합니다.");
						}if(name.length()>=5) {
							System.out.println("이름은 최대 4글자까지 허용합니다.");
						}if(phone.length()>=14) {
							System.out.println("핸드폰번호는 010-XXXX-XXXX형식으로 입력하세요.");
						}
					}
				}
			}
		});
		
		Border border = BorderFactory.createEmptyBorder(0, 5, 0, 0);
		idfield.setFont(new Font("맑은고딕", Font.BOLD, 30));
		idfield.setBackground(new Color(255, 255, 255, 150));
		idfield.setForeground(new Color(0, 0, 0, 255));
		idfield.setBorder(border);
		pwfield.setFont(new Font("맑은고딕", Font.BOLD, 30));
		pwfield.setBackground(new Color(255, 255, 255, 150));
		pwfield.setForeground(new Color(0, 0, 0, 255));
		pwfield.setBorder(border);
		pwfield.setEchoChar('●');
		namefield.setFont(new Font("맑은고딕", Font.BOLD, 30));
		namefield.setBackground(new Color(255, 255, 255, 150));
		namefield.setForeground(new Color(0, 0, 0, 255));
		namefield.setBorder(border);
		phonefield.setFont(new Font("맑은고딕", Font.BOLD, 30));
		phonefield.setBackground(new Color(255, 255, 255, 150));
		phonefield.setForeground(new Color(0, 0, 0, 255));
		phonefield.setBorder(border);
		
		idfield.setBounds(120, 65, 295, 60);
		pwfield.setBounds(120, 163, 295, 60);
		namefield.setBounds(120, 261, 295, 60);
		phonefield.setBounds(120, 359, 295, 60);
		
		add(exitbutton);
		add(backbutton);
		add(signupbutton);
		add(idfield);
		add(pwfield);
		add(namefield);
		add(phonefield);
		
		setVisible(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(idImg, 35, 65, null);
		g.drawImage(pwImg, 35, 163, null);
		g.drawImage(nameImg, 35, 261, null);
		g.drawImage(phoneImg, 35, 359, null);
		repaint();
	}
}
