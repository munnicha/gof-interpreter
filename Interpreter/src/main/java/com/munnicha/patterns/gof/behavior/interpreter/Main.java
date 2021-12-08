package com.munnicha.patterns.gof.behavior.interpreter;

import com.munnicha.patterns.gof.behavior.interpreter.model.AndExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.BooleanExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.ConstantExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.Context;
import com.munnicha.patterns.gof.behavior.interpreter.model.NotExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.OrExpression;
import com.munnicha.patterns.gof.behavior.interpreter.model.VariableExpression;

/**
 *
 * @author munnicha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        The grammar is defined as follows:
        BooleanExp ::= VariableExp | Constant | OrExp | AndExp | NotExp |  '(' BooleanExp ')'
        AndExp ::= BooleanExp 'and' BooleanExp
        OrExp ::= BooleanExp 'or' BooleanExp
        NotExp ::= 'not' BooleanExp
        Constant ::= 'true' | 'false'
        VariableExp ::= 'A' | 'B' | ... | 'X' | 'Y' | 'Z'
        */
        
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
        boolean result = expression1.evaluate(context);
        System.out.println(result);
        
        //((X and Y) or ((not Y) and X)
        BooleanExpression expression2 = new OrExpression(
                                            new AndExpression(x,y),
                                            new AndExpression(new NotExpression(y),x)
                                        );
        
        context.assign(x, false);
        context.assign(y, true);
        result = expression2.evaluate(context);
        System.out.println(result);
    }
    
}
