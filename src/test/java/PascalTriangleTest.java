import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PascalTriangleTest {

    @Test
    public void generatePascalTriangle() {
        ArrayList<ArrayList<Integer>> one = PascalTriangle.generatePascalTriangle(1);
        ArrayList<ArrayList<Integer>> oneResult = new ArrayList<>();
        ArrayList<Integer> innerOne = new ArrayList<>();
        innerOne.add(1);
        oneResult.add(innerOne);
        assertEquals(oneResult, one);
    }

    @Test
    public void generatePascalTriangleTwo() {
        ArrayList<ArrayList<Integer>> two = PascalTriangle.generatePascalTriangle(2);
        ArrayList<ArrayList<Integer>> twoResult = new ArrayList<>();
        ArrayList<Integer> innerTwo = new ArrayList<>();
        innerTwo.add(1);
        twoResult.add(innerTwo);
        ArrayList<Integer> nextInner = new ArrayList<>();
        nextInner.add(1);
        nextInner.add(1);
        twoResult.add(nextInner);
        assertEquals(twoResult, two);
    }

    @Test
    public void generatePascalTriangleThree() {
        ArrayList<ArrayList<Integer>> three = PascalTriangle.generatePascalTriangle(3);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> innerTwo = new ArrayList<>();
        innerTwo.add(1);
        result.add(innerTwo);
        ArrayList<Integer> nextInner = new ArrayList<>();
        nextInner.add(1);
        nextInner.add(1);
        result.add(nextInner);
        nextInner = new ArrayList<>();
        nextInner.add(1);
        nextInner.add(2);
        nextInner.add(1);
        result.add(nextInner);
        assertEquals(result, three);
    }
}