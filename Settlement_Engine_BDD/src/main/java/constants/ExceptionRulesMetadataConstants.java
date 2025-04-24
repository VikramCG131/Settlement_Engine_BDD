package constants;

public enum ExceptionRulesMetadataConstants {
	RULE_TYPE("Lookup"),
	SEVERITY("Medium"),
	EXCEPTION_OWNERS("Test"),
	INPUT_SOURCE("tallyman_raw"),
	iNPUT_ATTRIBUTES("seq_no"),
	REFERENCE_FILE("client_map_lkp"),
	REFERENCE_FILE_ATTRIBUTES("status");

	
	private final String value;
	ExceptionRulesMetadataConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
