package org.apache.tools.ant.taskdefs.condition;

import org.apache.tools.ant.*;

public class IsTrue extends ProjectComponent implements Condition
{
    private Boolean value;
    
    public IsTrue() {
        super();
        this.value = null;
    }
    
    public void setValue(final boolean value) {
        this.value = (value ? Boolean.TRUE : Boolean.FALSE);
    }
    
    public boolean eval() throws BuildException {
        if (this.value == null) {
            throw new BuildException("Nothing to test for truth");
        }
        return this.value;
    }
}
