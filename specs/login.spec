# Login

## Valid Login
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login" button
* User should see products


## Invalid Login - Wrong Password
* User enters "login.standardUser" into "username" field
* User enters "login.invalidPassword" into "password" field
* User clicks "login" button
* Verify checkout error message is "messages.invalidLogin"