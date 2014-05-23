package algocraft.function;


import static algocraft.function.Product.FlagDef2.*;
import static algocraft.function.SixFlags.______;

public class Product {

    static enum FlagDef2 {Imported, Packaged, Taxfree}

    private SixFlags flags = ______;

    public boolean isImported() {
        return flags.valueOf(Imported);
    }

    public boolean isPackaged() {
        return flags.valueOf(Packaged);
    }

    public boolean isTaxfree() {
        return flags.valueOf(Taxfree);
    }

    public void setImported(boolean flag) {
        flags = flags.resolve(Imported, flag);
    }

    public void setPackaged(boolean flag) {
        flags = flags.resolve(Packaged, flag);
    }

    public void setTaxfree(boolean flag) {
        flags = flags.resolve(Taxfree, flag);
    }

    @Override
    public String toString() {
        return flags.toString(FlagDef2.values()).toString();
    }

}
