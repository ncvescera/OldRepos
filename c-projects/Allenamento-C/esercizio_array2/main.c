#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 10

void fill_array(int *array, int dim);
void print_array(int *array, int dim);
double media(int *array, int dim);
void sort(int *array, int dim);

int main(void) {
  int * p_array = (int *) calloc(SIZE, sizeof(int));

  fill_array(p_array, SIZE);
  print_array(p_array, SIZE);

  sort(p_array, SIZE);

  printf("Media: %f\n", media(p_array, SIZE));

  printf("Ordinato\n");
  print_array(p_array, SIZE);

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

void print_array(int *array, int dim) {
  for(int i = 0; i < dim; i++)
    printf("%d ", array[i]);
  printf("\n");

  return;
}

double media(int *array, int dim) {
  double result = 0;

  for(int i = 0; i < dim; i++) {
    result += array[i];
  }

  result /= dim;

  return result;
}

void sort(int *array, int dim) {
  for(int i = 0; i < dim; i++) {
    for(int j = i+1; j < dim; j++) {
      int temp;
      if(array[i] > array[j]) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
  }

  return;
}
