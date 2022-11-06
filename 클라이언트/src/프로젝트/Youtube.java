package 프로젝트;

import java.awt.Component;
import java.awt.KeyboardFocusManager;

import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.browser.CefBrowser;
import org.cef.handler.CefFocusHandlerAdapter;

public class Youtube {
	public final CefApp cefApp;
	public final CefClient client;
	public final CefBrowser browser;
	public final Component browserUI;
	public boolean browserFocus = true;

	public Youtube() {
		CefSettings settingsBrowser = new CefSettings();
		settingsBrowser.locale = "ko";
		settingsBrowser.windowless_rendering_enabled = false;
		cefApp = CefApp.getInstance(settingsBrowser);
		client = cefApp.createClient();
		client.addFocusHandler(new CefFocusHandlerAdapter() {
            @Override
            public void onGotFocus(CefBrowser browser) {
                if (browserFocus) {
                	return;
                }
                browserFocus = true;
                KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
                browser.setFocus(true);
            }

            @Override
            public void onTakeFocus(CefBrowser browser, boolean next) {
            	browserFocus = false;
            }
        });
		browser = client.createBrowser(ProgramFrame.url, false, false);
		browserUI = browser.getUIComponent();
	}
}
