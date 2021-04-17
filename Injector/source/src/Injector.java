import com.sun.tools.attach.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Injector {

    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        List<VirtualMachineDescriptor> vms = VirtualMachine.list();
        VirtualMachine application = null;
        for (VirtualMachineDescriptor vm : vms)
            if (vm.displayName().equals("MySimpleApplication.jar")) application = VirtualMachine.attach(vm.id());
        if (application == null) {
            System.out.println("Application not found.");
            return;
        }
        File agent = new File("C:\\Users\\breno_t2n1ay9\\IdeaProjects\\ClientBase3\\eclipse\\MySimpleAgent\\target\\MySimpleAgent-1.0-SNAPSHOT.jar");
        application.loadAgent(agent.getAbsolutePath());
    }

}
