## Software architecture

Your integration tests call out to a payment processor's test environment in order to utilize their API. This is done in order to assert that it can correctly communicate with them.

However, their staging environment is not robust and tends to fall over whenever more than one engineer runs the tests at once. This is causing our test runs to fail randomly.

1. Give us two approaches we could take to try and reduce these failures.
2. What are the benefits and issues with each?
