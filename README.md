# PFE

## Run microservice
    $ docker pull quay.io/testcontainers/ryuk:0.2.2 (image used for test)
    $ docker-compose up -d
    $ run db init scripts : /src/main/resources/db/init-db.sql (to init database)
    $ export JAVA_HOME=`/usr/libexec/java_home -v 1.8.0_241`
    $ mvn clean install spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=development"
## Run package
    $ export JAVA_HOME=`/usr/libexec/java_home -v 1.8.0_241`
    $ mvn package (=> target/employee-0.0.1-SNAPSHOT.jar)
    end
