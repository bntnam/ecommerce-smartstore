package com.bntn.bookstore;

import com.bntn.bookstore.model.User;
import com.bntn.bookstore.model.security.Role;
import com.bntn.bookstore.model.security.UserRole;
import com.bntn.bookstore.service.UserService;
import com.bntn.bookstore.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EcommerceBookstoreApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceBookstoreApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User user1 = new User();
		user1.setUsername("user");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("user"));
		user1.setEmail("user@gmail.com");

		Set<UserRole> userRoles1 = new HashSet<>();

		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");

		userRoles1.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles1);

		User user2 = new User();
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user2.setEmail("admin@gmail.com");

		Set<UserRole> userRoles2 = new HashSet<>();

		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");

		userRoles2.add(new UserRole(user2, role2));

		userService.createUser(user2, userRoles2);
	}
}
