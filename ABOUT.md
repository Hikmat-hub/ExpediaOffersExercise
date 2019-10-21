# **Blocker**

Currently, I am facing to _**many request error 429**_ when I tried to deploy my project on Heroku, and I can't get any result and there many reasons that can cause this issue.

One of them is that there is a detector from Expedia side, that detects if the call acquired from the server-side which is the current issue that I am facing or from the client-side. If it the call from the server-side it will show to the end-user a page to validate that this action acquired from the user and not machine especially if the user try to use one of the global proxy servers.

It works locally you can try to run it on your local machine.
I added browser headers to make it work locally, but for the server side it didn't work because there is IP address criteria that can't resolve by just adding request headers.

**Why JAVA**

I used Java because of:
1. I am familiar with JAVA
2. It is platform-independent.
3. Java's robustness
4. Ease of use.
5. OOP
6. Security features

**Technologies that I used in this project**

Backend:
1. JAVA 8
2. Springboot
3. Spring Validator
4. Spring tag, JSTL
5. Spring MVC
6. Spring Test
7. Junit Test
8. Mockito For testing
9. SLF4J
10. Jakson
11. Apache HTTPCLient
12. **lombok** for pojo getter and setters
13. Gradle

Front End:
1. Jquery
2. Bootstrap 4
4. DatePicker

**My Workflow Process**

I try to accomplish the following points:
1. The single responsibility principle
2. Decoupling
3. Clear
4. I try to use meaningful method names and variables
5. Easy steps to add new parameters to the OffersService, what you have to do only add the field in the UI and after that add the parameter as property in OffersRequest but please make sure that you used the same name or you annotated with Jackson correct field name.
6. Add client side and server side validation.

**What I learned in the process**
1. How to deploy my project on Heroku.
2. Travis-CI
3. Spring Write custom Spring validator
4. Bootstrap

**How I create Expedia Service Response**

1. I get the JSON from the Offers Service.
2. Generate the JSON Schema for that response.
4. Generate the classes from that Json schema.

**Project challenges**

1. Expedia Offer service return to many request error code 429, and I have to added http request header to make it similar to browser request header and it works fine.
2. Hotel response was start with capital latter and I have to detect that and reflect it in the code.


**What I have to do next**

1. Enhance UI.
2. Write UI Unit test.
4. Add order parameters.
5. Add Google map so the user can get the direction.
6. Add another filer for Product Type, I noticed that there are package and Flight type
