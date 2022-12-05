#include <iostream>
using namespace std;

struct matsim
{
    int dim; /* matriz obligatoriamente cuadrada */
    float* v;
};
typedef struct matsim MatTriSup;

MatTriSup* crear(int n)
{
    int s = n*(n+1)/2;
    MatTriSup* mat = (MatTriSup*) malloc(sizeof(MatTriSup));
    mat->dim = n;
    mat->v = (float*) malloc(s*sizeof(float));
    return mat;
}

float acceder(MatTriSup* mat, int i, int j)
{
    int k; /* índice del elemento en el  vector */
    if (i<0 || i>=mat->dim || j<0 || j>=mat->dim)
    {
        printf("Acceso incorrecto!\n");
        exit(1);
    }
    if (i >= j)
        k = i*(i+1)/2 + j;
    else
        k = j*(j+1)/2 + i;
    return mat->v[k];
}

int main()
{
    return 0;
}