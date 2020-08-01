package com.pulsar;

import java.util.Collections;

import org.apache.pulsar.common.functions.FunctionConfig;
import org.apache.pulsar.functions.LocalRunner;

public class PulsarRunner {

	public static void main(String[] args) throws Exception {
		FunctionConfig functionConfig = new FunctionConfig();
		functionConfig.setName("exclamation");
		//从input-topic获取数据
		functionConfig.setInputs(Collections.singleton("input-topic"));
		//写入数据到output-topic
		functionConfig.setOutput("output-topic");
		functionConfig.setClassName(HelloFunction.class.getName());
		functionConfig.setRuntime(FunctionConfig.Runtime.JAVA);
		LocalRunner localRunner = LocalRunner.builder()
				.functionConfig(functionConfig)
				.brokerServiceUrl("pulsar://101.177.25.62:6650")
				.build();
		localRunner.start(true);
	}
}
