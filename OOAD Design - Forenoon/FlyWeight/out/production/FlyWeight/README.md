## Design Pattern - kalai.chelvan@accolitedigital.com
### Fly Weight

Lets assume that we have a cake shop receiving orders for cake to be baked.

The Cake shop has only specific type of cakes [RedVelvet, Chocolate, IceCream, BlackForest] and cake sizes preffered to the customer

We have received cake orders as array in the code. Each order is proccessed with cakeType.

If the CakeType (cake recepie) is already in the Factory then cake is baked on the size given by user, else receipe prepared in Factory and then the cake is baked.

        cakeInterface
        |___ Cake
            |
        CakeFactory
            |
        FlyWeightMain




## end