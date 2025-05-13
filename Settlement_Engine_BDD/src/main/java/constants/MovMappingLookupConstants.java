package constants;

public enum MovMappingLookupConstants {
	MOVEMENT_TYPE(""),
	DESCRIPTION("12");
	
	private final String value;
	MovMappingLookupConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}

