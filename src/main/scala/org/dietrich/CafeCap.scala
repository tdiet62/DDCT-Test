package org.dietrich

import org.dietrich.entities.Order

object CafeCap extends App {
  var order:Order = new Order();
  
  override def main(args:Array[String]){
    var o:Order = new Order()
  
  //Example 1 -  Place an order for drinks only
    placeOrder("Placing a drinks-only order",List[String]("Coffee","Coffee","Cola","Cola"))
  //Example 2 - Placing an order with drinks and cold food
    placeOrder("Placing a drinks-and-cold-food order",List[String]("Coffee","Cheese Sandwich","Cola","Cheese Sandwich"))  
   //Example 3 - Placing an order with drinks and hot and cold food
    placeOrder("Placing a drinks-and-food order",List[String]("Coffee","Steak Sandwich","Cola","Cheese Sandwich"))
  }
  
  def placeOrder(orderDescription:String,items:List[String]){
    println(orderDescription+" :\r\n")
    order = new Order()
    order.addItems(items)
    order.fillOrder()
    order.getBill()
  println("Service Charge is: \t\t"+order.serviceCharge+"\t@ "+order.serviceChargePercentage.setScale(2)+"%")
  println("Total Cost of Order is: \t\t"+order.totalCost)
  println("\r\n========== End of Order ===========")
  }
}