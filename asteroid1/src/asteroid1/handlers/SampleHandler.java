package asteroid1.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import asteroid1package.IRun;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;

public class SampleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"Asteroid1",
				"Click ok to play!");
		
		evaluateRunExtension();
		return null;
	}
	
	 private void evaluateRunExtension() {
		 //String greetings = "";
	        IConfigurationElement[] config = Platform.getExtensionRegistry()
	                .getConfigurationElementsFor("asteroid1.Irunextensionpoint");//Change to your own
	        try {
	            for (IConfigurationElement e : config) {
	                System.out.println("Evaluating IRun extension");
	                final Object o = e.createExecutableExtension("irun");
	                if (o instanceof IRun) {
	                   ((IRun) o).startGame();
	                }
	            }
	            //return greetings;
	        } catch (CoreException ex) {
	            System.out.println(ex.getMessage());
	            //return null;
	        }
	    }
	}

