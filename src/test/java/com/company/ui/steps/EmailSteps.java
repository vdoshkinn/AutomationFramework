package com.company.ui.steps;

import com.company.ui.pages.CreateEmailPage;
import com.company.ui.pages.EmailPage;
import org.openqa.selenium.WebDriver;

public class EmailSteps extends Steps {
    private EmailPage emailPage;
    private CreateEmailPage createEmailPage;

    public EmailSteps(WebDriver driver) {
        super.driver = driver;
        emailPage = new EmailPage(driver);
        createEmailPage = new CreateEmailPage(driver);
    }

    public void createEmail() {
        waitForElement(emailPage.writeNewEmail).click();
    }

    public void fillTo(String to) {
        createEmailPage.toInput.sendKeys(to);
    }

    public void fillSubject(String subject) {
        createEmailPage.subjectInput.sendKeys(subject);
    }

    public void enterBody(String body) {
        createEmailPage.bodyInput.sendKeys(body);
    }

    public void save() {
        createEmailPage.saveButton.click();
    }

    public void send() {
        createEmailPage.sendButton.click();
    }

    public void closeCreateMailPage() {
        createEmailPage.closeCreatePageButton.click();
    }

    public void closeConfirmationPage() {
        createEmailPage.closeConfirmationButton.click();
    }

    public void openDrafts() {
        emailPage.draftsButton.click();
        waitForElementToBeSelected(emailPage.draftsButton);
    }

    public void openSent() {
        emailPage.sentMessagesButton.click();
        waitForElementToBeSelected(emailPage.sentMessagesButton);
    }

    public void logout() {
        emailPage.accountButton.click();
        waitForElement(emailPage.logout).click();
    }
}
