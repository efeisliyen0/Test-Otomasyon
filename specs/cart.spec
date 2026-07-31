# Cart Tests

## Add Backpack to Cart and Verify
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login button" button
* User clicks "add to cart backpack button" button
* User clicks "shopping cart button" button
* User verifies "inventory item name" text is "cart.backpack"


## Remove Backpack From Cart
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login button" button
* User clicks "add to cart backpack button" button
* User clicks "shopping cart button" button
* User verifies "shopping cart badge" value is "cart.oneItem"
* User clicks "remove backpack button" button
* User verifies "shopping cart badge" is not displayed


## Cart Persistence Check
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login button" button
* User clicks "add to cart backpack button" button
* User verifies "shopping cart badge" value is "cart.oneItem"
* User clicks "menubutton" button
* User clicks "logoutbutton" button
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login button" button
* User verifies "shopping cart badge" value is "cart.oneItem"