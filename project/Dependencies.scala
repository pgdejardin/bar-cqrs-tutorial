import sbt._

object Dependencies {
  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
  lazy val `scala-logging` = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
  lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.6" % Test
}
