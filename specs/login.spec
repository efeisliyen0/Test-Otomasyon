# Login
## Valid Login
* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User should see products


## Invalid Login - Wrong Password
* User enters "standard_user" into "username" field
* User enters "wrong_password123" into "password" field
* User clicks "login" button
* Verify checkout error message is "Epic sadface: Username and password do not match any user in this service"