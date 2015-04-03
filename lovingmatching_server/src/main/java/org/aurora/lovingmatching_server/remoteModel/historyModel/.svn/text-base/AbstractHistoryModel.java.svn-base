package org.aurora.lovingmatching_server.remoteModel.historyModel;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.CoopRecordReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.HistoryReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.TrendReply;
import org.aurora.lovingmatching_server.remoteMessage.messageSet.Reply.VSRecordReply;

public interface AbstractHistoryModel {
	public HistoryReply getCoopHistory(String id);
	public TrendReply getCoopTrendHistory(String id, String type, String limit);
	public CoopRecordReply getCoopRecordHistory(String id, String limit);
	public HistoryReply getPKHistory(String id);
	public TrendReply getPKTrendHistory(String id, String type, String limit);
	public VSRecordReply getPKRecordHistory(String id, String limit);

}
