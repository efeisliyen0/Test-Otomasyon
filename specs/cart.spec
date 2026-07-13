# Cart Tests

## Add Backpack to Cart and Verify
* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User should see "Sauce Labs Backpack" in the cart

## Remove Backpack From Cart
* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User saves cart badge count
* User clicks "remove backpack" button
* Cart badge should decrease by one

## Cart Persistence Check
* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User clicks "add to cart backpack" button
* Cart badge should be "1"
* User clicks "menu" button
* User clicks "logout" button
* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* Cart badge should be "1"