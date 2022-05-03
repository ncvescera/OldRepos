#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
  char stringa[50];
  int len;

  printf("Stringa >: ");
  scanf("%s", stringa);

  len = strlen(stringa);

  for(char *c = stringa + (len-1); c >= stringa; c--){
    putchar(*c);
  }
  putchar('\n');

  return(EXIT_SUCCESS);
}
