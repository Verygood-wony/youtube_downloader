package 프로젝트서버;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;

public class Server {
	public static Server server;
	
	public Server() throws SQLException, IOException {
		System.out.println("서버 가동");
		int clientId = 0;
		ServerSocket ss = new ServerSocket(9876);
		try {
			while(true) {
				clientId++;
				Membership m = new Membership(ss.accept(), clientId);
				m.start();
			}
		} finally {
			ss.close();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		server = new Server();
	}
}