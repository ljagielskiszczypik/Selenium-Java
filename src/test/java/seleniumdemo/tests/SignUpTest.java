package seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import seleniumdemo.model.Model;
import seleniumdemo.pages.HotelSearchPage;
import seleniumdemo.pages.LoggedUserPage;
import seleniumdemo.pages.SignUpPage;
import seleniumdemo.utils.SeleniumHelper;
import java.io.IOException;
public class SignUpTest extends BaseTest{
    @Test
    public void signUpTest() throws IOException {
        ExtentTest test = extentReports.createTest("Sign up test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.clickSignUp(driver);
        test.log(Status.PASS,"Clicking sign up done", SeleniumHelper.getScreenshot(driver));
        SignUpPage signUpPage = new SignUpPage(driver);
        Model user = new Model();
        user.setFirstName("Łukasz");
        user.setLastName("Jagielski-Szczypik");
        user.setPhone("123456789");
        user.setEmail("lukas");
        user.setPassword("haslo123");
        signUpPage.setFirstName(user);
        test.log(Status.PASS,"Setting first name done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setLastName(user);
        test.log(Status.PASS,"Setting last name done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setPhone(user);
        test.log(Status.PASS,"Setting phone number done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setEmail(user);
        test.log(Status.PASS,"Setting email done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setPasword(user);
        test.log(Status.PASS,"Setting password done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setConfirmPassword(user);
        test.log(Status.PASS,"Confirming password done", SeleniumHelper.getScreenshot(driver));
        signUpPage.clickSubmit();
        test.log(Status.PASS,"Clicking submit button done", SeleniumHelper.getScreenshot(driver));
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        loggedUserPage.headingAssertion(driver);
        test.log(Status.PASS,"Assertion done", SeleniumHelper.getScreenshot(driver));
    }
    @Test
    public void signUpWithoutCredentialsTest() throws IOException {
        ExtentTest test = extentReports.createTest("Sign up without credentials test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.clickSignUp(driver);
        test.log(Status.PASS,"Clicking sign up done", SeleniumHelper.getScreenshot(driver));
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSubmit();
        test.log(Status.PASS,"Clicking submit button done", SeleniumHelper.getScreenshot(driver));
        signUpPage.assertionOfAlerts();
        test.log(Status.PASS,"Assertion done", SeleniumHelper.getScreenshot(driver));
    }
    @Test
    public void signUpWithIncorrectEmailTest() throws IOException {
        ExtentTest test = extentReports.createTest("Sign up without credentials test");
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.clickSignUp(driver);
        test.log(Status.PASS,"Clicking sign up done", SeleniumHelper.getScreenshot(driver));
        SignUpPage signUpPage = new SignUpPage(driver);
        Model user = new Model();
        user.setFirstName("Łukasz");
        user.setLastName("Jagielski-Szczypik");
        user.setPhone("123456789");
        user.setEmail("lukas");
        user.setPassword("haslo123");
        signUpPage.setFirstName(user);
        test.log(Status.PASS,"Setting first name done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setLastName(user);
        test.log(Status.PASS,"Setting last name done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setPhone(user);
        test.log(Status.PASS,"Setting phone number done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setIncorrectEmail(user);
        test.log(Status.PASS,"Setting incorrect email done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setPasword(user);
        test.log(Status.PASS,"Setting password done", SeleniumHelper.getScreenshot(driver));
        signUpPage.setConfirmPassword(user);
        test.log(Status.PASS,"Confirming password done", SeleniumHelper.getScreenshot(driver));
        signUpPage.clickSubmit();
        test.log(Status.PASS,"Clicking submit button done", SeleniumHelper.getScreenshot(driver));
        signUpPage.assertionOfIncorrectEmailAlert();
        test.log(Status.PASS,"Assertion done", SeleniumHelper.getScreenshot(driver));
    }
}
