package com.yuge.ing.generation;

public class CodeGenerator {
    public static void main(String[] args) {
        DataSourceInfo info = new DataSourceInfo(
                "jdbc:mysql://localhost:3306/ing_seata_order?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false&serverTimezone=GMT%2B8",
                "root",
                "root");
        CodeGenerationUtil.generation(
                "com.yuge.ing.seata.order",
                info,
                "yuge",
                "E:\\Program Files\\Workspace\\My-Workspace\\ing-seata\\seata-order\\src\\main\\java",
                "E:\\Program Files\\Workspace\\My-Workspace\\ing-seata\\seata-order\\src\\main\\resources\\mapper",
                "biz_",
                "biz_order");
    }
}
