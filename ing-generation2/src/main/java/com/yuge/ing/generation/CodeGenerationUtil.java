package com.yuge.ing.generation;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.yuge.ing.generation.DataSourceInfo;

import java.util.HashMap;
import java.util.Map;


public class CodeGenerationUtil {

    /**
     * 生成代码
     *
     * @param rootPackage       基础包名
     * @param dataSourceInfo    数据源信息
     * @param author            作者
     * @param javaOutputDir     代码输出路径
     * @param xmlOutputDir      mapper.xml输出路径
     * @param prefix            表前缀
     * @param tableNames        表名
     */
    public static void generation(String rootPackage,
                                  DataSourceInfo dataSourceInfo,
                                  String author,
                                  String javaOutputDir,
                                  String xmlOutputDir,
                                  String prefix,
                                  String... tableNames) {
        FastAutoGenerator.create(dataSourceInfo.getUrl(), dataSourceInfo.getUserName(), dataSourceInfo.getPassword())
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .outputDir(javaOutputDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    Map<OutputFile, String> outputFileStringMap = new HashMap<>();
                    outputFileStringMap.put(OutputFile.xml, xmlOutputDir);
                    builder.parent(rootPackage) // 设置父包名
                            .entity("po") // entity包名
                            .pathInfo(outputFileStringMap); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addTablePrefix(prefix); // 设置过滤表前缀
                    builder.addInclude(tableNames); // 设置需要生成的表名
                    // service
                    builder.serviceBuilder()
                            .superServiceClass(IService.class)
                            .superServiceImplClass(ServiceImpl.class)
                            .formatServiceFileName("%sService");
                    // entity
                    builder.entityBuilder()
                            .enableLombok()
                            .addTableFills(new Column("crt_time", FieldFill.INSERT),
                                    new Column("crt_user_id", FieldFill.INSERT),
                                    new Column("crt_user_name", FieldFill.INSERT),
                                    new Column("upd_time", FieldFill.INSERT_UPDATE),
                                    new Column("upd_user_id", FieldFill.INSERT_UPDATE),
                                    new Column("upd_user_name", FieldFill.INSERT_UPDATE))
                            .formatFileName("%sEntity");
                    // mapper
                    builder.mapperBuilder()
                            .superClass(BaseMapper.class)
                            .enableBaseResultMap()
                            .enableBaseColumnList();
                    // controller
                    builder.controllerBuilder()
                            .enableRestStyle();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
