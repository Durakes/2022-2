#include <iostream>
#include <math.h>

using namespace std;

struct punto  
{
    float x;  
    float y;  
};
typedef struct punto Punto; 


struct circulo  
{
    Punto p; /* centro del círculo */  
    float r; /* radio do círculo */  
}; 
typedef struct circulo Circulo;

struct rectangulo
{
    Punto pSuperior;
    Punto pInferior;
};
typedef struct rectangulo Rectangulo;

float distancia(Punto* p, Punto* q)
{
    float d = sqrt(pow(q->x - p->x, 2) + pow(q->y - p->y, 2));  
    return d;
}

int interior(Circulo* c, Punto* p)
{
    float d = distancia(&c->p, p);  
    if (d < c->r)
    {
        return 1;
    }else
    {
        return 0; 
    }
}


int main()
{
    Circulo c; 
    Punto p; 
    
    printf("Digite las coordenadas del centro y del radio (x y) y d \n "); 
    scanf("%f %f %f", &c.p.x, &c.p.y, &c.r);
    
    printf("Digite las coordenadas del punto (x y)\n ");
    scanf("%f %f", &p.x, &p.y);
    
    if(interior(&c, &p) == 1)
        printf("El punto esta dentro del Circulo\n");
    else 
        printf("El punto esta fuera del Circulo\n");
    
    
    return 0;  
}

