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
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(int i = 0; i < intervals.size(); i ++){
        	if(newInterval.start < intervals.get(i).end)
        }
        return res;
    }
}
