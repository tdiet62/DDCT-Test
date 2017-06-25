package org.dietrich.entities

import org.dietrich.UnitSpec

class OrderTest extends UnitSpec {
  var o:Order = new Order()
  var totalCost:BigDecimal=0.0;
  
  "The order of Coffee" should "have the correct cost" in {    
   
    totalCost=o.getBill(List[String]("Coffee"),false)
    assert(totalCost==1.00,"Total cost is wrong")
  }
  
  "The order of two items" should "have the correct cost" in {
    totalCost=o.getBill(List[String]("Coffee","Cola"),false)
    assert(totalCost==1.50,"Total cost is wrong")
  }
  
 
  
  "An order of cold food" should "now have a service charge of 10%" in {
    
    var serviceCharge:BigDecimal=o.getServiceChargePercentage(o.fillOrder(List[String]("Coffee","Cola","Cheese Sandwich"),false),false)
    
    assert(serviceCharge==0.10,"Service Charge Percentage is wrong")
  }
  
  "An order of hot food" should "now have a service charge of 20%" in {
    var serviceCharge:BigDecimal=o.getServiceChargePercentage(o.fillOrder(List[String]("Coffee","Cola","Cheese Sandwich","Steak Sandwich"),false),false)
    assert(serviceCharge==0.20)
  }
 
}