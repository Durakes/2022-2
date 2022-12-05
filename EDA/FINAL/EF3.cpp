#include <iostream>
#include <cstdlib>
#include <cstring>
using namespace std;

struct rectangulo
{
	float base;
	float altura;
	struct rectangulo *proximo;
};
typedef struct rectangulo Rectangulo;

void insertar_rect(Rectangulo **lista, float base, float altura)
{
	Rectangulo *nuevo = new Rectangulo;
	nuevo->base = base;
	nuevo->altura = altura;
	nuevo->proximo = *lista;
	*lista = nuevo;
}

void lista_imprime(Rectangulo *lista)
{
	Rectangulo *aux = lista;
	while(aux != NULL)
    {
		cout << aux->base << " " << aux->altura << endl;
		aux = aux->proximo;
	}
}

float area_total(Rectangulo *lista)
{
	if(lista == NULL)
		return 0;
	else
		return lista->base * lista->altura + area_total(lista->proximo);
}

float area_ultimo(Rectangulo *lista)
{
	if(lista->proximo == NULL)
		return lista->base * lista->altura;
	else
		return area_ultimo(lista->proximo);
}

void lista_libera(Rectangulo *lista)
{
	if(lista != NULL)
    {
		lista_libera(lista->proximo);
		delete lista;
	}
}

int main()
{
	Rectangulo *lista = NULL;
	insertar_rect(&lista, 15, 2);
	insertar_rect(&lista, 10, 2);
	insertar_rect(&lista, 2.5, 2);
	
    cout << "Lista de rectangulos:" << endl;
	lista_imprime(lista);
	
    cout << "Area total: " << area_total(lista) << endl;
	cout << "Area del ultimo rectangulo: " << area_ultimo(lista) << endl;
	
    lista_libera(lista);
	cout << "Lista liberada con exito" << endl;
	return 0;
}