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

Matriz* sumarMatrices(Matriz* mat1, Matriz* mat2)
{
    Matriz* matTotal;
    matTotal = crear(mat1->lin, mat1->col);
    llenar(matTotal);
    for(int i= 0; i < matTotal->lin; i++)
    {
        for(int j = 0; j < matTotal->col; j++)
        {
            matTotal->v[i][j] = mat1->v[i][j] + mat2->v[i][j];
        }
    }
    return matTotal;
}

Matriz* productoMatrices(Matriz* mat1, Matriz* mat2)
{
    Matriz* matTotal;
    matTotal = crear(mat1->lin, mat2->col);
    llenar(matTotal);
    for(int i= 0; i < matTotal->lin; i++)
    {
        for(int j = 0; j < matTotal->col; j++)
        {
            float suma = 0;
            for(int k = 0; k < mat1->col; k++)
            {
                suma += mat1->v[i][k] * mat2->v[k][j]; 
            }
            matTotal->v[i][j] = suma;
        }
    }
    return matTotal;
}

void llenarDatos(Matriz* mat)
{
    for(int i = 0; i < mat->lin; i++)
    {
        for(int j = 0; j < mat->col; j++)
        {
            cout << "Ingrese el valor en la posicion (" << i << "," << j <<"): \n";
            cin >> mat->v[i][j];
        }
    }
    cout << endl;
}

int main()
{
    Matriz *m, *m2, *m3, *mSuma, *mProducto;
    int lin1, col1, lin2, col2, lin3, col3;

    cout << "Indique las filas de la primera matriz" << endl;
    cin >> lin1;
    cout << "Indique las columnas de la primera matriz" << endl;
    cin >> col1;
    cout << endl;

    cout << "Indique las filas de la segunda matriz" << endl;
    cin >> lin2;
    cout << "Indique las columnas de la segunda matriz" << endl;
    cin >> col2;
    cout << endl;

    cout << "Indique las filas de la tercera matriz" << endl;
    cin >> lin3;
    cout << "Indique las columnas de la tercera matriz" << endl;
    cin >> col3;
    cout << endl;

    m = crear(lin1, col1);
    m2 = crear(lin2, col2);
    m3 = crear(lin3, col3);

    llenar(m);
    llenar(m2);
    llenar(m3);

    cout << "Ingrese los datos de la matriz 1" << endl;
    llenarDatos(m);
    
    cout << "Ingrese los datos de la matriz 2" << endl;
    llenarDatos(m2);
    
    cout << "Ingrese los datos de la matriz 3" << endl;
    llenarDatos(m3);

    imprimir(m);
    cout << endl;
    imprimir(m2);
    cout << endl;
    imprimir(m3);
    cout << endl;

    mSuma = sumarMatrices(m, m2);
    mProducto = productoMatrices(m, m3);

    cout << "Suma\n";
    imprimir(mSuma);

    cout << "Producto\n";
    imprimir(mProducto);
    return 0;
}