package com.ach.login.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of="mbrSn")
public class Member {

	@Id @GeneratedValue
	private Integer mbrSn;
	
	@Column(unique = true)
	private String mbrName;

	public Member(String mbrName) {
		super();
		this.mbrName = mbrName;
	}
	
	
}
