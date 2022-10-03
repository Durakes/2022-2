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

float areaRectangle(Rectangulo* rec)
{
    float a = (rec->pSuperior.x - rec->pInferior.x) *  (rec->pSuperior.y - rec->pInferior.y);
    return a;
}

float areaCircle(Circulo* cir)
{
    float a = cir->r * cir->r * 3.1416;
    return a;
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

Punto createPoint(float x, float y)
{
    Punto punto;
    punto.x = x;
    punto.y = y;

    return punto;
}

Circulo* createCircle(Punto punto, float r)
{
    Circulo *circle = (Circulo*) malloc(sizeof(Circulo));
    circle->p = punto;
    circle->r = r;
    return circle;
}

Rectangulo* createRectangle(Punto puntoInicial, Punto puntoFinal)
{
    Rectangulo *rectangulo = (Rectangulo*) malloc(sizeof(Rectangulo));
    rectangulo->pInferior = puntoInicial;
    rectangulo->pSuperior = puntoFinal;
    return rectangulo;
}

int main()
{
    Circulo *c;
    Rectangulo *r;

    Punto p1, p2, p3, p4;
    float a1, a2;

    p1 = createPoint(6,0);
    p2 = createPoint(4,3);
    p3 = createPoint(6,7);
    p4 = createPoint(9,10);

    c = createCircle(p1, 3);
    r = createRectangle(p2, p3);

    a1 = areaCircle(c);
    a2 = areaRectangle(r);

    if(interior(c, &p4) == 1)
    {
        cout << "El punto 4 esta dentro del circulo" << endl;
    }else
    {
        cout << "El punto 4 no esta dentro del circulo" << endl;
    }

    cout << "La distancia entre el punto 3 y 4 es: " << distancia(&p3, &p4) << endl;
    cout << "El valor del area del circulo: " << a1 << endl;
    cout << "El valor del area del rectangulo: " << a2 << endl;

    return 0;  
}