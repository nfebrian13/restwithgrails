package com.rest

class Customers {

	String customername
	String password
	String role

	static mapping={
		id insertable: false, column: "customer_id"
		version false
	}

	static constraints = {
	}
}
