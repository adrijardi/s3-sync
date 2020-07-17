# S3-sync

Simple sbt plugin to synchronise your local files to an S3 bucket. 
Useful to upload the outcome of a compiled website to S3.

Currently, this is a very simple plugin that that executes the command `aws s3 sync folder s3://bucket` 
and therefore you might be better off by just running the command yourself.

## Usage

- Add to `plugins.sbt`

```
addSbtPlugin("com.coding42" % "s3-sync" % "0.1.0")
```

- Add to `build.sbt`

```
s3SyncLocalRoot := "dist"
s3SyncBucket := "my-bucket.example.com"
```

- Run `sbt s3Sync`

## Future work

- Use the Java SDK to perform the sync
- Provide different options to add credentials
 