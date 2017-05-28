package org.dietrich

import org.dietrich.entities.Order

object CafeCap extends App {
  var order: Order = new Order();

  override def main(args: Array[String]) {

    //Example 1 -  Place an order for drinks only
    placeOrder("Placing a drinks-only order", List[String]("Coffee", "Coffee", "Cola", "Cola"))
    //Example 2 - Placing an order with drinks and cold food
    placeOrder("Placing a drinks-and-cold-food order", List[String]("Coffee", "Cheese Sandwich", "Cola", "Cheese Sandwich"))
    //Example 3 - Placing an order with drinks and hot and cold food
    placeOrder("Placing a drinks-and-food order", List[String]("Coffee", "Steak Sandwich", "Cola", "Cheese Sandwich"))
  }

  def placeOrder(orderDescription: String, items: List[String]) {
    println(orderDescription + " :\r\n")
    var order = new Order()
    order.addItems(items)
    order.getBill()
    var intro: String=""
    if (order.serviceChargePercentage > 0.00) {
      intro = "Service Charge "
      var sc: BigDecimal = order.serviceCharge
      var scp: BigDecimal = order.serviceChargePercentage * 100
      println(f"\r\n$intro%-50s $sc%3.2f @ $scp%1.2f" + "%")
    }else{
      println("\r")
    }
    intro = "To Pay"
    var orderCost: BigDecimal = order.totalCost.setScale(2)
    println(f"$intro%-50s $orderCost%3.2f")
    println("\r\n========== End of Order ===========")
  }
}