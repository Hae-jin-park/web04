package com.study.vo;

public class Model {
	private String name;
	private String urn;
	private String id;
	
	public Model(String id, String name, String urn) {
		this.id=id;
		this.name=name;
		this.urn=urn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrn() {
		return urn;
	}

	public void setUrn(String urn) {
		this.urn = urn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
