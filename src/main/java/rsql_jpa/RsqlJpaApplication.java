package rsql_jpa;

import controller.ProductController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RsqlJpaApplication {
	static ProductController controller = new ProductController();
	public static void main(String[] args) {
		SpringApplication.run(RsqlJpaApplication.class, args);
		controller.search("");
	}

}
