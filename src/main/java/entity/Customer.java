package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	    private String name;
	    private String firstname;
	    private String address;
	    private String tel;
		public Customer( String name, String firstname, String address, String tel) {
			super();
			
			this.name = name;
			this.firstname = firstname;
			this.address = address;
			this.tel = tel;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + ", firstname=" + firstname + ", address=" + address
					+ ", tel=" + tel + "]";
		}
	    
	    
	    
}
