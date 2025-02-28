package appstart.mymodappdemo;

import java.util.ServiceLoader;

import appfuncs.simplefuncs.SimpleMathFuncs;
import userfuncs.binaryfuncs.*;

public class MyModAppDemo {
    public static void main(String[] args) {

        if(SimpleMathFuncs.isFactor(2, 10)) System.out.println("2 является делителем 10");

        System.out.println("Наименьший общий делитель для 35 и 105 равен " + SimpleMathFuncs.lcf(35, 105));

        System.out.println("Наибольший общий делитель для 35 и 105 равен " + SimpleMathFuncs.gcf(35, 105));

        ServiceLoader<BinFuncProvider> ldr = ServiceLoader.load(BinFuncProvider.class);

        BinaryFunc binOp = null;

        for (var bfp : ldr) {
            if (bfp.get().getName().equals("absPlus")) {
                binOp = bfp.get();
                break;
            }
        }
        if (binOp != null) System.out.println("Result execution function absPlus: " + binOp.func(12, -4));
        else System.out.println("Func absPlus not found");

        for (var bfp : ldr) {
            if (bfp.get().getName().equals("absMinus")) {
                binOp = bfp.get();
                break;
            }
        }
        if (binOp != null) System.out.println("Result execution function absMinus: " + binOp.func(12, -4));
        else System.out.println("Func absMinus not found");
    }
}