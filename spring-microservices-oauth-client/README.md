# OAuth Client using Spring

## Starters used
> Cloud Oauth
> Security
> Web

## Configuration as Authorization Client
1. Added  "@EnableOAuth2Client" on application class to configure application as OAuth Client.
2. Created WebSecurityConfig extending WebSecurityConfigurerAdapter and configured user.
3. Added OAuth2RestTemplate Bean for Obtaining token.

## How to run project
1. Import this project as "Existing Maven Project"
2. Run it as "Spring boot App"
3. Open "http://localhost:8080/execute"
