package com.ares.controller;

import com.alibaba.fastjson.JSON;
import com.ares.infrastructure.message.RocketMQUtils;
import com.ares.enums.OrderTypeEnum;
import com.ares.enums.PaymentTypeEnum;
import com.ares.infrastructure.message.OrderMessage;
import com.ares.service.test.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * 测试controller
 *
 * @author 0xZzzz
 */
@RestController
@Slf4j
public class TestController {

    private static final String EXCEL_FILE_SUFFIX = ".xlsx";

    @Autowired
    private TestService testService;

    @Autowired
    private RocketMQUtils rocketMQUtils;

    @RequestMapping("/test")
    public String test(String str) {
        return testService.test(str);
    }

    @RequestMapping("/send")
    public String send(Integer orderStatus) {
        OrderMessage message = new OrderMessage();
        message.setOrderId(1L);
        message.setOrderStatus(orderStatus);
        message.setOrderType(OrderTypeEnum.POP.getType());
        message.setUserId(1L);
        message.setPrice(10L);
        message.setPaymentType(PaymentTypeEnum.ONLINE.getCode());
        rocketMQUtils.send("order", JSON.toJSONString(message));
        return "OK";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public boolean upload(@RequestParam("file") MultipartFile file) {
        try {
            validateFile(file);
            try (InputStream in = file.getInputStream()) {
                Workbook workbook = new XSSFWorkbook(in);
                Sheet sheet = workbook.getSheetAt(0);
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        log.info("excel item: {}", cell.getNumericCellValue());
                    }
                }
            }
            return true;
        } catch (Exception e) {
            log.error("upload error!", e);
            return false;
        }

    }

    /**
     * 校验文件
     */
    private void validateFile(MultipartFile file) {
        if (file == null || StringUtils.isEmpty(file.getOriginalFilename())) {
            throw new RuntimeException("file null!");
        }
        log.info("upload file: {}", file.getOriginalFilename());
        if (!file.getOriginalFilename().endsWith(EXCEL_FILE_SUFFIX)) {
            throw new RuntimeException("illegal file!");
        }
    }

}
