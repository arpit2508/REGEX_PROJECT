package com.regex.Regex_Infrrd;

//	POJO for Regular Expression & input text
public class Regex_POJO {
	private String regex;
	private String text;

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Regex_POJO [regex=" + regex + ", text=" + text + "]";
	}

}
