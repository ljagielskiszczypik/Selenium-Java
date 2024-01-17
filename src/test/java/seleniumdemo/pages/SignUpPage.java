package seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import seleniumdemo.model.Model;
import java.util.List;
public class SignUpPage {
    private static final Logger logger = LogManager.getLogger();
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

    public void setFirstName(Model user){
        logger.info("setting first name");
        signUpInputFirstName.sendKeys(user.getFirstName());
        logger.info("setting first done");
    }
    public void setLastName(Model user){
        logger.info("setting last name");
        signUpInputLastName.sendKeys(user.getLastName());
        logger.info("setting last name done");
    }
    public void setPhone(Model user){
        logger.info("setting phone number");
        signUpInputPhone.sendKeys(user.getPhone());
        logger.info("setting phone number done");
    }
    public void setEmail(Model user){
        int randNumb =(int)(Math.random()* 1000);
        String email = user.getEmail() + randNumb + "@gmail.com";
        logger.info("setting email");
        signUpInputEmail.sendKeys(email);
        logger.info("setting email done");
    }
    public void setPasword(Model user){
        logger.info("setting password");
        signUpInputPasword.sendKeys(user.getPassword());
        logger.info("setting password done");
    }
    public void setConfirmPassword(Model user){
        logger.info("confirming password");
        signUpInputConfirmPasword.sendKeys(user.getPassword());
        logger.info("confirming password done");
    }
    public void clickSubmit(){
        logger.info("clicking sign up button");
        signUpButton.click();
        logger.info("clicking sign up button done");
    }
    public void assertionOfAlerts(){
        logger.info("starting assertion");
        Assert.assertEquals(alerts.get(0).getText(),"The Email field is required.");
        Assert.assertEquals(alerts.get(1).getText(),"The Password field is required.");
        Assert.assertEquals(alerts.get(2).getText(),"The Password field is required.");
        Assert.assertEquals(alerts.get(3).getText(),"The First name field is required.");
        Assert.assertEquals(alerts.get(4).getText(),"The Last Name field is required.");
        logger.info("assertion done");
    }
    public void setIncorrectEmail(Model user){
        int randNumb =(int)(Math.random()* 1000);
        String email = user.getEmail() + randNumb + ".pl";
        logger.info("setting incorrect email");
        signUpInputEmail.sendKeys(email);
        logger.info("setting incorrect email done");
    }
    public void assertionOfIncorrectEmailAlert(){
        logger.info("starting assertion");
        Assert.assertEquals(alerts.get(0).getText(),"The Email field must contain a valid email address.");
        logger.info("assertion done");
    }
}
