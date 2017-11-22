name := "iotvisualisering"

version := "0.1"

scalaVersion := "2.12.4"

enablePlugins(ScalaJSPlugin)

// Does this application have a main method?
scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.3"

libraryDependencies += "org.singlespaced" %%% "scalajs-d3" % "0.3.4"

resolvers += sbt.Resolver.bintrayRepo("denigma", "denigma-releases") //add resolver
libraryDependencies ++= Seq(
  "org.denigma" %%% "threejs-facade" % "0.0.77-0.1.8",
)

jsDependencies += "org.webjars" % "three.js" % "r77" / "three.js"
