package com.vaadin.testbenchexample;
import javax.swing.*;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import com.vaadin.flow.component.html.testbench.SpanElement;
import com.vaadin.flow.component.icon.testbench.IconElement;
import com.vaadin.flow.component.select.testbench.SelectElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.annotations.Attribute;
import com.vaadin.testbench.elementsbase.Element;
import org.openqa.selenium.WebElement;


@Element( "NAVI-MENU" )
//@Attribute(name="class",value="navi-item page-item")
public class NaviMenuView extends TestBenchElement {

	// main


	protected TestBenchElement getAddresses() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 5 );
	}
	protected TestBenchElement getAddressesAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 5 );
	}
	protected TestBenchElement getPolicy() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").first();
	}
	protected TestBenchElement getPolicyAccept() {

		return $( TestBenchElement.class ).id( "navi-menu").$( IconElement.class ).first();
	}
	protected TestBenchElement getSuspense() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 25 );
	}
	protected TestBenchElement getBankInformation() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get(3);
	}
	protected TestBenchElement getBankInformationAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 4 );
	}

	// Policy

	protected TestBenchElement getApplication() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 1 );
	}

	protected TestBenchElement getDocument() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 18 );
	}

	protected TestBenchElement beneficiaries() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 7);
	}
	protected TestBenchElement beneficiariesAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 10 );
	}
	protected TestBenchElement payorAndOwner() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 4 );
	}
	protected TestBenchElement payorAndOwnerAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get(4 );
	}
	protected TestBenchElement otherRoles() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 10 );
	}
	protected TestBenchElement otherRolesAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get(13 );
	}
	protected TestBenchElement getNewBusiness() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 30 );
	}
	protected TestBenchElement getFamily() {

		return $( TestBenchElement.class ).id( "navi-menu").$("IRON-ICON").last();
	}
	protected TestBenchElement getFamilyAccept() {

		return $( TestBenchElement.class ).id( "navi-menu").$( IconElement.class ).last();
	}
	protected TestBenchElement checkIGO() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 25 );
	}
	protected TestBenchElement claims() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 18 );
	}

	// Suspense

	protected TestBenchElement suspense() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 30 );
	}
	protected TestBenchElement groupSuspense() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 21 );
	}
	protected TestBenchElement policySuspense() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 30 );
	}
	protected TestBenchElement groupSuspenseAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 24 );
	}

	// Groups

	protected TestBenchElement groupBills() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 6 );
	}
	protected TestBenchElement getDivisions () {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 9 );
	}
	protected TestBenchElement groupBillsAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 9 );
	}

	// Transactions

	protected TestBenchElement transactionsWL() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 12 );
	}
	protected TestBenchElement transactions() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 24 );
	}
	protected TestBenchElement transactionsAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 30 );
	}
	protected TestBenchElement transactionsLoan() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 27 );
	}
	protected TestBenchElement transactionsLoanAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 30 );
	}

	protected TestBenchElement policyTransactionsAccept() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 33 );
	}
	protected TestBenchElement policyTransactions() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 24 );
	}
	//claims

	protected TestBenchElement processClaim() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 15 );
	}
	protected TestBenchElement makePayment() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 18 );
	}
	protected TestBenchElement policy() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 21 );
	}
	protected TestBenchElement claimPolicy() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 24 );
	}
}
