# Getting Started

### Installation
Execute `mvn clean install` from the project root folder
### Running the application
Execute `mvn spring-boot:run` from the project root folder
### Application Overview
This application works with data stored in CSV files and represents them in market sales reports.

When running the application you can find the data from `docs/data.csv` file listed on  
the index page -> `localhost:8080`. Quarterly reports are displayed on the `/sales` page  
from which it is possible to filter the data based on time frames and counties, as well as  
determine vendor market share for given time periods and locations.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/#build-image)

