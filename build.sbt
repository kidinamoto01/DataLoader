name := "DataLoader"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "Hortonworks Repository" at "http://repo.hortonworks.com/content/repositories/releases/"

resolvers += "Hortonworks Jetty Maven Repository" at "http://repo.hortonworks.com/content/repositories/jetty-hadoop/"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.2"%"provided"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.0.0.2.5.3.0-37"

libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.0"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.12"

libraryDependencies +="org.apache.kafka"%"kafka-clients"%"0.10.0.0"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.26"

libraryDependencies +="org.apache.spark"%"spark-streaming-kafka-0-8-assembly_2.11"%"2.0.0.2.5.3.0-37"


assemblyMergeStrategy in assembly := {
  case PathList("com",   "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com",   "squareup", xs @ _*) => MergeStrategy.last
  case PathList("com",   "sun", xs @ _*) => MergeStrategy.last
  case PathList("com",   "thoughtworks", xs @ _*) => MergeStrategy.last
  case PathList("commons-beanutils", xs @ _*) => MergeStrategy.last
  case PathList("commons-cli", xs @ _*) => MergeStrategy.last
  case PathList("commons-collections", xs @ _*) => MergeStrategy.last
  case PathList("commons-io", xs @ _*) => MergeStrategy.last
  case PathList("io",    "netty", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("javax", "xml", xs @ _*) => MergeStrategy.last
  case PathList("org",   "apache", xs @ _*) => MergeStrategy.last
  case PathList("org",   "codehaus", xs @ _*) => MergeStrategy.last
  case PathList("org",   "fusesource", xs @ _*) => MergeStrategy.last
  case PathList("org",   "mortbay", xs @ _*) => MergeStrategy.last
  case PathList("org",   "tukaani", xs @ _*) => MergeStrategy.last
  case PathList("xerces", xs @ _*) => MergeStrategy.last
  case PathList("xmlenc", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
