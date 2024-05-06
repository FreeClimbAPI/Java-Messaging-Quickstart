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

import io.github.cdimascio.dotenv.Dotenv;
import com.fasterxml.jackson.annotation.JsonProperty;


class IncomingSmsRequest
{
    @JsonProperty("accountId")
    public String accountId;
    @JsonProperty("applicationId")
    public String applicationId;
    @JsonProperty("direction")
    public String direction;
    @JsonProperty("from")
    public String from;
    @JsonProperty("messageId")
    public String messageId;
    @JsonProperty("phoneNumberId")
    public String phoneNumberId;
    @JsonProperty("requestType")
    public String requestType;
    @JsonProperty("status")
    public String status;
    @JsonProperty("text")
    public String text;
    @JsonProperty("to")
    public String to;

    public IncomingSmsRequest() {
    }

    public IncomingSmsRequest(String accountId, String applicationId, String direction, String from, String messageId, String phoneNumberId, String requestType, String status, String text, String to) {
        this.accountId = accountId;
        this.applicationId = applicationId;
        this.direction = direction;
        this.from = from;
        this.messageId = messageId;
        this.phoneNumberId = phoneNumberId;
        this.requestType = requestType;
        this.status = status;
        this.text = text;
        this.to = to;
    }
}

@RestController
public class SmsHelloWorld {

  @RequestMapping(value = { "/incomingSms" }, method = RequestMethod.POST)
  public void inboundSms(@RequestBody IncomingSmsRequest request) {
    Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    String accountId = dotenv.get("ACCOUNT_ID");
    String apiKey = dotenv.get("API_KEY");
    String fromNumber = dotenv.get("FREECLIMB_NUMBER");
    String toNumber = request.from;
    String apiServer = System.getenv("API_SERVER") != null ? System.getenv("API_SERVER") : "https://www.freeclimb.com/apiserver";
    String message = "Hello, World!";

    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath(apiServer);
    defaultClient.setAccountId(accountId);
    defaultClient.setApiKey(apiKey);

    DefaultApi apiInstance = new DefaultApi(defaultClient);
      
    MessageRequest messageRequest = new MessageRequest(); // MessageRequest | Details to create a message
    messageRequest.setFrom(fromNumber);
    messageRequest.setTo(toNumber);
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
