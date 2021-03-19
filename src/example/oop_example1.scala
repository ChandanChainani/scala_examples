import java.sql.Timestamp
import java.util.Calendar

object Utils {
  def getCurrentTimeStamp: Timestamp = {
    val cal = Calendar.getInstance
    cal.setTime(new java.util.Date())
    cal.set(Calendar.MILLISECOND, 0)
    (new Timestamp(cal.getTimeInMillis))
  }
  def getCurrentTimeStampString: String = {
    this.getCurrentTimeStamp.toString
  }
}

abstract class Logging {
  val className: String

  def process(x: String): Unit

  def run(name: String) : Unit = {
    println(Utils.getCurrentTimeStampString + s" |  STARTED  | $className | `$name`")
    println(s"$name calling")
    try {
      // throw new Exception("EXCEPTION")
      process(name)

      println(Utils.getCurrentTimeStampString + s" | COMPLETED | $className | `$name`")
    }
    catch {
      case e: Exception => {
        val e_msg = e.getMessage
        // println(className, e_msg)
        println(Utils.getCurrentTimeStampString + s" |   ERROR   | $className | `$name` | $e_msg")
      }
    }
  }
}

object Log extends Logging {
  override val className = this.getClass.getSimpleName
    .slice(0, this.getClass.getSimpleName.length - 1)

  override def process(name: String) : Unit = {
    // println("running")
    println(Utils.getCurrentTimeStampString + s" |  RUNNING  | $className | `$name`")
    println(s"$name called")
  }
}

object Main extends App {
  Log.run("example")
  // println(args.toList, this.args.toList)
  // println(this.getClass.getMethods().toList)
}
