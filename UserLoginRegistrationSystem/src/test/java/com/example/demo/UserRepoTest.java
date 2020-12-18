package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTest {
	@Autowired
	private UserRepository userRepo;
    
	@Autowired
	private TestEntityManager entityManager;
	
	public void usertest() {
		User user=new User();
		user.setEmail("e@gmail.com");
		user.setFirstName("Eklas");
		user.setLastName("Rh");
		user.setPassword("123456");
		User savedUser=userRepo.save(user);
		User existUser= entityManager.find(User.class, savedUser.getId());
		//System.out.println("-----------------------------------------------------");
		//System.out.println(userRepo.findByEmail("e@gmail.com").getFirstName());
		assertThat(userRepo.findByEmail("").equals(savedUser));
		
	}
}
