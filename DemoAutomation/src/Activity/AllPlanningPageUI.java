package Activity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import ModelClass.AllPlanningPage;
import ModelClass.SpolLoginPage;

public class AllPlanningPageUI {
	WebDriver driver;
	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	

	public AllPlanningPageUI() {
		// TODO Auto-generated constructor stub
	}
	  @BeforeClass
	  private void setup() {
		  System.setProperty("webdriver.chrome.driver","E:\\Web automation\\chromedriver_win32\\chromedriver.exe");
		    driver= new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		    driver.get("http://diamondbetaauth.strategicplanningonline.com/Account/Login?returnUrl=http%3A%2F%2Fdiamondbeta.strategicplanningonline.com%2F");
		    homepage= new AllPlanningPage(driver);
			loginpage= new SpolLoginPage(driver);
			allPlanning= new AllPlanningPage(driver);
	  }
	  @Test(priority = 1)
	  public void testPlanningPage() throws InterruptedException {
		
		 
		  loginpage.typeEmailId("sreal");
		  Thread.sleep(2000);
		  loginpage.typePassword("sa123");
		  Thread.sleep(2000);
		  loginpage.clickSignIn();
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")));
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		  //Thread.sleep(3000);
		  SoftAssert softAssert =new SoftAssert();

		  //Verify.verify(allPlanning.pageTitleIsDisplayed());
		  softAssert.assertTrue(allPlanning.pageTitleIsDisplayed());
		  Verify.verify(allPlanning.detailButtonPrimaryIsDisplayed());
		  Verify.verify(allPlanning.detailButtonSecondaryIsDisplayed());
		  Verify.verify(allPlanning.searchBarIsDisplayed());
		  Verify.verify(allPlanning.unitManagerDropdownIsDisplayed());
		  Verify.verify(allPlanning.allUnitsDropdownIsDisplayed());
		  Verify.verify(allPlanning.allUnitsCheckboxIsDisplayed());
		  Verify.verify(allPlanning.downloadIconIsDisplayed());
		  Verify.verify(allPlanning.ellipsisIconIsDisplayed());
		
	
		  Thread.sleep(3000);
	
	  }
	  @Test(priority = 2)
	  public void testNewPlanningPage() throws InterruptedException {
		  allPlanning.clickEllipsisIcon();
		  Thread.sleep(2000);
		  allPlanning.clickNewPlan();
		  Thread.sleep(2000);
		  Verify.verify(allPlanning.unitcodeTextfieldIsDisplayed());
		  Verify.verify(allPlanning.unitTitleTextfieldIsDisplayed());
		  Verify.verify(allPlanning.unitManagerNewBDropdownIsDisplayed());
		  Verify.verify(allPlanning.unitTypeDropdownIsDisplayed());
		  Verify.verify(allPlanning.unitParentDropdownIsDisplayed());
		  Verify.verify(allPlanning.unitPurposeTextfieldIsDisplayed());
		  Verify.verify(allPlanning.cancelButtonIsDisplayed());
		  Verify.verify(allPlanning.saveButtonIsDisplayed());
		  Verify.verify(allPlanning.cancelIsEnable());
		  Verify.verify(!allPlanning.saveIsEnable());
		 
	      Thread.sleep(2000);
	 
	  }
	  @AfterClass
	  public void teardown() {
		  driver.close();
	  }

}
