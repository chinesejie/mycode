package com.pocoer.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * 这是与数据库对应的存储用户信息数据的实体类
 * @author roadahead
 */
@Entity
public class Kebsite {
	private Long id;
	private String kebsiteName;
	private Set<ExclusiveKey> exclusiveKey = new HashSet<ExclusiveKey>();
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKebsiteName() {
		return kebsiteName;
	}
	public void setKebsiteName(String kebsiteName) {
		this.kebsiteName = kebsiteName;
	}
	@OneToMany(mappedBy="kebsite",
			cascade={CascadeType.ALL}
	)
	public Set<ExclusiveKey> getExclusiveKey() {
		return exclusiveKey;
	}
	public void setExclusiveKey(Set<ExclusiveKey> exclusiveKey) {
		this.exclusiveKey = exclusiveKey;
	}
}
