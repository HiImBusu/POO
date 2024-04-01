package Conceptos.Herencia;

public class Punto {
    private double x; //coordenada x de un punto en el espacio R^2
    private double y; //coordenada y de un punto en el espacio R^2

    /**
     * @param x coordenada x de un punto en el espacio R^2
     * @param y coordenada y de un punto en el espacio R^2
     */
    public Punto(double x, double y) { this.x = x; this.y = y; }

    /**
     * Constructor por defecto en el punto (0,0)
     */
    public Punto() { this(0,0); }

    /**
     * Constructor de copia
     * @param p Punto del que se quiere copiar la información en una instancia nueva
     */
    public Punto(Punto p) { this.x = p.x; this.y = p.y; }

    /**
     * @return Coordenada x del punto
     */
    public double getX() { return x; }

    /**
     * Modificar coordenada X
     * @param x Nuevo valor
     */
    public void setX(double x) { this.x = x; }

    /**
     *
     * @return Coordenada y del punto
     */
    public double getY() { return y; }

    /**
     * Modificar coordenada Y
     * @param y Nuevo valor
     */
    public void setY(double y) { this.y = y; }

    /**
     * Trasladar un punto los valores indicados
     * @param incX incremento de la coordenada X
     * @param incY incremento de la coordenada Y
     */
    public void trasladar(double incX, double incY) {
        if (incX != 0 || incY != 0) {
            this.x += incX;
            this.y += incY;
        }
    }

    /**
     * Distancia Euclidea con otro punto
     * @param p Punto con el que calculo la distancia
     * @return distancia Euclidea
     */
    public double distanciaEuclidea(Punto p) {
        double difX = this.x - p.x;
        double difY = this.y - p.y;
        return Math.sqrt(difX * difX + difY * difY);
    }


    @Override
    public String toString() {
        return String.format("%5.2f, %5.2f", x, y);
    }
}
