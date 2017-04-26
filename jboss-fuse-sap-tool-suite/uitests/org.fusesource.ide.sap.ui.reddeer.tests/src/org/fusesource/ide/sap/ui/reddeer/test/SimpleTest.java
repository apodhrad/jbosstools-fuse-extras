package org.fusesource.ide.sap.ui.reddeer.test;

import static org.junit.Assert.assertTrue;

import org.jboss.reddeer.common.logging.Logger;
import org.jboss.reddeer.eclipse.ui.perspectives.AbstractPerspective;
import org.jboss.reddeer.eclipse.ui.perspectives.JavaEEPerspective;
import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.jboss.reddeer.requirements.cleanworkspace.CleanWorkspaceRequirement.CleanWorkspace;
import org.jboss.reddeer.requirements.openperspective.OpenPerspectiveRequirement.OpenPerspective;
import org.jboss.tools.fuse.reddeer.perspectives.FuseIntegrationPerspective;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Simple tests verifies only presence of JBoss Fuse Tooling plugins
 * 
 * @author tsedmik
 */
@CleanWorkspace
@OpenPerspective(JavaEEPerspective.class)
@RunWith(RedDeerSuite.class)
public class SimpleTest extends DefaultTest {

	private static Logger log = Logger.getLogger(SimpleTest.class);
	private static String PROJECT_NAME = "cbr @1";

	/**
	 * <p>
	 * Simple test tries to open perspectives related to JBoss Fuse Tooling
	 * </p>
	 * <b>Steps:</b>
	 * <ol>
	 * <li>open Fuse Integration perspective</li>
	 * </ol>
	 */
	@Test
	public void testOpenPerspectives() {

		AbstractPerspective perspective = new FuseIntegrationPerspective();
		perspective.open();
		assertTrue(perspective.isOpened());
	}
}
