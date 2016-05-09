package top.flyfire.asm.analysis;


import org.objectweb.asm.*;
import top.flyfire.asm.AccessUtil;

/**
 * Created by shyy_work on 2016/5/9.
 */
public class ClassPrinter  extends ClassVisitor implements Opcodes,AccessUtil {

    private StringBuilder builder;

    public ClassPrinter() {
        super(ASM5);
        builder = new StringBuilder();
    }

    @Override
    public void visit(int version, int access, String name, String signture, String superName, String[] interfaces) {
        builder.append(hasAccess(access,ACC_PUBLIC)?"public ":"")
                .append(hasAccess(access,ACC_ABSTRACT)?"abstract class "
                        :hasAccess(access,ACC_FINAL)?"final class "
                        :hasAccess(access,ACC_INTERFACE) ? "interface"
                        :hasAccess(access,ACC_ENUM)?"enum ":"")
                .append(name)
                .append(" extends ")
                .append(superName)
                .append(" {")
                .append("\r\n");
        super.visit(version, access, name, signture, superName, interfaces);
    }

    @Override
    public void visitSource(String source, String debug) {
        super.visitSource(source, debug);
    }

    @Override
    public void visitOuterClass(String owner, String name, String desc) {
        super.visitOuterClass(owner, name, desc);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return super.visitAnnotation(desc, visible);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        super.visitAttribute(attribute);
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        super.visitInnerClass(name, outerName, innerName, access);
    }

    @Override
    public FieldVisitor visitField(int access, String name , String desc, String signture, Object value) {
        builder.append(hasAccess(access,ACC_PRIVATE)?"private "
                :hasAccess(access,ACC_PROTECTED)?"protected "
                :hasAccess(access,ACC_PUBLIC)?"public ":"")
                .append(hasAccess(access,ACC_FINAL)?"final ":"")
                .append(desc)
                .append(name)
                .append("\r\n");
        return super.visitField(access, name, desc, signture, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signture, String[] exceptions) {
        builder.append(hasAccess(access,ACC_PRIVATE)?"private "
                :hasAccess(access,ACC_PROTECTED)?"protected "
                :hasAccess(access,ACC_PUBLIC)?"public ":"")
                .append(hasAccess(access,ACC_FINAL)?"final ":"")
                .append(name)
                .append(desc)
                .append("\r\n");
        return super.visitMethod(access, name, desc, signture, exceptions);
    }

    @Override
    public void visitEnd() {
        builder.append("}");
        super.visitEnd();
        System.out.println(builder);
    }
}
