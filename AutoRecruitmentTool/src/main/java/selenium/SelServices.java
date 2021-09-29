/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Eagle
 */
public class SelServices {

    public static String driverType = "chrome";
    public static WebDriver oDriver = null;

    public SelServices() {
        InitSelEnv(driverType);
    }

    private void InitSelEnv(String sBrowser) {
        if (sBrowser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");     
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
            //options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 11) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.82 Mobile Safari/537.36");
            options.addArguments("--user-agent=Chrome");
            oDriver = new ChromeDriver(options);
            //oDriver = new ChromeDriver();
        }
        if (sBrowser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            oDriver = new FirefoxDriver();
        }
    }
}
