#include <stdio.h>
#include <stdlib.h>

int absValue(int val);

int main(void) {
  int pippo = -3;

  printf("%d\n", absValue(pippo));

  return(EXIT_SUCCESS);
}

int absValue(int val) {
  if(val < 0)
    val *= -1;

  return val;
}
