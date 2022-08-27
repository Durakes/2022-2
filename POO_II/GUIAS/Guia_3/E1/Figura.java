public class Figura
{
    int tipo;
    double area;
    String nombre;

    public Figura(int tipo)
    {
        this.tipo = tipo;
    }

    void construirFigura()
    {
        switch(tipo)
        {
            case 1:
            area = areaTriangulo();
            nombre = "Triangulo";
            break;

            case 2:
            area = areaRectangulo();
            nombre = "Rectangulo";
            break;

            case 3:
            area = areaCirculo();
            nombre = "Circulo";
            break;

            case 4:
            area = areaCuadrado();
            nombre = "Cuadrado";
            break;

            default:
            break;
        }
    }

    double areaTriangulo()
    {
        double base;
        double altura;
        System.out.println("Ingrese la base del triangulo: ");
        base = Double.parseDouble(System.console().readLine());

        System.out.println("Ingrese la altura del triangulo: ");
        altura = Double.parseDouble(System.console().readLine());

        return base * altura * 0.5;
    }

    double areaRectangulo()
    {
        double altura;
        double largo;
        System.out.println("Ingrese la altura del rectangulo: ");
        altura = Double.parseDouble(System.console().readLine());

        System.out.println("Ingrese el largo del rectangulo: ");
        largo = Double.parseDouble(System.console().readLine());

        return largo * altura;
    }

    double areaCirculo()
    {
        double radio;
        System.out.println("Ingrese el radio del circulo: ");
        radio = Double.parseDouble(System.console().readLine());

        return Math.PI * radio * radio;
    }

    double areaCuadrado()
    {
        double lado;
        System.out.println("Ingrese el lado del cuadrado");
        lado = Double.parseDouble(System.console().readLine());

        return lado * lado;
    }
}
