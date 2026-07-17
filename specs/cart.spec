# Cart Tests

## Add Backpack to Cart and Verify
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login" button
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User verifies "inventory item name" text is "cart.backpack"


## Remove Backpack From Cart
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login" button
* User clicks "add to cart backpack" button
* User clicks "shopping cart" button
* User verifies "shopping cart badge" value is "cart.oneItem"
* User clicks "remove backpack" button
* User verifies "shopping cart badge" is not displayed


## Cart Persistence Check
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login" button
* User clicks "add to cart backpack" button
* User verifies "shopping cart badge" value is "cart.oneItem"
* User clicks "menu" button
* User clicks "logout" button
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login" button
* User verifies "shopping cart badge" value is "cart.oneItem"