package constants;
 
public enum ClientMappingConstants {
	CLIENT_CODE("500"),
	SHOP_CODE("12"),
	MAPPED_CODE("123");
	private final String value;
	ClientMappingConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}