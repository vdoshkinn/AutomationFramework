package com.company.ui.steps;

import com.company.ui.pages.CreateEmailPage;
import com.company.ui.pages.EmailPage;
import com.company.ui.pages.MessagesListPage;
import org.openqa.selenium.WebDriver;

public class ValidationSteps extends Steps {
    private EmailPage emailPage;
    private CreateEmailPage createEmailPage;
    private MessagesListPage draftsPage;

    public ValidationSteps(WebDriver driver) {
        super.driver = driver;
        emailPage = new EmailPage(driver);
        createEmailPage = new CreateEmailPage(driver);
        draftsPage = new MessagesListPage(driver);
    }

    public void validateEmailIsDisplayed(String login) {
        waitForElement(emailPage.accountButton);
        validateText(login + "@mail.ru", emailPage.accountButton);
    }

    public void validateCreateMailPageIsDisplayed() {
        validateElementIsDisplayed(createEmailPage.toInput);
    }

    public void validateSaveConfirmationTextIsDisplayed() {
        validateElementIsDisplayed(createEmailPage.savedMessage);
    }

    public void validateSendConfirmationMessageIsDisplayed() {
        validateElementIsDisplayed(createEmailPage.sendConfirmationMessage);
    }

    public void checkCorrespondent(String to) {
        validateText(to, draftsPage.toValue);
    }

    public void checkSubject(String subject) {
        validateText(subject, draftsPage.subjectValue);
    }

    public void checkBody(String body) {
        validateText(body, draftsPage.bodyValue);
    }
}