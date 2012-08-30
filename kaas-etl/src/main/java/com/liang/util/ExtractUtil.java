package com.liang.util;

import java.util.List;

import com.liang.reader.SatInfoReader;
import com.liang.service.TransformerService;

public class ExtractUtil {
	
	private TransformerService transformerService;
	
	public TransformerService getTransformerService() {
		return transformerService;
	}

	public void setTransformerService(TransformerService transformerService) {
		this.transformerService = transformerService;
	}

	public List<Integer> getGoodsList() {
		SatInfoReader reader = new SatInfoReader();
		System.out.println(reader.getMappings());
		
		return null;
	}
}
