/*******************************************************************************
 * Copyright (c) 2016 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package org.fusesource.ide.sap.ui.properties.uicreator;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.fusesource.camel.component.sap.model.rfc.impl.DestinationDataStoreEntryImpl;

/**
 * @author Aurelien Pupier
 *
 */
public interface IDestinationDataUICreator extends IDataUICreator {

	void initDataBindings(DataBindingContext bindingContext, EditingDomain editingDomain, DestinationDataStoreEntryImpl destinationDataStoreEntry);

}