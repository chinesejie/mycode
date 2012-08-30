package com.pocoer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * 这是与数据库对应的存储APIKey数据的实体类
 * @author roadahead
 */
@Entity
public class ExclusiveKey {
	private Long id;
	private String keyString;
	private Kebsite kebsite;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKeyString() {
		return keyString;
	}
	public void setKeyString(String keyString) {
		this.keyString = keyString;
	}
	@ManyToOne
	@JoinColumn(name="kebsiteid")
	public Kebsite getKebsite() {
		return kebsite;
	}
	public void setKebsite(Kebsite kebsite) {
		this.kebsite = kebsite;
	}
}
