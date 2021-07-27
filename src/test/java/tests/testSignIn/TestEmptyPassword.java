package tests.testSignIn;

import org.testng.annotations.Test;
import tests.MainTest;
import utils.Session;

public class TestEmptyPassword extends MainTest {

    @Test
    public void Test() {

        Session session = new Session(getWebDriver());
        session.getLoginPage().setCredentials(Email, PasswordEmpty);
        session.getLoginPage().validatePasswordNotification(EmptyPassNote);
        }
    }


