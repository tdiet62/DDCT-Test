package org.dietrich.entities

import org.dietrich.UnitSpec

class ItemTest extends UnitSpec{
  
    var coffee:Item = new Item(n="Coffee",h=true,c=1.00,f=false)
    var cola:Item = new Item(n="Cola",h=false,c=0.5,f=false)
  
  //basic test class
  
  "The item " should "be a hot drink" in {
    assert(!coffee.food && coffee.hot)
  }
    
    "The Cola " should "cost £0.50" in {
      assert(cola.name.equals("Cola"))
      assert(cola.cost.equals(0.50))
    }
  
}