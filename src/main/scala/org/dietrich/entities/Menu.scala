package org.dietrich.entities


class Menu {
  var menu:Map[String,Item] = Map("Coffee"             -> new Item(n="Coffee",h=true,f=false,c=1.00),
                                  "Cola"               -> new Item(n="Cola",h=false,f=false,c=0.5),
                                  "Cheese Sandwich"    -> new Item(n="Cheese Sandwich",h=false,f=true,c=2.00,s=0.1),
                                  "Steak Sandwich"     -> new Item(n="Steak Sandwich",h=true,f=true,c=4.5,s=0.2)
                                  ) 
  
}