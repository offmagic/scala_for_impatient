import scala.collection.JavaConverters

println("Ex 1 -------------------------------------------")
val goods = Map("Nike boots" -> 5000, "jacket" -> 8000)
for((k, v) <- goods) yield k -> (v - (v/10))

println("Ex 7 -------------------------------------------")
val sysProp = JavaConverters.propertiesAsScalaMap(System.getProperties)







