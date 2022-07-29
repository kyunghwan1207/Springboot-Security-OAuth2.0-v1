package team_project.beer_community;

import com.cos.security.controller.IndexController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BeerCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerCommunityApplication.class, args);
//		SpringApplication.run(IndexController.class, args);
		System.out.println("hello world");
	}

}
