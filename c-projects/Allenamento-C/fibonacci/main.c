#include <stdio.h>
#include <stdlib.h>

void fibonacci(int n);

int main(void) {
  unsigned int n;

  printf(">: ");
  scanf("%d", &n);

  fibonacci(n);

  return(EXIT_SUCCESS);
}

void fibonacci(int n) {
  unsigned long long int serie[n];
  serie[0] = 1;
  serie[1] = 1;

  printf("%llu ", serie[0]);

  for(int i = 1; i < n; i++){
    serie[i+1] = serie[i] + serie[i-1];
    printf("%llu ", serie[i]);
  }

  printf("\n");

  return;
}
