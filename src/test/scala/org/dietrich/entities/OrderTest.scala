package org.dietrich.entities

import org.dietrich.UnitSpec

class OrderTest extends UnitSpec {
  var o:Order = new Order()
  
  "The order" should "have one item" in {    
    o.addItem("Coffee")
    assert(o.ordered.length==1)
  }
  
  it should "have two items now" in {
    o.addItem("Cola")
    assert(o.ordered.length==2)
    o.fillOrder()
    assert(o.delivered.length==2)
  }
}