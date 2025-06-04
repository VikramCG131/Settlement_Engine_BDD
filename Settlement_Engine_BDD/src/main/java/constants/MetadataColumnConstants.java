package constants;

public enum MetadataColumnConstants {
	NAME("Test"),
	DATA_TYPE(""),
	ORDER("5"),
	MAX_SIZE("3"),
	BUSINESS_NAME("ABC"),
	IS_NULL(""),
	IS_KEY(""),
	IS_Serial("");
	
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
