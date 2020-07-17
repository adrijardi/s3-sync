import xerial.sbt.Sonatype._

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    publishSettings,
    sbtPlugin := true,
    organization := "com.coding42",
    name := "s3-sync",
    version := "0.1.0"
  )

lazy val publishSettings = Seq(
  publishTo := sonatypePublishToBundle.value,
  publishMavenStyle := true,
  licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  sonatypeProjectHosting := Some(GitHubHosting("adrijardi", "s3-sync", "adrian@coding42.com")),
)
