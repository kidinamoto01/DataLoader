package com.sheshou

import java.util.{Calendar, Properties}

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{SQLContext, SaveMode}

/**
  * Created by suyu on 17-4-18.
  */
object Write2Mysql {

  def main(args: Array[String]) {

    if (args.length <4) {
      System.err.println(s"""
                            |Usage: DirectKafkaWordCount <brokers> <topics>
                            |  <path> is a list of one or more kafka topics to consume from
                            |  <mysqlurl>
                            |  <databasename>
                            |  <tablename>
        """.stripMargin)
      System.exit(1)
    }
    val Array(master,path,mysqlurl,databasename,tablename) = args
    println(path)
    println(mysqlurl)
    println(databasename)
    println(tablename)
    /*
    val logFile = "/usr/local/share/spark-2.1.0-bin-hadoop2.6/README.md" // Should be some file on your system
    val filepath = "hdfs://192.168.1.21:8020/sheshou/data/parquet/realtime/forcebreak/2017/4/16/17"
    val middlewarepath = "hdfs://192.168.1.21:8020/user/root/test/webmiddle/20170413/web.json"
    val hdfspath = "hdfs://192.168.1.21:8020/user/root/test/windowslogin/20170413/windowslogin"*/
    val filepath = path
    val conf = new SparkConf().setAppName("Offline Doc Application").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    //read json file
    val file =sqlContext.read.parquet(filepath)//.toDF()

    //MySQL connection property
    val prop = new Properties()
    prop.setProperty("user", "root")
    prop.setProperty("password", "andlinks")

    val dfWriter = file.write.mode("append").option("driver", "com.mysql.jdbc.Driver")
    dfWriter.jdbc("jdbc:mysql://"+mysqlurl+"/log_info", tablename, prop)

  }

}
