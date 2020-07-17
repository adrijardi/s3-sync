package com.coding42.s3sync

import sbt._

import scala.language.postfixOps
import scala.sys.process._

object S3Sync extends AutoPlugin {
  object autoImport extends S3SyncKeys
  import autoImport._

  override def trigger = allRequirements

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    s3Sync := syncTask.value,
    s3SyncLocalRoot := "",
    s3SyncBucket := "",
  )

  lazy val syncTask = Def.task {
    (s3SyncLocalRoot.value, s3SyncBucket.value) match {
      case ("", _) => sys.error("s3SyncLocalRoot setting is required for s3Sync")
      case (_, "") => sys.error("s3SyncBucket setting is required for s3Sync")
      case (local, bucket) =>
        println(s"""Syncing s3 from $local to $bucket""")
        s"aws s3 sync $local s3://$bucket" !
    }
  }

}
