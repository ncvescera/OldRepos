#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void fill_array(int *array, int dim) {
  //setta il seme del random con l'ora
  srand(time(NULL));

  int random;
  for(int i = 0; i < dim; i++){
      *(array+i) = rand() % 10; //genera un numero tra 0 e 99
  }

  return;
}

void double_array(int *array, int dim) {
  int new_dim = dim * 2;
  double *p_new = (double *)malloc(sizeof(double)*(new_dim));

  for(int i = 0; i < dim; i++){
    double temp = array[i]/2.0;

    p_new[i] = temp;
    p_new[i + dim] = temp;
  }

  for(int i = 0; i < new_dim; i++) {
    printf("%f ", p_new[i]);
  }
  return;
}

int main(void) {
  int n;

  printf("n >: ");
  scanf("%d", &n);

  int array[n];

  fill_array(array, n);

  for(int i = 0; i < n; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");
  double_array(array, n);

  return(EXIT_SUCCESS);
}
