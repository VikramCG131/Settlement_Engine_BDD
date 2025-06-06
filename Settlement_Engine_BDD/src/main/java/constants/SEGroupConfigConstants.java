package constants;

import Utilities.CommonUtilities;

public enum SEGroupConfigConstants {
	GROUP_NAME("GR");
	
	
	private final String value;
	SEGroupConfigConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
