package constants;

public enum DataSourceFileConstants {
	
	FILE_NAME("Test"),	
	FILE_PATTERN("Test"),	
	FILE_MAX_SIZE("30"),
	FILE_TABLE_NAME("Test_");	
	
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
