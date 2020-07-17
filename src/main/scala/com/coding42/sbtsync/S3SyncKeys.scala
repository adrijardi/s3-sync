package com.coding42.sbtsync

import sbt._

trait S3SyncKeys {
  /**
   * Runs the sync command using the aws cli
   */
  val s3Sync = taskKey[Unit]("Synchronises the files from `s3SyncLocalRoot` to `s3SyncBucket` by running the cli command")

  /**
   * Folder from which to upload files
   */
  val s3SyncLocalRoot = taskKey[String]("Local directory to sync")

  /**
   * Bucket to upload files to
   */
  val s3SyncBucket = taskKey[String]("Bucket to sync to")

}
