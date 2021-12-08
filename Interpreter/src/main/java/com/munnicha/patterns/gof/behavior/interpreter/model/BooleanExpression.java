package com.munnicha.patterns.gof.behavior.interpreter.model;

/**
 *
 * @author munnicha
 */
public interface BooleanExpression {
    
    public boolean evaluate(Context context);
    
}
