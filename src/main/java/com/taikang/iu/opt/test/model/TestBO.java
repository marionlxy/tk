package com.taikang.iu.opt.test.model;

import java.lang.String;
import java.math.BigDecimal;
import java.util.Arrays;
import com.taikang.udp.framework.common.datastructre.impl.BaseBO;

/**
 * TestBO
 */
public class TestBO extends BaseBO {

	private static final long serialVersionUID = 1L;

	public TestBO() {
		init();
	}

	protected void init() {
		super.init();
		this.addList(Arrays.asList("serial_id", "num", "title", "text"));
	}

	private String serialId;

	public void setSerialId(String serialId) {
		getData().put("serial_id", serialId);
		this.serialId = serialId;
	}

	public String getSerialId() {
		return (String) getData().get("serial_id");
	}

	private Integer num;

	public void setNum(Integer num) {
		getData().put("num", num);
		this.num = num;
	}

	public Integer getNum() {
		return (Integer) getData().get("num");
	}

	private String title;

	public void setTitle(String title) {
		getData().put("title", title);
		this.title = title;
	}

	public String getTitle() {
		return (String) getData().get("title");
	}

	private String text;

	public void setText(String text) {
		getData().put("text", text);
		this.text = text;
	}

	public String getText() {
		return (String) getData().get("text");
	}
}
