package com;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class SecondarySortDriver extends Configured implements Tool {

	public int run(String[] args) throws Exception {
		Configuration conf = getConf();
		Job job = Job.getInstance(conf);
		job.setJarByClass(SecondarySortDriver.class);
		job.setJobName("SecondarySortDriver");

		Path inputPath = new Path(args[0]);
		Path outputPath = new Path(args[1]);
		FileInputFormat.setInputPaths(job, inputPath);
		FileOutputFormat.setOutputPath(job, outputPath);

		job.setOutputKeyClass(TemperaturePair.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapperClass(SecondarySortingMapper.class);
		job.setReducerClass(SecondarySortingReducer.class);
		job.setPartitionerClass(TemperaturePartitioner.class);
		job.setGroupingComparatorClass(GroupingComparator.class);

		boolean status = job.waitForCompletion(true);
		return status ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		// Make sure there are exactly 2 parameters
		if (args.length != 2) {
			throw new IllegalArgumentException("Usage: SecondarySortDriver" + " <input-path> <output-path>");
		}
		int returnStatus = ToolRunner.run(new SecondarySortDriver(), args);
		System.exit(returnStatus);
	}

}
