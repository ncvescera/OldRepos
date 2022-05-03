#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 5

void fill_array(int *array, int dim);
double getAverage(void *array, int dim, char flag);

int main(void) {
  //int * array = (int *) calloc(SIZE, sizeof(int));
  //float * array = (float *) calloc(SIZE, sizeof(float));
  float array[SIZE] = {5.0,5.0,5.0,5.0,5.0};
  //fill_array(array, SIZE);

  for(int i = 0; i < SIZE; i++)
    printf("%f ", array[i]);
  printf("\n");

  double test = getAverage(array, SIZE, 'f');

  printf("Media: %f\n", test);

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

double getAverage(void *array, int dim, char flag) {
  double result = 0;

  //dato un array generico (void) lo casta al tipo indicato da flag e ne calcola la media
  switch(flag) {
    case 'i':
      {
        int *p_array = (int *) array;
        for(int i = 0; i < dim; i++) {
          result += p_array[i];
        }
      }
      break;
    case 'f':
      {
        float *p_array = (float *) array;
        for(int i = 0; i < dim; i++) {
          result += p_array[i];
        }
      }
      break;
    case 'd':
      {
        double *p_array = (double *) array;
        for(int i = 0; i < dim; i++) {
          result += p_array[i];
        }
      }
      break;

    default:
      fprintf(stderr, "Wrong flag\n");
      return -1;
  }

  result /= dim;

  return result;
}
