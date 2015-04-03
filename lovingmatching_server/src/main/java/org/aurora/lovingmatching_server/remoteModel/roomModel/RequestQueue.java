package org.aurora.lovingmatching_server.remoteModel.roomModel;

import java.util.LinkedList;
import java.util.Queue;

import org.aurora.lovingmatching_server.remoteMessage.messageSet.Request.Request;

public class RequestQueue {
	private Queue<Request> request_queue;
	
	public RequestQueue()
	{
		request_queue = new LinkedList();
	}
	
	public void addRequest(Request request)
	{
		synchronized(request_queue){
			request_queue.add(request);
		}
	}
	
	public boolean isEmpty(){
		return request_queue.isEmpty();
	}
	
	public Request getRequest()
	{
		synchronized(request_queue){
			return request_queue.poll();
		}
	}
	
}
