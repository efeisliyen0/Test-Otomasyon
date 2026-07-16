# Checkout Scenarios

## Successful Checkout Process

* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User should see products
* User clicks "add to cart backpack" button
* User verifies "shopping cart badge" value is "1"
* User clicks "shopping cart" button
* User clicks "checkout" button
* User enters "Test" into "first name" field
* User enters "User" into "last name" field
* User enters "34000" into "postal code" field
* User clicks "continue" button
* User clicks "finish" button
* Order complete message should be "Thank you for your order!"


## Checkout Without First Name

* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User should see products
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User clicks "checkout" button
* User enters "" into "first name" field
* User enters "User" into "last name" field
* User enters "34000" into "postal code" field
* User clicks "continue" button
* Verify checkout error message is "Error: First Name is required"

