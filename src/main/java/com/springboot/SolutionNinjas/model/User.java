package com.springboot.SolutionNinjas.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@Entity
@Table(name="users")
public class User  {
	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	@NotBlank(message="First name cannot be null")
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Email(message="Please enter valid email ID.")
	@Column(name="email_id")
	private String emailid;
	
	@Column(name = "phone_no")
    private String phoneno;
	
    private String address; //can omit column annotation if variable is same as column name
    
    @ManyToOne
    @JoinColumn(name = "zip_code")
    private Area area;

   	private String picture;
    
    @Column(name="user_type")
   	private String usertype;
    
    @CreationTimestamp
	@Column(name="reg_date", nullable=false, updatable=false)
	private Date regdate;
	
	@UpdateTimestamp
	@Column(name="last_modified")
	private Date lastmodified;


//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Set<Authority> set=new HashSet<>();
//		set.add(new Authority(this.getUsertype()));
//		return null;
//	}

//	@Override
//	public String getPassword() {
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return false;
//	}
}
