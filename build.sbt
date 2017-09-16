organization in ThisBuild := "com.nike.redwiggler"

name := "redwiggler"

scalaVersion in ThisBuild := "2.11.8"

lazy val core = (project in file("core"))
  .settings(
    libraryDependencies ++= Seq(
      "org.everit.json" % "org.everit.json.schema" % "1.5.1",
      "org.slf4j" % "slf4j-api" % "1.7.25",
      "io.spray" %%  "spray-json" % "1.3.3",
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )

lazy val swagger = (project in file("swagger"))
  .dependsOn(core)
  .settings(
    libraryDependencies ++= Seq(
      "io.swagger" % "swagger-parser" % "1.0.28",
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )

lazy val restassured = (project in file("restassured"))
  .dependsOn(core)
  .settings(
    libraryDependencies ++= Seq(
      "com.jayway.restassured" % "rest-assured" % "2.9.0"
    )
  )

lazy val html = (project in file("html"))
  .dependsOn(core)
  .enablePlugins(SbtTwirl)

lazy val root = (project in file("."))
  .aggregate(core, swagger, restassured, html)
