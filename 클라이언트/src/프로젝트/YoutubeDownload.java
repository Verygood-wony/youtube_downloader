package 프로젝트;

import java.io.IOException;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class YoutubeDownload {
	private PythonInterpreter inter;
	private String url;
	private boolean able;

	public YoutubeDownload() {
		able = false;
		new Thread(new Runnable() {
			@Override
			public void run() {
				inter = new PythonInterpreter();
				able = true;
			}
		}).start();
	}
	
	public void download(String url, boolean mp3) {
		this.url = url;
		if(able) {
			if(mp3) {
				able = false;
				mp3Download();
			} else {
				able = false;
				mp4Download();
			}
		}
	}

	private void mp3Download() {
		String title = "";
		if (LoginFrame.programFrame.panel.urlfield.getText().equals("") == false 
				&& LoginFrame.programFrame.panel.urlfield.getText().equals("Youtube 동영상 URL을 입력해주세요.") == false
				&& url.contains("https://youtube.com/embed/")) {
			LoginFrame.programFrame.panel.donwload_start = true;
			LoginFrame.programFrame.panel.cp.download_start = true;
			inter.exec("import os\r\n" + 
					"import youtube_dlc\r\n" + 
					"import subprocess\r\n" + 
					"\r\n" + 
					"VIDEO_DOWNLOAD_PATH = './Youtube/Music/'  # 다운로드 경로\r\n" + 
					"VIDEO_TITLE = ''\r\n" + 
					"VIDEO_EXT = ''\r\n" + 
					"\r\n" + 
					"def format_change(video_title, video_ext):\r\n" + 
					"    try:\r\n" + 
					"        command = 'ffmpeg -y -i ./Youtube/Music/\"'+video_title+'.'+video_ext+'\" -metadata title='+video_title+' -ab 320k ./Youtube/Music/\"'+video_title+'.mp3\"'\r\n" + 
					"        subprocess.call(command)\r\n" + 
					"        \r\n" + 
					"    except Exception as e:\r\n" + 
					"        print('에러1', e)\r\n" + 
					"\r\n" + 
					"    os.remove('./Youtube/Music/'+video_title+'.'+video_ext)   # 원본파일 삭제\r\n" + 
					"    \r\n" + 
					"def video_info(youtube_video_list):\r\n" + 
					"    global VIDEO_TITLE\r\n" + 
					"    \r\n" + 
					"    try:\r\n" + 
					"        with youtube_dlc.YoutubeDL() as ydlc:\r\n" + 
					"            info_dict = ydlc.extract_info(youtube_video_list[0], download=False) # 유튜브 영상의 정보를 가져오기\r\n" + 
					"            video_title = info_dict.get('title', None)  # 제목 정보\r\n" + 
					"            video_title = video_title.replace('/', '_') # 제목 '/'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace(' ', '_') # 제목 공백을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('\\'', '_') # 제목 '\\'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace(':', '_') # 제목 ':'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('*', '_') # 제목 '*'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('?', '_') # 제목 '?'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('\"', '_') # 제목 '\"'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('<', '_') # 제목 '<'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('>', '_') # 제목 '>'을 '_'로 바꾸기\r\n" + 
					"            VIDEO_TITLE = video_title.replace('|', '_') # 제목 '|'을 '_'로 바꾸기\r\n" + 
					"\r\n" + 
					"    except Exception as e:\r\n" + 
					"        print('error2', e)\r\n" + 
					"\r\n" + 
					"def download_video(output_dir, youtube_video_list):\r\n" + 
					"    global VIDEO_EXT\r\n" + 
					"    # print(\"비디오 타이틀: \"+VIDEO_TITLE)\r\n" + 
					"\r\n" + 
					"    download_path = os.path.join(output_dir, VIDEO_TITLE+'.%(ext)s')\r\n" + 
					"\r\n" + 
					"    for video_url in youtube_video_list:\r\n" + 
					"\r\n" + 
					"        # youtube_dl options\r\n" + 
					"        ydlc_opts = {\r\n" + 
					"            'format': 'bestaudio',  # 가장 좋은 화질로 선택(화질을 선택하여 다운로드 가능)\r\n" + 
					"            'outtmpl': download_path, # 다운로드 경로 설정\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        try:\r\n" + 
					"            with youtube_dlc.YoutubeDL(ydlc_opts) as ydlc:\r\n" + 
					"                ydlc.download([video_url])   # 유튜브 다운로드\r\n" + 
					"                info_dict = ydlc.extract_info(youtube_video_list[0], download=False) # 유튜브 영상의 정보를 가져오기\r\n" + 
					"                VIDEO_EXT = info_dict.get('ext', None)  # 확장자 정보\r\n" + 
					"                format_change(VIDEO_TITLE, VIDEO_EXT)\r\n" + 
					"                \r\n" + 
					"        except Exception as e:\r\n" + 
					"            print('error3', e)\r\n" + 
					"\r\n" + 
					"if __name__ == '__main__':\r\n" + 
					"\r\n" + 
					"    youtube_url_list = [  # 유투브에서 다운로드 하려는 영상의 주소 리스트(아래는 Sample Video 리스트)\r\n" + 
					"        \""+this.url+"\"\r\n" + 
					"    ]\r\n" + 
					"    video_info(youtube_url_list)\r\n" + 
					"    download_video(VIDEO_DOWNLOAD_PATH, youtube_url_list)\r\n" + 
					"    print('Download Comoplete')\r\n" + 
					"");
			PyObject po = inter.get("VIDEO_TITLE");
			title = ""+po;
		}
		try {
			if(title.equals("")==false && (title==null)==false) {
				LoginFrame.client.download(LoginFrame.programFrame.id, this.url, title, "mp3");
				new Thread(new Runnable() {
					@Override
					public void run() {
						LoginFrame.programFrame.panel.visible = true;
						LoginFrame.programFrame.panel.downloaded = true;
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						LoginFrame.programFrame.panel.visible = false;
						LoginFrame.programFrame.panel.donwload_start = false;
						LoginFrame.programFrame.panel.cp.download_start = false;
						able = true;
					}
				}).start();
			}else {
				new Thread(new Runnable() {
					@Override
					public void run() {
						LoginFrame.programFrame.panel.visible = true;
						LoginFrame.programFrame.panel.downloaded = false;
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						LoginFrame.programFrame.panel.visible = false;
						LoginFrame.programFrame.panel.donwload_start = false;
						LoginFrame.programFrame.panel.cp.download_start = false;
						able = true;
					}
				}).start();
			}
			LoginFrame.programFrame.panel.bool = true;
			LoginFrame.programFrame.panel.i = 100;
			//LoginFrame.client.jtable(LoginFrame.programFrame.id, "mp3");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("다운로드 기록 실패");
		}
	}
	
	private void mp4Download() {
		String title = "";
		if (LoginFrame.programFrame.panel.urlfield.getText().equals("") == false 
				&& LoginFrame.programFrame.panel.urlfield.getText().equals("Youtube 동영상 URL을 입력해주세요.") == false
				&& url.contains("https://youtube.com/embed/")) {
			LoginFrame.programFrame.panel.donwload_start = true;
			LoginFrame.programFrame.panel.cp.download_start = true;
			inter.exec("import os\r\n" + 
					"import youtube_dlc\r\n" + 
					"import subprocess\r\n" + 
					"\r\n" + 
					"VIDEO_DOWNLOAD_PATH = './Youtube/Video/'  # 다운로드 경로\r\n" + 
					"VIDEO_TITLE = ''\r\n" + 
					"VIDEO_EXT = ''\r\n" + 
					"\r\n" + 
					"def format_change(video_title, video_ext):\r\n" + 
					"    try:\r\n" + 
					"        command = 'ffmpeg -y -i ./Youtube/Video/\"'+video_title+'.'+video_ext+'\" -metadata title='+video_title+' -ab 320k ./Youtube/Video/\"'+video_title+'.mp4\"'\r\n" + 
					"        subprocess.call(command)\r\n" + 
					"        \r\n" + 
					"    except Exception as e:\r\n" + 
					"        print('에러1', e)\r\n" + 
					"\r\n" + 
					"    os.remove('./Youtube/Video/'+video_title+'.'+video_ext)   # 원본파일 삭제\r\n" + 
					"    \r\n" + 
					"def video_info(youtube_video_list):\r\n" + 
					"    global VIDEO_TITLE\r\n" + 
					"    \r\n" + 
					"    try:\r\n" + 
					"        with youtube_dlc.YoutubeDL() as ydlc:\r\n" + 
					"            info_dict = ydlc.extract_info(youtube_video_list[0], download=False) # 유튜브 영상의 정보를 가져오기\r\n" + 
					"            video_title = info_dict.get('title', None)  # 제목 정보\r\n" + 
					"            video_title = video_title.replace('/', '_') # 제목 '/'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace(' ', '_') # 제목 공백을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('\\'', '_') # 제목 '\\'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace(':', '_') # 제목 ':'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('*', '_') # 제목 '*'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('?', '_') # 제목 '?'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('\"', '_') # 제목 '\"'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('<', '_') # 제목 '<'을 '_'로 바꾸기\r\n" + 
					"            video_title = video_title.replace('>', '_') # 제목 '>'을 '_'로 바꾸기\r\n" + 
					"            VIDEO_TITLE = video_title.replace('|', '_') # 제목 '|'을 '_'로 바꾸기\r\n" + 
					"\r\n" + 
					"    except Exception as e:\r\n" + 
					"        print('에러', e)\r\n" + 
					"\r\n" + 
					"def download_video(output_dir, youtube_video_list):\r\n" + 
					"    global VIDEO_EXT\r\n" + 
					"    # print(\"비디오 타이틀: \"+VIDEO_TITLE)\r\n" + 
					"\r\n" + 
					"    download_path = os.path.join(output_dir, VIDEO_TITLE+'.%(ext)s')\r\n" + 
					"\r\n" + 
					"    for video_url in youtube_video_list:\r\n" + 
					"\r\n" + 
					"        # youtube_dlc options\r\n" + 
					"        ydlc_opts = {\r\n" + 
					"            'format': 'bestvideo[ext=webm]+bestaudio[ext=webm]',  # 가장 좋은 화질로 선택(화질을 선택하여 다운로드 가능)\r\n" + 
					"            'outtmpl': download_path, # 다운로드 경로 설정\r\n" + 
					"        }\r\n" + 
					"\r\n" + 
					"        try:\r\n" + 
					"            with youtube_dlc.YoutubeDL(ydlc_opts) as ydlc:\r\n" + 
					"                ydlc.download([video_url])   # 유튜브 다운로드\r\n" + 
					"                info_dict = ydlc.extract_info(youtube_video_list[0], download=False) # 유튜브 영상의 정보를 가져오기\r\n" + 
					"                VIDEO_EXT = info_dict.get('ext', None)  # 확장자 정보\r\n" + 
					"                print('@@@@@@@@@ '+VIDEO_EXT)\r\n" + 
					"                format_change(VIDEO_TITLE, VIDEO_EXT)\r\n" + 
					"                \r\n" + 
					"        except Exception as e:\r\n" + 
					"            print('에러', e)\r\n" + 
					"\r\n" + 
					"if __name__ == '__main__':\r\n" + 
					"\r\n" + 
					"    youtube_url_list = [  # 유투브에서 다운로드 하려는 영상의 주소 리스트(아래는 Sample Video 리스트)\r\n" + 
					"        \""+this.url+"\"\r\n" + 
					"    ]\r\n" + 
					"    video_info(youtube_url_list)\r\n" + 
					"    download_video(VIDEO_DOWNLOAD_PATH, youtube_url_list)\r\n" + 
					"    print('다운완료')\r\n" + 
					"");
			PyObject po = inter.get("VIDEO_TITLE");
			title = ""+po;
		}
		try {
			if(title.equals("")==false && (title==null)==false) {
				LoginFrame.client.download(LoginFrame.programFrame.id, this.url, title, "mp4");
				new Thread(new Runnable() {
					@Override
					public void run() {
						LoginFrame.programFrame.panel.visible = true;
						LoginFrame.programFrame.panel.downloaded = true;
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						LoginFrame.programFrame.panel.visible = false;
						LoginFrame.programFrame.panel.donwload_start = false;
						LoginFrame.programFrame.panel.cp.download_start = false;
						able = true;
					}
				}).start();
			}else {
				new Thread(new Runnable() {
					@Override
					public void run() {
						LoginFrame.programFrame.panel.visible = true;
						LoginFrame.programFrame.panel.downloaded = false;
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						LoginFrame.programFrame.panel.visible = false;
						LoginFrame.programFrame.panel.donwload_start = false;
						LoginFrame.programFrame.panel.cp.download_start = false;
						able = true;
					}
				}).start();
			}
			LoginFrame.programFrame.panel.bool = false;
			LoginFrame.programFrame.panel.i = 100;
			//LoginFrame.client.jtable(LoginFrame.programFrame.id, "mp4");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("다운로드 기록 실패");
		}
	}
}
