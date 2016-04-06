package Maven.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_inMaven {
	public WebDriver driver;
	public WebElement Ob1;
	String BaseUrl = "http://qa_thinh_publication_name_2b-bd.audiencemedia.com";
	String Valid_User = "admin"; 
	String Valid_Pass = "devteam";
	String Email = "thinh.luong+001@audiencemedia.com";
	
	@DataProvider
	public Object[][] userdata(){
		return new Object[][]{
				{"","b"},
				{"c",""},
				{"!@#$%","   "},
				{"",""},
		};
	}
	
  @Test (priority = 0, enabled = true, dataProvider = "userdata")
  public void Login_Invalid (String Invalid_User, String Invalid_Pass) {
	  Ob1 = driver.findElement(By.id("id1"));	  Ob1.sendKeys(Invalid_User);
	  Ob1 = driver.findElement(By.id("id2"));	  Ob1.sendKeys(Invalid_Pass);
	  Ob1.submit();
	  Ob1 = driver.findElement(By.cssSelector("div[class='message error']"));
	  Assert.assertTrue(Ob1.isDisplayed());
//	  System.out.println(Ob1.getText());  
  }

  @Test (priority=1, groups = "checka")
  /*@Parameters ({"Valid_UserB","Valid_PassB"})
    public void Login_Valid (String Valid_UserB, String Valid_PassB) {
	  Ob1 = driver.findElement(By.id("id1"));	  Ob1.sendKeys(Valid_UserB);
	  Ob1 = driver.findElement(By.id("id2"));	  Ob1.sendKeys(Valid_PassB);
	--> This use to run from xml with Parameters  
*/	  
  public void Login_Valid () {
	  Ob1 = driver.findElement(By.id("id1"));	  Ob1.sendKeys(Valid_User);
	  Ob1 = driver.findElement(By.id("id2"));	  Ob1.sendKeys(Valid_Pass);
	  Ob1.submit();
	  Ob1 = driver.findElement(By.cssSelector("div[class='panel-1-header']>h1"));
	  Assert.assertTrue(Ob1.isDisplayed());
//	  System.out.println(Ob1.getText());
	  
//	  Ob1 = driver.findElement(By.linkText("CONTENT"));
//	  Actions action = new Actions(driver);
//	  action.moveToElement(Ob1).build().perform();
//	  driver.findElement(By.linkText("Issues")).click();
	}

  
  @Test (priority = 2, enabled=true)
  public void Forgot_password () {
	  Ob1 = driver.findElement(By.linkText("Forgot your password?"));	  Ob1.click();
	  
	  //Check Login button
	  Ob1 = driver.findElement(By.linkText("Login"));	  Ob1.click();
	  driver.navigate().back();
	  System.out.println(driver.getCurrentUrl());
	  
	  //Check Generate New Password
	  Ob1 = driver.findElement(By.cssSelector("input[class='textbox w100 gt2']"));	  Ob1.sendKeys(Email);
	  Ob1 = driver.findElement(By.cssSelector("input[class='fbutton b2 fl']"));	  Ob1.click();
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get(BaseUrl + "/admin");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  @AfterMethod
  public void afterMethod() {
//	  try {
//		Ob1=driver.findElement(By.cssSelector("div[class=\"message error\"]"));
////		Assert.assertEquals(Ob1.getText(), "A valid username and password is required to login.");
//		System.out.println(Ob1.getText());  
//		  } catch (Exception e) {
//			  System.out.println("No error message");
//		  }
	  //	  @@@ If clause will cause failed @@@
//	  if (driver.findElement(By.cssSelector("div[class=\"message error\"]")).isDisplayed()) {
//		System.out.println("Detected error message!");
//	} else {
//		System.out.println("OK");
//	} ==> This will get error because driver can't find out the Element
//	  driver.quit();
	  
	  System.out.println("\n---------------NGON LANH CANH DAO---------------\n");
//	  driver.close();
	  driver.quit();
  }
}
