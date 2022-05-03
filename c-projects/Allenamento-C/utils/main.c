#include <stdio.h>
#include <stdlib.h>
#include "util.h"

int main(void) {
  int array[4];

  fill_array_int(array, 4);

  print_array_int(array, 4);

  sort_int(array, 4);

  print_array_int(array,4);
  
  return(EXIT_SUCCESS);
}
