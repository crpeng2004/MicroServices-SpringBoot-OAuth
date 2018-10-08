# OAuth Server using Spring

## Starters used
> Cloud Oauth
> Security
> JDBC
> HSQL DB

## Configuration as Authorization Server
1. Added  "@EnableAuthorizationServer" to application class to configure application as authorization server.
2. Created AuthorizationServerConfig  extending AuthorizationServerConfigurerAdapter and configured authorization client
3. Created WebSecurityConfig extending WebSecurityConfigurerAdapter and configured user.

## Configuration as Resource Serer
1. Added "@EnableResourceServer" to application class to configure application as Resource Server
2. Created ResourceController with request mapping end point of '/resource/endpoint'

## How to run project
1. Import this project as "Existing Maven Project"
2. Run it as "Spring boot App"
3. Use Postman or equivalent app to test it

### Testing with Postman
You can import postman sample requests present in project and test or follow the steps given below.
#### Obtaining Access Token
1. Post Request with URL"http://localhost:9090/oauth/token"
2. Under "Authorization" tab, select "Basic Auth" with username as "webapp" and password as "websecret".
3. In "Body" tab, add three parameters with keys grant_type, username and password and with values password, user1, password1 respectively.
4. Send request and the response body should have access_token.
#### Accessing Resource on Resource server
1. Copy obtained access_token
2. Create a get request with URL "http://localhost:9090/resource/endpoint" 
3. Add a request param with key as "access_token" and value as copied access_token.
4. Send the request and resource should be accessible.