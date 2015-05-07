package Day20150507;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Interval;

 
/**
 * @ClassName: MergeIntervals
 * @Description: 
 * @author GongJun
 * @date 2015-5-7 下午8:41:24
 * @version V1.0  
 */

public class MergeIntervals {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        
        if(intervals == null || intervals.size() == 0)
        	return res;
        
        Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return (o1.start - o2.start);
			}
        	
        });
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(int i = 1; i < intervals.size(); i ++){
        	if(intervals.get(i).start <= end){ //==也算overlap
        		end = Math.max(end, intervals.get(i).end);
        	}
        	else{
        		Interval node = new Interval(start,end);
        		res.add(node);
        		start = intervals.get(i).start;
        		end = intervals.get(i).end;
        	}
        }
        
        Interval node = new Interval(start,end);
		res.add(node);
        
        return res;
    }
}
