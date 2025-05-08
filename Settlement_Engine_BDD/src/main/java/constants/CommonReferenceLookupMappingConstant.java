package constants;

public enum CommonReferenceLookupMappingConstant {
	CLIENT_CODE("50"),
	BRAND_CODE("12");
	
	private final String value;
	CommonReferenceLookupMappingConstant(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
