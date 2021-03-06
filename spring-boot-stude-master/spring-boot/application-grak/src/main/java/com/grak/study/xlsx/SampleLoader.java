/*
 * Copyright (c) 2017. Chengdu Qianxing Technology Co.,LTD.
 * All Rights Reserved.
 */

package com.grak.study.xlsx;

import com.grak.study.xlsx.monitor.FileLoader;
import com.grak.study.xlsx.monitor.FileMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 样本加载器
 * <p>
 * Created on 2017/3/15.
 *
 * @author Alan
 * @since 1.0
 */
@Component
@Order(1)
public class SampleLoader implements ApplicationRunner, FileLoader {

    Logger log = LoggerFactory.getLogger(getClass());

    private SampleConfig sampleConfig;

    @Autowired
    private FileMonitor monitor;

    @Autowired
    public SampleLoader(SampleConfig sampleConfig) {
        this.sampleConfig = sampleConfig;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("begin to load sample files...");
        String samplePath = sampleConfig.samplePath;
        if (samplePath == null) {
            log.warn("注意: 无法加载samplePath , samplePath 为空");
            return;
        }
        File file = new File(samplePath);
        loadSample(file);
        monitor.addDirectoryObserver(samplePath, this);
    }

    public void loadSample(File file) {
        if (file == null || !file.exists() || file.isHidden()
                || file.getName().endsWith(".svn")
                || file.getName().endsWith(".bak")) {
            return;
        }
        if (file.isDirectory()) {
            Arrays.asList(file.listFiles()).forEach(f -> loadSample(f));
            return;
        }
        String fileName = file.getName();
        if (fileName.endsWith(".csv")) {
            loadSampleByCsv(file);
        } else if (fileName.endsWith(".xlsx")) {
            loadSampleByExcel(file);
        }
    }

    public void loadSampleByCsv(File file) {
//        List<String[]> values = FileHelper.readCsvFile(file);
//        if (values == null || values.size() < 4) {
//            log.warn("cant use file {} 因为行数不够", file.getName());
//            return;
//        }
//        String parent = file.getParent().replace(File.separator, ".");
//        String fileName = file.getName();
//        String className = fileName.substring(0, fileName.indexOf('.'));
//        values.remove(0);// 第一行为说明，不要
//        String[] names = values.remove(0); // 第2行为字段值 不要
//        values.remove(0);// 第三行为说明，不要
//        String clazzName = sampleConfig.samplePackage + "." + parent + "."
//                + className;
//        try {
//            Class<Sample> clazz = (Class<Sample>) Class.forName(clazzName);
//            List<Sample> samples = SampleReflectHelper.resolveSample(clazz, names,
//                    values);
//
//            Field field = clazz.getField("factory");
//            SampleFactory factory = (SampleFactory) field.get(null);
//            factory.addSamples(samples);
//        } catch (Exception e) {
//            log.warn("parse file error, file is {}", fileName, e);
//        }
    }

    public void loadSampleByExcel(File file) {
        Map<String, List<String[]>> sheetMap = ExcelUtil.readExcelFile(file);
        sheetMap.forEach((name, values) -> {
            if (values == null || values.size() <= 4) {
                log.warn("cant use excel file {}, sheet {} 因为行数不够", file.getName(), name);
            } else {
                String fileName = file.getName();
                String pkg = fileName.substring(0, fileName.indexOf('.'));
                int index = name.indexOf(".");
                String className = name;
                if (index != -1) {
                    className = name.substring(index + 1);
                }
                values.remove(0);// 第一行为说明，不要
                values.remove(0);// 第2行为类型，不要
                String[] names = values.remove(0); // 第3行为字段名称
                values.remove(0);// 第4行为说明，不要
                String clazzName = sampleConfig.samplePackage + "." + pkg + "."
                        + className;
                try {
                    Class<Sample> clazz = (Class<Sample>) Class.forName(clazzName);
                    List<Sample> samples = SampleReflectHelper.resolveSample(clazz, names,
                            values);
                    Field field = clazz.getField("factory");
                    SampleFactory factory = (SampleFactory) field.get(null);
                    factory.addSamples(samples);
                } catch (Exception e) {
                    log.warn("parse file error, file is {}", fileName, e);
                }
            }
        });
    }

    @Override
    public void load(File file, boolean isNew) {
        try {
            log.info("on file change filename = {},isNew={}", file.getName(), isNew);
            loadSample(file);
        } catch (Exception e) {
            log.warn("on file change err,filename={},isNew={}", file.getName(), isNew);
        }
    }
}
