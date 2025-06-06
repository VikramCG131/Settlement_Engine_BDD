package constants;

import Utilities.CommonUtilities;

public enum SEGroupConfig {
	TEMPLATE_TYPE(""),
	EMAIL_ADDRESS("ab@gmail.com"),
	SUBJECT("TestAutomation"),
	INSERT_TEXT("Testing is in progress");
	
	private final String value;
	SEGroupConfig(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
