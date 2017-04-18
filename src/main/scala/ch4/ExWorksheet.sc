import java.util.Calendar

import scala.collection.JavaConverters
import scala.collection.mutable.ArrayBuffer

println("Ex 1 -------------------------------------------")
val goods = Map("Nike boots" -> 5000, "jacket" -> 8000)
for ((k, v) <- goods) yield k -> (v - (v / 10))

println("Ex 6 -------------------------------------------")
Calendar.



println("Ex 7 -------------------------------------------")
def printSystemProp() {
  val sysProp = JavaConverters.propertiesAsScalaMap(System.getProperties)

  val (maxKeyLength, avgValueLength) = {
    val info = sysProp.foldLeft((0, 0))( // maxKeyLength, avgValueLength
      (b, a) => {
        val maxKeyLength = if (a._1.length > b._1) a._1.length else b._1
        val sumValueLength = b._2 + a._2.length
        (maxKeyLength, sumValueLength)
      }
    )
    (info._1, info._2 / sysProp.size)
  }

  // define padding and width of columns
  val leftPadding = 10
  val rightPadding = 10
  val widthKeyColumn = maxKeyLength + leftPadding
  val widthValueColumn = avgValueLength + rightPadding

  // print table
  printBorder()
  for ((k, v) <- sysProp; if v.length <= avgValueLength && v.length > 10) {
    // for simplification print such 10 < values <= avgValueLength
    printRow(k, v)
  }
  printBorder()

  /**
    * Print one row for key and value.
    *
    * @param key   Key
    * @param value Value
    */
  def printRow(key: String, value: String) = {
    print("|" + key + " " * (widthKeyColumn - key.length) + "|"
      + value + " " * (widthValueColumn - value.length) + "|\n")
  }

  /**
    * Print border (top, bottom)
    */
  def printBorder() = {
    print("|" + "-" * widthKeyColumn + "|" + "-" * widthValueColumn + "|\n")
  }
}

printSystemProp()

println("Ex 8 -------------------------------------------")
val input8 = ArrayBuffer(2, 4, 7, -1, -10, 9, 100)
val (min, max) = input8.foldRight(0 -> 0)((a, b) => {
  val min = if (a < b._1) a else b._1
  val max = if (a > b._2) a else b._2
  min -> max
})

println("Ex 9 -------------------------------------------")
def stat(array: Array[Int], v: Int) = {
  var counterLess, counterEquals, counterMore = 0;
  for (el <- array) {
    if (el < v) counterLess += 1
    else if (el == v) counterEquals += 1
    else counterMore += 1
  }
  (counterLess, counterEquals, counterMore)
}
stat(Array(5, 11, 10, -2, 9, 100, 54, 10), 10)

println("Ex 10 -------------------------------------------")
"Hello".zip("World")
// таким образом можно реализовать простейшее шифрование (хотя это не слишком реалистичный пример)
// Такая конструкция может помочь когда нужно заменить некие символы на другие
// Например в тексте запрещены знаки < > и их можно заменять на *
// ну и для генерации map таким замен может пригодиться например

var sourceString = "!Test string <big> </big>"
for ((k, v) <- "<>!%".zip("****").toMap)
  sourceString = sourceString.replace(k.toChar, v.toChar)
sourceString

// ну или реализовать побитовые операции











