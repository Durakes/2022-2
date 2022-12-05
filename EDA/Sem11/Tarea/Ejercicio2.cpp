#include <stdio.h> 
#include <stdlib.h> 
#include <iostream>

using namespace std;
#define TRUE    1 
#define FALSE   0

typedef long TipoValor; 
typedef struct nodo *ApNodo; 
typedef struct nodo
{ 
    TipoValor dato;
    //TipoValor datoMayor;
    ApNodo izquierdo, derecho; 
}TipoNo; 

void crearArbol(ApNodo *raiz)
{ 
    *raiz = NULL; 
    return; 
} 

ApNodo crearNodo(TipoValor k, ApNodo izquierdo, ApNodo derecho )
{ 
    ApNodo p; 
    p = (ApNodo) malloc(sizeof(TipoNo)); 
    p->dato = k;
    p->izquierdo = izquierdo; 
    p->derecho = derecho; 
    return p;
} 

ApNodo inserir(TipoValor k, ApNodo p)
{ 
    if(p == NULL)
    { 
        return crearNodo(k,NULL,NULL); 
    } 
    if(k <= p->dato) 
        p->izquierdo = inserir(k, p->izquierdo); 
    else 
        p->derecho = inserir(k, p->derecho); 
    return p; 
}

/*Para la pregunta 3 se toma como consideración que se actualiza el árbol desde abajo hacia arriba. Empezando por las hojas y terminando en el nodo raiz*/

void actualizarArbol(ApNodo raiz)
{
    if(raiz != NULL)
    {
        if(raiz->derecho != NULL)
        {
            actualizarArbol(raiz->derecho);
            raiz->dato = raiz->derecho->dato;
            actualizarArbol(raiz->izquierdo);
        }else
        {
            if (raiz->izquierdo != NULL)
            {   
                actualizarArbol(raiz->izquierdo);
                raiz->dato = raiz->izquierdo->dato;
            }
        }
    }
}
/*-----------------------------------------------------------------*/ 
/* imprime el arbol */ 
/* formato ( dato (izquierdo) (derecho)), donde () representa NULL */

ApNodo duplicarNodos(ApNodo raiz)
{
    if(raiz != NULL)
    {
        ApNodo newroot;
        if(raiz->derecho != NULL)
        {
            raiz->derecho = duplicarNodos(raiz->derecho);
        }

        if(raiz->izquierdo != NULL)
        {
            raiz->izquierdo = duplicarNodos(raiz->izquierdo);
        }
        
        if(raiz->dato % 2 == 0)
            newroot = crearNodo(raiz->dato + 1, raiz, NULL);
        else
            newroot = crearNodo(raiz->dato - 1, NULL, raiz);
        return newroot;
    }
    return NULL;
}

void imprimeArbol(ApNodo p)
{ 
    if( p == NULL ) 
        printf("()"); 
    else
    { 
        printf("(%ld", p->dato); 
        imprimeArbol( p->izquierdo ); 
        imprimeArbol( p->derecho ); 
        printf(")"); 
    } 
    return; 
}

TipoValor SumaDato(ApNodo raiz)
{
    if(raiz == NULL)
        return 0;
    else
    {
        return raiz->dato + SumaDato(raiz->izquierdo) + SumaDato(raiz->derecho);
    }
}

TipoValor valorMinimo(ApNodo raiz)
{
    if(raiz->izquierdo == NULL)
        return raiz->dato;
    else 
        return valorMinimo(raiz->izquierdo);
}

int main(int argc, char *argv[])
{ 
    ApNodo raiz; 
    TipoValor dato; 
    int operacion; 
    crearArbol(&raiz); 
    printf("Ingrese una secuencia de valores. Finalizar la secuencia con -1: \n"); 
    scanf("%ld", &dato ); 
    while (dato != -1) 
    { 
        raiz = inserir (dato, raiz) ; 
        scanf("%ld", &dato); 
    } 
    printf("Arbol Inicial\n");
    imprimeArbol(raiz); 
    printf("\n");
    /*------- Pregunta 2 ------*/
    //cout << "La suma total es: " << SumaDato(raiz) << endl;
    //cout << "El valor minimo es: " << valorMinimo(raiz) << endl;
    
    /*------- Pregunta 3 ------*/
    /*actualizarArbol(raiz);
    printf("Arbol Nuevo \n");
    imprimeArbol(raiz);*/
    
    /*------- Pregunta 4 ------*/
    cout << endl;
    ApNodo duplicado = duplicarNodos(raiz);
    cout << "Duplicando nodos" << endl;
    imprimeArbol(duplicado);
    return 0; 
}