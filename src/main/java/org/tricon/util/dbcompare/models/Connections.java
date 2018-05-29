/**
 * 
 */
package org.tricon.util.dbcompare.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author raushan
 *
 */

@Entity
@Table(name = "connections")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"})
public class Connections {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
	private Long requestId;
	
	@NotNull
	private String db1_provider;
	
	@NotNull
	private String db2_provider;
	
	@NotNull
	private String db1_url;
	
	@NotNull
	private String db2_url;
	
	@NotNull
	private String db1_name;
	
	@NotNull
	private String db2_name;
	
	@NotNull
	private String db1_username;
	
	@NotNull
	private String db2_username;
	
	@NotNull
	private String db1_password;
	
	@NotNull
	private String db2_password;
	

   /* @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;*/

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

	public String getDb1_provider() {
		return db1_provider;
	}

	public void setDb1_provider(String db1_provider) {
		this.db1_provider = db1_provider;
	}

	public String getDb2_provider() {
		return db2_provider;
	}

	public void setDb2_provider(String db2_provider) {
		this.db2_provider = db2_provider;
	}

	
	
	public String getDb1_url() {
		return db1_url;
	}

	public void setDb1_url(String db1_url) {
		this.db1_url = db1_url;
	}

	public String getDb2_url() {
		return db2_url;
	}

	public void setDb2_url(String db2_url) {
		this.db2_url = db2_url;
	}

	public String getDb1_name() {
		return db1_name;
	}

	public void setDb1_name(String db1_name) {
		this.db1_name = db1_name;
	}

	public String getDb2_name() {
		return db2_name;
	}

	public void setDb2_name(String db2_name) {
		this.db2_name = db2_name;
	}

	public String getDb1_username() {
		return db1_username;
	}

	public void setDb1_username(String db1_username) {
		this.db1_username = db1_username;
	}

	public String getDb2_username() {
		return db2_username;
	}

	public void setDb2_username(String db2_username) {
		this.db2_username = db2_username;
	}

	public String getDb1_password() {
		return db1_password;
	}

	public void setDb1_password(String db1_password) {
		this.db1_password = db1_password;
	}

	public String getDb2_password() {
		return db2_password;
	}

	public void setDb2_password(String db2_password) {
		this.db2_password = db2_password;
	}

	/*public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}*/

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Connections [id=");
		builder.append(id);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", db1_provider=");
		builder.append(db1_provider);
		builder.append(", db2_provider=");
		builder.append(db2_provider);
		builder.append(", db1_url=");
		builder.append(db1_url);
		builder.append(", db2_url=");
		builder.append(db2_url);
		builder.append(", db1_name=");
		builder.append(db1_name);
		builder.append(", db2_name=");
		builder.append(db2_name);
		builder.append(", db1_username=");
		builder.append(db1_username);
		builder.append(", db2_username=");
		builder.append(db2_username);
		builder.append(", db1_password=");
		builder.append(db1_password);
		builder.append(", db2_password=");
		builder.append(db2_password);
		/*builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);*/
		builder.append("]");
		return builder.toString();
	}
	
}
