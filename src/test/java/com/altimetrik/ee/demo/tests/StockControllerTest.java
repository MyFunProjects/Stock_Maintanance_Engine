package com.altimetrik.ee.demo.tests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import com.altimetrik.ee.demo.controller.StockController;
import com.altimetrik.ee.demo.entity.StockEntity;
import com.altimetrik.ee.demo.service.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(StockController.class)

public class StockControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	StockService mockStockService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void test_GetStockDetails_using_StockNumber() throws Exception {
		StockEntity mockStockEntity = new StockEntity(1L, "Rice", 100, "06/06/2020", 6);
		when(mockStockService.getStockDetailsByID(any(Long.class))).thenReturn(mockStockEntity);
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/stock/Getstock/{stock_number}", 1)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.stockName").value("Rice"));
	}

	@Test
	public void test_CreateOrUpdateStock() throws Exception {
		StockEntity mockStockEntity = new StockEntity(null, "Vegetables", 140, "07/06/2020", 16);
		when(mockStockService.CreateOrUpdateStock(any(StockEntity.class))).thenReturn(mockStockEntity);
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/stock/CreateOrUpdateStock")
				.content(asJsonString(mockStockEntity))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.stockName").value("Vegetables"));
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
