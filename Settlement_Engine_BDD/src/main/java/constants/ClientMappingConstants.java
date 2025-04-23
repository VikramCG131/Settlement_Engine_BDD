package constants;
 
public enum ClientMappingConstants {
	CLIENT_CODE("500"),
	SHOP_CODE("Test"),
	MAPPED_CODE("SHOP");
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