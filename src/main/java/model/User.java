package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
		@NamedQuery(name = User.GET_USER_BY_FIRST_LAST_NAME, query = "Select u from User as u Where u.lastName=:lname And u.firstName = :fname"),
		@NamedQuery(name = User.GET_USER_BY_LOGIN_PASSWORD, query = "Select u from User as u Where u.login=:login And u.password = :password"),
		@NamedQuery(name = User.GET_USER_BY_LOGIN, query = "Select u from User as u Where u.login=:login") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(length = 30, unique = true, nullable = false)
	private String email;
	@Column(length = 30, unique = true, nullable = false)
	private String login;
	@Column(length = 60, nullable = false)
	private String password;
	private String phoneNumber;
	private Boolean isEnabled;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	@OneToOne(cascade = CascadeType.ALL, targetEntity = Basket.class, mappedBy = "user")
	private Basket basket = new Basket();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Custom> customs;

	public static final String GET_USER_BY_LOGIN_PASSWORD = "User.getUserByLoginPassword";
	public static final String GET_USER_BY_FIRST_LAST_NAME = "User.getUserByFirstLastName";
	public static final String GET_USER_BY_LOGIN = "User.getUserByLogin";

	public User() {
	}

	public User(String firstName, String lastName, String email, String login,
			String password, String phoneNumber, UserRole role, Boolean isEnabled) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.isEnabled = isEnabled;
	}

	public User(Long id, String firstName, String lastName, String email,
			String login, String password, String phoneNumber, UserRole role, Boolean isEnabled, Basket basket,
			Set<Custom> customs) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.basket = basket;
		this.customs = customs;
		this.isEnabled = isEnabled;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public Set<Custom> getCustoms() {
		return customs;
	}

	public void setCustoms(Set<Custom> customs) {
		this.customs = customs;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		if (customs == null) {
			if (other.customs != null)
				return false;
		} else if (!customs.equals(other.customs))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isEnabled == null) {
			if (other.isEnabled != null)
				return false;
		} else if (!isEnabled.equals(other.isEnabled))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

}
