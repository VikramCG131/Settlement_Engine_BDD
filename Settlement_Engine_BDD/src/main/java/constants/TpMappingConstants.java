package constants;
 
public enum TpMappingConstants {
	ELM_CODE("500"),
	NAME("12");
	private final String value;
	TpMappingConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}