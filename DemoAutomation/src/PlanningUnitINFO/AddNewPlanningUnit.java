package PlanningUnitINFO;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import ModelClass.AllPlanningPage;
import ModelClass.SpolLoginPage;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AddNewPlanningUnit {
	WebDriver driver;
	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	
	
	
	HSSFWorkbook workbook;
	  //define an Excel Work sheet
    HSSFSheet sheet;
	  //define a test result data object
	  Map<String, Object[]> testresultdata;
	  public String Testcase; 
		public WritableSheet writablesh; 
		public WritableWorkbook workbookcopy;
	
	
	
	
  @Test
  public void f() throws InterruptedException, RowsExceededException, WriteException {
	  loginpage.typeEmailId("sreal");
	  Thread.sleep(2000);
	  loginpage.typePassword("sa123");
	  Thread.sleep(2000);
	  loginpage.clickSignIn();
	  WebDriverWait wait = new WebDriverWait(driver,50);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")));
	  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();
	  
	  Thread.sleep(2000);

	  driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();

	  WebDriverWait wait1 = new WebDriverWait(driver,50);

	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
	  Thread.sleep(3000);
	  
	  
	  
	  allPlanning.clickEllipsisIcon();
	  Thread.sleep(2000);
	  allPlanning.clickNewPlan();
	  Thread.sleep(2000);
	  try {
		  Verify.verify(allPlanning.unitcodeTextfieldIsDisplayed());
		  Testcase = "PASS";
		
		} catch (Exception e) {
			  Testcase = "Fail";

		}
	  Label l3=new Label(10,20,Testcase);
	  writablesh.addCell(l3);
	  
	  try {
		  Verify.verify(allPlanning.unitTitleTextfieldIsDisplayed());
		  Testcase = "PASS";
		
		} catch (Exception e) {
			  Testcase = "Fail";

		}
	  Label l4=new Label(10,21,Testcase);
	  writablesh.addCell(l4);
	  
	  
	  try {
		  Verify.verify(allPlanning.unitManagerNewBDropdownIsDisplayed());
		  Testcase = "PASS";
		
		} catch (Exception e) {
			  Testcase = "Fail";

		}
	  Label l5=new Label(10,22,Testcase);
	  writablesh.addCell(l5);
	  
	  
	  
	  try {
		  Verify.verify(allPlanning.unitTypeDropdownIsDisplayed());
		  Testcase = "PASS";
		
		} catch (Exception e) {
			  Testcase = "Fail";

		}
	  Label l6=new Label(10,23,Testcase);
	  writablesh.addCell(l6);
	  
	  
	  
	  Verify.verify(allPlanning.unitParentDropdownIsDisplayed());
	  Verify.verify(allPlanning.unitPurposeTextfieldIsDisplayed());
	  Verify.verify(allPlanning.cancelButtonIsDisplayed());
	  Verify.verify(allPlanning.saveButtonIsDisplayed());
	  Verify.verify(allPlanning.cancelIsEnable());
	  
		  Verify.verify(!allPlanning.saveIsEnable());
			
		
		      Thread.sleep(2000);
	  
	  
	  
	  
	  
	  
	 
  }
 
  @BeforeClass
  private void setup() throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException {
	  System.setProperty("webdriver.chrome.driver","E:\\Web automation\\chromedriver_win32\\chromedriver.exe");
	  
	  
	  
	  FileInputStream testfile = new FileInputStream("E:\\Web automation\\SPOL_TestCase_v1.0 (1).xls");//Now get 
		Workbook wbook = Workbook.getWorkbook(testfile);
		//Now get Workbook 
		Sheet sheets = wbook.getSheet("TestCase_PlanningUnit");
		int Norows = sheets.getRows();
		//Read rows and columns and save it in String Two dimensional array
		String inputdata[][] = new String[sheets.getRows()][sheets.getColumns()];
		System.out.println("Number of rows present in TestData xls file is -"+Norows);
		//For writing the data into excel we will use 
		FileOutputStream testoutput = new FileOutputStream("E:\\Web automation\\SPOL_Result.xls");
		//System.out.println("creating file one");
		//To Create writable workbook
		workbookcopy = Workbook.createWorkbook(testoutput);
		System.out.println("creating file 2");
		//To Create Writable sheet in Writable workbook
		writablesh = workbookcopy.createSheet("TestCase_PlanningUnit",0);
		System.out.println("creating file 3");

		//Using for loop to write all the data to new sheet 
		for(int i=0;i<sheets.getRows();i++) { 
		for(int k=0;k<sheets.getColumns();k++) {
		 inputdata[i][k] = sheets.getCell(k, i).getContents(); 
		Label l = new Label(k, i, inputdata[i][k]); 
		Label l2 = new Label(10,0,"Result"); 
		writablesh.addCell(l); 
		writablesh.addCell(l2); 

		            }

		        }
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	    driver= new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("http://diamondbetaauth.strategicplanningonline.com/Account/Login?returnUrl=http%3A%2F%2Fdiamondbeta.strategicplanningonline.com%2F");
	    homepage= new AllPlanningPage(driver);
		loginpage= new SpolLoginPage(driver);
		allPlanning= new AllPlanningPage(driver);
  }

  @AfterClass
  public void afterSuite() {
	  
	  
	  try { 
			workbookcopy.write(); 
			} catch (IOException e) { 
			e.printStackTrace(); 
			} 

			try { 
			workbookcopy.close(); 
			} catch (WriteException e) { 
			e.printStackTrace(); 
			} catch (IOException e) { 
			e.printStackTrace(); 
			     } 

	  driver.close();
	  driver.quit();

  }

}
