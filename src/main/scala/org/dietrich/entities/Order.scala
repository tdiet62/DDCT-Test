package org.dietrich.entities

class Order {
  var ordered:List[String] = List[String]()
  var delivered:List[Item] = List[Item]()
  var serviceCharge:BigDecimal = 0.00
  var totalCost:BigDecimal = 0.00
  var menu:Menu = new Menu() 
  
  def addItem(item:String){
    ordered=item::ordered
  }
  
  def fillOrder(){
    for (item <- ordered)
    delivered = menu.menu.get(item).get::delivered
    
  }
  
}