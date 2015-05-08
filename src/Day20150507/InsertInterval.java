package Day20150507;

import java.util.ArrayList;
import java.util.List;

import common.Interval;

 
/**
 * @ClassName: InsertInterval
 * @Description: 
 * @author GongJun
 * @date 2015-5-7 下午9:37:59
 * @version V1.0  
 */

public class InsertInterval {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        
        if(newInterval == null)
            return intervals;
            
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        boolean flag = true;
        
        for(int i = 0; i < intervals.size(); i ++){
        	if(flag && newInterval.start <= intervals.get(i).end){
        		
        			
    			if(newInterval.end < intervals.get(i).start){
    				res.add(newInterval);
    				res.add(intervals.get(i));
    				flag = false;
    			}
    			else if(newInterval.end <= intervals.get(i).end){
    				start = Math.min(newInterval.start, intervals.get(i).start);
    				Interval node = new Interval(start,intervals.get(i).end);
    				res.add(node);
    				flag = false;
    			}
    			else{
    				newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
    				newInterval.end = Math.max(newInterval.end, intervals.get(i).end);;
    			}
        			
        		
        	}
        	else{
        		res.add(intervals.get(i));
        	}
        	
        }
        
        if(flag)
            res.add(newInterval);
        
        return res;
    }
}
