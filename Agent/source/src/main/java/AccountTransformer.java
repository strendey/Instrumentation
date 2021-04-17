import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class AccountTransformer implements ClassFileTransformer {

    private final String TARGET_CLASS_NAME;
    private final ClassLoader TARGET_CLASS_LOADER;

    public AccountTransformer(String className, ClassLoader classLoader) {
        this.TARGET_CLASS_NAME = className;
        this.TARGET_CLASS_LOADER = classLoader;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (TARGET_CLASS_NAME.equalsIgnoreCase(className) && TARGET_CLASS_LOADER.equals(loader)) {
            byte[] modifiedBytecode;
            try {
                ClassPool classPool = ClassPool.getDefault();
                classPool.appendClassPath(new LoaderClassPath(loader));
                CtClass account = ClassPool.getDefault().get("Account");
                CtMethod method = account.getDeclaredMethod("getBalance");
                method.insertBefore("{System.out.println(\"Esta classe foi modificada =D\");}");
                modifiedBytecode = account.toBytecode();
                account.detach();
                return modifiedBytecode;
            } catch (NotFoundException | CannotCompileException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
