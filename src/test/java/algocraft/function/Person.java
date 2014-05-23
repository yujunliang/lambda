package algocraft.function;

import static algocraft.function.Person.FlagDef.HasChildren;
import static algocraft.function.Person.FlagDef.Married;
import static algocraft.function.SixFlags.______;

public class Person {

    static enum FlagDef {Married, HasChildren}

    private SixFlags flags = ______;

    public boolean isMarried() {
        return flags.valueOf(Married);
    }

    public boolean hasChildren() {
        return flags.valueOf(HasChildren);
    }

    public void setMarried(boolean flag) {
        flags = flags.resolve(Married, flag);
    }

    public void setHasChildren(boolean flag) {
        flags = flags.resolve(HasChildren, flag);
    }

    @Override
    public String toString() {
        return flags.toString(FlagDef.values()).toString();
    }
}
