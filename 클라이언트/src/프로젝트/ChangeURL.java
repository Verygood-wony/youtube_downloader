package 프로젝트;

public class ChangeURL {
	public String url;

	public ChangeURL(String url) {
		this.url = url;
	}

	public void changeURL(String url) {
		if (url.equals("") || url.equals(" Youtube 동영상 URL을 입력해주세요.")) {
			ProgramFrame.url = "blank";
		} else {
			if (url.contains("https://www.youtube.com/watch?v=")) {
				// 유튜브 주소 추출
				int index = url.indexOf("=");
				String temp = url.substring(index + 1, index + 12);
				ProgramFrame.url = "https://youtube.com/embed/" + temp + "?fs=0&modestbranding=1";
			} else if (url.contains("https://youtu.be/")) {
				String temp = url.substring(17, 28);
				ProgramFrame.url = "https://youtube.com/embed/" + temp + "?fs=0&modestbranding=1";
			} else {
				ProgramFrame.url = "blank";
			}
		}
	}
	
	public String urlChange(String url) {
		String temp = url.substring(26, 37);
		return "https://www.youtube.com/watch?v="+temp;
	}
}