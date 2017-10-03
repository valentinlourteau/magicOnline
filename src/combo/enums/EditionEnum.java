package combo.enums;

public enum EditionEnum {
	
	RAVNICA {
		@Override
		public String getLabel() {
			return "RAV";
		}
	};
	
	public abstract String getLabel();

}
