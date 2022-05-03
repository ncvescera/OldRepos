#include "util.h"

void fill_array_int(int *array, int dim) {
  //setta il seme del random con l'ora
  srand(time(NULL));

  int random;
  for(int i = 0; i < dim; i++){
      *(array+i) = rand() % 10; //genera un numero tra 0 e 99
  }

  return;
}

void fill_array_float(float *array, int dim) {
  //setta il seme del random con l'ora
  srand(time(NULL));

  float random;
  for(int i = 0; i < dim; i++){
      *(array+i) = rand() % 10; //genera un numero tra 0 e 10
  }

  return;
}

void fill_array_double(double *array, int dim) {
  //setta il seme del random con l'ora
  srand(time(NULL));

  double random;
  for(int i = 0; i < dim; i++){
      *(array+i) = rand() % 10; //genera un numero tra 0 e 10
  }

  return;
}

void print_array_int(int *array, int dim) {
  for(int i = 0; i < dim; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");

  return;
}

void print_array_float(float *array, int dim) {
  for(int i = 0; i < dim; i++) {
    printf("%f ", array[i]);
  }
  printf("\n");

  return;
}

void print_array_double(double *array, int dim) {
  for(int i = 0; i < dim; i++) {
    printf("%f ", array[i]);
  }
  printf("\n");

  return;
}

void sort_int(int *array, int dim) {
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

void sort_float(float *array, int dim) {
  float temp;

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

void sort_double(double *array, int dim) {
  double temp;

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

bool array_find_int(int *array, int dim, int elem) {
  bool result = false;

  for(int i = 0; i < dim && !result; i++) {
    if(array[i] == elem)
      result = true;
  }

  return result;
}
