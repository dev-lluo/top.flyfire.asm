package test;

import org.objectweb.asm.ClassReader;
import top.flyfire.asm.analysis.ClassPrinter;

import java.io.IOException;

/**
 * Created by shyy_work on 2016/5/9.
 */
public class ClassPrinterTest {

    public static void main(String[] args) throws IOException {
        ClassPrinter classPrinter = new ClassPrinter();
        ClassReader classReader = new ClassReader("test.Base");
        classReader.accept(classPrinter,0);
    }
}
