#include <iostream>
using namespace std;

struct matriz
{
    int lin;
    int col;
    float* v;
};

typedef struct matriz Matriz;

Matriz* crear(int m, int n)
{
    Matriz* mat = (Matriz*) malloc(sizeof(Matriz));
    mat->lin = m;
    mat->col = n;
    mat->v = (float*) malloc(m*n*sizeof(float));
    return mat;
}

void libera(Matriz* mat)
{
    free(mat->v);
    free(mat);
}

float acceso(Matriz* mat, int i, int j)
{
    int k; /* Índice del elemento del vector*/
    
    if(i < 0 || i >= mat->lin || j < 0 || j >= mat->col)
    {
        printf("Acceso incorrecto!\n");
        exit(1);
    }
    
    k = i*mat->col + j;
    return mat->v[k];
}

void asignar(Matriz* mat, int i, int j, float v)
{
    int k;
    if(i < 0 || i >= mat->lin || j < 0 || j >= mat->col)
    {
        printf("Acceso incorrecto!\n");
        exit(1);
    }
    k = i*mat->col + j;
    mat->v[k] = v;
}

void imprimir(Matriz* mat)
{
    float m[mat->lin][mat->col];
    cout << "Matriz\n";
    for(int i = 0; i < mat->lin; i++)
    {
        for(int j = 0; j < mat->col; j++)
        {
            m[i][j] = acceso(mat, i, j);
        }
    }
    for(int i = 0; i < mat->lin; i++)
    {
        for(int j = 0; j < mat->col; j++)
        {
            cout << m[i][j] << " ";
        }
        printf("\n");
    }
}

int main()
{
    Matriz *m;
    float v;
    m = crear(3, 3);

    asignar(m, 1, 1, 5);
    asignar(m, 2, 1, 7);
    asignar(m, 0, 0, 4);
    v = acceso(m, 1, 1);

    imprimir(m);
    return 0;
}