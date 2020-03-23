package webdriver;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;

import java.io.File;
import java.io.IOException;

public class BrowserModProxyManager {

    BrowserMobProxy proxy = new BrowserMobProxyServer();
    private static BrowserModProxyManager instance;

    private BrowserModProxyManager() {}

    public static synchronized BrowserModProxyManager getInstance() {
        if (instance == null) {
            instance = new BrowserModProxyManager();
        }
        return instance;
    }

    public synchronized BrowserMobProxy getProxy() {
        if (!proxy.isStarted()) {
            proxy.setTrustAllServers(true);
            proxy.start();
        }
        return proxy;
    }

    public synchronized void captureHarFile() {
        proxy.newHar();
    }

    public synchronized void saveHarFile(final String file) {
        try {
            proxy.getHar().writeTo(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
