package com.entities.share;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

public class BaseEntity implements Serializable{
	/**  */
	private static final long serialVersionUID = 7120412449905249631L;

	private String id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public boolean copyProperties(Object source) {
		try {
			BeanUtils.copyProperties(this, source);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}