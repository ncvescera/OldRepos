#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

//riempie casualmente l'array passato
void fill_array_int(int *array, int dim);
void fill_array_float(float *array, int dim);
void fill_array_double(double *array, int dim);

//stampa il contenuto dell'array passato
void print_array_int(int *array, int dim);
void print_array_float(float *array, int dim);
void print_array_double(double *array, int dim);

//ordina in modo crescente l'array passato
void sort_int(int *array, int dim);
void sort_float(float *array, int dim);
void sort_double(double *array, int dim);

bool array_find_int(int *array, int dim, int elem);
