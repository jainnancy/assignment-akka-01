name := "assignment-akka-1"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq("log4j" % "log4j" % "1.2.17",
  "com.typesafe.akka" %% "akka-actor" % "2.5.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.9" % Test)

