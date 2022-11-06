package ������Ʈ;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CautionPanel extends JPanel implements ActionListener {
	public int p = 0;
	public boolean download_start = false;
	private int x = 410;
	private Timer timer;
	private Image downloading1 = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�ٿ�ε���1.png")).getImage(); // �ٿ�ε�
	private Image downloading2 = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�ٿ�ε���2.png")).getImage(); // �ٿ�ε�
	private Image downloading3 = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�ٿ�ε���3.png")).getImage(); // �ٿ�ε�
	private Image downloadc = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�ٿ�ε�Ϸ�.png")).getImage(); // �ٿ�ε� ����
	private Image downloadf = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�ٿ�ε����.png")).getImage(); // �ٿ�ε� ����
	private Image caution = new ImageIcon(LoginFrame.class.getResource("../�����ӱ������/�����.png")).getImage(); // �ٿ�ε� ����
	
	public CautionPanel() {
		setBackground(new Color(255, 255, 255, 255));
		setLayout(null);
		timer = new Timer(5, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(download_start) {
			if(p>200) {
				p = 0;
			}else {
				p++;
			}
		}else {
			if(x<-3500) {
				x = 410;
			}else {
				x -= 2;
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(download_start) {
			if(!LoginFrame.programFrame.panel.visible) {
				if(p>=130) {
					g.drawImage(downloading3, 30, 12, null); // �ٿ�ε� ��.
				}else if(p>=65) {
					g.drawImage(downloading2, 30, 12, null); // �ٿ�ε� ��.
				}else {
					g.drawImage(downloading1, 30, 12, null); // �ٿ�ε� ��.
				}
			}else {
				if(LoginFrame.programFrame.panel.downloaded) {
					g.drawImage(downloadc, 30, 12, null); // �ٿ�ε�Ϸ�
				}else {
					g.drawImage(downloadf, 30, 12, null); // �ٿ�ε����
				}
			}
		}else {
			g.drawImage(caution, x, 0, null); // �ٿ�ε����
		}
		repaint();
	}
}
