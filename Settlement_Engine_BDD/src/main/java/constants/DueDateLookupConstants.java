package constants;

public enum DueDateLookupConstants {
	CLIENT_CODE("50"),
	DATA_SET("amd"),
	CAPITAL_TERMS(""),
	COMISSION_TERMS("11"),
	MOVEMENT_TYPE("987"),
	RULE_TYPE("5"),
	PRODUCE_CODE("us"),
	RULE_EXPRESSION("abc");
	
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
