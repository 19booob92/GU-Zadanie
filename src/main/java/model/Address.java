package model;


import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = -6619723200813503872L;

	private String street;

	private long homeNo;

	private long flatNo;

	private String country;

	private String city;
	
	private Address(AddressBuilder builder) {
		this.street = builder.street;
		this.city = builder.city;
		this.country = builder.country;
		this.flatNo = builder.flatNo;
		this.homeNo = builder.homeNo;
	}

	public static class AddressBuilder extends Builder<Address> {

		private String street;

		private long homeNo;

		private long flatNo;

		private String country;

		private String city;
		
		public AddressBuilder() {
		}

		public AddressBuilder withStreet(String street) {
			this.street = street;
			return this;
		}

		public AddressBuilder withCity(String city) {
			this.city = city;
			return this;
		}

		public AddressBuilder withCountry(String country) {
			this.country = country;
			return this;
		}

		@Override
		public Address build() {
			return new Address(this);
		}

	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public long getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(long homeNo) {
		this.homeNo = homeNo;
	}

	public long getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(long flatNo) {
		this.flatNo = flatNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
