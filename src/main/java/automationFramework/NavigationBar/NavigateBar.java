package automationFramework.NavigationBar;

import org.openqa.selenium.support.PageFactory;

import automationFramework.Pages;
import automationFramework.Driver.Driver;
import automationFramework.WebElementPages.ComboBoxPage;
import automationFramework.WebPages.BatchManagerPage;
import automationFramework.WebPages.DealStatusQueuePage;
import automationFramework.WebPages.HelpPage;
import automationFramework.WebPages.TransactionsPage;

public class NavigateBar extends Pages{
	
	public static ComboBoxPage comboBoxPage;
	public static DealStatusQueuePage dealStatusQueuePage;
	public static BatchManagerPage batchManagerPage;
	public static TransactionsPage transactionsPage;
	public static HelpPage helpPage;
	private static UserProfileMenu userProfileMenu;
	private static NavigateBar navigateBar;
	private static UtilitiesMenu utilitiesMenu;
	private static ManageMenu manageMenu;

	// Search by Client Name or ID input combo box.
	public static ComboBoxPage comboBox() {
		comboBoxPage = PageFactory.initElements(Driver.instance, ComboBoxPage.class);
		return comboBoxPage;
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
		manageMenu = PageFactory.initElements(Driver.instance, ManageMenu.class);
		return manageMenu;
	}
	
	// Utilities menu
	public static UtilitiesMenu utilitiesMenu() {
		utilitiesMenu = PageFactory.initElements(Driver.instance, UtilitiesMenu.class);
		return utilitiesMenu;
	}
	
	// Help page
	public static HelpPage help() {
		helpPage = PageFactory.initElements(Driver.instance, HelpPage.class);
		return helpPage;
	}

	public static UserProfileMenu userProfileMenu() {
		userProfileMenu = PageFactory.initElements(Driver.instance, UserProfileMenu.class);
		return userProfileMenu;
	}

	public static NavigateBar click() {
		return new NavigateBar();
	}

}
