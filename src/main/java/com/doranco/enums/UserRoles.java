package com.doranco.enums;

public enum UserRoles {

	ADMIN("Administateur"), MODERATOR("Moderateur"), CLIENT("Client");

	private String role;

	private UserRoles(String role) {
		this.role = role;
	}

	public String getValue() {
		return role;
	}

	public static UserRoles getRole(String role) {
		for (UserRoles userRole : UserRoles.values()) {
			if (userRole.getValue().equals(role)) {
				return userRole;
			}
		}
		return null;
	}

}
