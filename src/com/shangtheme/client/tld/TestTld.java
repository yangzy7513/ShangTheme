package com.shangtheme.client.tld;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 测试tld
 * @author Mr.Y
 *
 */
public class TestTld extends SimpleTagSupport{
	
	private JspContext context;
	
	@Override
	public void setJspContext(JspContext pc) {
		this.context = pc;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) context;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String nowtime = sdf.format(date);
		JspWriter out = pageContext.getOut();
		out.write(nowtime);
	}
	
}
