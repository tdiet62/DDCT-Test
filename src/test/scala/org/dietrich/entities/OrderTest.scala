package org.dietrich.entities

import org.dietrich.UnitSpec

class OrderTest extends UnitSpec {
  var o:Order = new Order()
  
  "The order" should "have one item" in {    
    o.addItem("Coffee")
    assert(o.ordered.length==1)
    o.getBill()
    assert(o.totalCost==1.00,"Total cost is wrong")
  }
  
  it should "have two items now" in {
    o.addItem("Cola")
    assert(o.ordered.length==2)
    o.getBill()
    assert(o.delivered.length==2)
    assert(o.totalCost==1.50,"Total cost is wrong")
  }
  
  it should "have a cost of 1.50 and no service charge"  in {
    for(item <- o.delivered ){
      println("Item: "+item.name+" costs "+item.cost)
    }
    o.getBill()
    assert(o.totalCost==1.50,"Total cost is wrong")
    assert(o.serviceChargePercentage==0.00,"Service Charge Percentage is wrong")
  }
  
  it should "now have a service charge of 10%" in {
    o.addItem("Cheese Sandwich")
    o.getBill()
    assert(o.delivered.length==3,"length is wrong")
    assert(o.serviceChargePercentage==0.10,"Service Charge Percentage is wrong")
  }
  
  it should "now have a service charge of 20%" in {   
    o.addItem("Steak Sandwich")
    o.getBill()
    assert(o.delivered.length==4)
    assert(o.serviceChargePercentage==0.20)
  }
  
  "Anther order, same items" should "still have a service charge of 20%, using matchers" in {
    o = new Order()  
    o.addItems(List[String]("Coffee","Cola","Cheese Sandwich","Steak Sandwich"))
    o.getBill()
    assert(o.delivered.length==4)
    assert(o.serviceChargePercentage==0.20)
    var cost:BigDecimal =o.getBill()
    assert(cost==9.60)
  }
}