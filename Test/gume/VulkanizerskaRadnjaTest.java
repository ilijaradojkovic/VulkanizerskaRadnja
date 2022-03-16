package test.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.Radnja;
import auto_radnja.VulkanizerskaRadnja;

class VulkanizerskaRadnjaTest  extends RadnjaTest{

	

	@BeforeEach
	void setUp() throws Exception {
		r=new VulkanizerskaRadnja();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	

}
