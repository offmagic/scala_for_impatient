import scala.collection.JavaConverters

println("Ex 1 -------------------------------------------")
val goods = Map("Nike boots" -> 5000, "jacket" -> 8000)
for ((k, v) <- goods) yield k -> (v - (v / 10))

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





