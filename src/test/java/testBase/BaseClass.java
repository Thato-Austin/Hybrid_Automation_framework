package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass{
    public static WebDriver driver;
    public Logger logger;
    public Properties p;



    @BeforeClass(groups = {"Sanity", "Regression", "Master", "DataDriven"})
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {
        //loading config properties
        FileReader fileReader= new FileReader("./src//test//resources//config.properties");
        p= new Properties();
        p.load(fileReader);

        logger = LogManager.getLogger(this.getClass());

        switch (br.toLowerCase()) {
            case "edge" -> driver = new EdgeDriver();
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            default -> System.out.println("Invalid browser name..");
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://tutorialsninja.com/demo/");
        driver.get(p.getProperty("url")); // reading from config.properties
        driver.manage().window().maximize();
    }
    @AfterClass(groups = {"Sanity", "Regression", "Master", "DataDriven"})
    public void tearDown(){
        driver.quit();
    }

    public String randomString(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNum(){
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNum(){
        String generatedAlphaNum = RandomStringUtils.randomNumeric(10);
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedAlphaNum+generatedString);
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
