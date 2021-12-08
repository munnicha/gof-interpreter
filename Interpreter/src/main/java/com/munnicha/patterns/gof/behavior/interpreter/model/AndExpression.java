package com.munnicha.patterns.gof.behavior.interpreter.model;

/**
 *
 * @author munnicha
 */
public class AndExpression implements BooleanExpression{
    
    private BooleanExpression expr1;
    private  BooleanExpression expr2;

    public AndExpression(BooleanExpression expr1, BooleanExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean evaluate(Context context) {
        return expr1.evaluate(context) && expr2.evaluate(context);
    }
    
}
