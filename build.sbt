import Dependencies._

version := "0.1"

scalaVersion := "2.12.8"

lazy val sharedDependencies = Seq(logback, `scala-logging`)
lazy val testDependencies = Seq(scalatest)

lazy val `domain-boundaries` = project
  .settings(
    libraryDependencies ++= sharedDependencies,
    name := "domain-boundaries"
  )

lazy val `domain-core` = project
  .dependsOn(`domain-boundaries`)
  .settings(
    libraryDependencies ++= sharedDependencies ++ testDependencies,
    name := "domain-core"
  )

lazy val `infrastructure` = project
  .dependsOn(`domain-boundaries`)
  .settings(
    libraryDependencies ++= sharedDependencies ++ testDependencies,
    name := "infrastructure"
  )

lazy val root = (project in file("."))
  .aggregate(`domain-boundaries`, `domain-core`, infrastructure)
  .dependsOn(`domain-boundaries`, `domain-core`, infrastructure)
  .settings(name := "cafe-cqrs-tutorial")
