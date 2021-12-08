package com.munnicha.patterns.gof.behavior.interpreter.test;

import com.munnicha.patterns.gof.behavior.interpreter.model.AndExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.BooleanExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.ConstantExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.Context;
import com.munnicha.patterns.gof.behavior.interpreter.model.NotExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.OrExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.VariableExpression;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author munnicha
 */
public class InterpreterTest {
    
    @Test
    public void expressionTest(){
        Context context = new Context();
        VariableExpression x = new VariableExpression("X");
        VariableExpression y = new VariableExpression("Y");
        
        //((true and X) or (Y and (not X)))
        BooleanExpression expression1 = new OrExpression(
                                            new AndExpression(new ConstantExpression(true),x),
                                            new AndExpression(y, new NotExpression(x))
                                        );
        
        context.assign(x, false);
        context.assign(y, true);
        assertTrue(expression1.evaluate(context));
        
        //((X and Y) or ((not Y) and X)
        BooleanExpression expression2 = new OrExpression(
                                            new AndExpression(x,y),
                                            new AndExpression(new NotExpression(y),x)
                                        );
        
        context.assign(x, false);
        context.assign(y, true);
        assertFalse(expression2.evaluate(context));
    }
    
}
