import java.sql.Timestamp
import org.apache.spark.sql.functions._

// val columns = Seq("language","users_count")
// val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))

val columns = Seq("created", "timestamp")
val df = Seq(
  (1519858893, Timestamp.valueOf("2018-03-01 00:01:33")),
  (1519858950, Timestamp.valueOf("2018-03-01 00:02:30")),
  (1519859900, Timestamp.valueOf("2018-03-01 00:18:20")),
  (1519859900, Timestamp.valueOf("2018-03-01 00:18:20"))
).toDF(columns: _*)
println(df.schema)
df.printSchema
df.show
df.withColumn("timestamp", to_utc_timestamp(date_format(col("created"), "yyy-MM-dd"), "Asia/Kathmandu"))



val df = Seq(("2019-07-01 12:01:19.000"),
    ("2019-06-24 12:01:19.000"),
    ("2019-11-16 16:44:55.406"),
    ("2019-11-16 16:50:59.406")).toDF("input_timestamp")

  //Timestamp String to DateType
  df.withColumn("datetype", to_date(col("input_timestamp"),"yyyy-MM-dd")).show(false)


val sdf = new java.text.SimpleDateFormat("dd-MM-yyyy")

val year = 2014
val month = 10
val day = 31
Calendar cal = java.util.Calendar.getInstance()
cal.set(java.util.Calendar.YEAR, year);
cal.set(java.util.Calendar.MONTH, month - 1); // <-- months start
                                    // at 0.
cal.set(java.util.Calendar.DAY_OF_MONTH, day);

val date = new java.sql.Date(cal.getTimeInMillis());
println(sdf.format(date));
