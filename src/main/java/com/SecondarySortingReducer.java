package com;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class SecondarySortingReducer
		extends Reducer<TemperaturePair, IntWritable, TemperaturePair, IntWritable> {

	@Override
	public void reduce(TemperaturePair key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		for (IntWritable value : values) {
			context.write(key, value);
		}
	}
}
