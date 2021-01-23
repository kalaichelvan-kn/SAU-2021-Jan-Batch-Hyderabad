# Design Pattern - kalai.chelvan@accolitedigital.com

## Chain of Responsibilty Example 1

- Lets take a login page with 2 step authentication
- here is the chain

Step 1: Validating username and password if success then step 2

Step 2: Validation 2 Factor Authenticaition if success then Login to Home

In case of any failure in those steps transaction fails

![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/OOAD%20Design%20-%20Forenoon/ChainOfResponsibility/cor1.PNG)

## Chain of Responsibilty Example 2

- Online Order Placing

Step 1: Verify Products

Step 2: Verify Address

Step 3: Verify Payment

In case of any failure in those steps transaction fails

![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/OOAD%20Design%20-%20Forenoon/ChainOfResponsibility/cor2.PNG)

![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/OOAD%20Design%20-%20Forenoon/ChainOfResponsibility/process.PNG)

## end