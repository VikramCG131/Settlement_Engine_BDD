package constants;

import org.openqa.selenium.By;

public enum ClientLookUpConstants {
	PAYABLE_ELEMENT_2("500"),
	ADVANCE_COMMISSION("0.5"),
	SHOP_CODE("shop"),
	SHOPE_NAME("Test"),
	STATUS(""),
	DATA_SOURCE_TYPE("Automation");
	
	
	private final String value;
	ClientLookUpConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
