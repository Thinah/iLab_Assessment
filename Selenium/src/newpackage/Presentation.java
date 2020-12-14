
package newpackage;

import org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.reporters.TestHTMLReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.aventstack.extentreports.util.Assert;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;




//@RunWith(Parameterized.class)
//@Listeners(ExtentITestListenerClassAdapter.class)

public class Presentation {

	
		// TODO Auto-generated method stub

	   
	    
	    public ExtentReports extent;
	    public ExtentSparkReporter htmlreporter;
	    
	    public ExtentTest test;
	    
	    @BeforeTest
	    public void setExtent()
	    {
	    	htmlreporter =new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/myReport");
	    	
	    	htmlreporter.config().setDocumentTitle("Driver Automation");
	    	htmlreporter.config().setReportName("CAREERS");
	    	htmlreporter.config().setTheme(Theme.DARK);
	    	
	    	extent=new ExtentReports();
	    	
	    	extent.attachReporter(htmlreporter);
	    }
		 @AfterTest
		 public void endReport()
		 {
			
			 extent.flush();
		 }
	
@BeforeMethod

public void test1() {
	
			    System.getProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
    
				WebDriver driver=new FirefoxDriver();
			      driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			      driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    driver.get("https://www.ilabquality.com/");
			    driver.manage().window().setSize(new Dimension(1382, 744));
			    
			    
			   // System.getProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
				//WebDriver driver=new ChromeDriver();
			    //driver.get("https://www.ilabquality.com/");
			    //driver.manage().window().setSize(new Dimension(1382, 744));
}
 @Test
 public void Assess()
			    
			    {
	    System.getProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver\\geckodriver.exe");
	 
	  
		   WebDriver driver=new FirefoxDriver();
		    driver.get("https://www.ilabquality.com/");
	      driver.manage().window().setSize(new Dimension(1382, 744));
		         
		           
	      driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	      driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    test=extent.createTest("Careers Form");
			    driver.findElement(By.xpath("/html/body/header/div/div/div[3]/nav/ul/li[4]/a")).click();
			    
			    test=extent.createTest("South Africa Link");
			    driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div/div/div[4]/a")).click();
			    
			    test=extent.createTest("first link");
			    driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div[1]/a")).click();
			    
			    test=extent.createTest("Apply Online Button");
			    driver.findElement(By.xpath("/html/body/section[2]/div[2]/div/div/div/div/div[2]/div[1]/a")).click();
			    
			   // test=extent.createTest("Enter Name");
			    //driver.findElement(By.id("applicant_name")).click();
			    test=extent.createTest("name sendkeys");
			    driver.findElement(By.id("//*[@id=\"applicant_name\"]")).sendKeys("Thina");
			    
			    //test=extent.createTest("enter email");
			    //driver.findElement(By.id("email")).click();
			    test=extent.createTest("email sendkeys");
			    driver.findElement(By.id("//*[@id=\"email\"]")).sendKeys("thinagumede3@gmail.com");
			    
			    //test=extent.createTest("enter phone");
			    //driver.findElement(By.id("phone")).click();
			    test=extent.createTest("phone sendkeys");
			    driver.findElement(By.id("//*[@id=\"phone\"]")).sendKeys("061 765 8004");
			    
			    test=extent.createTest("submit application");
			    driver.findElement(By.id("//*[@id=\"wpjb_submit\"]")).click();
			    //assertEquals(vars.get("/").toString(), "iLabWebCareers");
	
			   // Assert.assertTrue(true);
			    
			    
			    }


 @AfterMethod
 public void teardown(ITestResult result) throws IOException
 {
 if(result.getStatus()==ITestResult.FAILURE)
 {
	 test.log(Status.FAIL,"TEST CASE FAILED IS"+result.getName());
	 test.log(Status.FAIL,"TEST CASE FAILED IS"+result.getThrowable());
	 }else if(result.getStatus()==ITestResult.SKIP){
	 test.log(Status.SKIP,"Test Case SKIPPED IS"+result.getName());
	 }else if(result.getStatus()==ITestResult.SUCCESS){
	 test.log(Status.PASS,"Test Case PASSED IS" +result.getName());
	 }
 

}
}



