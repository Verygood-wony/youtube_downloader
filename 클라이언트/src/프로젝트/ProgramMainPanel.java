package ������Ʈ;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.cef.CefApp;

public class ProgramMainPanel extends JPanel implements ActionListener {
	public JTextField urlfield;
	public ChangeURL changeurl = new ChangeURL(ProgramFrame.url);
	public CautionPanel cp = new CautionPanel();
	public String url;
	public JTable table;
	public int i = 1;;
	public Image backgroundImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/���.png")).getImage(); // ���ȭ��
	private Image titlebar = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/����ǥ����.png")).getImage(); // ���ǥ����
	private Image title = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/����.png")).getImage();
	private Image rgbbar = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/RGB��.png")).getImage(); // �Ʒ� RGB��
	private Image browserLoading = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�������ε�.png")).getImage(); // ������ �ε�
	private ImageIcon exitbtnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�ݱ��ư.png")); // �����ư�̹���
	private ImageIcon exitbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�ݱ��ưŬ��.png")); // �����ưŬ���̹���
	private ImageIcon minibtnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�ּ�ȭ��ư.png")); // �ּ�ȭ��ư�̹���
	private ImageIcon minibtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�ּ�ȭ��ưŬ��.png")); // �ּ�ȭ��ưŬ���̹���
	private ImageIcon urlbtnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/url�̵�.png")); // �������̵���ư�̹���
	private ImageIcon urlbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/url�̵�Ŭ��.png")); // �������̵���ưŬ���̹���
	private ImageIcon mp3btnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/mp3�ٿ�ε�.png")); // mp3�ٿ��ư�̹���
	private ImageIcon mp3btnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/mp3�ٿ�ε�Ŭ��.png")); // mp3�ٿ��ưŬ���̹���
	private ImageIcon mp4btnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/mp4�ٿ�ε�.png")); // mp4�ٿ��ư�̹���
	private ImageIcon mp4btnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/mp4�ٿ�ε�Ŭ��.png")); // mp4�ٿ��ưŬ���̹���
	private ImageIcon youtubebtnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/��Ʃ���̵�.png")); // ��Ʃ���̵���ưŬ���̹���
	private ImageIcon youtubebtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/��Ʃ���̵�Ŭ��.png")); // ��Ʃ���̵���ưŬ���̹���
	private ImageIcon modifybtnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/��������Ʈ�̵�.png")); // ��������Ʈ�̵���ưŬ���̹���
	private ImageIcon modifybtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/��������Ʈ�̵�Ŭ��.png")); // ��������Ʈ�̵���ưŬ���̹���
	private ImageIcon folderbtnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/��������.png")); // ���������ưŬ���̹���
	private ImageIcon folderbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/��������Ŭ��.png")); // ���������ưŬ���̹���
	private ImageIcon naverbtnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/���̹�Ŭ���忭��.png")); // ���̹�Ŭ���忭���ưŬ���̹���
	private ImageIcon naverbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/���̹�Ŭ���忭��Ŭ��.png")); // ���̹�Ŭ���忭���ưŬ���̹���
	private ImageIcon googlebtnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/����Ŭ���忭��.png")); // ����Ŭ���忭���ưŬ���̹���
	private ImageIcon googlebtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/����Ŭ���忭��Ŭ��.png")); // ����Ŭ���忭���ưŬ���̹���
	private ImageIcon mp3listbtnImg_no = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/���Ǹ���Ʈ.png")); // ���Ǹ���Ʈ��ưŬ���̹���
	private ImageIcon mp3listbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/���Ǹ���ƮŬ��.png")); // ���Ǹ���Ʈ��ưŬ���̹���
	private ImageIcon mp4listbtnImg_no = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�����󸮽�Ʈ.png")); // �����󸮽�Ʈ��ưŬ���̹���
	private ImageIcon mp4listbtnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�����󸮽�ƮŬ��.png")); // �����󸮽�Ʈ��ưŬ���̹���
	private ImageIcon rbrnImg = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/��õ������.png")); // ��õ�������ư�̹���
	private ImageIcon rbrnImgClicked = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/��õ������Ŭ��.png")); // ��õ�������ưŬ���̹���
	private JButton exitbutton = new JButton(exitbtnImg);
	private JButton minibutton = new JButton(minibtnImg);
	private JButton urlbutton = new JButton(urlbtnImg);
	private JButton mp3downloadbutton = new JButton(mp3btnImg);
	private JButton mp4downloadbutton = new JButton(mp4btnImg);
	private JButton youtubebutton = new JButton(youtubebtnImg);
	private JButton modifybutton = new JButton(modifybtnImg);
	private JButton folderbutton = new JButton(folderbtnImg);
	private JButton naverbutton = new JButton(naverbtnImg);
	private JButton googlebutton = new JButton(googlebtnImg);
	private JButton mp3listbutton = new JButton(mp3listbtnImgClicked);
	private JButton mp4listbutton = new JButton(mp4listbtnImg_no);
	private JButton recommendbutton = new JButton(rbrnImg);
	private JTableHeader hd;
	private JScrollPane sp;
	private Timer timer;
	private Color color;
	private YoutubeDownload download = new YoutubeDownload();
	private int count = 1, r = 18, g = 155, b = 235; // 198 100 255
	private boolean t = true;
	public boolean bool = true, visible = false, downloaded = true, donwload_start = false;

	public ProgramMainPanel() {
		setBackground(new Color(255, 255, 255, 255));
		setLayout(null);

		exitbutton.setBounds(1255, 0, 24, 24);
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
					CefApp.getInstance().dispose();
					LoginFrame.programFrame.setState(ProgramFrame.EXIT_ON_CLOSE);
					System.exit(0);
				}
			}
		});

		minibutton.setBounds(1225, 0, 24, 24);
		minibutton.setContentAreaFilled(false);
		minibutton.setBorderPainted(false);
		minibutton.setFocusPainted(false);
		minibutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minibutton.setIcon(minibtnImgClicked);
				minibutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				minibutton.setIcon(minibtnImg);
				minibutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					LoginFrame.programFrame.setState(ProgramFrame.ICONIFIED);
				}
			}
		});

		urlfield = new JTextField("Youtube ������ URL�� �Է����ּ���.");
		urlfield.setBounds(50, 513, 660, 25);
		/*
		 * �ؽ�Ʈ �ʵ� ���� �� 0, �� 10, �Ʒ� 0, �� 10
		 */
		Border border = BorderFactory.createEmptyBorder(0, 5, 0, 0);
		urlfield.setFont(new Font("�������", Font.PLAIN, 13));
		urlfield.setBorder(border);
		urlfield.setBackground(new Color(18, 115, 235, 255));
		urlfield.setForeground(new Color(255, 255, 255));
		urlfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					url = urlfield.getText();
					changeurl = new ChangeURL(url);
					changeurl.changeURL(url);
					if(ProgramFrame.url.equals("blank")) {
						LoginFrame.programFrame.youtube.browser.loadURL("https://youtube.com/embed/ILTHidJwGkA?fs=0&modestbranding=1");
					}else {
						LoginFrame.programFrame.youtube.browser.loadURL(ProgramFrame.url);
						//ProgramFrame.runYoutube();
					}
				}
			}
		});
		urlfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					urlfield.setText("");
				}
			}
		});
		urlfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!LoginFrame.programFrame.youtube.browserFocus) {
                	return;
                }
                LoginFrame.programFrame.youtube.browserFocus = false;
                KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
                urlfield.requestFocus();
            }
        });

		urlbutton.setBounds(720, 500, 50, 50);
		urlbutton.setContentAreaFilled(false);
		urlbutton.setBorderPainted(false);
		urlbutton.setFocusPainted(false);
		urlbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				urlbutton.setIcon(urlbtnImgClicked);
				urlbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				urlbutton.setIcon(urlbtnImg);
				urlbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					url = urlfield.getText();
					changeurl = new ChangeURL(url);
					changeurl.changeURL(url);
					if(ProgramFrame.url.equals("blank")) {
						LoginFrame.programFrame.youtube.browser.loadURL("https://youtube.com/embed/ILTHidJwGkA?fs=0&modestbranding=1");
					}else {
						LoginFrame.programFrame.youtube.browser.loadURL(ProgramFrame.url);
						//ProgramFrame.runYoutube();
					}
				}
			}
		});

		mp3downloadbutton.setBounds(50, 580, 355, 100);
		mp3downloadbutton.setContentAreaFilled(false);
		mp3downloadbutton.setBorderPainted(false);
		mp3downloadbutton.setFocusPainted(false);
		mp3downloadbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mp3downloadbutton.setIcon(mp3btnImgClicked);
				mp3downloadbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mp3downloadbutton.setIcon(mp3btnImg);
				mp3downloadbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					cp.p = 0;
					new Thread(new Runnable() {
						@Override
						public void run() {
							download.download(ProgramFrame.url, true);
						}
					}).start();
				}
			}
		});

		mp4downloadbutton.setBounds(415, 580, 355, 100);
		mp4downloadbutton.setContentAreaFilled(false);
		mp4downloadbutton.setBorderPainted(false);
		mp4downloadbutton.setFocusPainted(false);
		mp4downloadbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mp4downloadbutton.setIcon(mp4btnImgClicked);
				mp4downloadbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mp4downloadbutton.setIcon(mp4btnImg);
				mp4downloadbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					cp.p = 0;
					new Thread(new Runnable() {
						@Override
						public void run() {
							download.download(ProgramFrame.url, false);
						}
					}).start();
				}
			}
		});
		
		youtubebutton.setBounds(820, 65, 200, 70);
		youtubebutton.setContentAreaFilled(false);
		youtubebutton.setBorderPainted(false);
		youtubebutton.setFocusPainted(false);
		youtubebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				youtubebutton.setIcon(youtubebtnImgClicked);
				youtubebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				youtubebutton.setIcon(youtubebtnImg);
				youtubebutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					try {
						Desktop.getDesktop().browse(new URI("https://www.youtube.com"));
					} catch (IOException ioe) {
						ioe.printStackTrace();
					} catch (URISyntaxException ue) {
						ue.printStackTrace();
					}
				}
			}
		});
		
		modifybutton.setBounds(1030, 65, 200, 70);
		modifybutton.setContentAreaFilled(false);
		modifybutton.setBorderPainted(false);
		modifybutton.setFocusPainted(false);
		modifybutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				modifybutton.setIcon(modifybtnImgClicked);
				modifybutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				modifybutton.setIcon(modifybtnImg);
				modifybutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					try {
						Desktop.getDesktop().browse(new URI("https://mp3cut.net/#"));
					} catch (IOException ioe) {
						ioe.printStackTrace();
					} catch (URISyntaxException ue) {
						ue.printStackTrace();
					}
				}
			}
		});
		
		folderbutton.setBounds(820, 145, 130, 70);
		folderbutton.setContentAreaFilled(false);
		folderbutton.setBorderPainted(false);
		folderbutton.setFocusPainted(false);
		folderbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				folderbutton.setIcon(folderbtnImgClicked);
				folderbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				folderbutton.setIcon(folderbtnImg);
				folderbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					try {
						Desktop.getDesktop().open(new File("./Youtube/"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		naverbutton.setBounds(960, 145, 130, 70);
		naverbutton.setContentAreaFilled(false);
		naverbutton.setBorderPainted(false);
		naverbutton.setFocusPainted(false);
		naverbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				naverbutton.setIcon(naverbtnImgClicked);
				naverbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				naverbutton.setIcon(naverbtnImg);
				naverbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					try {
						Desktop.getDesktop().browse(new URI("https://cloud.naver.com/"));
					} catch (IOException ioe) {
						ioe.printStackTrace();
					} catch (URISyntaxException ue) {
						ue.printStackTrace();
					}
				}
			}
		});
		
		googlebutton.setBounds(1100, 145, 130, 70);
		googlebutton.setContentAreaFilled(false);
		googlebutton.setBorderPainted(false);
		googlebutton.setFocusPainted(false);
		googlebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				googlebutton.setIcon(googlebtnImgClicked);
				googlebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				googlebutton.setIcon(googlebtnImg);
				googlebutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					try {
						Desktop.getDesktop().browse(new URI("https://drive.google.com/?tab=wo"));
					} catch (IOException ioe) {
						ioe.printStackTrace();
					} catch (URISyntaxException ue) {
						ue.printStackTrace();
					}
				}
			}
		});
		
		mp3listbutton.setBounds(820, 225, 200, 35);
		mp3listbutton.setContentAreaFilled(false);
		mp3listbutton.setBorderPainted(false);
		mp3listbutton.setFocusPainted(false);
		mp3listbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					if(!bool) {
						bool = !bool;
					}
					if(bool) {
						mp3listbutton.setIcon(mp3listbtnImgClicked);
						mp4listbutton.setIcon(mp4listbtnImg_no);
						sp.setBorder(new LineBorder(new Color(18, 115, 235), 5));
						table.setGridColor(new Color(18, 115, 235));
						hd.setBackground(new Color(18, 115, 235));
						jtable("mp3");
					}else {
						mp3listbutton.setIcon(mp3listbtnImg_no);
						mp4listbutton.setIcon(mp4listbtnImgClicked);
						sp.setBorder(new LineBorder(new Color(139, 89, 255), 5));
						table.setGridColor(new Color(139, 89, 255));
						hd.setBackground(new Color(139, 89, 255));
						jtable("mp4");
					}
				}
			}
		});
		
		mp4listbutton.setBounds(1030, 225, 200, 35);
		mp4listbutton.setContentAreaFilled(false);
		mp4listbutton.setBorderPainted(false);
		mp4listbutton.setFocusPainted(false);
		mp4listbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					if(bool) {
						bool = !bool;
					}
					if(bool) {
						mp3listbutton.setIcon(mp3listbtnImgClicked);
						mp4listbutton.setIcon(mp4listbtnImg_no);
						sp.setBorder(new LineBorder(new Color(18, 115, 235), 5));
						table.setGridColor(new Color(18, 115, 235));
						hd.setBackground(new Color(18, 115, 235));
						jtable("mp3");
					}else {
						mp3listbutton.setIcon(mp3listbtnImg_no);
						mp4listbutton.setIcon(mp4listbtnImgClicked);
						sp.setBorder(new LineBorder(new Color(139, 89, 255), 5));
						table.setGridColor(new Color(139, 89, 255));
						hd.setBackground(new Color(139, 89, 255));
						jtable("mp4");
					}
				}
			}
		});
		
		String header[] = {"����", "URL", "����Ÿ��", "��¥"};
		String contents[][] = {};
		table = new JTable();
		table.setModel(new DefaultTableModel(contents, header) {		// ���̺� ���� �Ұ�
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		});
		table.setGridColor(new Color(18, 115, 235));
		hd = table.getTableHeader();
		hd.setFont(new Font("���� ���", Font.BOLD, 15));
		hd.setBackground(new Color(18, 115, 235));
		hd.setForeground(new Color(255, 255, 255));
		table.getTableHeader().setReorderingAllowed(false);	// �÷� �̵��Ұ�
		sp = new JScrollPane(table);
		sp.setBounds(820, 270, 410, 200);
		sp.setBorder(new LineBorder(new Color(18, 115, 235), 5));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					if(e.getClickCount()==2) {	// ����Ŭ��
						int row = table.getSelectedRow();
						int column = 1;
						ProgramFrame.url = ""+table.getValueAt(row, column);
						changeurl = new ChangeURL(ProgramFrame.url);
						changeurl.changeURL(ProgramFrame.url);
						LoginFrame.programFrame.youtube.browser.loadURL(ProgramFrame.url);
						urlfield.setText(ProgramFrame.url);
					}
				}
			}
		});
		
		recommendbutton.setBounds(820, 485, 410, 80);
		recommendbutton.setContentAreaFilled(false);
		recommendbutton.setBorderPainted(false);
		recommendbutton.setFocusPainted(false);
		recommendbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				recommendbutton.setIcon(rbrnImgClicked);
				recommendbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				recommendbutton.setIcon(rbrnImg);
				recommendbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					Recommend r = new Recommend();
					LoginFrame.programFrame.youtube.browser.loadURL(ProgramFrame.url);
				}
			}
		});
		
		cp.setBounds(820, 580, 410, 100);

		addMouseMotionListener(new MouseAdapter() { // â �̵�
			@Override
			public void mouseDragged(MouseEvent e) {
				if((e.getModifiersEx()&InputEvent.BUTTON1_DOWN_MASK)!=0) {
					if (e.getY() <= 25) {
						LoginFrame.programFrame.setLocation(e.getXOnScreen() - 640, e.getYOnScreen() - 10);
					}
				}
			}
		});

		//youtubePanel.setBounds(50, 65, 720, 410);

		add(exitbutton);
		add(minibutton);
		//add(youtubePanel);
		add(urlfield);
		add(urlbutton);
		add(mp3downloadbutton);
		add(mp4downloadbutton);
		add(youtubebutton);
		add(modifybutton);
		add(folderbutton);
		add(naverbutton);
		add(googlebutton);
		add(mp3listbutton);
		add(mp4listbutton);
		add(sp);
		add(recommendbutton);
		add(cp);

		timer = new Timer(100, this);
		timer.start();
	}
	
	public void jtable(String type) {
		try {
			LoginFrame.client.jtable(LoginFrame.programFrame.id, type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("���̺� ���� ����");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(donwload_start) {
			color = new Color(r, g, b, 255);
			if (count == 1) {
				r += 9;
				g -= 3;
				b++;
			} else {
				r -= 9;
				g += 3;
				b--;
			}
			if (r == 180 || r == 18) {
				count *= -1;
			}
		}
		if(i%100==0) {
			if(bool) {
				mp3listbutton.setIcon(mp3listbtnImgClicked);
				mp4listbutton.setIcon(mp4listbtnImg_no);
				sp.setBorder(new LineBorder(new Color(18, 115, 235), 5));
				table.setGridColor(new Color(18, 115, 235));
				hd.setBackground(new Color(18, 115, 235));
				jtable("mp3");
			}else {
				mp3listbutton.setIcon(mp3listbtnImg_no);
				mp4listbutton.setIcon(mp4listbtnImgClicked);
				sp.setBorder(new LineBorder(new Color(139, 89, 255), 5));
				table.setGridColor(new Color(139, 89, 255));
				hd.setBackground(new Color(139, 89, 255));
				jtable("mp4");
			}
			i++;
		}
		if(t) {
			i++;
			if(i==5) {
				if(bool) {
					mp3listbutton.setIcon(mp3listbtnImgClicked);
					mp4listbutton.setIcon(mp4listbtnImg_no);
					sp.setBorder(new LineBorder(new Color(18, 115, 235), 5));
					table.setGridColor(new Color(18, 115, 235));
					hd.setBackground(new Color(18, 115, 235));
					jtable("mp3");
				}else {
					mp3listbutton.setIcon(mp3listbtnImg_no);
					mp4listbutton.setIcon(mp4listbtnImgClicked);
					sp.setBorder(new LineBorder(new Color(139, 89, 255), 5));
					table.setGridColor(new Color(139, 89, 255));
					hd.setBackground(new Color(139, 89, 255));
					jtable("mp4");
				}
				t = false;
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImg, 0, 0, null); // ��� �̹���
		g.drawImage(titlebar, 0, 0, new Color(18, 115, 235, 255), null); // ���� ǥ����
		g.drawImage(title, 0, 2, null); // ����
		g.drawImage(browserLoading, 50, 65, null);
		if(donwload_start) {
			g.drawImage(rgbbar, 0, 710, color, null); // �ϴ� RGB ��
		}
		repaint();
	}
}
