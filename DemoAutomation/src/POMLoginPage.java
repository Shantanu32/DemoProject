import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMLoginPage {

	public POMLoginPage(WebDriver driver2) {
		this.driver=driver2;
	}
	WebDriver driver;

    By userName = By.xpath("//input[@id='user-name']");
 
    By password= By.xpath("//input[@id='password']");
 
    By loginButton= By.xpath("//input[@id='login-button']");
 
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
