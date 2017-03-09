package com;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class TemperaturePartitioner extends Partitioner<TemperaturePair, Text> {

	@Override
	public int getPartition(TemperaturePair pair, Text text, int numberOfPartitions) {
		// make sure that partitions are non-negative
		return Math.abs(pair.getYearMonth().hashCode() % numberOfPartitions);
	}
}
