package com.sda.latnikovd.springbootapp;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseTest {

	@BeforeEach
	void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

}
