package org.dietrich

import org.dietrich.entities.Order

object CafeCap extends App {
  
  var o:Order = new Order()
  
  //Example 1 -  Place an order for drinks only
  println("Placing a drinks-only order:\r\n")
  o.addItems(List[String]("Coffee","Coffee","Cola","Cola"))
  var cost:BigDecimal = o.getBill()
  println("Total Cost of Order is: \t\t"+cost)
  
  //Example 2 - Placing an order with drinks and cold food
  o=new Order()
  println("Placing a drinks-and-cold-food order:\r\n")
  o.addItems(List[String]("Coffee","Cheese Sandwich","Cola","Cheese Sandwich"))
  cost = o.getBill()
  println("Total Cost of Order is: \t\t"+cost)
  
   //Example 2 - Placing an order with drinks and cold food
  o=new Order()
  println("Placing a drinks-and-food order:\r\n")
  o.addItems(List[String]("Coffee","Steak Sandwich","Cola","Cheese Sandwich"))
  cost = o.getBill()
  println("Total Cost of Order is: \t\t"+cost)
}