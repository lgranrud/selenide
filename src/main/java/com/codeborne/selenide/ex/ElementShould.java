package com.codeborne.selenide.ex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.impl.Describe;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.ex.ErrorMessages.actualValue;

public class ElementShould extends UIAssertionError {
  public ElementShould(String searchCriteria, String prefix, Condition expectedCondition, WebElement element, Exception lastError, long timeoutMs) {
    this(searchCriteria, prefix, null, expectedCondition, element, lastError, timeoutMs);
  }
  public ElementShould(String searchCriteria, String prefix, String message, Condition expectedCondition, WebElement element, Throwable lastError, long timeoutMs) {
    super("Element should " + prefix + expectedCondition + " {" + searchCriteria + "}" + (message != null ? " because " + message : "") +
        "\nElement: '" + Describe.describe(element) + '\'' +
        actualValue(expectedCondition, element), timeoutMs, lastError);
  }

  @Override
  public String toString() {
    return getMessage();
  }
}
