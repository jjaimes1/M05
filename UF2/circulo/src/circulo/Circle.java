
public class Circle {

    /** radi de la circunferencia **/
    private double radius;

    /**
     * Constructor
     * 
     * @param radi
     */
    public Circle(double radi) {
        this.radius = radi;
    }

    /**
     * Calcula l'area de la circunferencia
     * 
     * @return l'area de la circunferencia
     */
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Calcula el perimetre de la circunferencia
     * 
     * @return perimetre de la circunferencia
     */
    public double calculatePerimeter() {
        return Math.PI * 2 * radius;
    }

    /**
     * Determina si una circunferencia és més gran que una altre
     * 
     * @param circle
     * @return true si circle és més gran, false si és més petit
     */
    public boolean moreBigCircle(Circle circle) {
        return circle.radius > this.radius;
    }

}
