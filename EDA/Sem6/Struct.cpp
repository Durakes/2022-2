#include <iostream>

using namespace std;

struct punto  
{
    float x;  
    float y;  
};


void imprime(struct punto* pp)  
{ 
    printf("El punto registrado fue: (%f, %f)\n", pp->x, pp->y); 
}

void captura(struct punto* pp)
{
    printf("Digite las coordenadas del punto(x y): ");  scanf("%f %f", &pp->x, &pp->y);  
}

    
int main()
{
    struct punto p;  
    captura(&p);  
    imprime(&p);  
    return 0;  
}