//definisco una Macro che ritorna la dimezione (int) di un array
#define sizeOfArray(x) (int)( sizeof(x)/sizeof(x[0]) )

//definisco due macro che ritornano la dimenzione delle righe e delle colonne di una matrice
#define sizeOfRow(x) (int)( sizeof(x)/sizeof(x[0]) )
#define sizeOfCol(x) (int)( ( sizeof(x)/sizeof(x[0][0]) ) / sizeOfRow(x) )