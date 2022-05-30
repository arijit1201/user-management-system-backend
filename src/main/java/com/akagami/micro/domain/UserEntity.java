package com.akagami.micro.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//POJO  -> Plain old Java Object
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection="users")
public class UserEntity {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
}
