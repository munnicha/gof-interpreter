package com.munnicha.patterns.gof.behavior.interpreter.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author munnicha
 */
public class Context {
    
    private Map<String,VariableExpression> variables;
    private Map<VariableExpression,Boolean> assigments;

    public Context() {
        variables = new HashMap<>();
        assigments = new HashMap<>();
    }
    
    public boolean lookup(String varName){
        return assigments.get(variables.get(varName));
    }
    
    public void assign(VariableExpression var, boolean bool){
        variables.put(var.getName(), var);
        assigments.put(var,bool);
    }  
  
}
