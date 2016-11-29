package jp.i2qi.jersey.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="MEMBER")
public class Member {

	@Id
	private Integer id;

	private String name;


}
