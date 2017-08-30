package org.plazmaforge.framework.report;


public class DefaultReportAction extends AbstractReportAction {

    public DefaultReportAction() {
	super();
    }

    public DefaultReportAction(IReport report) {
	super(report);
    }

    protected IReport createReport() {
	return new DefaultReport();
    }

    protected void initReport(IReport report) {
	super.initReport(report);
	setName(report.getName());
	setText(report.getCaption());
	setDescription(report.getDescription());
    }
}
