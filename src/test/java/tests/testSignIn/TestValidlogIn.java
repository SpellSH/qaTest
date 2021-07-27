package tests.testSignIn;

import org.testng.annotations.Test;
import tests.MainTest;
import utils.Session;

public class TestValidlogIn extends MainTest {

    @Test
    public void TestValidlogIn() throws InterruptedException {

        Session session = new Session(getWebDriver());
        session.getLoginPage().setCredentials(Email,Password);
        session.getLoginPage().validateSignIn(Login);
        }
    }


