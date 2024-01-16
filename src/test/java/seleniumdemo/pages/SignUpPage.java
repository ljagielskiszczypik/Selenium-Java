package seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    }public void setPasword(String password){
        signUpInputPasword.sendKeys(password);
    }public void setConfirmPassword(String passwordConfirm){
        signUpInputConfirmPasword.sendKeys(passwordConfirm);
    }
    public void clickSubmit(){
        signUpButton.click();
    }


    //        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Łukasz");
//        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Jagielski-Szczypik");
//        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("123456789");
//        int randNumb =(int)(Math.random()* 1000);
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("lukas"+randNumb+"@gmail.com");
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("haslo123");
//        driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys("haslo123");
//        driver.findElement(By.xpath("//form[@id='headersignupform']/div[@class='form-group']/button")).click();
//        By headingLocator = By.xpath("//h3[@class='RTL']");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(headingLocator));
//        WebElement heading = driver.findElement(headingLocator);
//        Assert.assertEquals(heading.getText(),"Hi, Łukasz Jagielski-Szczypik");
}
