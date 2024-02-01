package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.relevantcodes.extentreports.model.Author;

public class CustomerPage {
WebDriver driver;
public CustomerPage(WebDriver driver)
{
	this.driver=driver;
}
//define repository
@FindBy(xpath = "(//a[starts-with(text(),'Customers')])[2]")
WebElement ObjCustomer;
@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
WebElement ObjAddIcon;
@FindBy(xpath = "//input[@id='x_Customer_Number']")
WebElement ObjCustomerNum;
@FindBy(xpath = "//input[@id='x_Customer_Name']")
WebElement ObjCustomerName;
@FindBy(xpath = "//textarea[@id='x_Address']")
WebElement ObjAddress;
@FindBy(xpath = "//input[@id='x_City']")
WebElement ObjCity;
@FindBy(xpath = "//input[@id='x_Country']")
WebElement ObjCountry;
@FindBy(xpath = "//input[@id='x_Contact_Person']")
WebElement ObjContactPerson;
@FindBy(xpath = "//input[@id='x_Phone_Number']")
WebElement ObjPhoneNumber;
@FindBy(xpath = "//input[@id='x__Email']")
WebElement ObjEmail;
@FindBy(xpath = "//input[@id='x_Mobile_Number']")
WebElement ObjMobileNumber;
@FindBy(xpath = "//input[@id='x_Notes']")
WebElement ObjNotes;
@FindBy(xpath = "//button[@id='btnAction']")
WebElement ObjAddbtn;
@FindBy(xpath = "//button[normalize-space()='OK!']")
WebElement ObjConfirmOk;
@FindBy(xpath = "(//button[starts-with(text(),'OK')])[6]")
WebElement ObjAlertOk;
@FindBy(xpath = "//span[@data-caption='Search']")
WebElement ObjSearchPanel;
@FindBy(xpath = "//input[@id='psearch']")
WebElement ObjSearchtextbox;
@FindBy(xpath = "//button[@id='btnsubmit']")
WebElement ObjSearchbutton;
@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
WebElement Webtable;

//method for add customer

public boolean add_Customer(String Customername,String Address,String City,String Country,
		String ContactName,String PhoneNumber,String Email,String MobileNumber,String Notes) throws Throwable
{
	this.ObjCustomer.click();
	this.ObjAddIcon.click();
	String Exp_Num=this.ObjCustomerNum.getAttribute("value");
	this.ObjCustomerName.sendKeys(Customername);
	this.ObjAddress.sendKeys(Address);
	this.ObjCity.sendKeys(City);
	this.ObjCountry.sendKeys(Country);
	this.ObjContactPerson.sendKeys(ContactName);
	this.ObjPhoneNumber.sendKeys(PhoneNumber);
	this.ObjEmail.sendKeys(Email);
	this.ObjMobileNumber.sendKeys(MobileNumber);
	this.ObjNotes.sendKeys(Notes);
	this.ObjAddbtn.click();
	Thread.sleep(2000);
	this.ObjConfirmOk.click();
	Thread.sleep(2000);
	this.ObjAlertOk.click();
	if(!this.ObjSearchtextbox.isDisplayed())
	this.ObjSearchPanel.click();
	this.ObjSearchtextbox.clear();
	this.ObjSearchtextbox.sendKeys(Exp_Num);
	this.ObjSearchbutton.click();
	Thread.sleep(2000);
	String Act_Num=this.Webtable.getText();
	if(Act_Num.equals(Exp_Num))
	{
		Reporter.log("Customer Added Success::"+Exp_Num+" "+Act_Num,true);
		
		return true;
	}else
	{
		Reporter.log("Customer Added Fail::"+Exp_Num+" "+Act_Num,true);
		return false;
	}

	
	
	
	
	
}

}
