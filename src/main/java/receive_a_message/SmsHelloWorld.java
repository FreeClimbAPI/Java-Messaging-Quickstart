package main.java.receive_a_message;

import com.github.freeclimbapi.ApiClient;
import com.github.freeclimbapi.ApiException;
import com.github.freeclimbapi.Configuration;
import com.github.freeclimbapi.auth.*;
import com.github.freeclimbapi.models.*;
import com.github.freeclimbapi.DefaultApi;
import com.github.freeclimbapi.models.MessageRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class SmsHelloWorld {

  @RequestMapping(value = { "/incomingSms" }, method = RequestMethod.POST)
  public void inboundSms(@RequestBody String body) {
    String fromNumber = System.getenv("FREECLIMB_PHONE_NUMBER");
    String toNumber = System.getenv("TO_PHONE_NUMBER");
    String message = "Hello World!";
  
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www.freeclimb.com/apiserver");
      
    // Configure HTTP basic authorization: fc
    HttpBasicAuth fc = (HttpBasicAuth) defaultClient.getAuthentication("fc");
    fc.setUsername(System.getenv("ACCOUNT_ID"));
    fc.setPassword(System.getenv("API_KEY"));

    DefaultApi apiInstance = new DefaultApi(defaultClient);
      
    MessageRequest messageRequest = new MessageRequest(); // MessageRequest | Details to create a message
    messageRequest.setFrom(fromNumber);
    messageRequest.setTo(fromNumber);
    messageRequest.setText(message);
    try {
      apiInstance.sendAnSmsMessage(messageRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#sendAnSmsMessage");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }

}
