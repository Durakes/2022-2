#include <iostream>
#include <stdio.h>
#include <malloc.h>
using namespace std;

typedef struct tempNodo
{
    float valor;
    int columna;
    struct tempNodo* prox;
} Nodo;

typedef Nodo* PUNT;

typedef struct
{
    PUNT* A;
    int lineas;
    int columnas;
} MATRIZ;

void iniciarMatriz(MATRIZ *m, int linea, int columna)
{
    //int i;
    m->lineas = linea;
    m->columnas = columna;
    m->A = (PUNT*) malloc(linea*sizeof(PUNT));

    for (int i = 0; i < linea; i++)
    {
        m->A[i] = NULL;
    }
}

bool AdicionarValorMatriz(MATRIZ* m, int linea, int columna, float valor)
{
    if(linea < 0 || linea >= m->lineas || columna < 0 || columna >= m->columnas)
    {
        return false;
    }
    
    PUNT ant = NULL;
    PUNT actual = m->A[linea];

    while (actual != NULL && actual->columna < columna)
    {
        ant = actual;
        actual = actual->prox;
    }

    if(actual != NULL && actual->columna == columna)
    {
        if(valor == 0)
        {
            if(ant == NULL)
            {
                m->A[linea] = actual->prox;
            }else
            {
                ant->prox = actual->prox;
            }
            free(actual);
        }else
        {
            ant->prox = actual->prox;
        }
    }else if (valor != 0)
    {
        PUNT nuevo = (PUNT) malloc(sizeof(Nodo));
        nuevo->columna = columna;
        nuevo->valor = valor;
        nuevo->prox = actual;
        if(ant == NULL)
        {
            m->A[linea] = nuevo;
        }else
        {
            ant->prox = nuevo;
        }
        return true;
    }
    return false;
}


float ValorDeMatriz(MATRIZ *m, int linea, int columna)
{
    if(linea < 0 || linea >= m->lineas || columna < 0 || columna >= m->columnas)
    {
        return 0;
    }

    PUNT actual = m->A[linea];
    while (actual != NULL && actual->columna < columna)
    {
        actual = actual->prox;
    }

    if(actual != NULL && actual->columna == columna)
    {
        return actual->valor;
    }
    return 0;
}

bool utilMatriz(MATRIZ *m, int index)
{
    if(m->A[index]!= NULL)
    {
        return true;
    }else
    {
        return false;
    }
}


void imprimirMatriz(MATRIZ *m)
{
    float matriztemp[m->lineas][m->columnas];

    for(int i = 0; i < m->lineas; i++)
    {
        for(int j = 0; j < m->columnas; j++)
        {
            matriztemp[i][j] = 0;
        }
    }
    
    PUNT ant = NULL;
    PUNT actual;

    for(int i = 0; i < m->lineas; i++)
    {
        if(m->A[i] != NULL)
        {
            actual = m->A[i];
            while (true)
            {
                ant = actual;
                actual = actual->prox;
                matriztemp[i][ant->columna] = ant->valor;

                if(actual == NULL)
                {
                    break;
                }
            }
        }
    }

    for(int i = 0; i < m->lineas; i++)
    {
        for(int j = 0; j < m->columnas; j++)
        {
            cout << matriztemp[i][j] << " ";
        }
        cout << endl;
    }
}

int main()
{
    MATRIZ* matriz = (MATRIZ*) malloc(sizeof(MATRIZ));

    iniciarMatriz(matriz, 3, 3);
    AdicionarValorMatriz(matriz, 2, 1, 5);
    AdicionarValorMatriz(matriz, 1, 2, 2);
    AdicionarValorMatriz(matriz, 0, 0, 7); 

    imprimirMatriz(matriz);

    return 0;
}