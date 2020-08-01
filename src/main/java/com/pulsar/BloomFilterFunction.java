package com.pulsar;

import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.TypedMessageBuilder;
import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;

import com.clearspring.analytics.stream.membership.BloomFilter;

public class BloomFilterFunction implements Function<String, Void> {

	BloomFilter filter = new BloomFilter(20, 20);

	public Void process(String input, Context context) throws Exception {
		if (!filter.isPresent(input)) {
			filter.add(input);
			// 发送消息
			TypedMessageBuilder<String> sender = context.newOutputMessage("notSeenTopic", Schema.STRING);
			sender.value(input).send();
		}
		return null;
	}
}