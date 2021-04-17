import javassist.ClassPool;
import javassist.LoaderClassPath;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class AgentMain {

    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
        transformClass("Account", instrumentation);
    }

    public static void transformClass(String className, Instrumentation instrumentation) {
        try {
            Class<?> account = Class.forName(className);
            AccountTransformer accountTransformer = new AccountTransformer(className, account.getClassLoader());
            instrumentation.addTransformer(accountTransformer, true);
            instrumentation.retransformClasses(account);
        } catch (ClassNotFoundException | UnmodifiableClassException e) {
            e.printStackTrace();
        }
    }

}
