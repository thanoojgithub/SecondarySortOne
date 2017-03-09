package com;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public class TemperaturePair implements Writable, WritableComparable<TemperaturePair> {

	private Text yearMonth = new Text(); // natural key
	private Text year = new Text();
	private Text month = new Text();
	private Text day = new Text();
	private IntWritable temperature = new IntWritable(); // secondary key

	public Text getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(Text yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Text getDay() {
		return day;
	}

	public void setDay(Text day) {
		this.day = day;
	}

	public IntWritable getTemperature() {
		return temperature;
	}

	public void setTemperature(IntWritable temperature) {
		this.temperature = temperature;
	}

	@Override
	public int compareTo(TemperaturePair pair) {
		int compareValue = this.yearMonth.compareTo(pair.getYearMonth());
		if (compareValue == 0) {
			compareValue = temperature.compareTo(pair.getTemperature());
		}
		return compareValue; // sort ascending
		// return -1 * compareValue; // sort descending
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		year.readFields(in);
		month.readFields(in);
		yearMonth.readFields(in);
		day.readFields(in);
		temperature.readFields(in);

	}

	@Override
	public void write(DataOutput out) throws IOException {
		year.write(out);
		month.write(out);
		yearMonth.write(out);
		day.write(out);
		temperature.write(out);
	}

	public Text getYear() {
		return year;
	}

	public void setYear(Text year) {
		this.year = year;
	}

	public Text getMonth() {
		return month;
	}

	public void setMonth(Text month) {
		this.month = month;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		result = prime * result + ((yearMonth == null) ? 0 : yearMonth.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemperaturePair other = (TemperaturePair) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (temperature == null) {
			if (other.temperature != null)
				return false;
		} else if (!temperature.equals(other.temperature))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		if (yearMonth == null) {
			if (other.yearMonth != null)
				return false;
		} else if (!yearMonth.equals(other.yearMonth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return year + " " + month + " " + day;
	}

}
