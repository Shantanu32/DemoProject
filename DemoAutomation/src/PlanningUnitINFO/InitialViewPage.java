package PlanningUnitINFO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
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
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class InitialViewPage {
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
	

	public InitialViewPage() {
		// TODO Auto-generated constructor stub
	}
	  @BeforeClass
	  private void setup() throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException{
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
	   
	  @Test(priority = 1)
	  public void testLogin() throws InterruptedException {
				 
		  loginpage.typeEmailId("sreal");
		  Thread.sleep(2000);
		  loginpage.typePassword("sa123");
		  Thread.sleep(2000);
		  loginpage.clickSignIn();
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")));
		  try {
			Assert.assertTrue(driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).isDisplayed());
		      //testresultdata.put("2", new Object[] {1d, "Check Login", "Login Success","Pass"});

		} catch (Exception e) {
		      //testresultdata.put("2", new Object[] {1d, "Check Login", "Login Success","Fail"});
		}
	  }
	  
	  
	  @Test(priority = 2)
	  public void testPlanningPage() throws InterruptedException, RowsExceededException, WriteException {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();

		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		  Thread.sleep(3000);
		  SoftAssert softAssert =new SoftAssert();

		  //Verify.verify(allPlanning.pageTitleIsDisplayed());
		  try {
			  softAssert.assertTrue(allPlanning.pageTitleIsDisplayed());
			  Testcase = "PASS";
			
			} catch (Exception e) {
				  Testcase = "Fail";

			}
		  Label l3=new Label(10,2,Testcase);
		  writablesh.addCell(l3);
		  try {
			  Verify.verify(allPlanning.detailButtonPrimaryIsDisplayed());
			  Testcase = "PASS";
			
			} catch (Exception e) {
				  Testcase = "Fail";

			}
		  Label l4=new Label(10,3,Testcase);
		  writablesh.addCell(l4);
		  
		  
		  try {
			  Verify.verify(allPlanning.detailButtonPrimaryIsDisplayed());
			  Testcase = "PASS";
			
			} catch (Exception e) {
				  Testcase = "Fail";

			}
		  Label l5=new Label(10,4,Testcase);
		  writablesh.addCell(l5);
		  try {
			  Verify.verify(allPlanning.detailButtonPrimaryIsDisplayed());
			  Testcase = "PASS";
			
			} catch (Exception e) {
				  Testcase = "Fail";

			}
		  Label l6=new Label(10,5,Testcase);
		  writablesh.addCell(l6);
		  try {
			  Verify.verify(allPlanning.detailButtonSecondaryIsDisplayed());
			  Testcase = "PASS";
			
			} catch (Exception e) {
				  Testcase = "Fail";

			}
		  Label l7=new Label(10,6,Testcase);
		  writablesh.addCell(l7);
		  
		  try {
			  Verify.verify(allPlanning.searchBarIsDisplayed());
			  Testcase = "PASS";
			
			} catch (Exception e) {
				  Testcase = "Fail";

			}
		  Label l8=new Label(10,7,Testcase);
		  writablesh.addCell(l8);
		  
		  
			  
			  Verify.verify(allPlanning.unitManagerDropdownIsDisplayed());
			  Verify.verify(allPlanning.allUnitsDropdownIsDisplayed());
			  Verify.verify(allPlanning.allUnitsCheckboxIsDisplayed());
			  Verify.verify(allPlanning.downloadIconIsDisplayed());
			  Verify.verify(allPlanning.ellipsisIconIsDisplayed());
			  Thread.sleep(3000);
		
			
	
	  }
	 
	
	  @AfterClass
	  public void teardown() {
		  
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
