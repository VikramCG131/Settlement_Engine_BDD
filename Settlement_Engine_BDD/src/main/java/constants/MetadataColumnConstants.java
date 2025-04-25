package constants;

public enum MetadataColumnConstants {
	NAME("Test"),
	DATA_TYPE(""),
	IS_ACTIVE(""),
	IS_NULL(""),
	MIN_SIZE("5"),
	MAX_SIZE("30"),
	ORDER("5"),
	DATE_FORMAT("04/25/2025"),
	TABLE_NAME("metadata"),
	BUSINESS_NAME("ABC");
	
	
	private final String value;
	MetadataColumnConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
