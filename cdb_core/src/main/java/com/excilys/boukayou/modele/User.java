package com.excilys.boukayou.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	

		@Id
		@Column(name = "id")
		private long id;

		@Column(name = "name")
		private String name;
		
		@Column(name = "password")
		private String password;
		
		

		public User(long id, String name, String password) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
	
}
