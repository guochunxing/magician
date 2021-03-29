import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * author: chunxing
 * date: 2021/3/29 01:03
 * description:
 */
public class MybatisGenerator {

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig global = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        global.setOutputDir(projectPath + "/src/main/java");
        global.setAuthor("workabee");
        global.setOpen(false);
        global.setBaseResultMap(true);
        global.setBaseColumnList(true);
        global.setFileOverride(true);
        generator.setGlobalConfig(global);

        // 数据源配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setUrl("jdbc:mysql://localhost:3306/magician-console?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        generator.setDataSource(dataSource);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("magician-admin-infra");
        packageConfig.setEntity("model");
        generator.setPackageInfo(packageConfig);

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity("entity.java");
        templateConfig.setController("");
        templateConfig.setService("");
        templateConfig.setXml("");
        generator.setTemplate(templateConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/java/com/workabee/magician/admin/infra/model"
                        + "/" + tableInfo.getEntityName() + "Model" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude("*");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");
        generator.setStrategy(strategy);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

}
