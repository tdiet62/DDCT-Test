package org.dietrich.entities

import scala.math.BigDecimal

class Order {
  var ordered: List[String] = List[String]()
  var delivered: List[Item] = List[Item]()
  var serviceChargePercentage: BigDecimal = 0.00
  var serviceCharge: BigDecimal = 0.00
  var totalCost: BigDecimal = 0.00
  var preChargeCost: BigDecimal = 0.00
  var menu: Menu = new Menu()

  def addItem(item: String) {
    ordered = item :: ordered
  }

  def addItems(items: List[String]) {
    for (item <- items) {
      addItem(item)
    }
  }

  def fillOrder() {
    for (itemName <- ordered) {
      var item: Item = menu.menu.get(itemName).get
      delivered = item :: delivered
      addItemCost(item)
    }
  }

  def getBill(): BigDecimal = {
    //reset everything - bill is always calculated complete fresh
    preChargeCost = 0.00
    totalCost = 0.00
    serviceCharge = 0.00
    serviceChargePercentage = 0.00
    delivered = List[Item]()
    fillOrder()
    serviceCharge = (preChargeCost * serviceChargePercentage).setScale(2,BigDecimal.RoundingMode.HALF_DOWN)
    totalCost = preChargeCost + serviceCharge
    return totalCost
  }

  def addItemCost(item: Item) {
    var name: String = item.name
    var cost: BigDecimal = item.cost.setScale(2)
    println(f"$name%-40s $cost%3.2f")
    preChargeCost += item.cost
    checkForServiceChargeMeal(item)
  }

  def checkForServiceChargeMeal(item: Item) {
    item.food match {
                      case true => {
                                      if (serviceChargePercentage == 0.00) {
                                        serviceChargePercentage = 0.10
                                      }
                                      checkForServiceChargeHotFood(item)
                                    }
                      case false => //do nothing
                    }
  }

  def checkForServiceChargeHotFood(item: Item) {
    //implicit that we are dealing with a 'food' item here, as this method only called where item is 'food'
    item.hot match {
                      case true => {
                        serviceChargePercentage = 0.20
                      }
                      case false => //do nothing
                    }
   }

}