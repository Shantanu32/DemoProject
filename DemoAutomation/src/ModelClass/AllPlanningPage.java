package ModelClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllPlanningPage {
	WebDriver driver;
	public AllPlanningPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By pageTitle = By.xpath("//button[@id='dropdownMenuButton']");
	By detailButtonPrimary = By.xpath("//button[@id='detailButton']");
	By detailButtonSecondary = By.xpath("//button[@id='laneButton']");
	By searchBar = By.xpath("//planningunit-subheader-tab/div[1]/span[1]/div[1]/input[1]");
	By unitManagerDropdown = By.xpath("//span[contains(text(),'Unit Manager')]");
	By allUnitsDropdown = By.xpath("//planningunit-subheader-tab/div[1]/span[3]/kendo-dropdownlist[1]/span[1]/span[1]");
	By viewAllUnitsCheckbox = By.xpath("//planningunit-subheader-tab/div[1]/div[1]/label[1]");
	By downloadIcon = By.xpath("//planningunit-subheader-tab/div[1]/div[2]/span[1]/i[1]");
	By ellipsisIcon = By.xpath("//span[@id='dropdownMenuButton']");
	By newPlanButton = By.xpath("//a[contains(text(),'New Planning Unit')]");
	By unitcodeTextfield = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
	By unitTitleTextfield = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");
	By unitManagerNewBDropdown = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/lazy-dropdown[1]/button[1]");
    By unitTypeDropdown = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[2]/div[2]/kendo-dropdownlist[1]/span[1]/span[1]");
    By unitParentDropdown = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[3]/tree-view-dropdown[1]/div[1]/button[1]");
    By unitPurposeTextfield = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[4]/div[1]/kendo-editor[1]/div[1]/div[1]");
    By cancelButton = By.xpath("//button[contains(text(),'Cancel')]");
    By saveButton = By.xpath("//button[contains(text(),'Save')]");
    
    public boolean pageTitleIsDisplayed() {
		return driver.findElement(pageTitle).isDisplayed();
	}
    public boolean detailButtonPrimaryIsDisplayed() {
		return driver.findElement(detailButtonPrimary).isDisplayed();
	}
    public boolean detailButtonSecondaryIsDisplayed() {
		return driver.findElement(detailButtonSecondary).isDisplayed();
	}
    public boolean searchBarIsDisplayed() {
		return driver.findElement(searchBar).isDisplayed();
	}
    public boolean unitManagerDropdownIsDisplayed() {
		return driver.findElement(unitManagerDropdown).isDisplayed();
	}
    public boolean allUnitsDropdownIsDisplayed() {
		return driver.findElement(allUnitsDropdown).isDisplayed();
	}
    public boolean allUnitsCheckboxIsDisplayed() {
		return driver.findElement(viewAllUnitsCheckbox).isDisplayed();
	}
    public boolean downloadIconIsDisplayed() {
		return driver.findElement(downloadIcon).isDisplayed();
	}
    public boolean ellipsisIconIsDisplayed() {
		return driver.findElement(ellipsisIcon).isDisplayed();
	}
    public boolean unitcodeTextfieldIsDisplayed() {
		return driver.findElement(unitcodeTextfield).isDisplayed();
	}
    public boolean unitTitleTextfieldIsDisplayed() {
		return driver.findElement(unitTitleTextfield).isDisplayed();
	}
    public boolean unitManagerNewBDropdownIsDisplayed() {
		return driver.findElement(unitManagerNewBDropdown).isDisplayed();
	}
    public boolean unitTypeDropdownIsDisplayed() {
  		return driver.findElement(unitTypeDropdown).isDisplayed();
  	}
    public boolean unitParentDropdownIsDisplayed() {
  		return driver.findElement(unitParentDropdown).isDisplayed();
  	}
    public boolean unitPurposeTextfieldIsDisplayed() {
  		return driver.findElement(unitPurposeTextfield).isDisplayed();
  	}
    public boolean cancelButtonIsDisplayed() {
  		return driver.findElement(cancelButton).isDisplayed();
  	}
    public boolean saveButtonIsDisplayed() {
  		return driver.findElement(saveButton).isDisplayed();
  	}
    public void clickEllipsisIcon() {
		driver.findElement(ellipsisIcon).click();
	}
    public void clickNewPlan() {
		driver.findElement(newPlanButton).click();
	}
    public boolean cancelIsEnable() {
		return driver.findElement(cancelButton).isEnabled();
	}
    public boolean saveIsEnable() {
		return driver.findElement(saveButton).isEnabled();
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
