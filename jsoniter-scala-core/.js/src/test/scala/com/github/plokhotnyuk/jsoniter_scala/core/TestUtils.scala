package com.github.plokhotnyuk.jsoniter_scala.core
import java.io.{ByteArrayInputStream, InputStream}

object TestUtils {
  val isJDK8: Boolean = false
  val isJS: Boolean = true

  def getResourceAsStream(resource: String): java.io.InputStream = {
    val resourcePath = Path.join(
      "jsoniter-scala-core",
      "src", "test", "resources",
      "com", "github", "plokhotnyuk", "jsoniter_scala", "core",
      resource
    )
    new ByteArrayInputStream(FS.readFileSync(resourcePath, "utf8").getBytes)
  }

  def bytes(inputStream: InputStream): Array[Byte] =  {
    Iterator.continually(inputStream.read())
      .takeWhile(_ != -1)
      .map(_.toByte)
      .toArray
  }

  def lowercaseHex(b: Byte): String = {
    // In Scala.js, String.format takes Bytes to be Ints, so extra 0xff are added
    String.format("%02x", b & 0xff)
  }

  def uppercaseHex(b: Byte): String = {
    // In Scala.js, String.format takes Bytes to be Ints, so extra 0xff are added
    String.format("%02X", b & 0xff)
  }

  def jvmOnly(thunk: => Unit): Unit = {}
}
