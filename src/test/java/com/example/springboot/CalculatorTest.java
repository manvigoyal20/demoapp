package com.example.springboot;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void evaluatesExpression() {
       CalculatorTest calculator = new CalculatorTest();
    //    int sum = calculator.evaluate("1+2+3");
       int sum = calculator.evaluatesExpression
       assertEquals(6, sum);
    }
    
}
// package com.javadevelopersguide.junit;
// import static org.junit.Assert.assertEquals;
// import org.junit.Test;

// public class CalculatorTest {
//      @Test
//      public void evaluatesExpression() {
//         Calculator calculator = new Calculator();
//         int sum = calculator.evaluate("1+2+3");
//         assertEquals(6, sum);
//      }
// }
