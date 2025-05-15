package constants;

import Utilities.CommonUtilities;

public enum EmailAlertConstants {
	TEMPLATE_TYPE(""),
	EMAIL_ADDRESS("ab@gmail.com"),
	SUBJECT("TestAutomation"),
	INSERT_TEXT("Testing is in progress");
	
	private final String value;
	EmailAlertConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
