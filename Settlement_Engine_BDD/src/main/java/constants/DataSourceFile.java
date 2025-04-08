package constants;

public enum DataSourceFile {
	
	FILE_NAME("Test Automation"),
	FILE_TYPE("csv"),
	FILE_PATTERN("raw"),
	FILE_PATH_RAW("C://local"),
	FILE_PATH_CLEANSED("d://local"),
	FILE_MAX_SIZE("30"),
	FILE_TABLE_NAME("MetadataSourceFile"),
	FILE_DELIMETER(","),
	COLUMN_IDENTIFIER(",");
	
	
	private final String value;
	DataSourceFile(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
	

}
