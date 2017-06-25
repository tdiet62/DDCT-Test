package org.dietrich.entities

import scala.math.BigDecimal

class Order {

  def fillOrder(orders: List[String], printOrder: Boolean): List[Item] = {

    val menu: Menu = new Menu()
    var delivered: List[Item] = List[Item]()
    for (itemName <- orders) {
      var item: Item = menu.menu.get(itemName).get
      delivered = item :: delivered
      if (printOrder)
        printItem(item.name, item.cost)
    }
    delivered
  }

  def getBill(orders: List[String], printOrder: Boolean): BigDecimal = {
    val delivered = fillOrder(orders, printOrder)
    val totalCost = getPreChargeCost(delivered) + getServiceCharge(delivered, printOrder)
    if (printOrder) printToPay(totalCost)
    return totalCost
  }

  def getServiceCharge(delivered: List[Item], printOrder: Boolean): BigDecimal = {
    var serviceCharge: BigDecimal = 0.0
    val serviceChargePercentage: BigDecimal = getServiceChargePercentage(delivered, printOrder)
    delivered.foreach((item: Item) => serviceCharge += item.cost * serviceChargePercentage)
    if (printOrder)
      printServiceCharge(serviceCharge, serviceChargePercentage)
    serviceCharge
  }

  def getPreChargeCost(delivered: List[Item]): BigDecimal = {
    var preCharge: BigDecimal = 0.00
    delivered.foreach((item: Item) => preCharge += item.cost)
    preCharge
  }

  def getServiceChargePercentage(items: List[Item], printOrder: Boolean): BigDecimal = {
    items.reduceLeft(
      (i1: Item, i2: Item) =>
        {
          if (i1.serviceChargePercentage > i2.serviceChargePercentage)
            i1
          else i2
        }).serviceChargePercentage;
  }

  def printToPay = (totalCost: BigDecimal) => {
    val toPay = "To Pay"
    val orderCost: BigDecimal = totalCost.setScale(2)
    println(f"$toPay%-50s $orderCost%3.2f")
  }

  def printItem = (name: String, cost: BigDecimal) =>
    {
      println(f"$name%-50s $cost%3.2f")
    }

  def printServiceCharge(sc: BigDecimal, scp: BigDecimal) = {
    val intro: String = "Service Charge"
    println(f"\r\n$intro%-50s $sc%3.2f @ $scp%1.2f" + "%")
  }

}