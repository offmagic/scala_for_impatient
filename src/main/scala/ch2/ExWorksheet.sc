import scala.math.pow

println("Ex 1 -------------------------------------------")
def signum(input: Int) = if (input > 0) 1 else if (input < 0) -1 else 0
val calculatedValue0 = signum(2)
val calculatedValue1 = signum(-2)
val calculatedValue2 = signum(0)

// можно ещё сделать с помщью patter matching:
// TODO: read about anonymous function in patter matching:
// http://scala-lang.org/files/archive/spec/2.11/08-pattern-matching.html#pattern-matching-anonymous-functions
def signumOther(input: Int) = input match {
  case in if in > 0 => 1
  case in if in < 0 => -1
  case in if in == 0 => 0
}

val calculatedValue3 = signum(2)
val calculatedValue4 = signum(-2)
val calculatedValue5 = signum(0)

println("Ex 2 -------------------------------------------")
val emptyBlock = {}
// Пустой блок возвращает объект Unit.

println("Ex 3 -------------------------------------------")
var y = 1
val x: AnyVal = y = 3
// Данное присвоение легально если x имеет тип тип Unit или его суперкласс AnyVal

println("Ex 4 -------------------------------------------")
// первый вариант, но он некрасивый
for (i <- 0 to 10; calc = 10 - i) println(calc)

// красивый
for (i <- (0 to 10).reverse) println(i)

println("Ex 5 -------------------------------------------")
def countDown(n: Int): Unit = {
  for (i <- (0 to n).reverse) println(i)
}
countDown(20)

println("Ex 6 -------------------------------------------")
var multi = 1L
for (ch <- "Hello") multi *= ch.toLong
println(multi)

println("Ex 7 -------------------------------------------")
// можно сделать с помощью foldLeft
println("Multi: " + "Hello".foldLeft(1L)((a, b) => a * b))

println("Ex 8 -------------------------------------------")
def product(s: String) = {
  s.foldLeft(1L)((a, b) => a * b)
}
println(product("Hello"))

println("Ex 9 -------------------------------------------")
def productRec(s: String, acc: Long = 1L): Long = {
  if (s.isEmpty) acc else productRec(s.tail, acc * s.head)
}
productRec("Hello")
// TODO: попробовать реализовать с помощью patter matching - case (head::tail)

println("Ex 10 ------------------------------------------")
def calc(x: Long, n: Long): Double = {
  if (n == 0) 1 // 0
  else if (n > 0 && n % 2 == 0) pow(calc(x, n / 2), 2)
  else if (n > 0 && n % 2 != 0) x * calc(x, n - 1)
  else 1 / calc(x, -n)
}
calc(4, -2)
calc(2, 4)




