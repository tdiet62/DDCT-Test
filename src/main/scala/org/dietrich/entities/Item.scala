package org.dietrich.entities

class Item(n:String="",f:Boolean = false,h:Boolean = false,c:BigDecimal = 0.0,s:BigDecimal =0.0) {
  val name:String = n;
  val food:Boolean = f;
  val hot:Boolean= h;
  val cost:BigDecimal = c;
  val serviceChargePercentage:BigDecimal = s;
}