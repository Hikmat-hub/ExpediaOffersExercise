# **Blocker**

Currently, I am facing to _**many request error 429**_ when I tried to deploy my project on Heroku, and I can't get any result and there many reasons that can cause this issue.

One of them is that there is a detector from Expedia side, that detects if the call acquired from the server-side which is the current issue that I am facing or from the client-side. If it the call from the server-side it will show to the end-user a page to validate that this action acquired from the user and not machine especially if the user try to use one of the global proxy servers.

It works locally you can try to run it on your local machine.
I added browser headers to make it work locally, but for the server side it didn't work because there is IP address criteria that can't resolve by just adding request headers.

**Introduction**

This project is based on Springboot framework, You will not find any Ajax request between web page and API.
I used basic JSTL and Spring tags.

**Assumptions**

I did the following assumptions:
1. **minTripStartDate** Should not be less than current date and always it should be less than minTripStartDate if it is exists.
2. **maxTripStartDate** Should not be less than current date and also always it should be greater than minTripStartDate.
3. Rating values should be more than zero and less than 5
4. I assumed to add the core code that define how the code structure will be.

Dependencies:
* Java8
* Gradle
