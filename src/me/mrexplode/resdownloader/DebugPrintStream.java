package me.mrexplode.resdownloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class DebugPrintStream extends PrintStream {

	public DebugPrintStream(File paramFile) throws FileNotFoundException {
		super(paramFile);
	}

	public DebugPrintStream(File paramFile, String paramString)
			throws FileNotFoundException, UnsupportedEncodingException {
		super(paramFile, paramString);
	}

	public DebugPrintStream(OutputStream paramOutputStream) {
		super(paramOutputStream);
	}

	public DebugPrintStream(OutputStream paramOutputStream, boolean paramBoolean) {
		super(paramOutputStream, paramBoolean);
	}

	public DebugPrintStream(OutputStream paramOutputStream, boolean paramBoolean, String paramString)
			throws UnsupportedEncodingException {
		super(paramOutputStream, paramBoolean, paramString);
	}

	public DebugPrintStream(String paramString) throws FileNotFoundException {
		super(paramString);
	}

	public DebugPrintStream(String paramString1, String paramString2)
			throws FileNotFoundException, UnsupportedEncodingException {
		super(paramString1, paramString2);
	}

	@Override
	public void println(String x) {
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		super.println(trace[1].getClassName() + "." + trace[1].getLineNumber() + ": " + x);
	}

}
