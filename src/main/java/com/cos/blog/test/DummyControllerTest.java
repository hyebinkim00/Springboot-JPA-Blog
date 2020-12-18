package com.cos.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired //의존성 주입
	private UserRepository userRepository;
	
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
    //findBYId.get() : 오류 메세지만 있음
			
			@Override
			public IllegalArgumentException get() {
		
				return new IllegalArgumentException("해당 유저는 없습니다. id : "+id);
			}
		});
		return  user;
	}
	
	
	
	@PostMapping("/dummy/join")
		public String join(User user) {
			System.out.println("username :  "+user.getUsername());  
			System.out.println("password :  "+user.getPassword());
			System.out.println("emAail :  "+user.getEmail());
			
			user.setRole(RoleType.USER);
			userRepository.save(user);
			
			return "회원가입 완료";
		}
}
