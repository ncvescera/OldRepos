#include <stdio.h>
#include <stdlib.h>

static int a = 2;

int main() {
  //int a = 5;

  printf("A: %d\n\n", a);
  { printf("a: %d", a);}

  return(0);
}
