package 프로젝트;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Recommend {
	public String url = "";
	
	public Recommend() {
		url = LoginFrame.programFrame.panel.changeurl.urlChange(ProgramFrame.url);
		try {
			Document doc = Jsoup.connect(url).get();
			String data = ""+doc;
			int num = data.indexOf("\"webCommandMetadata\":{\"url\":\"/watch?v=");
			int num2 = num+38;
			String videoID = data.substring(num2, num2+11);
			ProgramFrame.url = "https://youtube.com/embed/" + videoID + "?fs=0&modestbranding=1";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("크롤링 실패");
		}
	}

}
