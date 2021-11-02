package myfirstplugin.handlers;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;

//Copy and paste the following import statements

import myfirstplugin.IGreet;//Change to fit your own.

public class SampleHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
        MessageDialog.openInformation(
                window.getShell(),
                "My_Plugin",
                evaluateGreeterExtension());//Copy and replace.
        return null;
    }

    //Copy and paste the following method
    private String evaluateGreeterExtension() {
        String greetings = " ";
        IConfigurationElement[] config = Platform.getExtensionRegistry()
                .getConfigurationElementsFor("myfirstplugin.HelloWorld");//Change to your own
        try {
            for (IConfigurationElement e : config) {
                System.out.println("Evaluating extension");
                final Object o = e.createExecutableExtension("class");
                if (o instanceof IGreet) {
                    greetings+=((IGreet) o).sayHello()+"\n";
                }
            }
            return greetings;
        } catch (CoreException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}