package com.vaadin.testbenchexample;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ClaimsIT extends BaseLoginTest {

/*
    @Test
    public void addClaim() throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItem().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        waitUntil(driver -> getPolicy.isDisplayed(), 20);
//        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("GWL10413319");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("GWL10413319").click();
        NaviMenuView menu = $(NaviMenuView.class).first();
        menu.claims().click();
        ScenarioView claims = $(ScenarioView.class).first();
        claims.getAddClaimsButton().click();
        EntryDialogContent createClaim = $(EntryDialogContent.class).first();
        createClaim.addRundomCaseNumber();
        createClaim.getClaimType().selectByText("Death");
        LocalDate currentDate = createClaim.getReceivedDate().getDate();
        LocalDate newDate = currentDate.minusMonths(1);
        createClaim.getIncurredDate().setDate(newDate);
        createClaim.getClaimCause().selectByText("Colon Cancer - C18.9");
        createClaim.saveAndOpenButton().click();


    }

    @Test
    public void processClaim() throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItem().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 120);
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        waitUntil(driver -> getPolicy.isDisplayed(), 20);
//        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("GWL10413319");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("GWL10413319").click();
        NaviMenuView menu = $(NaviMenuView.class).first();
        menu.claims().click();
        ScenarioView claims = $(ScenarioView.class).first();
        claims.getClaim().getCell("87414").click();
        menu.processClaim().click();
        EntryDialogContent event = $(EntryDialogContent.class).first();
        event.getEventType().selectByText("Decision");
        event.okButton().click();
    }

    @Test
    public void payClaim() throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItem().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 120);
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        waitUntil(driver -> getPolicy.isDisplayed(), 20);
//        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("GWL10413319");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("GWL10413319").click();
        NaviMenuView menu = $(NaviMenuView.class).first();
        menu.claims().click();
        ScenarioView claims = $(ScenarioView.class).first();
        claims.getClaim().getCell("87414").click();
        menu.makePayment().click();
        EntryDialogContent payment = $(EntryDialogContent.class).first();
        payment.getPayee().selectByText("Olga Hopkins");
        payment.okButton().click();
        menu.policy().click();

    }

    @Test
    public void undoClaimPayment() throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItem().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 120);
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        waitUntil(driver -> getPolicy.isDisplayed(), 20);
//        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("GWL10413319");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("GWL10413319").click();
        NaviMenuView menu = $(NaviMenuView.class).first();
        menu.policyTransactions().click();
        ScenarioView transactions = $(ScenarioView.class).first();
        transactions.reverseSecondTransactionButton().click();
        waitUntil(driver -> $(VaadinDialogView.class).exists(), 120);
        VaadinDialogView confirm = $(VaadinDialogView.class).first();
        confirm.getConfirmButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);
        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinDialogView.class).exists(), 120);
        VaadinDialogView confirmDelete = $(VaadinDialogView.class).first();
        confirmDelete.getDeleteButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);

    }

    @Test
    public void processDenyClaim() throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItem().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 120);
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        waitUntil(driver -> getPolicy.isDisplayed(), 20);
//        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("GWL10413319");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("GWL10413319").click();
        NaviMenuView menu = $(NaviMenuView.class).first();
        menu.claims().click();
        ScenarioView claims = $(ScenarioView.class).first();
        claims.getClaim().getCell("87414").click();
        menu.processClaim().click();
        EntryDialogContent event = $(EntryDialogContent.class).first();
        event.getEventType().selectByText("Decision");
        EntryDialogContent denyClaim = $(EntryDialogContent.class).first();
        denyClaim.editDecision().click();
        EntryDialogContent decision = $(EntryDialogContent.class).last();
        decision.getClaimDecision().selectByText("Deny");
        decision.okButton().click();
        event.getDenialClaimReason().selectByText("Other");
        event.okButton().click();
        ScenarioView claimStatus = $(ScenarioView.class).first();
        Assertions.assertEquals("Denied", claimStatus.claimStatus().getText());

    }
*/
    @Test
    public void deathClaim() throws InterruptedException, IOException {
        VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
        getSelectButton.getSelectItemAccept().selectByText("Search Policy");
        waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        waitUntil(driver -> getPolicy.isDisplayed(), 20);
//        SearchComponentView getPolicy = $(SearchComponentView.class).first();
        getPolicy.searchByPolicy().sendKeys("GWL10413319");
        getPolicy.searchButton().click();
        getPolicy.family().getCell("GWL10413319").click();
        NaviMenuView menu = $(NaviMenuView.class).first();
        menu.claims().click();
        ScenarioView claims = $(ScenarioView.class).first();
        claims.getAddClaimsButton().click();
        EntryDialogContent createClaim = $(EntryDialogContent.class).first();
        createClaim.addRundomCaseNumber();
        createClaim.getClaimType().selectByText("Death");
        LocalDate currentDate = createClaim.getReceivedDate().getDate();
        LocalDate newDate = currentDate.minusMonths(1);
        createClaim.getIncurredDate().setDate(newDate);
 //       createClaim.getClaimCause().selectByText("Colon Cancer - C18.9");
        createClaim.saveAndOpenButton().click();
        menu.processClaim().click();
        EntryDialogContent event = $(EntryDialogContent.class).first();
        event.getEventType().selectByText("Decision");
        event.okButton().click();
        NaviMenuView payClaim = $(NaviMenuView.class).first();
        payClaim.makePayment().click();
        EntryDialogContent payment = $(EntryDialogContent.class).first();
        payment.getPayee().selectByText("Olga Hopkins");
        payment.okButton().click();
        NaviMenuView policyClaim = $(NaviMenuView.class).first();
        policyClaim.claimPolicy().click();
        policyClaim.policyTransactionsAccept().click();
        ScenarioView transactions = $(ScenarioView.class).first();
        transactions.reverseSecondTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
        confirm.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);
        transactions.deleteFirstTransactionButton().click();
        waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 120);
        VaadinConfirmDialogView confirmDelete = $(VaadinConfirmDialogView.class).first();
        confirmDelete.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);
        transactions.deleteFirstTransactionButton().click();
        VaadinConfirmDialogView delete = $(VaadinConfirmDialogView.class).first();
        delete.getSaveButton().click();
        waitUntil(driver -> !transactions.progressBar().isDisplayed(), 80);
        NaviMenuView denyClaims = $(NaviMenuView.class).first();
        denyClaims.claims().click();
        ScenarioView getClaims = $(ScenarioView.class).first();
        getClaims.getClaim().getCell("Approved").click();
        NaviMenuView deny = $(NaviMenuView.class).first();
        deny.processClaim().click();
        EntryDialogContent change = $(EntryDialogContent.class).first();
        change.getEventType().selectByText("Decision");
        EntryDialogContent denyClaim = $(EntryDialogContent.class).first();
        denyClaim.editDecision().click();
        EntryDialogContent decision = $(EntryDialogContent.class).last();
        decision.getClaimDecision().selectByText("Deny");
        decision.okButton().click();
        EntryDialogContent reason = $(EntryDialogContent.class).first();
        reason.getDenialClaimReason().selectByText("Other");
        reason.okButton().click();
        ScenarioView claimStatus = $(ScenarioView.class).first();
        Assertions.assertEquals("Denied", claimStatus.claimStatus().getText());

    }

}