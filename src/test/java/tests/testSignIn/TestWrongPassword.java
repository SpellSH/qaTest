package tests.testSignIn;

import org.testng.annotations.Test;
import tests.MainTest;
import utils.Session;

public class TestWrongPassword extends MainTest {

    @Test
    public void TestWrongPassword() throws InterruptedException {

        Session session = new Session(getWebDriver());
        session.getLoginPage().setCredentials(Email, PasswordFail);
        session.getLoginPage().validateInvalidNotification(WrongPassOrEmail);
        }
    }


