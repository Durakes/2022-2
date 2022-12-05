#include <iostream>
#include <cstring>
using namespace std;

struct trabajador
{
    char nombre[81];
    float valor_hora;
    int horas_mes;
}; 
typedef struct trabajador Trabajador;
//El nodo del árbol es dado representado así:

Trabajador* crearTrabajador(char nombre[], float hora, int mes)
{
    Trabajador* t = (Trabajador*)malloc(sizeof(Trabajador));
    t->valor_hora = hora;
    t->horas_mes = mes;
    strcpy(t->nombre, nombre);
    return t;
}

struct  nodoArbol
{
    Trabajador *info; 
    nodoArbol *izq;
    nodoArbol *der;
};
typedef struct nodoArbol NodoArbol;

NodoArbol* arbol_crea(Trabajador *trabajador, NodoArbol* i, NodoArbol* d)
{
    NodoArbol* p = (NodoArbol*)malloc(sizeof(NodoArbol)); 
    p->info = trabajador; 
    p->izq = i; 
    p->der = d;  
    return p; 
}

int arbol_vacio(NodoArbol* a)
{
    return a == NULL; 
}

NodoArbol* arbol_libera(NodoArbol* a)
{
    if ( a != NULL)
    { 
        arbol_libera(a->izq); 
        arbol_libera(a->der);
        free(a);  
    }
    return NULL; 
}

Trabajador* buscar(NodoArbol *a , char *s)
{
    if(a == NULL)
        return NULL;
    else
    {
        int index = strcmp(a->info->nombre, s);
        if(index == 0)
        {
            return a->info;
        }else if(index > 0)
        {
            return buscar(a->izq, s);
        }else
        {
            return buscar(a->der, s);
        }
    }
}

int main()
{
    string nombret1 = "juliana";
    string nombret2 = "daniela";
    string nombret3 = "pamela";
    string nombret4 = "ana";
    string nombret5 = "maria";
    string nombret6 = "manuel";
    string nombret7 = "roberto";
    string nombret8 = "talia";
    string nombret9 = "juan";

    Trabajador *t1 = crearTrabajador(&nombret1[0], 10.5, 10);
    Trabajador *t2 = crearTrabajador(&nombret2[0], 20.5, 15);
    Trabajador *t3 = crearTrabajador(&nombret3[0], 20.5, 15);
    Trabajador *t4 = crearTrabajador(&nombret4[0], 20.5, 15);
    Trabajador *t5 = crearTrabajador(&nombret5[0], 20.5, 15);
    Trabajador *t6 = crearTrabajador(&nombret6[0], 20.5, 15);
    Trabajador *t7 = crearTrabajador(&nombret7[0], 20.5, 15);
    Trabajador *t8 = crearTrabajador(&nombret8[0], 20.5, 15);
    
    NodoArbol *a = arbol_crea(t1,arbol_crea(t2,arbol_crea(t4,NULL,NULL),NULL),arbol_crea(t3,arbol_crea(t5,arbol_crea(t6,NULL,NULL),NULL),arbol_crea(t7,NULL,arbol_crea(t8,NULL,NULL))));

    string nombreBuscar = "";

    cout << "Ingrese el nombre a buscar: " << endl;
    cin >> nombreBuscar;

    Trabajador *resultado = buscar(a,&nombreBuscar[0]);

    if(resultado!=NULL)
    {
        cout << "Los datos del empleado buscado son: " << endl;
        cout << "Nombre: " << resultado->nombre << endl;
        cout << "Salario por hora: " << resultado->valor_hora << endl;
        cout << "Horas trabajadas: " << resultado->horas_mes << endl;
    }else
    {
        cout << "El trabajador no existe" << endl;
    }

    return 0;
}