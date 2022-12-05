#include <iostream>
using namespace std;

struct matriz
{
    int lin;
    int col;
    float** v;
};

typedef struct matriz Matriz;

Matriz* crear(int m, int n)
{
    int i;
    Matriz* mat = (Matriz*) malloc(sizeof(Matriz));
    mat->lin = m;
    mat->col = n;
    mat->v = (float**) malloc(m*n*sizeof(float*));
    for(i=0; i < m; i++)
    {
        mat->v[i] = (float*) malloc(n*sizeof(float));
    }
    return mat;
}

void libera(Matriz* mat)
{
    int i;
    for(i = 0; i < mat->lin; i++)
    {
        free(mat->v[i]);
    }
    free(mat->v);
    free(mat);
}

float acceder(Matriz* mat, int i, int j)
{
    if(i < 0 || i >= mat->lin || j < 0 || j >= mat->col)
    {
        printf("Acceso incorrecto!\n");
        exit(1);
    }

    return mat->v[i][j];
}

void asignar(Matriz* mat, int i, int j, float v)
{
    if(i < 0 || i >= mat->lin || j < 0 || j >= mat->col)
    {
        printf("Acceso incorrecto!\n");
        exit(1);
    }
    mat->v[i][j] = v;
}


void llenar(Matriz *mat)
{
    for(int i = 0; i < mat->lin; i++)
    {
        for(int j = 0; j < mat->col; j++)
        {   
            mat->v[i][j] = 0;
        }
    }
}

void imprimir(Matriz* mat)
{
    cout << "Matriz\n";
    for(int i = 0; i < mat->lin; i++)
    {
        for(int j = 0; j < mat->col; j++)
        {   
            cout << mat->v[i][j] << " ";
        }
        cout << endl;
    }
}

int main()
{
    Matriz *m;
    float v;
    m = crear(3, 3);
    llenar(m);

    asignar(m, 1, 1, 5);
    asignar(m, 2, 1, 7);
    asignar(m, 0, 0, 4);
    v = acceder(m, 1, 1);

    imprimir(m);
    return 0;
}