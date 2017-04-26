package org.fusesource.ide.sap.ui.reddeer.test;

import org.jboss.reddeer.common.logging.Logger;
import org.jboss.reddeer.common.matcher.RegexMatcher;
import org.jboss.reddeer.common.wait.TimePeriod;
import org.jboss.reddeer.common.wait.WaitWhile;
import org.jboss.reddeer.core.condition.JobIsRunning;
import org.jboss.reddeer.core.exception.CoreLayerException;
import org.jboss.reddeer.core.handler.ShellHandler;
import org.jboss.reddeer.core.matcher.WithTooltipTextMatcher;
import org.jboss.reddeer.eclipse.ui.console.ConsoleView;
import org.jboss.reddeer.swt.impl.toolbar.DefaultToolItem;
import org.jboss.reddeer.workbench.impl.shell.WorkbenchShell;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Prepares environment for tests
 * 
 * @author tsedmik
 */
public class DefaultTest {

	private static Logger log = Logger.getLogger(DefaultTest.class);

	/**
	 * Prepares test environment
	 */
	@BeforeClass
	public static void defaultClassSetup() {

//		log.info("Maximizing workbench shell.");
//		new WorkbenchShell().maximize();
//
//		log.info("Disable showing Console view after standard output changes");
//		ConsolePreferencePage consolePref = new ConsolePreferencePage();
//		consolePref.open();
//		consolePref.toggleShowConsoleErrorWrite(false);
//		consolePref.toggleShowConsoleStandardWrite(false);
//		consolePref.ok();
//
//		log.info("Disable showing Error Log view after changes");
//		new ErrorLogView().selectActivateOnNewEvents(false);
	}

	/**
	 * Prepares test environment
	 */
	@Before
	public void defaultSetup() {

		new WorkbenchShell();

		log.info("Deleting Error Log.");
//		new ErrorLogView().deleteLog();
	}

	/**
	 * Cleans up test environment
	 */
	@After
	public void defaultClean() {

		new WorkbenchShell();

		log.info("Closing all non workbench shells.");
		ShellHandler.getInstance().closeAllNonWorbenchShells();

		log.info("Try to terminate a console.");
		ConsoleView console = new ConsoleView();
		console.open();
		try {
			console.terminateConsole();
			new WaitWhile(new JobIsRunning(), TimePeriod.LONG);
		} catch (CoreLayerException ex) {
			log.warn("Cannot terminate a console. Perhaps there is no active console.");
		}

		log.info("Save editor");
		try {
			new DefaultToolItem(new WorkbenchShell(), 0, new WithTooltipTextMatcher(new RegexMatcher("Save All.*")))
					.click();
		} catch (Exception e) {
			log.info("Nothing to save");
		}
	}


}
