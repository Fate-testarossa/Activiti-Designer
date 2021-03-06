package org.activiti.designer.property;

import org.activiti.bpmn.model.ServiceTask;
import org.activiti.bpmn.model.alfresco.AlfrescoScriptTask;
import org.activiti.designer.util.extension.ExtensionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class PropertyServiceTaskFilter extends ActivitiPropertyFilter {

	@Override
	protected boolean accept(PictogramElement pe) {
		Object bo = getBusinessObject(pe);
		if (bo instanceof ServiceTask && !ExtensionUtil.isCustomServiceTask(bo)) {
		  ServiceTask serviceTask = (ServiceTask) bo;
		  if (AlfrescoScriptTask.ALFRESCO_SCRIPT_DELEGATE.equalsIgnoreCase(serviceTask.getImplementation()) == false &&
		          ServiceTask.MAIL_TASK.equalsIgnoreCase(serviceTask.getType()) == false) {
        return true;
      }
		}
		return false;
	}

}
