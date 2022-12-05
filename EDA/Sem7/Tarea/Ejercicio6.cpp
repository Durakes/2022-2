#include <iostream>
using namespace std;

struct matsim
{
    int dim;
    float **v;
};

typedef struct matsim MatTriSup;

MatTriSup* crear(int n)
{
    int i;
    MatTriSup* mat = (MatTriSup*) malloc(sizeof(MatTriSup));
    mat->dim = n;
    mat->v = (float**) malloc(n*sizeof(float*));
    for (i = 0; i < n; i++)
        mat->v[i] = (float*) malloc((n-i)*sizeof(float));
    return mat;
}

float acceder(MatTriSup* mat, int i, int j)
{
    if (i < 0 || i >= mat->dim || j < 0 || j >= mat->dim)
    {
        printf("Acceso incorrecto \n");
        exit(1);
    }
    if (i <= j)
        return mat->v[i][j];
    else
        return 0;
}

void asignar(MatTriSup* mat, int i, int j, float v)
{
    if (i < 0 || i >= mat->dim || j < 0 || j >= mat->dim)
    {
        printf("Acceso incorrecto \n");
        exit(1);
    }
    if (i <= j)
        mat->v[i][j] = v;
    else
        cout << "No se puede asignar valor en ese espacio" << endl;
}

int main()
{
    MatTriSup *m;
    m = crear(3);

    asignar(m, 1, 2, 3);

    cout << acceder(m, 1, 2) << endl;
    cout << acceder(m, 2, 0) << endl;

    return 0;
}
