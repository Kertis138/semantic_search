# owlbotTeam


####Note this!
```
Server has global and local properties environment.
Local properties (local.properties) is in a higher priority than properties in application.properties.
Also local.properties isn't added to Version Contol (git).
```

####For execution:
```
mvn clean package
java -jar path.jar
```

####Or you can use maven plugin:
```
mvn clean package
mvn exec:java
```

####Restful service provide next paths:
* /api/auth
    * /tokenize  (for access get token)
* /modules
    * /start
        * /
        * ?moduleId={moduleid}
    * /stop
        * /
        * ?moduleId={moduleid}
* /status
    * /
    * ?moduleId={moduleid}
* /database
    * /get?moduleId={moduleid}&var={var}



##The technologies we used:
* Maven
* Spring
    * Spring Core
    * Spring MVC
    * Spring Events
    * Spring XML Config
    * Spring Annotation Config
    * Spring Security
* Hibernate
    * Mapping
    * Hibernate Core
    * Hibernate Validation
    * HQL
* Jetty
* Gson
* Jackson
* Log4j

#ToDo:
* Root context configuration
* Auto models mapping
* Spring security setup
* (OWL) Twitch Auth implementation (utilities)
* Setup logging
* (OWL) Twitch Core class
* Security token service implementation
* Auth token handler
* User context setup
* Server host setup
* DAO services
* Check init system when new module created (Need optimization)
* Table modules reset auto increment into server initialization
* System recovering mode
* Not start module if already started
* Security service for check regular token getting (block by id)
* Check concurrent for hibernate services
* Secure token by md5