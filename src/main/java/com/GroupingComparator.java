package com;

/**
 * Once the data reaches a reducer, all data is grouped by key. Since we have a composite key, we need to make sure records are grouped solely by the natural key. This is accomplished by writing a custom GroupPartitioner. We have a Comparator object only considering the yearMonth field of the TemperaturePair class for the purposes of grouping the records together.
 * Mapout should be (Key+Value, Value)
When we have joined Key&Value. Still we need to have mechanism to sort on original Key as well as on value.So we would add a custom comparator.
Now data is sorted on original Key but if we send this data to reducer, it will not guarantee to send all value of a given key to one reducer as we are using Key+Value as key. To make sure it we would add group comparator.
 */
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {
	public GroupingComparator() {
		super(TemperaturePair.class, true);
	}

	@Override
	public int compare(WritableComparable wc1, WritableComparable wc2) {
		TemperaturePair pair = (TemperaturePair) wc1;
		TemperaturePair pair2 = (TemperaturePair) wc2;
		return pair.getYearMonth().compareTo(pair2.getYearMonth());
	}

}
