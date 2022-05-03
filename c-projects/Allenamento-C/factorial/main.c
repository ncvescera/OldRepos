#include <stdio.h>
#include <stdlib.h>

long int factorial(long int n);

int main(void) {
  long int n;

  printf("n >: ");
  scanf("%ld", &n);

  printf("!%ld = %ld\n", n, factorial(n));

  return(EXIT_SUCCESS);
}

long int factorial(long int n) {
  if(n <= 1)
    return 1;
  else
    return factorial(n-1)*n;
}
