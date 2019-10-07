package com.aureole.dto;

public class AbstractDTO<T> {
	private int id;
	public AbstractDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
