import sbt._

object Dependencies {
  lazy val munit = "org.scalameta" %% "munit" % "0.7.29"

  lazy val sdkCore = "com.ibm.cloud" % "sdk-core" % "9.24.3"

  lazy val jsoniterScalaCirce = "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-circe" % "2.36.7"
  lazy val jsoniterScalaMacros = "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.36.7"
  lazy val jsoniterScalaCore = "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "2.36.7"

  lazy val iamcredentials= "com.anymindgroup" %% "zio-gcp-iamcredentials-v1" % "0.2.0"

  lazy val storage ="com.anymindgroup" %% "zio-gcp-storage-v1" % "0.2.0"

  lazy val pubsub = "com.anymindgroup" %% "zio-gcp-pubsub-v1" % "0.2.0"

  
}

