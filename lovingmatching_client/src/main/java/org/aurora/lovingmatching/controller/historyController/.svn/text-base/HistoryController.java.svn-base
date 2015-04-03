package org.aurora.lovingmatching.controller.historyController;

import org.aurora.lovingmatching.model.shareModel.historyModel.HistoryModel;
import org.aurora.lovingmatching.view.StubView.StubHistoryView;
import org.aurora.lovingmatching.vo.HistoryVO;
/**
 * 
 * @author ljing12[AT]software.nju.edu.cn
 *
 */
public class HistoryController {
	private HistoryModel historyModel;
	private StubHistoryView historyView;
	public HistoryController(StubHistoryView historyView,HistoryModel historyModel) {
		this.historyModel=historyModel;
		this.historyView=historyView;
	}
	
	public boolean addHistory(HistoryVO historyVO){
		return historyModel.addHistory(historyVO);
	}
}
