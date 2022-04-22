package com.company.ui.tests;

import com.company.ui.models.Mail;
import com.company.ui.steps.EmailSteps;
import com.company.ui.steps.LoginSteps;
import com.company.ui.steps.ValidationSteps;
import com.company.ui.utils.PropertiesUtils;

import org.testng.annotations.*;


public class MailTest extends BaseTest {
    LoginSteps loginSteps = new LoginSteps(driver);
    EmailSteps emailSteps = new EmailSteps(driver);
    ValidationSteps validationSteps = new ValidationSteps(driver);

    private final String login = PropertiesUtils.getProperty("login");
    private final String password = PropertiesUtils.getProperty("password");


    @BeforeMethod
    public void before() throws InterruptedException {
        openMainPage();
        loginSteps.validateLoginFieldIsDisplayed();
        loginSteps.enterLogin(login);
        loginSteps.enterPassword(password);
        validationSteps.validateEmailIsDisplayed(login);
    }

    @DataProvider
    public Object[][] getMales() {
        Mail[][] result = new Mail[1][1];
        result[0][0] = new Mail("testerautotester@rambler.ru", "Autotest mail", "Hi!");
        return result;
    }

    @Test(dataProvider = "getMales")
    public void test01(Mail mail) {
        emailSteps.createEmail();
        validationSteps.validateCreateMailPageIsDisplayed();
        emailSteps.fillTo(mail.getTo());
        emailSteps.fillSubject(mail.getSubject());
        emailSteps.enterBody(mail.getBody());
        emailSteps.save();
        validationSteps.validateSaveConfirmationTextIsDisplayed();
        emailSteps.closeCreateMailPage();

        emailSteps.openDrafts();
        validationSteps.checkCorrespondent(mail.getTo());
        validationSteps.checkSubject(mail.getSubject());
        validationSteps.checkBody(mail.getBody());
    }

    @Test(dataProvider = "getMales")
    public void test02(Mail mail) {
        emailSteps.createEmail();
        validationSteps.validateCreateMailPageIsDisplayed();
        emailSteps.fillTo(mail.getTo());
        emailSteps.fillSubject(mail.getSubject());
        emailSteps.enterBody(mail.getBody());
        emailSteps.send();
        validationSteps.validateSendConfirmationMessageIsDisplayed();
        emailSteps.closeConfirmationPage();

        emailSteps.openSent();
        validationSteps.checkCorrespondent(mail.getTo());
        validationSteps.checkSubject(mail.getSubject());
        validationSteps.checkBody(mail.getBody());
    }

    @AfterMethod
    public void afterMethod() {
        emailSteps.logout();
        loginSteps.validateLoginFieldIsDisplayed();
        closeDriver();
    }

    @AfterSuite
    public void afterSuite() {
        quitDriver();
    }
}
