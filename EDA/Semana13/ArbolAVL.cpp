#include <iostream>
using namespace std;

struct Cancion
{
    int codigo;
    string titulo;
    int codGenero;

    Cancion(){}
    Cancion(int cod, string tit, int codG)
    {
        this->codigo = cod;
        this->titulo = tit;
        this->codGenero = codG;
    }
};

typedef struct nodo
{
    Cancion cancion; 
    struct nodo *izquierdo, *derecha; 
    short altura;
}Nodo;

Nodo * nuevoNodo(Cancion x)
{
    Nodo* nuevo = new Nodo;
    if(nuevo)
    {
        nuevo->cancion = x; 
        nuevo->izquierdo = NULL; 
        nuevo->derecha = NULL; 
        nuevo->altura = 0; 
    }else
        cout<<"Error al separar la memoria del nuevo nodo\n";
    return nuevo; 
}

/*Retorna el mayor valor entre dos valores 
a,b -> altura de dos nodos en el árbol*/
short mayor(short a, short b)
{
    return(a>b) ? a:b; 
}

short alturaDelNodo(Nodo * nodo)
{
    if(nodo == NULL)
        return -1; 
    else
        return nodo->altura; 
}

/*Calcula y retorna el factor de equilibrio
en un arbol balanceado debe ser -1, 1 , 0*/
short factorDeEquilibrio(Nodo *nodo)
{
    if(nodo)
        return (alturaDelNodo(nodo->izquierdo)-alturaDelNodo(nodo->derecha));
    else 
        return 0;
}

/**Rotacion a la izquierda*/ 
Nodo * rotacionIzquierda(Nodo *r)
{
    Nodo *y , *f;
    y = r->derecha; 
    f = y->izquierdo;
    
    y->izquierdo = r; 
    r->derecha = f; 
    
    r->altura = mayor(alturaDelNodo(r->izquierdo), alturaDelNodo(r->derecha)) +1;
    y->altura = mayor(alturaDelNodo(y->izquierdo), alturaDelNodo(y->derecha)) +1;
    return y;
}

/**Rotacion a la derecha*/ 
Nodo * rotacionDerecha(Nodo *r)
{
    Nodo *y , *f;
    y = r->izquierdo; 
    f = y->derecha;
    
    y->derecha = r; 
    r->izquierdo = f; 
    
    r->altura = mayor(alturaDelNodo(r->izquierdo), alturaDelNodo(r->derecha)) +1;
    y->altura = mayor(alturaDelNodo(y->izquierdo), alturaDelNodo(y->derecha)) +1;
    return y;
}

/**Rotacion doble*/ 
Nodo * rotacionDerechaIzquierda(Nodo *r)
{        
    r->derecha = rotacionDerecha(r->derecha);     
    return rotacionIzquierda(r);
}

/**Rotacion doble*/ 
Nodo * rotacionIzquierdaDerecha(Nodo *r)
{        
    r->izquierdo = rotacionIzquierda(r->izquierdo);     
    return rotacionDerecha(r);
}

Nodo* insertarNodo(Nodo* nodo, Cancion valor)
{
    if(nodo == NULL)
    {
        return(nuevoNodo(valor));
    }
    
    if(valor.titulo.compare(nodo->cancion.titulo) < 0)
    {
        nodo->izquierdo = insertarNodo(nodo->izquierdo,valor);
    }
    else if(valor.titulo.compare(nodo->cancion.titulo) > 0)
    {
        nodo->derecha = insertarNodo(nodo->derecha,valor);
    }
    else
        return nodo;

    nodo->altura = 1 + mayor(alturaDelNodo(nodo->derecha),alturaDelNodo(nodo->izquierdo));

    int balance = factorDeEquilibrio(nodo);

    if (balance > 1 && valor.titulo < nodo->izquierdo->cancion.titulo)
        return rotacionDerecha(nodo);

    // Right Right Case
    if (balance < -1 && valor.titulo > nodo->derecha->cancion.titulo)
        return rotacionIzquierda(nodo);

    // Left Right Case
    if (balance > 1 && valor.titulo > nodo->izquierdo->cancion.titulo)
    {
        nodo->izquierdo = rotacionIzquierda(nodo->izquierdo);
        return rotacionDerecha(nodo);
    }

    // Right Left Case
    if (balance < -1 && valor.titulo < nodo->derecha->cancion.titulo)
    {
        nodo->derecha = rotacionDerecha(nodo->derecha);
        return rotacionIzquierda(nodo);
    }

    /* return the (unchanged) node pointer */
    return nodo;
}

void preOrder(Nodo *raiz)
{
    if(raiz != NULL)
    {
        cout << raiz->cancion.titulo<< " " << endl;
        preOrder(raiz->izquierdo);
        preOrder(raiz->derecha);
    }
}

bool buscarArbol(Nodo* raiz, string valor)
{
    if(raiz == NULL)
        return false;
    else if(raiz->cancion.titulo.compare(valor) == 0)
        return true;
    else if(raiz->cancion.titulo.compare(valor) > 0)
    {
        bool val = buscarArbol(raiz->izquierdo, valor);
        return val;
    }else
    {
        bool val = buscarArbol(raiz->derecha, valor);
        return val;
    }
}

int main()
{
    Nodo *raiz = NULL;
    Cancion cancion1(0,"Always",0);
    Cancion cancion2(1,"I'm Greedy",0);
    Cancion cancion3(2,"Turbo Lover",0);
    Cancion cancion4(3,"Umbrella",0);
    Cancion cancion5(4,"The Unforgiven",0);
    Cancion cancion6(5,"November Rain",0);
    /* Constructing tree given in
    the above figure */
    raiz = insertarNodo(raiz, cancion1);
    raiz = insertarNodo(raiz, cancion2);
    raiz = insertarNodo(raiz, cancion3);
    raiz = insertarNodo(raiz, cancion4);
    raiz = insertarNodo(raiz, cancion5);
    raiz = insertarNodo(raiz, cancion6);

    /* The constructed AVL Tree would be
                30
            / \
            20 40
            / \ \
        10 25 50
    */
    cout << "Preorder traversal of the "
            "constructed AVL tree is \n";
    preOrder(raiz);
    cout << endl;
    cout << buscarArbol(raiz,"Umbrella") << endl;
    cout << endl;
    cout << buscarArbol(raiz,"One") << endl;
    
    return 0;
}