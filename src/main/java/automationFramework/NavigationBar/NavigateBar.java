package automationFramework.NavigationBar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import automationFramework.BasePageObject;
import automationFramework.Pages;
import automationFramework.Driver.Driver;
import automationFramework.WebElementPages.ComboBoxPage;
import automationFramework.WebPages.BatchManagerPage;
import automationFramework.WebPages.DealStatusQueuePage;
import automationFramework.WebPages.HelpPage;
import automationFramework.WebPages.LoginPage;
import automationFramework.WebPages.TransactionsPage;

public class NavigateBar extends Pages{
	
	public static DealStatusQueuePage dealStatusQueuePage;
	public static BatchManagerPage batchManagerPage;
	public static TransactionsPage transactionsPage;
	public static HelpPage helpPage;

	// Search by Client Name or ID input combo box.
	public static ComboBoxPage comboBox() {
		return new ComboBoxPage();
	}

	// DealStatuQueue page
	public static DealStatusQueuePage dealStatusQueue() {
		dealStatusQueuePage = PageFactory.initElements(Driver.instance, DealStatusQueuePage.class);
		return dealStatusQueuePage;
	}
	
	// BatchManager page
	public static BatchManagerPage batchManager() {
		batchManagerPage = PageFactory.initElements(Driver.instance, BatchManagerPage.class);
		return batchManagerPage;
	}

	// Transactions page
	public static TransactionsPage transactions() {
		transactionsPage = PageFactory.initElements(Driver.instance, TransactionsPage.class);
		return transactionsPage;
	}

	// Manage menu
	public static ManageMenu manage() {
		return new ManageMenu();
	}
	
	// Utilities menu
	public static UtilitiesMenu utilitiesMenu() {
		return new UtilitiesMenu();
	}
	
	// Help page
	public static HelpPage help() {
		helpPage = PageFactory.initElements(Driver.instance, HelpPage.class);
		return helpPage;
	}

}
