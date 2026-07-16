# Cart Tests

## Add Backpack to Cart and Verify
* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User verifies "inventory item name" text is "Sauce Labs Backpack"

## Remove Backpack From Cart
* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User verifies "shopping cart badge" value is "1"
* User clicks "remove backpack" button
* User verifies "shopping cart badge" is not displayed

## Cart Persistence Check
* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User clicks "add to cart backpack" button
* User verifies "shopping cart badge" value is "1"
* User clicks "menu" button
* User clicks "logout" button
* User enters "standard_user" into "username" field
* User enters "secret_sauce" into "password" field
* User clicks "login" button
* User verifies "shopping cart badge" value is "1"