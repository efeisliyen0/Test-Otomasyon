# Checkout Scenarios

## Successful Checkout Process
* User enters "standard_user" into username field
* User enters "secret_sauce" into password field
* User clicks login button
* User should see products
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User clicks "checkout" button
* Fill customer information as "Test", "User", "34000"
* User clicks "continue" button
* User clicks "finish" button
* Verify order completion message is "Thank you for your order!"

## Checkout Without First Name
* User enters "standard_user" into username field
* User enters "secret_sauce" into password field
* User clicks login button
* User should see products
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User clicks "checkout" button
* Fill customer information as "", "User", "34000"
* User clicks "continue" button
* Verify checkout error message is "Error: First Name is required"
