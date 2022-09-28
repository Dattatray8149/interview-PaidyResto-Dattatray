This restaurant system is implemented in Core Java. As explained in question thrid pary libraries are not used like jbdc libraries for Database connection, Rest API framework libraries.  The solution is designed to solve the concurrency problem and this system should be scalable. 
Data is stored in Cache (HasMap for simiplicity)

PRoduction ready solution may include
-------------------------------------------------------------------
Next step in this solution would be Create UI for system, use DB libraries for persistent storage , create REST APIs and call from UI, deploy the application in Kubernetes cluster in order to auto-upsclaing and auto-downscaling . Kubernetes HPA can be used to achieve this.
Other things like Load balance for full production ready setup can be achieved using Kubernetes Ingress. 
The application is containerised using docker
All unit test coverage with few integration tests would add ability to the application  a self quality assurance capability

Assumption
---------------------------------------------------------------------
Simulatenious 10 users can use this system assuming for one restaurant this can be the max number of concurrent request.
All order placing is automated in code. Each thread places order using random numbers and random menu item.
At any time any user (thread) can check the all order status or current order status
Relevant comments has been added in code
As time contraint is there extra feature haven't been added. Also Junit coverage could have been added here.
Basic OOPs concepts implemented. 



How to run application
---------------------------------------------------------
As its core java application , import as project and compile it using any IDE (Intellij) / traditional javac command also fine
In IDE , use RestaurantServer main class OR After compilation jar file should be created  and can be run.
Watch the 10 threads created and each thread is placing order independently.
All multi-threaded
All order cache and order numbers have been synchronized to run smoothly in multi-threaded environment
 