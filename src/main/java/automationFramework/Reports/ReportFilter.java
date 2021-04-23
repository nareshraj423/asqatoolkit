package automationFramework.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.Driver.Driver;
import automationFramework.WebElementPages.ComboBoxPage;
import org.openqa.selenium.JavascriptExecutor;

public class ReportFilter extends ReportMenu {
	
	Logger log = LoggerFactory.getLogger("Report.class");

	private By fromLocator = By.xpath("//input[@id='from-date']");
	private By toLocator = By.xpath("//input[@id='to-date']");
	private By stateDropDownLocator = By.xpath("//ng-select[@id='state-filter']");
	private By clientDropdownLocator = By.xpath("//ng-select[@id='client']");
	private By applyButtonLocator = By.xpath("//button[contains(text(),'Apply')]");
	
	private String fromDate;
	private String toDate;
	private String state;
	private String client;
	
	public ReportFilter(ReportFilterBuilder reportFilterBuilder) {
		this.fromDate = reportFilterBuilder.fromDate;
		this.toDate = reportFilterBuilder.toDate;
		this.state = reportFilterBuilder.state;
		this.client = reportFilterBuilder.client;
	}
	
	public ReportFilter apply() {
		pressKey(fromLocator, Keys.CLEAR);
		type(fromDate, fromLocator);
		pressKey(toLocator, Keys.CLEAR);
		type(toDate, toLocator);
		//type(state, stateDropDownLocator);
		//search(stateDropDownLocator, state);
		//search(clientDropdownLocator, client);
		//type(client, clientDropdownLocator);
		click(applyButtonLocator);
		return this;
	}
	
	public static class ReportFilterBuilder{
		private String fromDate;
		private String toDate;
		private String state;
		private String client;
		
		
		public ReportFilterBuilder() {
			return;
		}
		
		public ReportFilterBuilder date(String fromDate, String toDate) {
			this.fromDate = fromDate;
			this.toDate = toDate;
			return this;
		}

		public ReportFilterBuilder state(String state) {
			this.state = state;
			return this;
		}
		
		public ReportFilterBuilder toDate(String toDate) {
			this.toDate = toDate;
			return this;
		}
		
		public ReportFilterBuilder client(String client) {
			this.client = client;
			return this;
		}
		
		public ReportFilter build() {
			return new ReportFilter(this);
		}	
	}
}
