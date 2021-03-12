package com.yuge.ing.generation;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerationUtil {

    //得到当前项目的路径
    public static String oPath = "D:\\Program Files\\Workspace\\My-workspace\\Ing\\ggg";

    public static void main(String[] args) {
        DataSourceInfo info = new DataSourceInfo(
                "jdbc:mysql://127.0.0.1:3306/ing_business?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT%2B8",
                "root",
                "123.com");
        CodeGenerationUtil.generationFull(
                "com.yuge.ing.business",
                info,
                true,
                true,
                "biz_",
                "biz_order", "biz_order_item");
    }

    /**
     * 生成mapper
     *
     * @param rootPackage    基础包名
     * @param dataSourceInfo 数据源信息
     * @param tableNames     要生成文件对应的表
     */
    public static void generationJava(String rootPackage,
                                      DataSourceInfo dataSourceInfo,
                                      boolean enableController,
                                      boolean enableService,
                                      String prefix,
                                      String... tableNames) {
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局配置
        GlobalConfig gc = globalConfig(getOutputDir("server"));
        autoGenerator.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = dataSourceConfig(dataSourceInfo);
        autoGenerator.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = strategyConfig(prefix, tableNames);
        strategy.setSuperMapperClass("com.yuge.cloud.mybatis.core.mapper.BaseMapper");
        strategy.setSuperControllerClass("com.yuge.cloud.web.core.controller.BaseController");
        strategy.setSuperServiceClass("com.yuge.cloud.mybatis.core.service.IService");
        strategy.setSuperServiceImplClass("com.yuge.cloud.mybatis.core.service.impl.ServiceImpl");
        autoGenerator.setStrategy(strategy);
        // 包配置
        PackageConfig pc = packageConfig(rootPackage);
        autoGenerator.setPackageInfo(pc);
        // 配置模板
        TemplateConfig templateConfig = templateConfig(enableController, enableService);
        autoGenerator.setTemplate(templateConfig);
        // 执行生成
        autoGenerator.execute();
    }

    /**
     * 生成xml
     *
     * @param dataSourceInfo 数据源信息
     * @param tableNames     要生成文件对应的表
     */
    public static void generationXml(DataSourceInfo dataSourceInfo, String prefix, String... tableNames) {
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局配置
        GlobalConfig gc = globalConfig(getXmlOutputDir("server"));
        autoGenerator.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = dataSourceConfig(dataSourceInfo);
        autoGenerator.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = strategyConfig(prefix, tableNames);
        autoGenerator.setStrategy(strategy);
        // 包配置
        PackageConfig pc = packageConfig("");
        autoGenerator.setPackageInfo(pc);
        // 配置模板
        TemplateConfig templateConfig = templateConfigOnlyXml();
        autoGenerator.setTemplate(templateConfig);
        // 执行生成
        autoGenerator.execute();
    }


    /**
     * 生成mapper、附带po
     *
     * @param rootPackage    基础包名
     * @param dataSourceInfo 数据源信息
     * @param tableNames     要生成文件对应的表
     */
    public static void generationFull(String rootPackage,
                                      DataSourceInfo dataSourceInfo,
                                      boolean enableController,
                                      boolean enableService,
                                      String prefix,
                                      String... tableNames) {
        //生成po
        generationJava(rootPackage, dataSourceInfo, enableController, enableService, prefix, tableNames);
        //生成xml
        generationXml(dataSourceInfo, prefix, tableNames);
    }


    /**
     * 全局配置
     *
     * @param
     * @return com.baomidou.mybatisplus.generator.config.GlobalConfig
     */
    private static GlobalConfig globalConfig(String outputDir) {
        //全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setFileOverride(false); //文件覆盖

        gc.setOutputDir(outputDir);
        gc.setOpen(false);//生成完成后不弹出文件框
        gc.setFileOverride(false);  //文件覆盖
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("yuge");// 作者

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        return gc;
    }

    /**
     * 数据源配置
     *
     * @param dataSourceInfo
     * @return com.baomidou.mybatisplus.generator.config.DataSourceConfig
     */
    private static DataSourceConfig dataSourceConfig(DataSourceInfo dataSourceInfo) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(dataSourceInfo.getUserName());
        dsc.setPassword(dataSourceInfo.getPassword());
        dsc.setUrl(dataSourceInfo.getUrl());  //指定数据库
        return dsc;
    }

    private static StrategyConfig strategyConfig(String prefix, String... tableNames) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);      // 表名生成策略
        strategy.setInclude(tableNames);     // 需要生成的表
        strategy.setTablePrefix(prefix);
        strategy.setEntityLombokModel(true);
        return strategy;
    }

    private static PackageConfig packageConfig(String packageName) {
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        pc.setController("server.controller");
        pc.setService("server.service");
        pc.setServiceImpl("server.service.impl");
        pc.setMapper("server.mapper");
        pc.setEntity("server.po");
        pc.setXml("mapper");
        return pc;
    }

    private static TemplateConfig templateConfig(boolean enableService, boolean enableController) {
        TemplateConfig templateConfig = new TemplateConfig();
        if (!enableController) {
            templateConfig.setController("");
        }
        if (!enableService) {
            templateConfig.setService("");
            templateConfig.setServiceImpl("");
        }

        templateConfig.setXml("");
        return templateConfig;
    }

    private static TemplateConfig templateConfigOnlyXml() {
        TemplateConfig templateConfig = new TemplateConfig();

        //控制 不生成 controller、service
        templateConfig.setController("");
        templateConfig.setService("");
        templateConfig.setServiceImpl("");
        templateConfig.setEntity("");
        templateConfig.setMapper("");
        return templateConfig;
    }

    private static String splitPath(String oPath, String model) {
        String prefx = oPath.substring(oPath.indexOf("-") + 1);
        System.out.println(prefx);
        return prefx + "-" + model;
    }

    public static String getOutputDir(String model) {
        String nPath = splitPath(oPath, model);
        return oPath + "\\" + nPath + "/src/main/java";
    }

    public static String getXmlOutputDir(String model) {
        String nPath = splitPath(oPath, model);
        return oPath + "\\" + nPath + "/src/main/resources";
    }

}
