package top.flyfire.asm;

/**
 * Created by shyy_work on 2016/5/9.
 */
public interface AccessUtil {

    default boolean hasAccess(int value,int access){
        return (value&access)==access;
    }

}
