/*
 * Copyright 2013, The Thymeleaf Project (http://www.thymeleaf.org/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.thymeleaf.extras.eclipse.contentassist;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.ArrayList;

import javax.xml.namespace.QName;

/**
 * Common code between the various processors in this plugin that pick out
 * Thymeleaf processors from the document.
 * 
 * @author Emanuel Rabina
 */
public abstract class AbstractProcessorComputer {

	/**
	 * Find the Eclipse project for the file the user is working on.
	 * 
	 * @return The project owning the file the user has open.
	 */
	protected static IProject findCurrentProject() {

		StructuredTextEditor editor = (StructuredTextEditor)ContentAssistPlugin.getDefault()
				.getWorkbench().getWorkbenchWindows()[0].getActivePage().getActiveEditor();
		IFile file = ((IFileEditorInput)editor.getEditorInput()).getFile();
		return file.getProject();
	}

	/**
	 * Return a list of the namespaces valid at the given node.
	 * 
	 * @param node
	 * @return List of namespaces known to this node.
	 */
	protected static ArrayList<QName> findNodeNamespaces(Node node) {

		ArrayList<QName> namespaces = new ArrayList<QName>();

		if (node instanceof Element) {
			NamedNodeMap attributes = node.getAttributes();
			for (int i = 0; i < attributes.getLength(); i++) {
				String name = ((Attr)attributes.item(i)).getName();
				if (name.startsWith("xmlns:")) {
					namespaces.add(new QName(((Element)node).getAttribute(name), "", name.substring(6)));
				}
			}
		}
		Node parent = node.getParentNode();
		if (parent != null) {
			namespaces.addAll(findNodeNamespaces(parent));
		}

		return namespaces;
	}

	/**
	 * Returns whether or not the given character is a valid processor name
	 * character.
	 * 
	 * @param c
	 * @return <tt>true</tt> if <tt>char</tt> is an alphanumeric character, or
	 * 		   one of the following symbols: <tt>: - </tt>
	 */
	protected static boolean isProcessorChar(char c) {

		return Character.isLetterOrDigit(c) || c == ':' || c == '-';
	}
}