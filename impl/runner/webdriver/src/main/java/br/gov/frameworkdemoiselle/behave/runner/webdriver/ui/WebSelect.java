package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.runner.ui.Select;

public class WebSelect extends WebBase implements Select {

	public void selectValue(String value) {
		if (getElements().get(0).getTagName().equals("select")) {
			// Select comum e usa um helper do selenium
			org.openqa.selenium.support.ui.Select lSelect = new org.openqa.selenium.support.ui.Select(getElements().get(0));
			lSelect.selectByVisibleText(value);
		} else {

			// Aguarda o primeiro elemento ser clicável
			waitElement(0);

			// Outros tipos de select como a do primefaces
			WebElement elementMain = getElements().get(0);
			elementMain.click();

			List<WebElement> elementValue = getElements().get(1).findElements(By.tagName("li"));
			for (WebElement item : elementValue) {
				if (item.getText().equals(value)) {
					// Aguarda o segundo elemento ser clicável
					waitElement(1);
					item.click();
					break;
				}
			}
		}

	}

}
