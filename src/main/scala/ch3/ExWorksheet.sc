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

