package com.github.plokhotnyuk.jsoniter_scala.core

private[core] object Platform {
  @inline def stringFromByteArray(bytes: Array[Byte]): String =
    new String(bytes, 0, 0, bytes.length)

  @inline def stringFromByteArray(bytes: Array[Byte], offset: Int, count: Int): String =
    new String(bytes, 0, offset, count)

  @inline def getBytesFromString(str: String, srcBegin: Int, srcEnd: Int, dst: Array[Byte], dstBegin: Int): Unit =
    str.getBytes(srcBegin, srcEnd, dst, dstBegin)

  @inline def doubleToLongBits(double: Double): Long =
    java.lang.Double.doubleToRawLongBits(double)

  @inline def floatToIntBits(float: Float): Int =
    java.lang.Float.floatToRawIntBits(float)
}
