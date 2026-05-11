Inventory Management System – Multi-Level Software Testing Framework
Project Overview

This project is a Java-based Inventory Management System developed as part of the Software Quality Assurance course project. The main objective of this project is to demonstrate a multi-level software testing framework using:

Manual Testing
JUnit Testing
Selenium Automation Testing

The system includes functionalities such as:

Product Management
Inventory Handling
Shopping Cart Operations
Customer Purchase Management
Order Processing
Technologies Used
Java
JUnit 5
Selenium WebDriver
ChromeDriver
HTML
JavaScript
Visual Studio Code
Project Structure
InventoryManagementSystem/
│
├── src/
│   ├── Customer.java
│   ├── Product.java
│   ├── Inventory.java
│   ├── ShoppingCart.java
│   ├── Order.java
│   ├── Supplier.java
│   ├── Warehouse.java
│   └── ...
│
├── tests/
│   ├── TestCustomer.java
│   ├── TestProduct.java
│   ├── TestInventory.java
│   ├── TestShoppingCart.java
│   ├── TestOrder.java
│   └── ...
│
├── selenium/
│   ├── SeleniumTest.java
│   ├── inventory.html
│   └── ...
│
└── README.md
Features
Inventory Features
Add Product
Remove Product
Search Product
Check Product Availability
Customer Features
Purchase Product
Return Product
Balance Management
Purchase History
Shopping Cart Features
Add Item
Remove Item
Calculate Total Price
Order Features
Order Status Update
Order Tracking
Manual Testing

Manual testing was performed using predefined test cases implemented in:

ManualTestDemo.java

The following operations were tested:

Product creation
Add/remove inventory
Product searching
Availability checking
Shopping cart operations
Customer purchases
Order status updates
Example Manual Test Output
TC-01: Product Creation
Expected: Product name = Keyboard
Actual: Keyboard
Status: PASS
Validation Issues Found
Negative quantity values were accepted
Negative price values were accepted

These issues indicate missing input validation.

JUnit Testing

JUnit was used for automated unit testing of individual classes and methods.

Classes Tested
Customer
Product
Inventory
ShoppingCart
Order
Supplier
Warehouse
Assertions Used
assertEquals()
assertTrue()
assertFalse()
assertNotEquals()
Running JUnit Tests

Run tests using Visual Studio Code Test Runner or terminal.

Example:

mvn test
Selenium Automation Testing

Selenium WebDriver was used to automate GUI testing for the Inventory Management web interface.

Selenium Features
Automatic browser launch
Automatic form filling
Button click automation
GUI validation
Automated Workflow
Launch browser
Open inventory webpage
Enter product details
Click Add Product button
Verify success message
How to Run the Project
1. Clone Repository
git clone <repository-link>
2. Open in VS Code

Open the project folder in:

Visual Studio Code

3. Run Java Application

Run:

ManualTestDemo.java

or any main class.

4. Run JUnit Tests

Run test classes individually using:

VS Code Test Runner
Maven
JUnit Extension
5. Run Selenium Test

Requirements:

Google Chrome
ChromeDriver
Selenium Java Libraries

Run:

SeleniumTest.java
Findings
Successful Functionalities
Inventory operations
Shopping cart operations
Customer purchase operations
Order management
GUI automation
Issues Identified
Missing validation for negative values
Minor floating-point rounding inconsistencies
Difficulties Faced
Selenium WebDriver setup
ChromeDriver configuration
Managing multiple testing frameworks
Writing large numbers of test cases
GUI automation synchronization issues
Conclusion

This project successfully implemented a multi-level software testing framework for an Inventory Management System using:

Manual Testing
JUnit Testing
Selenium Automation Testing

The testing process improved software reliability, identified defects, and validated both backend logic and graphical user interface behavior.
