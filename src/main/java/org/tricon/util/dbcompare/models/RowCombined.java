package org.tricon.util.dbcompare.models;

public class RowCombined {

	private String tbl1;
	
	private String tbl2;
	
	private String key1;
	
	private String key2;
	
	private String col1;
	
	private String col2;

	private Object value1;
	
	private Object value2;
	
	private boolean match;
	
	
	/*@Override
	public boolean equals(Object o){
		if(this==o)
			return true;
		if(o==null || o.getClass()!=this.getClass())
			return false;
		RowCombined r=(RowCombined) o;
		
		return (r.key1 !=null && this.key1 !=null && r.col1 !=null && this.col1 !=null && r.key1.equals(this.key1) && r.col1.equals(this.col1));
	}*/
	
	
	public String getTbl1() {
	
		return tbl1;
	}

	
	public void setTbl1(String tbl1) {
	
		this.tbl1 = tbl1;
	}

	
	public String getTbl2() {
	
		return tbl2;
	}

	
	public void setTbl2(String tbl2) {
	
		this.tbl2 = tbl2;
	}

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

	

	public boolean isMatch() {
		if(this.key1 !=null && ! this.key1.isEmpty() && this.key2 !=null && ! this.key2.isEmpty() && this.value1 !=null  
				&& this.value2 !=null  && this.key1.equals(this.key2) && this.value1.equals(this.value2)){
			match=true;
		}
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

	
	public Object getValue1() {
	
		return value1;
	}

	
	public void setValue1(Object value) {
	
		this.value1 = value;
	}

	
	public Object getValue2() {
	
		return value2;
	}

	
	public void setValue2(Object value2) {
	
		this.value2 = value2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RowCombined [");
		builder.append(" tbl1=");
		builder.append(tbl1);
		builder.append(" tbl2=");
		builder.append(tbl2);
		builder.append(" key1=");
		builder.append(key1);
		builder.append(", key2=");
		builder.append(key2);
		builder.append(", match=");
		builder.append(match);
		builder.append(", col1=");
		builder.append(col1);
		builder.append(", col2=");
		builder.append(col2);
		builder.append(", value1=");
		builder.append(value1);
		builder.append(", value2=");
		builder.append(value2);
		builder.append("]");
		return builder.toString();
	}
	
}
