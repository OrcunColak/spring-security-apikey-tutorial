# Read Me

See
https://medium.com/@iamprovidence/authentication-history-basic-digest-cookie-session-token-jwt-api-key-55d6c21be90b

The API Key flow is avoided for user authentication but is commonly used for machine-to-machine (M2M) communication or
third-party integrations, where one software application or system interacts with another API (Application Programming
Interfaces).

Here is a basic overview of the API Key flow:

Developers or administrators generate API keys beforehand
Server Authentication. The client includes an Authorization header in all subsequent requests with the word "ApiKey"
followed by the key:

```
HTTP: https://my-app.com/get-photos

Authorization: ApiKey 9c403eb171e9517f40e415ccc069c403eb171e9517f40e41
```

# Original Code

Original code is from  
https://jackynote.medium.com/implementing-multiple-authentication-methods-in-a-spring-boot-3-e57feac77ebd

This project demonstrates Multiple Authentication Methods for different URLs

# Internal API

APIs prefixed with /api/internal use authentication via API Key embedded in the header.

# Form Login

Go to  
http://localhost:8080/  
to test form login

# XSS

https://danielangel22.medium.com/preventing-xss-attacks-in-your-spring-boot-api-c266a175e011

# Swagger

Go to  
http://localhost:8080/swagger-ui/index.html?continue#/internal-api-controller/internalHealthCheck  
to test api key

