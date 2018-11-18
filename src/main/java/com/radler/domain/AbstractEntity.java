package com.radler.domain;
import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(updatable = false)
protected int id;

public void setId(int id) {
	this.id = id;
}

public int getId() {
	return this.id;
}

}
