package com.pulsar;

import java.util.function.Function;

public class HelloFunction implements Function<String, String> {

	@Override
	public String apply(String input) {
		return String.format("hello, %s!", input);
	}
}