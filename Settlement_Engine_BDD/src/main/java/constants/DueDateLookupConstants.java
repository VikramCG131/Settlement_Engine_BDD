package constants;

public enum DueDateLookupConstants {
	CLIENT_CODE("50"),
	DATA_SET("101"),
	CAPITAL_TERMS("Test"),
	COMISSION_TERMS("11"),
	MOVEMENT_TYPE("300"),
	RULE_TYPE("ABC"),
	PRODUCE_CODE("12"),
	RULE_EXPRESSION("12");
	
	private final String value;
	DueDateLookupConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
