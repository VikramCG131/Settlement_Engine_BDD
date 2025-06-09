package constants;
	
	
	public enum SECalculationConstants {
		RULE_NAME("RULE_"),
		VARIABLE_NAME("var");
		
		private final String value;
		SECalculationConstants(String value)
		{
			this.value=value;
		}
		public String getValue()
		{
			return value;
		}
	}
