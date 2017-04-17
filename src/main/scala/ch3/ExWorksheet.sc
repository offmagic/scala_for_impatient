import java.util.TimeZone

import scala.collection.JavaConverters
import scala.collection.mutable.ArrayBuffer

println("Ex 1 -------------------------------------------")
// возвращение немутабельного Vector
def getArray(max: Int) = {
  for (i <- 0 until 10) yield i
}
getArray(10)

// возвращение Array
def getArrayMutable(max: Int) = {
  val array = new Array[Int](max)
  for (i <- 0 until 10) array(i) = i
  array
}
val mutableArray = getArrayMutable(10);

println("Ex 2 -------------------------------------------")
val inputArray = Array(1, 2, 3, 4, 5)
for (i <- 0 until(inputArray.length, 2)) {
  if (i + 1 < inputArray.length) {
    val tmp = inputArray(i)
    inputArray(i) = inputArray(i + 1)
    inputArray(i + 1) = tmp
  }
}
inputArray

println("Ex 3 -------------------------------------------")
val newInputArray = Array(1, 2, 3, 4, 5)
for (i <- newInputArray.indices;
     j = if (i % 2 == 0)
       if (i + 1 < newInputArray.length) i + 1 else i
     else i - 1)
  yield newInputArray(j)

println("Ex 4 -------------------------------------------")
val newInputArray2 = Array(1, 2, -3, -4, 5, 0, 10)
val poz = new ArrayBuffer[Int]()
val other = new ArrayBuffer[Int]()

val array = {
  for (el <- newInputArray2) {
    if (el > 0)
      poz += el
    else
      other += el
  }
  poz ++= other
}
println("Ex 5 -------------------------------------------")
val inputArray2 = Array(1.0, 4.0, 6.0, 8.0)
val avg = inputArray.sum / inputArray.length

println("Ex 6 -------------------------------------------")
val inputArray3 = Array(1, 4, 6, 8)
val sorted = inputArray3.sortWith(_ > _)

// тоже самое и для ArrayBuffer
val buffer = ArrayBuffer(1.0, 3.0, 0.0).sortWith(_ > _)

println("Ex 7 -------------------------------------------")
Array(4, 5, 6, 6, 5, 1, 4, 1).distinct

println("Ex 8 -------------------------------------------")
val inputArray4 = ArrayBuffer(1, 0, 4, 6, 8, -2, -5, 10, -1)
val negativeElements = for (i <-
                            (for (i <- inputArray4.indices; if inputArray4(i) <= 0) yield i).reverse)
  yield inputArray4.remove(i)

inputArray4 ++= negativeElements.reverse

// Данный алгоритм экономит память, нам не нужно создавать два ArrayBuffer, чтобы сохранять
// положительные и отрицательные + нулевые элементы, но есть минус, что при удалении
// все элементы сдвигаются влево. Ну и плюс накладные расходы на reverse
// (реализовано через List(head::tail) При малом колличестве отрицательных элементов - он экономит память.
// При большом колличестве - полностью невыгоден из-за сдвига.

println("Ex 9 -------------------------------------------")
val timeZones = TimeZone.getAvailableIDs()
timeZones.filter(x => x.startsWith("America/")).map(x => x.substring(8)).sorted

println("Ex 10 ------------------------------------------")
import java.awt.datatransfer._
import scala.collection.JavaConverters
val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
val images =  JavaConverters.asScalaBuffer(flavors.getNativesForFlavor(DataFlavor.imageFlavor))






