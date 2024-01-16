package seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SignUpPage {
    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement signUpInputFirstName;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement signUpInputLastName;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement signUpInputPhone;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement signUpInputEmail;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement signUpInputPasword;
    @FindBy(xpath = "//input[@name='confirmpassword']")
    private WebElement signUpInputConfirmPasword;
    @FindBy(xpath = "//form[@id='headersignupform']/div[@class='form-group']/button")
    private WebElement signUpButton;
    @FindBy(xpath = "//div[@id='login']//p")
    List<WebElement> alerts;

    public void setFirstName(String name){
        signUpInputFirstName.sendKeys(name);
    }
    public void setLastName(String lastName){
        signUpInputLastName.sendKeys(lastName);
    }
    public void setPhone(String phone){
        signUpInputPhone.sendKeys(phone);
    }
    public void setEmail(String emailname){
        int randNumb =(int)(Math.random()* 1000);
        String email = emailname + randNumb + "@gmail.com";
        signUpInputEmail.sendKeys(email);
    }
    public void setPasword(String password){
        signUpInputPasword.sendKeys(password);
    }
    public void setConfirmPassword(String passwordConfirm){
        signUpInputConfirmPasword.sendKeys(passwordConfirm);
    }
    public void clickSubmit(){
        signUpButton.click();
    }
    public void assertionOfAlerts(){
        Assert.assertEquals(alerts.get(0).getText(),"The Email field is required.");
        Assert.assertEquals(alerts.get(1).getText(),"The Password field is required.");
        Assert.assertEquals(alerts.get(2).getText(),"The Password field is required.");
        Assert.assertEquals(alerts.get(3).getText(),"The First name field is required.");
        Assert.assertEquals(alerts.get(4).getText(),"The Last Name field is required.");
    }
    public void setIncorrectEmail(String emailname){
        int randNumb =(int)(Math.random()* 1000);
        String email = emailname + randNumb + ".pl";
        signUpInputEmail.sendKeys(email);
    }
    public void assertionOfIncorrectEmailAlert(){
        Assert.assertEquals(alerts.get(0).getText(),"The Email field must contain a valid email address.");
    }
}
