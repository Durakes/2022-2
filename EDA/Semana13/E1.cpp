#include <iostream>
using namespace std;

class Pila{
	private:
		int* arreglo;
		int tope;
		int tamano;
	public:
		Pila();
		void push(int);
		int pop();
		int getTope();
		int getTamano();
		bool isEmpty();
		bool isFull();
		int peek();
	};

Pila::Pila(){
	arreglo=new int[50];
	tope=-1;
	tamano=50;
}

void Pila::push(int dato){
    
	if(!isFull()){
		tope++;
		arreglo[tope]=dato;
	}
}


int Pila::pop(){
	if(!isEmpty()){
		int x=arreglo[tope];
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
int Pila::peek(){
	if(!isEmpty())
		return arreglo[tope];
	return ' ';
}


void eliminarCambiar(Pila* pila){
	if(pila->isEmpty())return;
	
	int x=pila->pop();
	
	eliminarCambiar(pila);
	
	if(x!=0){
		if(x<0)x=x*-1;
		pila->push(x);
		
	}
}

int main(){
	Pila* p=new Pila();
	int n;
	
	p->push(0);
	p->push(-1);
	p->push(-8);
	p->push(0);
	p->push(-9);
	
	eliminarCambiar(p);
	
	
	while(!p->isEmpty()){
		n=p->pop();
		cout<<n<<endl;
	}
	
	delete p;
	
	return 0;
}