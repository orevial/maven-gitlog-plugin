package com.github.danielflower.mavenplugins.gitlog;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

// Not unit tests, but a way to manually observe the output during maven test phase
public class GeneratorTest {

	@Test
	public void writeLogToStandardOutput() throws Exception {
		Log log = new SystemStreamLog();
		ChangeLogRenderer renderer = new MavenLoggerRenderer(log);
		Generator generator = new Generator(Arrays.asList(renderer), log);
		generator.openRepository();
		generator.generate();
	}

	@Test
	public void writePlainTextLogToFile() throws Exception {
		Log log = new SystemStreamLog();
		ChangeLogRenderer renderer = new PlainTextRenderer(log, new File("target"), "changelog.txt");
		Generator generator = new Generator(Arrays.asList(renderer), log);
		generator.openRepository();
		generator.generate();
	}

}