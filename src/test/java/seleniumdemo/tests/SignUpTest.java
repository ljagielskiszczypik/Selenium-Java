package seleniumdemo.tests;

import org.testng.annotations.Test;
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
        signUpPage.setFirstName("Łukasz");
        signUpPage.setLastName("Jagielski-Szczypik");
        signUpPage.setPhone("123456789");
        signUpPage.setEmail("lukas");
        signUpPage.setPasword("haslo123");
        signUpPage.setConfirmPassword("haslo123");
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
        signUpPage.setFirstName("Łukasz");
        signUpPage.setLastName("Jagielski-Szczypik");
        signUpPage.setPhone("123456789");
        signUpPage.setIncorrectEmail("lukas");
        signUpPage.setPasword("haslo123");
        signUpPage.setConfirmPassword("haslo123");
        signUpPage.clickSubmit();
        signUpPage.assertionOfIncorrectEmailAlert();
    }
}
