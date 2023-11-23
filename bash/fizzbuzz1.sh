#!/bin/bash

for i in {1..20}; do
 if [ $(($i % 15)) -eq 0 ]; 
 	then echo -n "fizzbuzz "; 
 elif [ $(($i % 5)) -eq 0 ]; 
 	then echo -n "buzz "; 
 elif [ $(($i % 3)) -eq 0 ]; 
 	then echo -n "fizz "; 
 else echo -n "$i "; 
 fi; 
done
echo
