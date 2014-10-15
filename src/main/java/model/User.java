package model;


import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -3170641718449901223L;

	private static long nextId = 0;

	private long id;

	private String name;

	private String surname;

	private Address address;

	private long allProductsCost;

	private User(UserBuilder builder) {
		this.id = nextId++;
		
		this.address = builder.address;
		this.allProductsCost = allProductsCost;
		this.name = builder.name;
		this.surname = builder.surname;
	}

	public static class UserBuilder extends Builder<User> {

		private String name;

		private String surname;

		private Address address;

		private long allProductsCost;

		public UserBuilder() {
			allProductsCost = 0L;
		}

		public UserBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public UserBuilder withSurname(String surname) {
			this.surname = surname;
			return this;
		}

		public UserBuilder withAddress(Address address) {
			this.address = address;
			return this;
		}

		public UserBuilder withAllProductsCost(long allProductsCost) {
			this.allProductsCost = allProductsCost;
			return this;
		}

		@Override
		public User build() {
			return new User(this);
		}

	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getAllProductsCost() {
		return allProductsCost;
	}

	public void setAllProductsCost(long allProductsCost) {
		this.allProductsCost = allProductsCost;
	}

	public void addToProductCost(long valueToAdd) {
		allProductsCost += valueToAdd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", address=" + address + ", allProductsCost="
				+ allProductsCost + "] \n";
	}

}
