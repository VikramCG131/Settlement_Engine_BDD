package constants;

public enum BrandMappingConstants {
	CLIENT_CODE("50"),
	BRAND_CODE("12");
	
	private final String value;
	BrandMappingConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
