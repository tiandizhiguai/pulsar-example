package com.pulsar;

import java.util.Collections;

import org.apache.pulsar.common.functions.FunctionConfig;
import org.apache.pulsar.functions.LocalRunner;

public class BigDataRunner {

	public static void main(String[] args) throws Exception {
		FunctionConfig functionConfig = new FunctionConfig();
		functionConfig.setName("BigDataRunner");
		functionConfig.setInputs(Collections.singleton("input-topic"));
		functionConfig.setClassName(BloomFilterFunction.class.getName());
		functionConfig.setRuntime(FunctionConfig.Runtime.JAVA);
		LocalRunner localRunner = LocalRunner.builder()
				.functionConfig(functionConfig)
				.build();
		localRunner.start(true);
	}
}
