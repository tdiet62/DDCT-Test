package org.dietrich

import org.dietrich.entities.Order
import org.dietrich.entities.Item

object CafeCap extends App {

  override def main(args: Array[String]) {
    //Example 1 -  Place an order for drinks only
    placeOrder("Placing a drinks-only order", List[String]("Coffee", "Coffee", "Cola", "Cola"), true)
    //Example 2 - Placing an order with drinks and cold food
    placeOrder("Placing a drinks-and-cold-food order", List[String]("Coffee", "Cheese Sandwich", "Cola", "Cheese Sandwich"), true)
    //Example 3 - Placing an order with drinks and hot and cold food
    placeOrder("Placing a drinks-and-food order", List[String]("Coffee", "Steak Sandwich", "Cola", "Cheese Sandwich"), true)
    //Example 4 - Placing an order with drinks and hot and cold food
    placeOrder("Placing a food only order", List[String]("Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Cheese Sandwich"), true)
  }

  def placeOrder(orderDescription: String, items: List[String], printOrder: Boolean) =
    {
      println(orderDescription + " :\r\n")
      new Order().getBill(items, printOrder)
      println("\r\n========== End of Order ===========")
    }

}