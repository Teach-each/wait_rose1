package com.wait.rose_Tes_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(
		features="src/test/resources/Feature",
		glue="com.wait.rose_step_defenition",
				tags= "@WR1",
		plugin = {
				"pretty",
				"html:target/cucumber-html-report.html",
				"json:target/cucumber.json",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
				
		},
		dryRun = false,
		monochrome = true
		
		
		)
public class TestRunner {

}
