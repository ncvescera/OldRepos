#include <stdio.h>
#include <stdlib.h>
#include <time.h> //per generare numeri casuali
#include <stdbool.h>

#define MAX_DIM 30

void fill_array(int *array, int dim);
void cpArray(int *source, int *dest, int dim); //copia un array in un altro array [ delle stesse dimensioni ]
void sort(int *array, int dim);
bool is_sorted(int *array, int dim);

int main(void) {
  srand(time(NULL));
  int dim = rand() % MAX_DIM;
  int array[MAX_DIM] = {0};

  fill_array(array, dim);
  for(int i = 0; i < dim; i++){
    printf("%d ", array[i]);
  }
  printf("\n\n");

  bool result = is_sorted(array, dim);

  if(result)
    printf("SORTED ! :D\n");
  else
    printf("NOT SORTED :/\n");

  return(EXIT_SUCCESS);
}

//riempie l'array con numeri casuali
void fill_array(int *array, int dim) {
  //setta il seme del random con l'ora
  srand(time(NULL));

  int random;
  for(int i = 0; i < dim; i++){
      array[i] = rand() % 10; //genera un numero tra 0 e 99
  }

  return;
}

void sort(int *array, int dim) {
  int temp;

  for(int i = 0; i < dim; i++){
    for(int j = 0; j < dim-1; j++){
      if(array[i] < array[j]){
        temp = array[j];
        array[j] = array[i];
        array[i] = temp;
      }
    }
  }

  return;
}

void cpArray(int *source, int *dest, int dim) {
  for(int i = 0; i < dim; i++) {
    dest[i] = source[i];
  }

  return;
}

bool is_sorted(int *array, int dim) {
  int sorted[dim];
  cpArray(array, sorted, dim);
  sort(sorted, dim);

  bool result = true;
  for(int i = 0; i < dim && result; i++) {
    if(array[i] != sorted[i])
      result = false;
  }

  return result;
}
