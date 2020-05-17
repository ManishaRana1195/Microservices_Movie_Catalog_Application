## Movie Catalog Application
### This is an hands on attempt to learn more about Microservices and how do you implement them in Java. 

#### Basic Setup
Here, is the link to the presentation where I have summarized the basics of Microservice Architecture and details of its components. My aim here is to learn about the basics of microservice in Java and service discovery using Eureka server by implementing a movie catalog application. Movie catalog application is for movies, similar to the way GoodReads is for the books.Now the first step is to go over the architecture. I will be creating 3 microservices,    
1. Rating data service - which is responsible for providing the rating given to a movie by a user and also list of all ratings given by a user.    
2. Movie details service - which returns movie information for a movie ID.    
3. Cataloging service - which takes the results from rating data and movie details service, combines them and provides it to the client.

As shown below in the diagram, how three services will interact. 

##### Service architecture

![](https://github.com/ManishaRana1195/Microservices_Movie_Catalog_Application/blob/master/documents/basic_architecture.png)


#### Adding Clientside Service Discovery -Eureka

For the services to communicate with each other, we should register them to eureka service discovery server and add eureka client to each of the 3 services. The architecture will be updated to the following:

##### Architecture with service discovery

![](https://github.com/ManishaRana1195/Microservices_Movie_Catalog_Application/blob/master/documents/architecture%20with%20eureka.png)       

After adding the eureka service client to each microservice, they were discovered by the discovery server and the result is as shown below:

##### Microservices detected by Eureka Server

![](https://github.com/ManishaRana1195/Microservices_Movie_Catalog_Application/blob/master/documents/service_discovery_result.png)

#### Adding fault tolerance
Fault tolerance: It is about how your system/software can tolerate a fault. The end user does not observe any fault, their interaction with system is less affected, though there might be longer delay periods than normal. 

Resilience: How many faults the system, can handle before it breaks/crashes down? The crashed/broken system can be observed by the end user. Is there a mechanism to recover from the fault. 

Scenario: If any of the the two services, movie details service or, rating data service becomes slow, not responding within required time, causing request in other part of the system to slow down. For each HTTP request, the web server spawns a thread to fulfill that request. If one the service becomes slow, i.e a thread is occupied(is busy) in serving the request, leading to exceed the total number of concurrent threads limit. 

Possible solution: Apply circuit breaker pattern on slow service.

What is circuit breaker pattern ?
 	1. You have a circuit breaker service that detects some service X is slowing down the system, causing timeout.
 	2. The circuit breaker service stops forwarding the request to service X, responds with error message to end user and keeps checking on it after a certain interval.
 	3. Once Service X is back again, the circuit  breaker releases the requests to service X.

So, how do we know when to requests are timing out and circuit breaker is needed?
Circuit breaker has certain parameters for that, it checks how many requests failed out of last "N" requests, what is timeout duration and how long to wait before making next request to that service X. 

How do we respond to the requests that are pending?
Have a fallback mechanism. You can either have default fallback message to the end users or serve the response saved in cache(recommeded).
​	














 
