package 프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.table.DefaultTableModel;

public class Client {
	public BufferedReader in;
	public PrintWriter out;
	
	public Client() throws Exception, IOException {
		Socket socket = new Socket("localhost", 9876);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		
		System.out.println(in.readLine());
	}
	
	public void signup(String id, String pw, String name, String phone) throws IOException {
		out.println("회원가입");
		out.println("SELECT user_id FROM user WHERE user_id='"+id+"'");
		out.println(id);
		if(in.readLine().equals(id)==false) {
			out.println("INSERT INTO user (user_id, user_pw, user_name, user_phone, user_date) VALUES('"+id+"', '"+pw+"', '"+name+"', '"+phone+"', now())");
		}else {
			System.out.println("이미 존재하는 아이디");
		}
	}
	
	public void login(String id, String pw) throws IOException {
		out.println("로그인");
		out.println("SELECT user_id FROM user WHERE user_id='"+id+"' AND user_pw='"+pw+"'");
		out.println(id);
		if(in.readLine().equals(id)==true) {
			LoginFrame.loginFrame.dispose();
			LoginFrame.programFrame = new ProgramFrame(id);
		}else {
			LoginFrame.loginFrame.panel.wrong.setVisible(true);
		}
	}
	
	public void download(String id, String temp, String title, String type) throws IOException {
		String url = LoginFrame.programFrame.panel.changeurl.urlChange(temp);
		out.println("다운로드기록");
		out.println("SELECT url FROM download_file WHERE user_id='"+id+"' AND url='"+url+"' AND file_type='"+type+"'");
		out.println(url);
		if(in.readLine().equals(url)==false) {
			out.println("INSERT INTO download_file (user_id, title, url, file_type, download_date) VALUES('"+id+"', '"+title+"', '"+url+"', '"+type+"', now())");
		}else {
			out.println("UPDATE download_file SET title='"+title+"', download_date=now() WHERE user_id='"+id+"' AND url='"+url+"'");
		}
	}
	
	public void jtable(String id, String type) throws IOException {
		out.println("jtable");
		out.println("SELECT*FROM download_file WHERE user_id='"+id+"' AND file_type='"+type+"' order by download_date DESC");
		DefaultTableModel model = (DefaultTableModel)LoginFrame.programFrame.panel.table.getModel();
		model.setNumRows(0);
		String temp = in.readLine();
		int row = Integer.parseInt(temp);
		String arr[] = new String[4];
		for(int i=0; i<row; i++) {
			arr[0] = in.readLine();
			arr[1] = in.readLine();
			arr[2] = in.readLine();
			arr[3] = in.readLine();
			model.addRow(arr);
		}
	}
}
