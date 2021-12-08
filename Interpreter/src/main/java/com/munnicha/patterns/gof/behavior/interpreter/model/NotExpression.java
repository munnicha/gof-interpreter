package com.munnicha.patterns.gof.behavior.interpreter.model;

/**
 *
 * @author munnicha
 */
public class NotExpression  implements BooleanExpression{
    
    private BooleanExpression expr1;

    public NotExpression(BooleanExpression expr1) {
        this.expr1 = expr1;
    }

    @Override
    public boolean evaluate(Context context) {
        return !expr1.evaluate(context);
    }
    
    
}
