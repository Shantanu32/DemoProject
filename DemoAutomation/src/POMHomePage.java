import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMHomePage {
	WebDriver driver;
	public POMHomePage(WebDriver driver) {
		this.driver=driver;
	}
	By button= By.xpath("//body/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='inventory_container']/div[1]/div[1]/div[3]/select[1]");
	 
    public Boolean getButton(){
        Boolean status = driver.findElement(button).isDisplayed();
        return status;
    }

}
