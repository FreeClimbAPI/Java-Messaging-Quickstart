package main.java.receive_a_message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    if (dotenv.get("ACCOUNT_ID") == null || dotenv.get("API_KEY") == null || dotenv.get("FREECLIMB_NUMBER") == null){
      System.err.println("ERROR: ENVIRONMENT VARIABLES ARE NOT SET. PLEASE SET ALL ENVIRONMMENT VARIABLES AND RETRY.");
      return;
    }
    SpringApplication.run(Application.class, args);
  }
}
