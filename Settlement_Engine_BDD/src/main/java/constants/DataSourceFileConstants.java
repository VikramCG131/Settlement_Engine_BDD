package constants;

public enum DataSourceFileConstants {
	
	FILE_NAME("Test"),
	FILE_TYPE(""),
	FILE_PATTERN("Test"),
	FILE_PATH_RAW(""),
	FILE_PATH_CLEANSED("d://local"),
	FILE_MAX_SIZE("30"),
	FILE_TABLE_NAME("Metadata"),
	FILE_DELIMETER(""),
	COLUMN_IDENTIFIER("Test2");
	
	
	private final String value;
	DataSourceFileConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
	

}
