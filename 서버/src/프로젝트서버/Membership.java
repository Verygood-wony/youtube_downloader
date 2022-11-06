package 프로젝트서버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Membership extends Thread {
	private Socket socket;
	private int myId;
	private Statement stmt;
	private ResultSet rs;
	
	public Membership(Socket socket, int clientId) throws SQLException {
		this.socket = socket;
		this.myId = clientId;
		Connection con = makeConnection();
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery("USE user_db");
	}
	
	private static Connection makeConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection("jdbc:mysql://localhost/user_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false", "root", "dhfqorj147");
			System.out.println("데이터베이스 연결 성공");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch(SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}
	
	private void signup(BufferedReader in, PrintWriter out) throws IOException {
		String dbquery = "";
		dbquery = in.readLine();
		try {
			rs = stmt.executeQuery(dbquery);
			String id = "";
			String temp = in.readLine();
			while(rs.next()) {
				id = rs.getString("user_id");
			}
			if(id.equals(temp)==false) {
				out.println(id);
				dbquery = "";
				dbquery = in.readLine();
				stmt.executeUpdate(dbquery);
				System.out.println("회원가입 완료");
			}else {
				out.println(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void login(BufferedReader in, PrintWriter out) throws IOException {
		String dbquery = "";
		dbquery = in.readLine();
		try {
			rs = stmt.executeQuery(dbquery);
			String id = "";
			String temp = in.readLine();
			System.out.println(temp);
			while(rs.next()) {
				id = rs.getString("user_id");
			}
			if(id.equals(temp)==true) {
				out.println(id);
			}else {
				out.println("로그인실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void download_list(BufferedReader in, PrintWriter out) throws IOException {
		String dbquery = "";
		dbquery = in.readLine();
		System.out.println(dbquery);
		try {
			rs = stmt.executeQuery(dbquery);
			String url = "";
			String temp = in.readLine();
			System.out.println(temp);
			while(rs.next()) {
				url = rs.getString("url");
			}
			if(url.equals(temp)==false) {
				out.println(url);
				dbquery = "";
				dbquery = in.readLine();
				stmt.executeUpdate(dbquery);
			}else {
				out.println(url);
				dbquery = "";
				dbquery = in.readLine();
				stmt.executeUpdate(dbquery);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void jtable(BufferedReader in, PrintWriter out) throws IOException {
		String dbquery = "";
		dbquery = in.readLine();
		try {
			rs = stmt.executeQuery(dbquery);
			String title = "";
			String url = "";
			String type = "";
			String date = "";
			rs.last();
			int row = rs.getRow();
			out.println(row);
			rs.beforeFirst();
			while(rs.next()) {
				title = rs.getString("title");
				url = rs.getString("url");
				type = rs.getString("file_type");
				date = rs.getString("download_date");
				out.println(title);
				out.println(url);
				out.println(type);
				out.println(date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println("서버와 정상적으로 연결되었습니다.");
			while(true) {
				String dbquery = "";
				dbquery = in.readLine();
				if(dbquery==null) {
					break;
				}else if(dbquery.equals("회원가입")) {
					signup(in, out);
				}else if(dbquery.equals("로그인")) {
					login(in, out);
				}else if(dbquery.equals("다운로드기록")) {
					download_list(in, out);
				}else if(dbquery.equals("jtable")) {
					jtable(in, out);
				}
			}
		} catch(IOException e) {
			System.out.println("클라이언트 번호: "+myId+"처리 실패"+e);
		} finally {
			try {
				socket.close();
			} catch(IOException e) {
				System.out.println("소켓 종료 오류"+e);
			}
			System.out.println("클라이언트 번호: "+myId+"처리 종료");
		}
	}
}
