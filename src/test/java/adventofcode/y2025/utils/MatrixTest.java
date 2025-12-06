package adventofcode.y2025.utils;

import adventofcode.utils.Matrix;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static adventofcode.utils.Mapper.iterableToString;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    public void oneXone(){
        Character[][] input = new Character[][]{{'x'}};
        var o = new Matrix<>(input);
        var neighbours = o.neighbours(0,0);
        assertEquals(0, neighbours.size());
    }

    @Test
    public void twoXtwo(){
        Character[][] input = new Character[][]{{'x','y'}, {'a','b'}};
        var o = new Matrix<>(input);
        var neighbours = o.neighbours(0,0);
        assertEquals(3, neighbours.size(), iterableToString(neighbours));
        Iterator<Character> iterator = neighbours.iterator();
        assertEquals('y', iterator.next());
        assertEquals('a', iterator.next());
        assertEquals('b', iterator.next());
    }


}