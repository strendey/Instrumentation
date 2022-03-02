# Project 
This project is divided into three simple programs: 
- A simple app to simulate something like an ATM. 
- A Java agent that uses [Javassist](https://github.com/jboss-javassist/javassist) to make low-level changes (bytecode) at runtime. 
- An injector that uses the [Attach API](https://docs.oracle.com/javase/8/docs/technotes/guides/attach/) 
to attach the agent to the JVM. 

## Recommendation 
Instrumentation in Java is not as simple as it sounds, even using Javassist.  
If you are going to use instrumentation in a more complex project, I recommend using [ASM](https://asm.ow2.io) 
and understanding the [Java Virtual Machine set Instruction Set](https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html). 

## Thanks 
[superblaubeere27](https://github.com/superblaubeere27) for lighting the [Attach API](https://docs.oracle.com/javase/8/docs/technotes/guides/attach/).
 
## License 
[MIT](https://choosealicense.com/licenses/mit/)
