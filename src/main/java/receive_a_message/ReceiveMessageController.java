package main.java.send_a_message;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.vailsys.freeclimb.api.FreeClimbClient;
import com.vailsys.freeclimb.api.FreeClimbException;

@RestController
public class ReceiveMessageController {
  private final String fromNumber = System.getenv("FREECLIMB_PHONE_NUMBER");
  private final String toNumber = System.getenv("TO_PHONE_NUMBER");
  private final String accountId = System.getenv("ACCOUNT_ID");
  private final String authToken = System.getenv("AUTH_TOKEN");

  @RequestMapping(value = { "/InboundSms" }, method = RequestMethod.POST)
  public void inboundSms(@RequestBody String body) {
    FreeClimbClient client;
    try {
      client = new FreeClimbClient(accountId, authToken);
      client.messages.create(fromNumber, toNumber, "Hello from the FreeClimb API!");
    } catch (FreeClimbException e) {
      // Handle Error
    }
  }

}
