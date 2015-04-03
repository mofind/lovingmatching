package org.aurora.lovingmatching.model.shareModel.historyModel;

import java.util.ArrayList;

import org.aurora.lovingmatching.po.LocalAllHistoryPO;
import org.aurora.lovingmatching.po.LocalHistoryPO;
import org.aurora.lovingmatching.txtUtility.AbstractFileUtility;
import org.aurora.lovingmatching.txtUtility.FileUtility;
import org.aurora.lovingmatching.view.StubView.StubHistoryView;
import org.aurora.lovingmatching.vo.HistoryVO;

public class HistoryModel {
	private AbstractFileUtility fileUtility;
	private ArrayList<StubHistoryView> historyViews = new ArrayList<StubHistoryView>();

	public void addChangeListner(StubHistoryView stubHistoryView) {
		this.historyViews.add(stubHistoryView);
		this.fileUtility = new FileUtility();
	}

	public boolean addHistory(HistoryVO historyVO) {
		LocalHistoryPO historyPO = new LocalHistoryPO(historyVO);
		return fileUtility.addHistory(historyPO);
	}

	public LocalAllHistoryPO getUserHistory(String uid) {
		return fileUtility.getOneUserHistory(uid);
	}
}
