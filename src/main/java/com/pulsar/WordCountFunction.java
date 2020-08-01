package com.pulsar;

import java.util.Arrays;

import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

public class WordCountFunction implements Function<String, Void> {

	@Override
	public Void process(String input, Context context) throws Exception {
		Arrays.asList(input.split(" ")).forEach(word -> {
			String counterKey = word.toLowerCase();
			context.incrCounter(counterKey, 1);
		});
		
		return null;
	}
}
