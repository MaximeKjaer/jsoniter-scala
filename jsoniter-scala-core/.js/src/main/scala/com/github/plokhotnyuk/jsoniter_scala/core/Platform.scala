package com.github.plokhotnyuk.jsoniter_scala.core

private[core] object Platform {
  final val isGraalVM: Boolean = false

  @inline def stringFromByteArray(bytes: Array[Byte]): String =
    new String(bytes)

  @inline def stringFromByteArray(bytes: Array[Byte], offset: Int, count: Int): String =
    new String(bytes, offset, count)

  @inline def getBytesFromString(str: String, srcBegin: Int, srcEnd: Int, dst: Array[Byte], dstBegin: Int): Unit =
    str.substring(srcBegin, srcEnd).getBytes.copyToArray(dst, dstBegin)

  @inline def doubleToLongBits(double: Double): Long =
    java.lang.Double.doubleToLongBits(double)

  @inline def floatToIntBits(float: Float): Int =
    java.lang.Float.floatToIntBits(float)
}
