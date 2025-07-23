import Dependencies._

ThisBuild / scalaVersion := "3.3.6"
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild/organization := "com.premierdev"
ThisBuild/organizationName := "PremierDev"

lazy val root = (project in file("."))
  .settings(
    name := "iam-policy-generator",
    libraryDependencies ++= Seq(
      "com.ibm.cloud" % "sdk-core" % "9.24.3",
      munit % Test,
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-circe" % "2.36.7",
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.36.7" % Provided,
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "2.36.7"
    )
  )
