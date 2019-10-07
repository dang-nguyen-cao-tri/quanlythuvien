package com.aureole.dto;

public class CategoryDTO extends AbstractDTO<CategoryDTO> {
	private String typeName;
	private String code;
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
