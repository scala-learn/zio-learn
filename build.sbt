ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.17"

lazy val root = (project in file("."))
  .settings(
    name := "zio-learn",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.0.5"
    )
  )
