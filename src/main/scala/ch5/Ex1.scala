package ch5

/**
  * Created by aboznyak on 24.04.2017.
  */
object Ex1 extends App {

  val counter1: Counter = new Counter
  for (_ <- 0 to Int.MaxValue) counter1.increment
  println(counter1.current)

}

class Counter {
  private var value = 0

  def increment = {
    if (value == Int.MaxValue) {
      throw new IllegalAccessError("You cannot increment value more than Int.MaxValue")
    }
    value += 1
  }

  def current = {
    value
  }
}
