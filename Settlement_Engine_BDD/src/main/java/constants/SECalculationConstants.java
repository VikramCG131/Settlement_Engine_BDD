package constants;
	
	
	public enum SECalculationConstants {
		RULE_NAME("RULE_"),
		VARIABLE_NAME("Variable");
		
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
