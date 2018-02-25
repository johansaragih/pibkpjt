/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Johan Saragih
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FvBusBookingApplication.class)
@WebAppConfiguration
public class DataControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private MockMvc mockMvc;
    
    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void getData_ThenOK_isCorrect() throws Exception {
        MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/data"))
            .andExpect(MockMvcResultMatchers.status().isOk());
//            .andExpect(MockMvcResultMatchers.content().contentType(contentType));
//            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }
//    
//    @Test
//    public void uploadData_ThenOK_isCorrect() throws Exception {
//        File file = new File("C:\\Users\\Johan Saragih\\Downloads\\Data Contoh 1.xlsx");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/upload")
//                .file(new MockMultipartFile("file", file.getName(), "application/vnd.ms-excel", fileInputStream)))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
    
//    @Test
//    public void uploadData_ThenNomorBarangIsExist_isNotCorrect() throws Exception {
//        File file = new File("C:\\Users\\Johan Saragih\\Downloads\\Data Contoh 1.xlsx");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/upload")
//                .file(new MockMultipartFile("file", file.getName(), "application/vnd.ms-excel", fileInputStream)))
//                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
//    }

//    @Test
//    public void uploadData_ThenNomorBarangIsExist_isNotCorrect() throws Exception {
//        File file = new File("C:\\Users\\Johan Saragih\\Downloads\\Data Contoh 1.xlsx");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/upload")
//                .file(new MockMultipartFile("file", file.getName(), "application/vnd.ms-excel", fileInputStream)))
//                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
//    }
    
}
