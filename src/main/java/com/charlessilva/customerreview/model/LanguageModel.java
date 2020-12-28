package com.charlessilva.customerreview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "lang")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LanguageModel implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 2819932420794051351L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String isocode;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getIsocode()
	{
		return isocode;
	}

	public void setIsocode(String isocode)
	{
		this.isocode = isocode;
	}
}
