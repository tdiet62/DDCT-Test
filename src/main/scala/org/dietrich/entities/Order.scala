package org.dietrich.entities

import scala.math.BigDecimal

class Order {
  var ordered:List[String] = List[String]()
  var delivered:List[Item] = List[Item]()
  var serviceCharge:BigDecimal = 0.00
  var totalCost:BigDecimal = 0.00
  var menu:Menu = new Menu() 
  
  def addItem(item:String){
    ordered=item::ordered
  }
  
  def addItems(items:List[String]){
    for(item <- items){
      addItem(item)
    }
    fillOrder()
  }

  
  def fillOrder(){
    for (item <- ordered)
    delivered = menu.menu.get(item).get::delivered    
  }
  
  
  
  def getBill():BigDecimal ={
    for(item <- delivered){
      println("Item : "+item.name+"\t\t\t"+item.cost.setScale(2))
      totalCost+=item.cost.setScale(2)      
    }
    println("Total Cost : \t\t\t"+totalCost)
    return totalCost
  }
  
}