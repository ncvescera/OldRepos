#include <stdio.h>
#include <stdlib.h>
#include <time.h> //per generare numeri casuali
#include <stdbool.h>

#define SIZE 30 //dimensione dell'array

void fill_array(int *array, int dim);
void sort(int *array, int dim);
bool find(int *array, int dim, int elem);

int main(void) {
  int array[SIZE];

  fill_array(array, SIZE);

  //stampa dell'array non ordinato
  printf("non sorted\n");
  for(int i = 0; i < SIZE; i++){
      printf("%d ", array[i]);
  }
  printf("\n\n");

  //stampa dell'array ordinato
  sort(array, SIZE);
  printf("sorted\n");
  for(int i = 0; i < SIZE; i++){
      printf("%d ", array[i]);
  }
  printf("\n\n");

  int to_find;
  printf("Find\n");
  printf(">: ");
  scanf("%d", &to_find);

  if(find(array, SIZE, to_find))
    printf("\nElemento trovato !\n");
  else
    printf("\nElemento NON trovato :/\n");

  printf("MAX: %d\n", array[SIZE-1]);
  printf("MIN: %d\n", array[0]);

  return(EXIT_SUCCESS);
}

//riempie l'array con numeri casuali
void fill_array(int *array, int dim) {
  //setta il seme del random con l'ora
  srand(time(NULL));

  int random;
  for(int i = 0; i < dim; i++){
      array[i] = rand() % 100; //genera un numero tra 0 e 99
  }

  return;
}

//ordina l'array crescente con bubblesort
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

//cerca un numero nell'array
bool find(int *array, int dim, int elem) {
  bool result = false;

  for(int i = 0; i < dim && !result; i++) {
    if(array[i] == elem)
      result = true;
  }

  return result;
}
