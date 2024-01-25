# Java SMS Quickstart

This quickstart serves as a guide to get your first SMS application up and running with [FreeClimb](https://docs.freeclimb.com/docs/how-freeclimb-works).

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

1. Configure environment variables:

   | ENV VARIABLE | DESCRIPTION                                                                                                                            |
   | ------------ | -------------------------------------------------------------------------------------------------------------------------------------- |
   | ACCOUNT_ID   | Account ID which can be found under [API credentials](https://www.freeclimb.com/dashboard/portal/account/authentication) in dashboard. |
   | API_KEY      | API key which can be found under [API credentials](https://www.freeclimb.com/dashboard/portal/account/authentication) in dashboard.    |

2. Replace placeholder values for `to` and `from` numbers:

   | VARIABLE | DESCRIPTION                                                                                                                                                                                            |
   | -------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
   | TO       | The number which will receive messages from your application. For trial accounts, this is your [verified number](https://docs.freeclimb.com/docs/using-your-trial-account#verifying-outbound-numbers). |
   | FROM     | The number that sends messages from your application. Your FreeClimb number.                                                                                                                           |

3. Start ngrok

   ```bash

       ngrok http 80
   ```

4. [Configure your applications's endpoints](https://docs.freeclimb.com/docs/registering-and-configuring-an-application#configure-your-application) by adding a publicly accessible URL (we recommend an [ngrok](https://ngrok.com/download) URL) and the route reference `/incomingSms` to your App Config's SMS URL field:

   ```bash
   https://YOUR-URL.ngrok.io/incomingSms
   ```

## Running the Quickstart

1. Start your voice quickstart application

   ```bash
   gradle build && java -Dserver.port=0080 -jar build/libs/Java-SMS-Quickstart-3.0.6-plain.jar
   ```

2. Call the FreeClimb number assigned to the application you've configured for this tutorial

## Feedback & Issues

If you would like to give the team feedback or you encounter a problem, please [contact support](https://www.freeclimb.com/support/) or [submit a ticket](https://freeclimb.com/dashboard/portal/support) in the dashboard.
