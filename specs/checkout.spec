# Checkout Scenarios

## Successful Checkout Process

* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login button" button
* User should see products
* User clicks "add to cart backpack button" button
* User verifies "shopping cart badge" value is "cart.oneItem"
* User clicks "shopping cart button" button
* User clicks "checkoutbutton" button
* User enters "checkout.firstName" into "first name" field
* User enters "checkout.lastName" into "last name" field
* User enters "checkout.postalCode" into "postal code" field
* User clicks "continuebutton" button
* User clicks "finishbutton" button
* User verifies message "completemessage" matches "Thank you for your order!"


## Checkout Without First Name

* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login button" button
* User should see products
* User clicks "add to cart backpack button" button
* User clicks "shopping cart button" button
* User clicks "checkoutbutton" button
* User enters "" into "first name" field
* User enters "checkout.lastName" into "last name" field
* User enters "checkout.postalCode" into "postal code" field
* User clicks "continuebutton" button
* User verifies message "checkouterrormessage" matches "Error: First Name is required"