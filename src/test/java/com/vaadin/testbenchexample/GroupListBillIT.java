package com.vaadin.testbenchexample;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import com.vaadin.flow.component.grid.testbench.GridElement;
import com.vaadin.testbench.TestBenchElement;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

public class GroupListBillIT extends BaseLoginTest {
	protected LocalDate initialPaidToDate;
	protected final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);

	@Test
	public void addManualGroupBill() throws InterruptedException {
		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItemAccept().selectByText("Search Group");
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getGroup = $(SearchComponentView.class).first();
		getGroup.searchByGroup().sendKeys("00638100");
		getGroup.searchButton().click();
		getGroup.family().getCell("00638100").click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactionsAccept().click();
		ScenarioView groupTransaction = $(ScenarioView.class).first();
		groupTransaction.addGroupTransactionButton().click();
//		EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText( "Group Manual Bill" );
		TransactionPopUpPageView effectDate=$(TransactionPopUpPageView.class).first();
		effectDate.effectiveDate().setDate(LocalDate.now());
		EntryDialogContent transaction1 = $(EntryDialogContent.class).first();

		transaction1.okButton().click();
		ScenarioView processManualBillTransaction = $(ScenarioView.class).first();
		processManualBillTransaction.processFirstTransactionButton().click();
		Thread.sleep( 3_000 );
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getSaveButton().click();

		ScenarioView transactionsPage = $(ScenarioView.class).first();
		waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 80);
//		System.out.println(transactionsPage.transactionStatus().getCell("Active").getText());
//		Assertions.assertFalse(transactionsPage.transactionStatus().getCell("Pending").isDisplayed());
		Assertions.assertTrue(transactionsPage.transactionStatus().getCell("Active").isDisplayed());

	}
	@Test
	public void suspense() throws InterruptedException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItemAccept().selectByText("Search Group");
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getGroup = $( SearchComponentView.class ).first();
		getGroup.searchByGroup().sendKeys( "00638100" );
		getGroup.searchButton().click();
		getGroup.family().getCell( "00638100" ).click();
		NaviMenuView addSuspense = $( NaviMenuView.class ).first();
		addSuspense.groupSuspenseAccept().click();
		ScenarioView addSuspenseButton = $( ScenarioView.class ).first();
		addSuspenseButton.addSuspenceButton().click();
		EntryDialogContent suspenseSource = $( EntryDialogContent.class ).first();
		suspenseSource.suspenseAmountAccept().setValue( "489.85" );
		Assertions.assertEquals( "489.85",suspenseSource.suspenseAmountAccept().getValue() );
		suspenseSource.suspenseSourceAccept().selectByText( "Check" );
		Assertions.assertEquals( "Check",suspenseSource.suspenseSourceAccept().getSelectedText() );
		suspenseSource.depositAccountAccept().selectByText( "General Premium" );
		suspenseSource.processButton().click();
		ScenarioView checkSuspence=$(ScenarioView.class).first();
//				Assertions.assertEquals( "$100,000.00",checkSuspence.suspenceBalance().getText() );

		checkSuspence.transferSuspenceButton().click();

		EntryDialogContent transferSuspence = $(EntryDialogContent.class).first();
		transferSuspence.fromAccountAccept().selectByText("General Premium");

		//	EntryDialogContent transferSuspenceTo = $(EntryDialogContent.class).first();
		//	transferSuspence.note().sendKeys( "123" );
		//	transferSuspence.toAccount().focus();
		transferSuspence.toAccountAccept().selectByText( "Group" );
		transferSuspence.searchFamily().sendKeys( "00638100" );
		transferSuspence.search().doubleClick();
		transferSuspence.family().getCell( "00638100" ).click();
		transferSuspence.toAccountAccept().selectByText( "List Bill" );
		transferSuspence.transferAmountAccept().setValue( "489.85" );
		Assertions.assertEquals( "489.85",transferSuspence.transferAmountAccept().getValue() );
//		transferSuspence.transferEffectveDate().setDate( LocalDate.now() );
//		transferSuspence.note().sendKeys( "transfer" );
		transferSuspence.okButton().click();
//		ScenarioView suspenceAmount=$(ScenarioView.class).first();

	}

	@Test
	public void payListBill()throws InterruptedException, IOException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItemAccept().selectByText("Search Group");
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getGroup = $( SearchComponentView.class ).first();
		getGroup.searchByGroup().sendKeys( "00638100" );
		getGroup.searchButton().click();
		getGroup.family().getCell( "00638100" ).click();
		NaviMenuView getDevivsions=$(NaviMenuView.class).first();
		getDevivsions.getDivisions().click();
		ScenarioView getPaidToDate = $(ScenarioView.class).first();
//		System.out.println(getPaidToDate.paidToDate().getText());
        String originalDateText = getPaidToDate.paidToDate().getText();
        initialPaidToDate = LocalDate.parse(originalDateText, formatter);

		NaviMenuView groupBills = $( NaviMenuView.class ).first();
		groupBills.groupBillsAccept().click();
		ScenarioView bills=$(ScenarioView.class).first();
		bills.bill().getCell("Unpaid").click();
		bills.receivedAsBilledAccept().click();
		bills.reconcileAccept().click();
		Thread.sleep(3_000);
		bills.suspenseFundingAccept().click();

		EntryDialogContent suspenseFunding = $(EntryDialogContent.class).first();
		suspenseFunding.autoFund().click();

		suspenseFunding.okFundButton().click();
		ScenarioView payBill = $(ScenarioView.class).first();
		payBill.processBillAccept().click();
		waitUntil(driver -> $(VaadinConfirmDialogView.class).exists(), 80);
//		Thread.sleep(3_000);
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getSaveButton().click();
		ScenarioView process = $(ScenarioView.class).first();
		waitUntil(driver -> process.billInfo().isDisplayed(),80);
//		Thread.sleep(50_000);
		NaviMenuView devivsions=$(NaviMenuView.class).first();
		getDevivsions.getDivisions().click();
		ScenarioView paidToDate = $(ScenarioView.class).first();
		String updatedText = paidToDate.paidToDate().getText();
		LocalDate updatedDate = LocalDate.parse(updatedText, formatter);

		Assertions.assertEquals(initialPaidToDate.plusMonths(1), updatedDate);
	}
/*
	@Test
	public void addLoan() throws InterruptedException, IOException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");;
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "08D7444033" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "08D7444033" ).click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactionsLoan().click();
		ScenarioView loanTransaction = $(ScenarioView.class).first();
		loanTransaction.addTransactionButton().click();
		EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
//		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText( "Loan" );
		EntryDialogContent loan = $(EntryDialogContent.class).first();
		loan.loanAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "300" );
		loan.loanAmount().sendKeys("300");
		loan.specialHandling().click();
		loan.specialHandling().selectByText("None");
//		loan.disbursementMethod().selectByText( "Check Disbursement" );
//		Assertions.assertEquals( "1,000.00",loan.loanAmount().getValue() );
		Thread.sleep( 5_000 );
		loan.approved().click();
		loan.okButton().click();
//		NaviMenuView seeTransaction = $(NaviMenuView.class).first();
//		seeTransaction.getResult().click();

		ScenarioView processLoanTransaction = $(ScenarioView.class).first();
		processLoanTransaction.processInitialPremiumTransactionButton().click();
		VaadinDialogView confirm = $(VaadinDialogView.class).first();
		confirm.getConfirmButton().click();
		ScenarioView transactionsPage = $(ScenarioView.class).first();
		waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 80);

		NaviMenuView policy = $(NaviMenuView.class).first();
		policy.getPolicy().click();
		ScenarioView policyPage = $(ScenarioView.class).first();
		Assertions.assertEquals( "300.00",policyPage.loanBalance().getValue());
		NaviMenuView transactions = $(NaviMenuView.class).first();
		transactions.transactionsLoan().click();
		ScenarioView deleteTransaction = $(ScenarioView.class).first();
		deleteTransaction.reverseLoanTransactionButton().click();
		VaadinDialogView ok = $(VaadinDialogView.class).first();
		ok.getConfirmButton().click();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);
		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		deleteLoanTransaction.deleteLoanTransactionButton().click();
		VaadinDialogView confirmation = $(VaadinDialogView.class).first();
		confirmation.getConfirmButton().click();

	}


	@Test
	public void addRider() throws InterruptedException, IOException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");;
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys("08D9229851" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "08D9229851" ).click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactions().click();
		ScenarioView loanTransaction = $(ScenarioView.class).first();
		loanTransaction.addTransactionButton().click();
		EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
	//	TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText( "Add Rider" );
		EntryDialogContent addRider = $(EntryDialogContent.class).first();
		addRider.coverageName().selectByText("Children's Term");
		addRider.faceAmount().setValue("5000");
	//	addRider.faceAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "5000" );
		Assertions.assertEquals("5,000.00",addRider.faceAmount().getValue());
	//	TransactionPopUpPageView notes = $(TransactionPopUpPageView.class).first();
	//	addRider.notes().sendKeys( "123" );
		addRider.issueAge().click();
		addRider.okButton().click();
		ScenarioView processTransaction = $(ScenarioView.class).first();
		processTransaction.processInitialPremiumTransactionButton().click();
		VaadinDialogView confirm = $(VaadinDialogView.class).first();
		confirm.getConfirmButton().click();
		ScenarioView transactionsPage = $(ScenarioView.class).first();
		waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 60);

		Assertions.assertEquals( "$ 16.90",transactionsPage.modalPremium().getText() );


		ScenarioView deleteTransaction = $(ScenarioView.class).first();
		deleteTransaction.reverseAddRiderTransactionButton().click();
		VaadinDialogView ok = $(VaadinDialogView.class).first();
		ok.getConfirmButton().click();
		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);

//		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		deleteLoanTransaction.deleteLoanTransactionButton().click();
		VaadinDialogView confirmation = $(VaadinDialogView.class).first();
		confirmation.getConfirmButton().click();


	}
*/
}
