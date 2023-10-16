package com.javawiz.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseObject {
    public String firstName;
    public String lastName;

	/*@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", createUser="
				+ createUser + ", createdDate=" + createdDate + ", lastModifiedUser=" + lastModifiedUser + "]";

	}*/

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%s, firstName='%s', lastName='%s', createUser='%s', createdDate='%s', lastModifiedUser='%s', updateDate='%s']",
				id, firstName, lastName, createUser, createdDate, lastModifiedUser, updateDate);
	}
}

