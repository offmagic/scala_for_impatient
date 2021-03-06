import math._
import scala.util.Random
import scala.BigInt.probablePrime

println("Ex 2 -------------------------------------------")
val calc1 = pow(sqrt(3), 2)

println("Ex 3 -------------------------------------------")
1 + 1
// res0 = 1 // res0 - это val

println("Ex 4 -------------------------------------------")
val calc2 = "crazy" * 3
// Метод "*" назодится в классе StringLike от которого наследуется StringOps.
// В объекте scala.Predef происходит implicit conversion java.lang.String в StringOps:
// implicit def augmentString(x: String): StringOps = new StringOps(x)

println("Ex 5 -------------------------------------------")
val calc3 = 10 max 2
// Метод max класса RichInt. Там такая же история как и с предыдущим примером
// TODO: Разобраться позже с Predef.LowPriorityImplicits, не понятно почему Low и какой конфликт

println("Ex 6 -------------------------------------------")
val calc4 = BigInt(2).pow(1024)

println("Ex 7 -------------------------------------------")
val calc5 = probablePrime(100, Random)
// нужно заимпортить import scala.BigInt.probablePrime ну или весь пакет ._
// и scala.util.Random

println("Ex 8 -------------------------------------------")
BigInt(Random.nextLong()).toString(36) // toString(x) вернуть результат в какой-нибудь др
// системе исчесления

println("Ex 9 -------------------------------------------")
val head = "testString1".head
val last = "testString1".last

println("Ex 10-------------------------------------------")
val take = "take".take(2)
val drop = "drop".drop(2)
val takeRight = "takeRight".takeRight(5)
val dropRight = "dropRight".dropRight(5)

val substring = "subString".substring(3)

// Все данные методы из трейта IndexedSeqOptimized написаны, чтобы не получить эксепшены.
// Например если передётся число меньше 0, то результатом будет просто пустая строка.
// После беглого просмотра, я не нашёл места где может появиться exception.
// Java версия облает меньшей гибкостью и нужно перед вызовом обязательно проверять границы ну или ловить
// эксепшены.

// С другой стороны в scala методах происходит итерация по элементам и добавление каждого символа в builder
// ну и в конце происходит преобразование в String

// В Java версии для substring мы ничего не делаем - берём создаём новую строку передавая конструктору
// массив char и границы. Так как String immutable и массив не может измениться, то это очень быстро.

// Вывод если мы имеем дело с огромными текстовыми документами, то скорее всего лучшим варинтом будет использование
// String(уменьшить элегантность, но получить хорошую производительность - хотя всё равно нужны тесты),
// в других случаях лучше использовать scala тип.



