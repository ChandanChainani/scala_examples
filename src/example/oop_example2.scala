package example

import java.lang.ClassNotFoundException

// import com.google.inject.AbstractModule

// import com.typesafe.config.{
//   Config,
//   ConfigFactory
// }

// import java.io.{
//   Reader,
//   File
// }
// import java.util.Properties

// import reflect.runtime.universe._

/// import scala.concurrent.duration.Duration
/// import scala.concurrent.ExecutionContext.Implicits.global
// import scala.concurrent.{
//   Future,
//   Await
// }
// import scala.io.Source
// import scala.io.StdIn.readLine
import scala.sys.process._
// import java.lang.reflect.Method

trait TestTrait {
  def main() : Unit
}

object Sample extends TestTrait {
  override def main() : Unit = {
    println("Sample Main")
  }
}

object DynamicRef {
   def objectReferenceByPackage(packageName: String, elementName: String) : TestTrait = {
     val packageWithElementName = s"$packageName.$elementName"
     // println(packageWithElementName)

     // 1 try
     // val s = str.toCharArray()
     // s(0) += 32
     // val n = new String(s)


     // val runClass = Class.forName(packageName + n)
     // println("name", runClass.getName)
     // val ins = Class.forName("example." + n, true, this.getClass.getClassLoader)
     // ins.getMethod("Sample", List())
     // println(ins.getMethods.toList)
     // val m = (runClass.getClasses(0)) runClass.newInstance()
     // println(runClass.getGenericInterfaces)
     // val m = runClass.getDeclaredMethods
     // // runClass.getDeclaredMethod("Sample", String.class)
     // m.foreach(f => {
     //   val nname = m.g
     //   m.getClass.getTypeParameters.foreach(println)
     //   println("name", nname)
     // })
     // println(runClass)

     // 2 try
     // try {
     //   val cons = Class.forName("example." + str + "$").getDeclaredConstructors();
     //   println(cons.toList)
     //   println(Class.forName("example." + str + "$").getMethods)
     //   cons(0).setAccessible(true);
     //   val someObjectTrait: TestTrait = cons(0).newInstance().asInstanceOf[TestTrait]
     //   println("calling someObjectTrait: ")
     //   someObjectTrait.run()

     //   val runClass = Class.forName("example." + str)
     //   val tClass = runClass.getClass
     //   val j = tClass.newInstance()
     //   print(runClass, tClass, runClass.getClassLoader, runClass.getName, runClass.getTypeName, runClass.getPackage, runClass.getSimpleName)

     //   val runMethod = runClass.getClass.getMethod("run")
     //   val result = runMethod.invoke(runClass, data.getClass)
     //   println(result)

     //     .getMethod("run", x$2)
     //     println("here", runClass)
     //     runClass.getMethod("run", data)
     //     val runMethod = runClass.getDeclaredMethod("run", classOf[String])
     // }
     // catch {
     //   case e: ClassNotFoundException => println("stack", e)
     // }

     // println(runClass.getMethods.toList, runClass.getFields.toList, runClass)

     // 3 try
     // val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
     // val moduleSymbol = runtimeMirror.moduleSymbol(
     //   Class.forName(packageWithElementName))

     // val targetMethod = moduleSymbol.typeSignature
     //   .members
     //   .filter(x => x.isMethod && x.name.toString == methodName)
     //   .head
     //   .asMethod

     // return runtimeMirror.reflect(runtimeMirror.reflectModule(moduleSymbol).instance)
     //   .reflectMethod(targetMethod)

     // 4 try
     // val m = universe.runtimeMirror(getClass.getClassLoader)
     // val module = m.staticModule(packageWithElementName)
     // val im = m.reflectModule(module)
     // // val method = im.symbol.info.decl(universe.TermName(methodName)).asMethod
     // val method = im.symbol.typeSignature.member(universe.TermName(methodName)).asMethod
     // val objMirror = m.reflect(im.instance)
     // objMirror.reflectMethod(method)

     // 5 try
     // val mirror = universe.runtimeMirror(getClass.getClassLoader);
     // val classInstance = Class.forName(packageWithElementName + "$");
     // val classSymbol = mirror.classSymbol(classInstance);
     // val classType = classSymbol.toType;//println(classType) gives ABC
     // /******this line does not work*****/
     // println("symbol", classSymbol)
     // println(classType)
     // println(classInstance)
     // println(classInstance.getClass)
     // println(classType.getClass)
     // println(classSymbol.getClass)
     // // println(classInstance.getMethod("Sample", ))
     // // classInstance.newInstance().asInstanceOf[classType];
     // println(classInstance.newInstance())
     // println(classInstance.newInstance().getClass)


     // 6 try
     val cons = Class.forName(packageWithElementName + "$").getDeclaredConstructors()
     cons(0).setAccessible(true)
     //    val someObjectTrait: TestTrait = cons(0).newInstance().asInstanceOf[TestTrait]
     //    println("calling someObjectTrait: " + someObjectTrait.run _)
     return cons(0).newInstance().asInstanceOf[TestTrait]
   }
}

object OOP_Example2 extends App {
  val classPackage = "example"
  val callObject = "Sample"

  // val m = objectReferenceByPackage(classPackage + "." + nname, "Sample")
  val m = DynamicRef.objectReferenceByPackage(classPackage, callObject)
  // println("method", m)
  m.main()
}
