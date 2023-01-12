package second.two.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="studentform")
public class student {
	
	@Override
	public String toString() {
		return "student [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Address=" + Address + "]";
	}
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student(long id, String name, String email, String address) {
		super();
		Id = id;
		Name = name;
		Email = email;
		Address = address;
	}
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	private String Name;
	private String Email;
	private String Address;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	

}
