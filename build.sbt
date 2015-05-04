
scalaVersion in ThisBuild := "2.11.6"

lazy val root = project.in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "dockerui",
    persistLauncher := true,
    scalacOptions ++= Seq(
      "-Xlint",
      "-deprecation",
      "-Xfatal-warnings"
    ),
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "upickle" % "0.2.8",
      "org.scala-js" %%% "scalajs-dom" % "0.8.0" withSources() withJavadoc(),
      "be.doeraene" %%% "scalajs-jquery" % "0.8.0",
      "com.github.japgolly.scalajs-react" %%% "extra" % "0.8.3"
    ),
    artifactPath in (Compile, fullOptJS) := (baseDirectory in ThisBuild).value / "chromeapp" / "scalajs-opt.js",
    artifactPath in (Compile, fastOptJS) := (baseDirectory in ThisBuild).value / "chromeapp" / "scalajs-fastopt.js",
    artifactPath in (Compile, packageScalaJSLauncher) := (baseDirectory in ThisBuild).value / "chromeapp" / "scalajs-launcher.js"
  )

pollInterval := 100
fork in run := true
