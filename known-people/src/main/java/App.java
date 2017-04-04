import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import template.BaseDataDto;
import template.JobTemplateAddDto;
import template.TemplateDto;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guojun.wang on 2017/3/30.
 */
public class App {
    private static Map<String, String> templates = new LinkedHashMap<>();

    static {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static void main(String[] args) throws IOException, UnirestException {
        loadBaseData();
        Map<String, String> templates = loadTemplatesFromExcel();
        for (Map.Entry<String, String> entry : templates.entrySet()) {
            process(entry.getKey(), entry.getValue());
        }
    }

    private static void loadBaseData() throws IOException {
        String filename1 = "D:\\Projects\\JProjects\\JavaExpress\\known-people\\src\\main\\resources\\basedata.json";
        String text = new String(Files.readAllBytes(Paths.get(filename1)));
        BaseDataDto baseData = JSON.parseObject(text, BaseDataDto.class);
        for (String[] item : baseData.getSubJobType()) {
            templates.put(item[2], item[0] + "," + item[1]);
        }
    }

    private static Map<String, String> loadTemplatesFromExcel() throws IOException {
        Map<String, String> templates = new LinkedHashMap<>();
        String filename = "C:\\Users\\guojun.wang\\Desktop\\jobt.xlsx";

        FileInputStream input = new FileInputStream(new File(filename));  //读取的文件路径
        XSSFWorkbook wb = new XSSFWorkbook(new BufferedInputStream(input));
        System.out.println(wb.getNumberOfSheets());
        XSSFSheet xssfSheet = wb.getSheetAt(0);
        for (int rowNum = 1; rowNum <= 50; rowNum++) {
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            if (xssfRow != null) {
                String subtypeName = getValue(xssfRow.getCell(0));
                String description = getValue(xssfRow.getCell(1));
                templates.put(subtypeName, description);
            }
        }
        return templates;
    }

    private static void process(String subtypeName, String description) throws UnirestException {
        String[] items = templates.get(subtypeName).split(",");
        JobTemplateAddDto model = new JobTemplateAddDto();
        model.setJobTypeMain(items[1]);
        model.setSubJobTypeMain(items[0]);
        model.setJobdescription(description);
        model.setJobtitle(subtypeName);

        TemplateDto templateDto = new TemplateDto();
        templateDto.setCreateUserId(666666);
        templateDto.setTemplateTypeName(subtypeName);
        templateDto.setTemplateContent(JSON.toJSONString(model));
        templateDto.setHot(true);
        templateDto.setTemplateName(model.getJobtitle());
        templateDto.setModule(1);
        templateDto.setTemplateOwner(2);


        addTemplate(templateDto);

        System.out.println("subtypeId:" + templates.get(subtypeName));
        System.out.println("subtypeName:" + subtypeName);
        //System.out.println("description:" + description);
        System.out.println("---------------------");
    }

    private static void addTemplate(TemplateDto dto) throws UnirestException {
        String url = "http://localhost:8090/template/add";
        //String url = "http://172.17.6.16:8080/template/add";
        HttpResponse<Long> response = Unirest.post(url)
                .header("user-id", String.valueOf(dto.getCreateUserId()))
                .header("Content-Type", "application/json")
                .body(dto)
                .asObject(Long.class);
        System.out.println(response.getBody());
    }

    private static String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }
}