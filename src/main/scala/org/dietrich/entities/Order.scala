package org.dietrich.entities

import scala.math.BigDecimal

class Order {
  var ordered:List[String] = List[String]()
  var delivered:List[Item] = List[Item]()
  var serviceChargePercentage:BigDecimal = 0.00
  var serviceCharge:BigDecimal = 0.00
  var totalCost:BigDecimal = 0.00
  var preChargeCost:BigDecimal = 0.00
  var menu:Menu = new Menu() 
  
  def addItem(item:String){
    ordered=item::ordered
  }
  
  def addItems(items:List[String]){
    for(item <- items){
      addItem(item)
    }
  }

  
  def fillOrder(){
    delivered=List[Item]()
    for (item <- ordered)
    delivered = menu.menu.get(item).get::delivered    
  }
  
  
  
  def getBill():BigDecimal ={
    var hasFood:Boolean = false
    var isHot:Boolean = false
    for(item <- delivered){
      println("Item : "+item.name+"\t\t\t"+item.cost.setScale(2))
      if(item.food) {
        hasFood=true        
        if(item.hot) isHot =true
      }   
      preChargeCost+=item.cost.setScale(2)
    }
    if(hasFood){
      serviceChargePercentage=0.10
      if(isHot) serviceChargePercentage=0.20
    }
    serviceCharge=(preChargeCost*serviceChargePercentage).setScale(2)
    totalCost=preChargeCost+serviceCharge.setScale(2)
    return totalCost
  }
  
}