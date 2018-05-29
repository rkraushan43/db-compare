package org.tricon.util.dbcompare.models;

public class RowCombined {

	private String key1;
	
	private String key2;
	
	private String strValue1;
	
	private String strValue2;
	
	private String col1;
	
	private String col2;

	private boolean match;
	
	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public String getStrValue1() {
		return strValue1;
	}

	public void setStrValue1(String strValue1) {
		this.strValue1 = strValue1;
	}

	public String getStrValue2() {
		return strValue2;
	}

	public void setStrValue2(String strValue2) {
		this.strValue2 = strValue2;
		if(this.key1 !=null && ! this.key1.isEmpty() && this.key2 !=null && ! this.key2.isEmpty() && this.strValue1 !=null  && ! this.strValue1.isEmpty()
				&& this.strValue2 !=null && ! this.strValue2.isEmpty() && this.key1.equals(this.key2) && this.strValue1.equals(this.strValue2)){
			match=true;
		}
	}

	public boolean isMatch() {
		return match;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

	
	public String getCol1() {
	
		return col1;
	}

	
	public void setCol1(String col1) {
	
		this.col1 = col1;
	}

	
	public String getCol2() {
	
		return col2;
	}

	
	public void setCol2(String col2) {
	
		this.col2 = col2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RowCombined [key1=");
		builder.append(key1);
		builder.append(", key2=");
		builder.append(key2);
		builder.append(", strValue1=");
		builder.append(strValue1);
		builder.append(", strValue2=");
		builder.append(strValue2);
		builder.append(", match=");
		builder.append(match);
		builder.append(", col1=");
		builder.append(col1);
		builder.append(", col2=");
		builder.append(col2);
		builder.append("]");
		return builder.toString();
	}
	
}
