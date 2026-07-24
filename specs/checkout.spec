# Checkout Scenarios

## Successful Checkout Process

* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login" button
* User should see products
* User clicks "add to cart backpack" button
* User verifies "shopping cart badge" value is "cart.oneItem"
* User clicks "shopping cart" button
* User clicks "checkout" button
* User enters "checkout.firstName" into "first name" field
* User enters "checkout.lastName" into "last name" field
* User enters "checkout.postalCode" into "postal code" field
* User clicks "continue" button
* User clicks "finish" button
* User verifies message "completemessage" matches "messages.orderComplete"


## Checkout Without First Name

* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login" button
* User should see products
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User clicks "checkout" button
* User enters "" into "first name" field
* User enters "checkout.lastName" into "last name" field
* User enters "checkout.postalCode" into "postal code" field
* User clicks "continue" button
* User verifies message "checkouterror" matches "messages.emptyFirstNameError"