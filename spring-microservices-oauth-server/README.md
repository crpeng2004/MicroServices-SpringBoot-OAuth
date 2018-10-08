# OAuth Server using Spring

## Starters used
> Cloud Oauth
> Security
> JDBC
> HSQL DB

## How project is configured
1. After creating spring boot app with above starters add "@EnableAuthorizationServer" to application class.
2. Create AuthorizationServerConfig  extending AuthorizationServerConfigurerAdapter and configure authorization client
3. Create WebSecurityConfig extending WebSecurityConfigurerAdapter and configure user.

## How to run project
1. Import this project as "Existing Maven Project"
2. Run it as "Spring boot App"
3. Use Postman or equivalent app to test it

### Testing with Postman
#### Obtaining Access Token
1. Post Request with URL"http://localhost:9090/oauth/token
2. Under "Authorization" tab, select "Basic Auth" with username as "webapp" and password as "websecret".
3. In "Body" tab, add three parameters with keys grant_type, username and password and with values password, user1, password1 respectively.
4. Send request and the response body should have access_token.
