package ModelClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpolLoginPage {

	public SpolLoginPage(WebDriver driver2) {
		this.driver=driver2;
	}
	WebDriver driver;

    By userName = By.xpath("//input[@id='Username']");
 
    By password= By.xpath("//input[@id='Password']");
 
    By loginButton= By.name("button");
 
    public void typeEmailId(String Id){
        driver.findElement(userName).sendKeys(Id);
    }
 
    public void typePassword(String PasswordValue){
        driver.findElement(password).sendKeys(PasswordValue);
    }
 
    public void clickSignIn(){
        driver.findElement(loginButton).click();
    }


}
