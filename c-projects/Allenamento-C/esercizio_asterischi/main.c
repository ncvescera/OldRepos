#include <stdio.h>
#include <stdlib.h>

int main(void) {
  int righe;

  printf("Righe >: ");
  scanf("%d", &righe);

  int spazi = 0;

  for(int i = 0; i < righe; i++) {
    for(int j = i; j > 0; j--)
      printf(" ");
    printf("******\n");
  }

  return(EXIT_SUCCESS);
}
