#!/bin/bash

function is_multiple() {
 dividend=$1
 divisor=$2
 return $(($dividend % $divisor))
}

for i in {1..20}; do
 if is_multiple $i 15 ; 
 	then echo -n "fizzbuzz "; 
 elif is_multiple $i 5; 
 	then echo -n "buzz "; 
 elif is_multiple $i 3; 
 	then echo -n "fizz "; 
 else echo -n "$i "; 
 fi; 
done
echo
