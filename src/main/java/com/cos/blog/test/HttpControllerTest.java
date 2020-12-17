package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {

	private static final String TAG ="HttpControllerTest: ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = new Member(1,"ssar","1234","ssar@naver.com");
		System.out.println(TAG+"getter : "+m.getId());
		m.setId(500);
		System.out.println(TAG+"setter: " +m.getId());
		return "lombok 테스트 완료";
	}
	
	
		@GetMapping("/http/get") //@RequestParam
		public String getTest( @RequestParam int id) {
				return "get 요청:" +id;
		}
		
		//(insert)
		@PostMapping("/http/post")
		public String postTest(@RequestBody String text) { //message convert
			return "post 요청"+text;
		}
		
		//(update)
		@PutMapping("/http/put")
		public String putTest() {
			return "put 요청";
		}
		
		@DeleteMapping("/http/delete")
		public String deleteTest() {
			return "delete 요청";
		}
}
