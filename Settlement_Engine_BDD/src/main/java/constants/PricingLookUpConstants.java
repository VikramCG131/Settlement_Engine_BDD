package constants;

public enum PricingLookUpConstants {
	ACTIVE_FROM_DATE(""),
	CURRENCY("USD"),
	CLIENT_CODE("US"),
	PRODUCT_CODE("PR"),
	INSTALEMENTS("1"),
	OFFER_MONTHS("11"),
	LOAN_AMOUNT_MIN("1000"),
	LOAN_AMOUNT_MAX("10000"),
	RULE("AB"),
	COMM_SUB_PCT("0.5"),
	MIN_MAX_SUB_VAL("5"),
	CNTDWN_RATE_PCT("39"),
	MIN_CNTDWN_RATE_PCT("5"),
	CNTDWN_ADJUST("6"),
	THIRD_PARTY_1_ENCODING("8"),
	THIRD_PARTY_1_RATE("5"),
	THIRD_PARTY_2_ENCODING("6"),
	THIRD_PARTY_2_RATE("10"),
	THIRD_PARTY_3_ENCODING("8"),
	THIRD_PARTY_3_RATE("9"),
	VOL_BONUS_PCT("10"),
	HEAD_OFFICE_REBATE("9");
	
	
	private final String value;
	PricingLookUpConstants(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}
