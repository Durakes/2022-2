#include <iostream>
using namespace std;

struct matsim
{
    int dim;
    float **v;
};

typedef struct matsim MatTriInf;

MatTriInf* crear(int n)
{
    int i;
    MatTriInf* mat = (MatTriInf*) malloc(sizeof(MatTriInf));
    mat->dim = n;
    mat->v = (float**) malloc(n*sizeof(float*));
    for (i = 0; i < n; i++)
        mat->v[i] = (float*) malloc((i+1)*sizeof(float));
    return mat;
}

float acceder(MatTriInf* mat, int i, int j)
{
    if (i < 0 || i >= mat->dim || j < 0 || j >= mat->dim)
    {
        printf("Acceso incorrecto \n");
        exit(1);
    }
    if (i >= j)
        return mat->v[i][j];
    else
        return 0;
}

void asignar(MatTriInf* mat, int i, int j, float v)
{
    if (i < 0 || i >= mat->dim || j < 0 || j >= mat->dim)
    {
        printf("Acceso incorrecto \n");
        exit(1);
    }
    if (i >= j)
        mat->v[i][j] = v;
    else
        cout << "No se puede asignar valor en ese espacio" << endl;
}

int main()
{
    MatTriInf *m;
    m = crear(3);

    asignar(m, 2, 1, 3);

    cout << acceder(m, 2, 1) << endl;
    cout << acceder(m, 0, 2) << endl;

    return 0;
}
