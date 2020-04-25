##Movie Catalog Application
###This is an hands on attempt to learn more about Microservices and how do you implement them in Java. 

#### Basic Setup
Here, is the link to the presentation where I have summarized the basics of Microservice Architecture and details of its components. My aim here is to learn about the basics of microservice in Java and service discovery using Eureka server by implementing a movie catalog application. Movie catalog application is for movies, similar to the way GoodReads is for the books.Now the first step is to go over the architecture. I will be creating 3 microservices, 
	1. Rating data service - which is responsible for providing the rating given to a movie by a user and also list of all ratings given by a user.
	2. Movie details service - which returns movie information for a movie ID.
	3. Cataloging service - which takes the results from rating data and movie details service, combines them and provides it to the client.
	 
As shown below in the diagram, how three services will interact.      

![service architecture]()


#### Adding Clientside Service Discovery -Eureka

For the services to communicate with each other, we should register them to eureka service discovery server and add eureka client to each of the 3 services. The architecture will be updated to the following:

![Architecture with service discovery]()

### Adding fault tolerance








 




 
