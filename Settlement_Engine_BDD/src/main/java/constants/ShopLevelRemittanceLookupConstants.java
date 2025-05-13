package constants;
 
public enum ShopLevelRemittanceLookupConstants {
	PAYABLE_EL2("500"),
	SHOP_CODE("12"),
	ADVICE_ENTITY("123");
	private final String value;
	ShopLevelRemittanceLookupConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}