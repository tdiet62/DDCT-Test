package org.dietrich.entities

class Item(n:String="",f:Boolean = false,h:Boolean = false,c:BigDecimal = 0.0) {
  var name:String = n;
  var food:Boolean = f;
  var hot:Boolean= h;
  var cost:BigDecimal = c;
}