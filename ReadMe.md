**Why did I choose this framework?**
This automation framework using Cucumber and Page Object Model, including configuration, utilities, Test Pages -  step definitions, and test scenarios

I have chosen this framework because it is in Cucumber BBD - that enables the both technical and non-technical, BA and team members to easily understand the scenarios and the purpose the tests.

This framework is using Page Object Model that promotes reusability and reducing code duplication - as we add further scenarios it will make it easier to maintain the project.

To support the reusability and code duplication I am using a config to store hard-coded values such as url username / password and other env config that allows us easy to maintain the data.

I am using  DriverManager - to pass the WebDriver Setup and teardown after each test is executed and search test is generated in Junit with detailed reporting of each step.

Below I have provided a diagram of the project and dependencies  

src
└── test
└── java
└── pages # Page Object classes for different pages (CartPage - CheckoutPage - InventoryPage - LoginPage.)
└── runners # Cucumber test runner classes
└── stepdefinitions # Step definitions linked to Gherkin feature steps for CheckoutSteps - and LogingSteps
└── Utils #DriverManager and WaitUtils
└── resources
└── features # Gherkin feature files describing scenarios in BDD style for Checkout.feature, login.feature. products.feature
└──config.properties: url / username / password
└── 1.3 AdditionalScenariosToCover.md 
pom.xml # Maven dependencies and build configuration


## Prerequisites
Maven Installed
IntelliJ
Chrome

## How to Run
Tests can be run using right-click 'TestRunner' or individual tests running the .feature file (right-click on the feature file)
or
mvn clean test

## view 1.3AdditionalScenariosToCover for challenges faced and scenarios to cover
