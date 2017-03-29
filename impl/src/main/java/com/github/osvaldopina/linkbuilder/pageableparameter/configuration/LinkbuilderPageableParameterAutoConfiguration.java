package com.github.osvaldopina.linkbuilder.pageableparameter.configuration;

import com.github.osvaldopina.linkbuilder.pageableparameter.PageableArgumentResolver;
import com.github.osvaldopina.linkbuilder.pageableparameter.PageableVariableValueDiscover;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LinkbuilderPageableParameterAutoConfiguration {

	@Bean
	PageableArgumentResolver pageableArgumentResolver() {
		return new PageableArgumentResolver();
	}

	@Bean
	PageableVariableValueDiscover pageableVariableValueDiscover() {
		return new PageableVariableValueDiscover();
	}


}
