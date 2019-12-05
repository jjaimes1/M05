package circulos;



import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestCircle
{


    @Test
    public void testArea()
    {
        Circle result;
        double res= 12.56;
        double rad = 2;

        result = new Circle(rad);
        assertEquals(res, result.calculateArea(), 0.5);

    }


    @Test
    public void testPerimentre()
    {
        double rad =2;
        double res = 12.56;
        Circle result = new Circle(rad);

        assertEquals(res, result.calculatePerimeter(), 0.5);
    }

    @Test
    public void comparacioCercles()
    {
        double rad =2;
        double rad2 =4;

        Circle result = new Circle(rad);
        Circle result2 = new Circle(rad2);

        assertTrue(result.moreBigCircle(result2));

    }
}
