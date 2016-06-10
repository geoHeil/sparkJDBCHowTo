package sparkDb

import java.util.Properties

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{ SparkConf, SparkContext }

object DBConnection extends App {

  override def main(args: Array[String]) = {
    val conf = new SparkConf()
      .setAppName("db-jdbc-connection")
      .setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sql = new HiveContext(sc)

    val prop = new Properties()
    prop.put("user", "foo")
    prop.put("password", "foo")
    prop.put("driver", "org.postgresql.Driver")
    import sql.implicits._

    val df = sc.parallelize(Array((1, 234), (2, 1233))).toDF("id", "val")
    val dfWriter = df.write.mode("append")

    //TODO how to read and write from spark in & from a JDBC connection?
    dfWriter.jdbc("jdbc:postgresql://localhost:5432/foo", "table1", prop)

    sc.stop
  }
}