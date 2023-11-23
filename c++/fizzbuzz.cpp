#include <iostream>
#include <string>

std::string fizzbuzz(int n) {
    std::string rv = "";
    for(int i=1; i<=n; i++) {
        rv += i % 15 == 0 ? "fizzbuzz" : i % 5 == 0 ? "buzz" : i % 3 == 0 ? "fizz" : std::to_string(i);
        if (i<n) {
            rv += " ";
        }
    }
    return rv;
}

int main()
{
  std::cout <<  fizzbuzz(20);
}
