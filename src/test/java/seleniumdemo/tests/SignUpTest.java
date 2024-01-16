package seleniumdemo.tests;

import org.testng.annotations.Test;
import seleniumdemo.model.Model;
import seleniumdemo.pages.HotelSearchPage;
import seleniumdemo.pages.LoggedUserPage;
import seleniumdemo.pages.SignUpPage;
import java.time.Duration;
public class SignUpTest extends BaseTest{
    @Test
    public void signUpTest(){
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.clickSignUp(driver,Duration.ofSeconds(8));
        SignUpPage signUpPage = new SignUpPage(driver);
        Model user = new Model();
        user.setFirstName("Łukasz");
        user.setLastName("Jagielski-Szczypik");
        user.setPhone("123456789");
        user.setEmail("lukas");
        user.setPassword("haslo123");
        signUpPage.setFirstName(user);
        signUpPage.setLastName(user);
        signUpPage.setPhone(user);
        signUpPage.setEmail(user);
        signUpPage.setPasword(user);
        signUpPage.setConfirmPassword(user);
        signUpPage.clickSubmit();
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        loggedUserPage.headingAssertion(driver, Duration.ofSeconds(7));
    }
    @Test
    public void signUpWithoutCredentialsTest(){
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.clickSignUp(driver,Duration.ofSeconds(8));
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSubmit();
        signUpPage.assertionOfAlerts();
    }
    @Test
    public void signUpWithIncorrectEmailTest(){
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        hotelSearchPage.clickSignUp(driver,Duration.ofSeconds(8));
        SignUpPage signUpPage = new SignUpPage(driver);
        Model user = new Model();
        user.setFirstName("Łukasz");
        user.setLastName("Jagielski-Szczypik");
        user.setPhone("123456789");
        user.setEmail("lukas");
        user.setPassword("haslo123");
        signUpPage.setFirstName(user);
        signUpPage.setLastName(user);
        signUpPage.setPhone(user);
        signUpPage.setIncorrectEmail(user);
        signUpPage.setPasword(user);
        signUpPage.setConfirmPassword(user);
        signUpPage.clickSubmit();
        signUpPage.assertionOfIncorrectEmailAlert();
    }
}
