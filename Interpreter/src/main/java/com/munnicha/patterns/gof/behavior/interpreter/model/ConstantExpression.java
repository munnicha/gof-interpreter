package com.munnicha.patterns.gof.behavior.interpreter.model;

/**
 *
 * @author munnicha
 */
public class ConstantExpression implements BooleanExpression{
    
    private boolean constant;

    public ConstantExpression(boolean constant) {
        this.constant = constant;
    }
    
    @Override
    public boolean evaluate(Context context) {
        return constant;
    }

}
