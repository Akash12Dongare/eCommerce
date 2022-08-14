/**
 * 
 */
package com.eCommerce.utils;

/**
 * @author Akash.d
 *
 */
public class GenericJsonBean {
	private String STS;
	private String MSG = "";
	private Object CONTENT = "";
	private String TKN;
	private String STACKTRACE = "";

	public static GenericJsonBean createJsonString(String STS, String MSG, Object content) {
		GenericJsonBean genericJsonBean = new GenericJsonBean();
		genericJsonBean.setMSG(MSG);
		genericJsonBean.setSTS(STS);
		genericJsonBean.setCONTENT(content);

		return genericJsonBean;
	}

	public static GenericJsonBean createJsonString(String TKN, String STS, String MSG, Object content) {
		GenericJsonBean genericJsonBean = new GenericJsonBean();
		genericJsonBean.setTKN(TKN);
		genericJsonBean.setMSG(MSG);
		genericJsonBean.setSTS(STS);
		genericJsonBean.setCONTENT(content);

		return genericJsonBean;
	}

	public static GenericJsonBean createJsonString(String STS, String MSG, Object content, String stacktrace) {
		GenericJsonBean genericJsonBean = new GenericJsonBean();
		genericJsonBean.setMSG(MSG);
		genericJsonBean.setSTS(STS);
		genericJsonBean.setCONTENT(content);
		genericJsonBean.setSTACKTRACE(stacktrace);
		return genericJsonBean;
	}

	public static GenericJsonBean createJsonString(GenericJsonBean genericJsonBean) {

		return genericJsonBean;
	}

	public String getSTS() {
		return STS;
	}

	public void setSTS(String sTS) {
		STS = sTS;
	}

	public String getMSG() {
		return MSG;
	}

	public void setMSG(String mSG) {
		MSG = mSG;
	}

	public Object getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(Object cONTENT) {
		CONTENT = cONTENT;
	}

	public String getTKN() {
		return TKN;
	}

	public void setTKN(String tKN) {
		TKN = tKN;
	}

	public String getSTACKTRACE() {
		return STACKTRACE;
	}

	public void setSTACKTRACE(String sTACKTRACE) {
		STACKTRACE = sTACKTRACE;
	}

}
