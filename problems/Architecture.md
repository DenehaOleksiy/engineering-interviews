## Software architecture

Your integration tests call out to an external third party payment processor's test environment in order to utilize their API. This is part of our acceptance test suite in order to assert that our service may correctly communicate with them.

However, the payment processor's test environment only allows one engineer to run their acceptance tests against it one at a time. If any more engineers run their tests at the same time, their test environment crashes and our acceptance tests will fail randomly. 

1. Give us two approaches we could take to try and reduce these failures.
2. Please discuss the pros and cons with your approaches.
