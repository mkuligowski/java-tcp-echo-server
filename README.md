# java-tcp-echo-server
Java TCP Echo Server (University Project)

This is simple multithreaded Java TCP Echo Server.

You can just run it and it will start listening on port 9000 with initial thread pool of 10 threads.

You can pass also two command line arguments where:
* arg[0] is a port
* arg[1] is a quantity of threads in the pool. If the value of this argument is -1 then new thread will be created each time
