# Java Messaging Quickstart

This quickstart serves as a guide to get your first Messaging application up and running with [FreeClimb](https://docs.freeclimb.com/docs/how-freeclimb-works).

Specifically, the project will:

- Receive an incoming message via a FreeClimb application
- Respond "Hello World!" to the incoming message

## Tutorial

We offer a [Java SMS Quickstart Tutorial](https://docs.freeclimb.com/docs/java-messaging-quickstart) for more detailed set-up instructions and explanation of how FreeClimb works.

## Requirements
A [FreeClimb account](https://www.freeclimb.com/dashboard/signup/)

A [registered application](https://docs.freeclimb.com/docs/registering-and-configuring-an-application#register-an-app) with a named alias

A [configured FreeClimb number](https://docs.freeclimb.com/docs/getting-and-configuring-a-freeclimb-number) assigned to your application

Trial accounts: a [verified number](https://docs.freeclimb.com/docs/using-your-trial-account#verifying-outbound-numbers)

Tools:
- [Java](https://www.oracle.com/java/technologies/downloads/) 8 or higher
- [ngrok](https://ngrok.com/download) (recommended for hosting)
- [Gradle](https://gradle.org/install/)

## Setting up the Quickstart

1. Configure environment variables (in `.env.sample` and rename the file to `.env`):

   | ENV VARIABLE     | DESCRIPTION                                                                                                                            |
   | ---------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
   | ACCOUNT_ID       | Account ID which can be found under [API credentials](https://www.freeclimb.com/dashboard/portal/account/authentication) in dashboard. |
   | API_KEY          | API key which can be found under [API credentials](https://www.freeclimb.com/dashboard/portal/account/authentication) in dashboard.    |
   | FREECLIMB_NUMBER | The number that sends messages from your application. Your FreeClimb number.                                                           |

2. Make your local server publicly accessible
    ```bash
    ngrok http 3000
    ```
    Once you run ngrok you should receive a response with a public URL, that looks something like 'https://ba1c-63-209-137-19.ngrok-free.app'. 

3. [Configure your applications's endpoints](https://docs.freeclimb.com/docs/registering-and-configuring-an-application#configure-your-application) by adding a publicly accessible URL (we recommend an [ngrok](https://ngrok.com/download) URL) and the route reference `/incomingSms` to your App Config's SMS URL field:

    ```bash
    https://YOUR-URL.ngrok.io/incomingSms
    ```
    
## Running the Quickstart
1. Start your voice quickstart application

    ```bash
    gradle build && java -Dserver.port=3000 -jar build/libs/Java-SMS-Quickstart-plain.jar
    ```

2. Call the FreeClimb number assigned to the application you've configured for this tutorial 

## Using Docker to Run the Quickstart

1. Pull docker image from dockerhub

   ```bash
   docker pull freeclimbapi/java-sms-quickstart
   ```

2. Run docker image after replacing placeholder values

   ```bash
   docker run -e ACCOUNT_ID=<YOUR_ACCOUNT_ID> -e API_KEY=<YOUR_API_KEY> -e FREECLIMB_NUMBER=<YOUR_FREECLIMB_NUMBER> -p 3000:3000 freeclimbapi/java-sms-quickstart
   ```

## Feedback & Issues
If you would like to give the team feedback or you encounter a problem, please [contact support](https://www.freeclimb.com/support/) or [submit a ticket](https://freeclimb.com/dashboard/portal/support) in the dashboard.
