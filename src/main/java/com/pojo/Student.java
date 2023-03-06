package com.pojo;


import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString
@JsonInclude (value=JsonInclude.Include.NON_EMPTY, content=Include.NON_NULL)
public final class Student {
	private int id;
	private String firstnatme;
	private String lastname;
	private String email;
}
