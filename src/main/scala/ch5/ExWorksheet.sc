import scala.beans.BeanProperty

println("Ex 2 -------------------------------------------")

class BankAccount(private[this] var balance: Int) {

  def deposit(deposit: Int) = {
    balance += deposit
  }

  def withdraw(withdraw: Int) = {
    balance -= withdraw
  }

  def current = balance
}

val bankAccount1: BankAccount = new BankAccount(0);
bankAccount1.deposit(1000)
bankAccount1.withdraw(999)
println(bankAccount1.current)

println("Ex 3 -------------------------------------------")

class Time(val hours: Int, val minutes: Int) {

  def before(other: Time): Boolean = {
    if (hours < other.hours) true
    else if (hours == other.hours && minutes < other.minutes) true
    else false
  }
}

var time1 = new Time(10, 15)
var time2 = new Time(10, 14)
println(time1.before(time2))
time1 = new Time(10, 15)
time2 = new Time(10, 30)
println(time1.before(time2))

println("Ex 4 -------------------------------------------")
class Time2(val hours: Int, val minutes: Int) {

  val minutesAfterMidnight = hours * 60 + minutes

  def before(other: Time2): Boolean = {
    if (minutesAfterMidnight < other.minutesAfterMidnight) true
    else false
  }
}

var anotherTime1 = new Time2(10, 15)
var anotherTime2 = new Time2(10, 14)
println(anotherTime1.before(anotherTime2))
anotherTime1 = new Time2(10, 15)
anotherTime2 = new Time2(10, 30)
println(anotherTime1.before(anotherTime2))

println("Ex 5 -------------------------------------------")

class Student(@BeanProperty var id: Long, @BeanProperty var name: String) {

}