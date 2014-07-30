package com.esofthead.mycollab.mobile.module.crm.view.account;

import com.esofthead.mycollab.mobile.module.crm.ui.AbstractRelatedItemSelectionView;
import com.esofthead.mycollab.mobile.module.crm.ui.AbstractRelatedListView;
import com.esofthead.mycollab.mobile.module.crm.view.lead.LeadListDisplay;
import com.esofthead.mycollab.mobile.ui.AbstractPagedBeanList;
import com.esofthead.mycollab.module.crm.domain.SimpleLead;
import com.esofthead.mycollab.module.crm.domain.criteria.LeadSearchCriteria;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;

/**
 * @author MyCollab Inc.
 * 
 * @since 4.3.1
 */
public class AccountLeadSelectionView extends
		AbstractRelatedItemSelectionView<SimpleLead, LeadSearchCriteria> {

	private static final long serialVersionUID = 362958193460007588L;

	public AccountLeadSelectionView(
			AbstractRelatedListView<SimpleLead, LeadSearchCriteria> relatedListView) {
		super("Select Leads", relatedListView);
	}

	@Override
	protected void initUI() {
		this.itemList = new LeadListDisplay();
		this.itemList
				.setRowDisplayHandler(new AbstractPagedBeanList.RowDisplayHandler<SimpleLead>() {

					@Override
					public Component generateRow(final SimpleLead obj,
							int rowIndex) {
						final SelectableButton b = new SelectableButton(obj
								.getLeadName());
						if (selections.contains(obj)) {
							b.select();
						}
						b.addClickListener(new Button.ClickListener() {
							private static final long serialVersionUID = -8573958585577402364L;

							@Override
							public void buttonClick(Button.ClickEvent event) {
								if (b.isSelected())
									selections.add(obj);
								else
									selections.remove(obj);
							}
						});
						return b;
					}
				});
	}

}