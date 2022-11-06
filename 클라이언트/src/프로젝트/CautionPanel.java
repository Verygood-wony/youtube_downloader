package 프로젝트;

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
	private Image downloading1 = new ImageIcon(LoginFrame.class.getResource("../프레임구성요소/다운로드중1.png")).getImage(); // 다운로딩
	private Image downloading2 = new ImageIcon(LoginFrame.class.getResource("../프레임구성요소/다운로드중2.png")).getImage(); // 다운로딩
	private Image downloading3 = new ImageIcon(LoginFrame.class.getResource("../프레임구성요소/다운로드중3.png")).getImage(); // 다운로딩
	private Image downloadc = new ImageIcon(LoginFrame.class.getResource("../프레임구성요소/다운로드완료.png")).getImage(); // 다운로드 성공
	private Image downloadf = new ImageIcon(LoginFrame.class.getResource("../프레임구성요소/다운로드실패.png")).getImage(); // 다운로드 실패
	private Image caution = new ImageIcon(LoginFrame.class.getResource("../프레임구성요소/경고문구.png")).getImage(); // 다운로드 실패
	
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
					g.drawImage(downloading3, 30, 12, null); // 다운로드 중.
				}else if(p>=65) {
					g.drawImage(downloading2, 30, 12, null); // 다운로드 중.
				}else {
					g.drawImage(downloading1, 30, 12, null); // 다운로드 중.
				}
			}else {
				if(LoginFrame.programFrame.panel.downloaded) {
					g.drawImage(downloadc, 30, 12, null); // 다운로드완료
				}else {
					g.drawImage(downloadf, 30, 12, null); // 다운로드실패
				}
			}
		}else {
			g.drawImage(caution, x, 0, null); // 다운로드실패
		}
		repaint();
	}
}
