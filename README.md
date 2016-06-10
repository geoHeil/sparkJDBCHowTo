# Experiments trying to connect spark with JDBC

  - install scala & sbt
  - create a jar file using `sbt assembly`
  - execute via `spark-submit`, keep in mind the database-driver is already included in the JAR

  ```
  spark-submit --packages 'org.postgresql:postgresql:9.4-1201-jdbc4' target/scala-2.10/foosparkdb-assembly-0.0.1.SNAPSHOT.jar
  spark-submit target/scala-2.10/foosparkdb-assembly-0.0.1.SNAPSHOT.jar
  ```
  unfortunately so far only resulted in ` java.sql.SQLException: No suitable driver` for both commands above.

  What is wrong with my approach?