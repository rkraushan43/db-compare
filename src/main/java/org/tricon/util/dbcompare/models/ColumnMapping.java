/**
 * 
 */
package org.tricon.util.dbcompare.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author raushan
 *
 */
@Entity
@Table(name = "columnmapping")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"})
public class ColumnMapping {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
	private Long requestId;
	
	@NotNull
	private String tbl1_name;
	
	@NotNull
	private String key1_name;
	
	@NotNull
	private String col1_name;
	
	@NotNull
	private String col1_type;
	
	@NotNull
	private String tbl2_name;
	
	@NotNull
	private String key2_name;
	
	@NotNull
	private String col2_name;
	
	@NotNull
	private String col2_type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getTbl1_name() {
		return tbl1_name;
	}

	public void setTbl1_name(String tbl1_name) {
		this.tbl1_name = tbl1_name;
	}

	public String getKey1_name() {
		return key1_name;
	}

	public void setKey1_name(String key1_name) {
		this.key1_name = key1_name;
	}

	public String getCol1_name() {
		return col1_name;
	}

	public void setCol1_name(String col1_name) {
		this.col1_name = col1_name;
	}

	public String getCol1_type() {
		return col1_type;
	}

	public void setCol1_type(String col1_type) {
		this.col1_type = col1_type;
	}

	public String getTbl2_name() {
		return tbl2_name;
	}

	public void setTbl2_name(String tbl2_name) {
		this.tbl2_name = tbl2_name;
	}

	public String getKey2_name() {
		return key2_name;
	}

	public void setKey2_name(String key2_name) {
		this.key2_name = key2_name;
	}

	public String getCol2_name() {
		return col2_name;
	}

	public void setCol2_name(String col2_name) {
		this.col2_name = col2_name;
	}

	public String getCol2_type() {
		return col2_type;
	}

	public void setCol2_type(String col2_type) {
		this.col2_type = col2_type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ColumnMapping [id=");
		builder.append(id);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", tbl1_name=");
		builder.append(tbl1_name);
		builder.append(", key1_name=");
		builder.append(key1_name);
		builder.append(", col1_name=");
		builder.append(col1_name);
		builder.append(", col1_type=");
		builder.append(col1_type);
		builder.append(", tbl2_name=");
		builder.append(tbl2_name);
		builder.append(", key2_name=");
		builder.append(key2_name);
		builder.append(", col2_name=");
		builder.append(col2_name);
		builder.append(", col2_type=");
		builder.append(col2_type);
		builder.append("]");
		return builder.toString();
	}
}
