package constants;

public enum Element3MappingConstants {
	PRODUCT_CODE("500"),
	ELEMENT3_CODE("123");
	
	private final String value;
	Element3MappingConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
