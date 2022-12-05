#include <iostream>


using namespace std;

//Creacion de la pila y la fila como clases

class Pila{
	private:
		char* arreglo;
		int tope;
		int tamano;
	public:
		Pila();
		void push(char);
		char pop();
		int getTope();
		int getTamano();
		bool isEmpty();
		bool isFull();
		char peek();
	};
	
	class Fila{
	private:
		char* arreglo;
		int frente;
		int final;
		int tamano;
	public:
		Fila();
		void insertar(char);
		char retirar();
		int getFrente();
		int getFinal();
		int getTamano();
		bool isEmpty();
		bool isFull();
		char peek();
	};
	

//Implementacion de las clases
	
	Pila::Pila(){
		arreglo=new char[50];
		tope=-1;
		tamano=50;
	}
	void Pila::push(char dato){
		if(!isFull()){
			tope++;
			arreglo[tope]=dato;
		}
	}
	char Pila::pop(){
		if(!isEmpty()){
			char x=arreglo[tope];
			tope--;
			return x;
		}
		return ' ';
	}
	int Pila::getTope(){
		return tope;
	}
	int Pila::getTamano(){
		return tamano;
	}
	bool Pila::isEmpty(){
		if(tope == -1)
			return true;
		else
			return false;
	}
	bool Pila::isFull(){
		if(tope == tamano-1)
			return true;
		else
			return false;
	}
	char Pila::peek(){
		if(!isEmpty())
			return arreglo[tope];
		return ' ';
	}
	
	Fila::Fila(){
		arreglo=new char[50];
		frente=-1;
		final=-1;
		tamano=50;
	}
	void Fila::insertar(char dato){
		if(!isFull()){
			final++;
			arreglo[final]=dato;
			if(frente == -1)
				frente++;
		}
	}
	char Fila::retirar(){
		if(!isEmpty()){
			char x=arreglo[frente];
			if(frente == final)
				frente=final=-1;
			else
				frente++;
			return x;
		}
		return ' ';
	}
	int Fila::getFrente(){
		return frente;
	}
	int Fila::getFinal(){
		return final;
	}
	int Fila::getTamano(){
		return tamano;
	}
	bool Fila::isEmpty(){
		if(frente == -1)
			return true;
		else
			return false;
	}
	bool Fila::isFull(){
		if(final == tamano-1)
			return true;
		else
			return false;
	}
	char Fila::peek(){
		if(!isEmpty())
			return arreglo[frente];
		return ' ';
	}
	
//Implementacion de la función	
	
int esPalindromo(char* palabra){
	if(palabra==NULL)return 0;
	
	Pila* p=new Pila();
	Fila* f=new Fila();
	
	//Se introduce la palabra en la pila y la fila
	int i=0;
	while(palabra[i]!='\0'){
		if(palabra[i]!=' '){
			p->push(palabra[i]);
			f->insertar(palabra[i]);
		}
		i++;
	}
	
	//Se comprueba si es palindromo
	char aux1, aux2;
	bool pal=true;
	while(!p->isEmpty() && !f->isEmpty() && pal){
		aux1=p->pop();
		aux2=f->retirar();
		if(aux1!=aux2)pal=false;
	}
	
	delete p;
	delete f;
	
	if(pal)return 1;
	else return 0;
}	
//main
int main(){
	//pedirle la palabra al usuario
	int tamanio=0;
	char* palabra=new char[50];
	cout<<"Ingrese la palabra: "<<endl;
	cin>>palabra;
	
	//verificar si es palindromo o no
	if(esPalindromo(palabra))
		cout<<"La palabra es palindromo"<<endl;
	else
		cout<<"La palabra no es palindromo"<<endl;
		
	//eliminar la memoria dinamica utilizada
	delete[] palabra;
	
	return 0;
}
