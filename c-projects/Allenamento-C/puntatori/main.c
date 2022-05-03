#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void fill_array(int *array, int dim);
void print_array(int *array, int dim, int start);

int main(void) {
  int *p;
  int n;

  printf("n >: ");
  scanf("%d",&n);

  //inizializzazione dell'array p con calloc
  p = (int *)calloc(n, sizeof(int));  //calloc alloca la memoria e setta il valore a 0 delle celle

  fill_array(p, n);

  printf("\n");
  print_array(p, n, 0);
  printf("\n");

  free(p);

  //inizializzazione dell'array con malloc
  int new_p_size = 2 * n;
  p = (int *) malloc(sizeof(int) * new_p_size);

  printf("P Address: %p\n", p);
  print_array(p, new_p_size, 0);

  for(int i = 0; i < new_p_size; i++)
    p[i] = i;

  print_array(p, new_p_size, 0);

  //ridimensiono l'array p a n elementi
  p = (int *) realloc(p, n);

  printf("P realloc Address: %p\n", p);
  print_array(p, n, 0);

  //ridimensiono l'array p a 2*n elementi
  p = (int *) realloc(p, new_p_size);

  printf("P rerealooc Address: %p\n", p);
  print_array(p, new_p_size, n);

  return (EXIT_SUCCESS);
}

void fill_array(int *array, int dim) {
  //setta il seme del random con l'ora
  srand(time(NULL));

  int random;
  for(int i = 0; i < dim; i++){
      *(array+i) = rand() % 10; //genera un numero tra 0 e 99
  }

  return;
}

void print_array(int *array, int dim, int start) {
  for(int i = start; i < dim; i++)
    printf("%d ", *(array+i));
  printf("\n");
}
