#include <iostream>
using namespace std;
struct rectangulo
{
    float base; 
    float altura;
    struct rectangulo * proximo;
};
typedef struct rectangulo Rectangulo;

Rectangulo* crearRectangulo(float base, float altura)
{
    Rectangulo* rect = (Rectangulo*)malloc(sizeof(Rectangulo));
    rect->base = base;
    rect->altura = altura;
    rect->proximo = NULL;
    return rect;
}
Rectangulo* listaCrear()
{
    return NULL;
}

Rectangulo* lista_insertar_rect(Rectangulo** listaRec,Rectangulo *nuevoRect)
{
    if(*listaRec == NULL)
    {
        *listaRec = nuevoRect;

    }else
    {
        Rectangulo *tempRect = *listaRec;
        while (tempRect->proximo!=NULL)
        {
            tempRect = tempRect->proximo;
        }

        tempRect->proximo = nuevoRect;
    }

    return *listaRec;
}

void lista_imprime(Rectangulo *lista)
{
    Rectangulo * temp= lista;
    do
    {
        cout << temp->altura << endl;
        temp = temp->proximo;
    }while(temp->proximo!=NULL);
}

int main()
{
    Rectangulo* r1 = crearRectangulo(15,2);
    Rectangulo* r2 = crearRectangulo(10,3);

    Rectangulo* listaRect = listaCrear();
    lista_insertar_rect(&listaRect, r1);
    lista_insertar_rect(&listaRect, r2);

    lista_imprime(listaRect);

    return 0;
}