package automationFramework.WebElementPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automationFramework.BasePageObject;

public class EditorPage extends BasePageObject {
	//Logger log = LoggerFactory.getLogger("EditorPage.class");

	private By editorLocator = By.id("tinymce");
	private By frame = By.tagName("iframe");

//	public EditorPage(WebDriver driver, Logger log) {
//		super(driver, log);
//	}

	/** Get text from TinyMCE WYSIWYG Editor */
	public String getEditorText() {
		switchToFrame(frame);
		String text = find(editorLocator).getText();
		log.info("Text from TinyMCE WYSIWYG Editor: " + text);
		return text;
	}

}
