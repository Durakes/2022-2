#include <iostream>
#include <cstring>

using namespace std;

struct nodo{
    char dato;
    struct nodo *siguiente;
};

struct nodo *pila = NULL;
struct nodo *fila = NULL;

void insertarPila(char);
void insertarFila(char);
char extraerPila();
char extraerFila();
void mostrarPila();
void mostrarFila();
void liberarPila();
void liberarFila();
int esPalindromo(char*);

int main(){
    char palabra[100];
    int i = 1;

    cout << "Ingrese una palabra: ";
    scanf("%s" , palabra);

    if(esPalindromo(palabra) == 1){
        cout << "\nLa palabra es palindromo";
    }else{
        cout << "\nLa palabra no es palindromo";
    }

    liberarPila();
    liberarFila();

    return 0;
}

int esPalindromo(char* palabra)
{
    for(int i=0; i<strlen(palabra); i++){
        if(palabra[i] != ' '){
            insertarPila(palabra[i]);
            insertarFila(palabra[i]);
        }
    }

    for(int i=0; i<strlen(palabra); i++){
        if(palabra[i] != ' '){
            if(extraerPila() != extraerFila()){
                return 0;
            }
        }
    }
    return 1;
}

void insertarPila(char n)
{
    struct nodo *nuevo;
    nuevo = (struct nodo*)malloc(sizeof(struct nodo));
    nuevo->dato = n;
    nuevo->siguiente = pila;
    pila = nuevo;
}

void insertarFila(char n){
    struct nodo *nuevo;
    nuevo = (struct nodo*)malloc(sizeof(struct nodo));
    nuevo->dato = n;
    nuevo->siguiente = NULL;

    if(fila == NULL){
        fila = nuevo;
    }else{
        struct nodo *aux = fila;
        while(aux->siguiente != NULL){
            aux = aux->siguiente;
        }
        aux->siguiente = nuevo;
    }
}

char extraerPila(){
    struct nodo *aux;
    char n;
    aux = pila;
    n = aux->dato;
    pila = aux->siguiente;
    free(aux);
    return n;
}

char extraerFila(){
    struct nodo *aux;
    char n;
    aux = fila;
    n = aux->dato;
    fila = aux->siguiente;
    free(aux);
    return n;
}

void mostrarPila(){
    struct nodo *aux;
    aux = pila;
    while(aux != NULL){
        cout << aux->dato << " ";
        aux = aux->siguiente;
    }
}

void mostrarFila(){
    struct nodo *aux;
    aux = fila;
    while(aux != NULL){
        cout << aux->dato << " ";
        aux = aux->siguiente;
    }
}

void liberarPila()
{
    struct nodo *aux;
    while(pila != NULL)
    {
        aux = pila;
        pila = aux->siguiente;
        free(aux);
    }
}

void liberarFila(){
    struct nodo *aux;
    while(fila != NULL){
        aux = fila;
        fila = aux->siguiente;
        free(aux);
    }
}