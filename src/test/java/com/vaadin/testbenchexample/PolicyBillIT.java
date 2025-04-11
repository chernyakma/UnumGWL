package com.vaadin.testbenchexample;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class PolicyBillIT extends BaseLoginTest {

    protected LocalDate initialPaidToDate;
    protected final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
    @Test
    public void suspense() throws InterruptedException {
        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItem().selectByText("Search Policy");
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("GWL10000209");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("GWL10000209").click();
        NaviMenuView getFamily = $(NaviMenuView.class).first();
        NaviMenuView addSuspense = $(NaviMenuView.class).first();
        addSuspense.policySuspense().click();
        ScenarioView addSuspenseButton = $(ScenarioView.class).first();
        addSuspenseButton.addSuspenceButton().click();
        EntryDialogContent suspenseSource = $(EntryDialogContent.class).first();
        suspenseSource.suspenseAmount().setValue("76.69");
        Assertions.assertEquals("76.69", suspenseSource.suspenseAmount().getValue());
        suspenseSource.suspenseSource().selectByText("Check");
        Assertions.assertEquals("Check", suspenseSource.suspenseSource().getSelectedText());
        suspenseSource.depositAccount().selectByText("General Premium");
        suspenseSource.processButton().click();
 //       ScenarioView checkSuspence = $(ScenarioView.class).first();
    }

    @Test
    public void payDirectBill() throws InterruptedException {
        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItem().selectByText("Search Policy");
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("GWL10000209");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("GWL10000209").click();
        NaviMenuView transaction = $(NaviMenuView.class).first();
        transaction.policyTransactions().click();
        ScenarioView premiumTransaction = $(ScenarioView.class).first();
        String originalDateText = premiumTransaction.policyPaidToDate().getText();
        initialPaidToDate = LocalDate.parse(originalDateText, formatter);
        premiumTransaction.addTransactionButton().click();
//        TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
        EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
        selectTransaction.transactionType().selectByText("Premium");
        EntryDialogContent premium = $(EntryDialogContent.class).first();
        premium.premiumAmount().sendKeys(Keys.chord(Keys.CONTROL, "a"), "76.69");
 //       premium.billingMonths().sendKeys(Keys.chord(Keys.CONTROL, "a"), "1");
 //       TransactionPopUpPageView notes = $(TransactionPopUpPageView.class).first();
        premium.notes().sendKeys("123");
        premium.okButton().click();
        ScenarioView processPremiumTransaction = $(ScenarioView.class).first();
        processPremiumTransaction.processInitialPremiumTransactionButton().click();
        Thread.sleep(3_000);
 //       VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        VaadinDialogView confirm = $(VaadinDialogView.class).first();
        confirm.getConfirmButton().click();
        ScenarioView transactionsPage = $(ScenarioView.class).first();

        waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 80);
        //       ScenarioView paidToDate = $(ScenarioView.class).first();
        String updatedText = transactionsPage.policyPaidToDate().getText();
        LocalDate updatedDate = LocalDate.parse(updatedText, formatter);

        Assertions.assertEquals(initialPaidToDate.plusMonths(3), updatedDate);

    }

    @Test
    public void payEFT() {

        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItem().selectByText("Search Policy");

        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("GWL10000689");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("GWL10000689").click();

        NaviMenuView transaction = $(NaviMenuView.class).first();
        transaction.policyTransactions().click();

        ScenarioView payPremium = $(ScenarioView.class).first();

        //flexible parser
        String originalDateText = payPremium.policyPaidToDate().getText();
        initialPaidToDate = parseFlexibleDate(originalDateText);

        //  Use flexible parser for input field too
        //      String currentDateString = payPremium.date().getInputValue();
        //       LocalDate currentDate = parseFlexibleDate(currentDateString);
        //       LocalDate newDate = currentDate.plusMonths(1);
        LocalDate originalDate = parseFlexibleDate(originalDateText);
        LocalDate newDate = originalDate.plusDays(1);
        payPremium.date().setDate(newDate);

        payPremium.cycle().click();
 //       VaadinConfirmDialogView cycleUp = $(VaadinConfirmDialogView.class).first();
        VaadinDialogView cycleUp = $(VaadinDialogView.class).first();
        cycleUp.getConfirmButton().click();
        waitUntil(driver -> !payPremium.progressBar().isDisplayed(), 80);
        String updatedText = payPremium.policyPaidToDate().getText();
//        System.out.println("Raw date string: '" + dateString + "'");

        LocalDate updatedDate = LocalDate.parse(updatedText, formatter);

        Assertions.assertEquals(initialPaidToDate.plusMonths(1), updatedDate);

    }

    protected LocalDate parseFlexibleDate(String dateString) {
        dateString = dateString.trim(); // 🔑 trims extra spaces

        List<DateTimeFormatter> formatters = List.of(
                DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH),   // "Sep 1, 2025"
                DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH),  // "September 1, 2025"
                DateTimeFormatter.ofPattern("M/d/yyyy")                       // "4/1/2025"
        );

        for (DateTimeFormatter f : formatters) {
            try {
                return LocalDate.parse(dateString, f);
            } catch (Exception ignored) {}
        }

        throw new IllegalArgumentException("Could not parse date: " + dateString);
    }

}



