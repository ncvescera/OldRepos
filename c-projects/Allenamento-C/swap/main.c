#include <stdio.h>
#include <stdlib.h>

void swap(int *i, int *j);


int main(void) {
  int a = 5, b = 3;

  swap(&a, &b);

  printf("A: %d B: %d\n", a, b);

  return(EXIT_SUCCESS);
}

void swap(int *i, int *j) {
  int temp = *i;
  *i = *j;
  *j = temp;

  return;
}
