name := "foosparkdb"
organization := "connect-spark-to-db"
version := "0.0.1.SNAPSHOT"

scalaVersion := "2.10.6"

scalacOptions ++= Seq("-deprecation")

lazy val spark = "1.6.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % spark % "provided",
  "org.apache.spark" %% "spark-hive" % spark % "provided",
  "org.apache.spark" %% "spark-sql" % spark % "provided",
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42"
)

mainClass := Some("sparkDb.DBConnection")