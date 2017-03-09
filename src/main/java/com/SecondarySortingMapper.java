package com;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SecondarySortingMapper extends Mapper<LongWritable, Text, TemperaturePair, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String[] tokens = value.toString().split(",");
		String yearMonth = tokens[0] + tokens[1];
		String day = tokens[2];
		IntWritable temperature = new IntWritable(Integer.parseInt(tokens[3]));
		TemperaturePair temperaturePair = new TemperaturePair();
		temperaturePair.setYear(new Text(tokens[0]));
		temperaturePair.setMonth(new Text(tokens[1]));
		temperaturePair.setYearMonth(new Text(yearMonth));
		temperaturePair.setDay(new Text(day));
		temperaturePair.setTemperature(temperature);
		context.write(temperaturePair, temperature);
	}
}
