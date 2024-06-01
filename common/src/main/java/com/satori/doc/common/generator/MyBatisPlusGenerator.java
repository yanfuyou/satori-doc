package com.satori.doc.common.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.satori.doc.model.po.BasePO;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.util.Assert;

import java.sql.Types;
import java.util.Collections;

/**
 * @author cat_y
 */
@AllArgsConstructor
public class MyBatisPlusGenerator {

    private final FastAutoGenerator fastAutoGenerator;

    private Builder.GlobalConfig globalConfig;

    private Builder.PackageConfig packageConfig;

    private Builder.StrategyConfig strategyConfig;


    @NoArgsConstructor
    @Data
    @Accessors(fluent = true, chain = true)
    public static class Builder {
        private String url;

        private String name;

        private String pwd;

        private GlobalConfig globalConfig;

        private PackageConfig packageConfig;

        private StrategyConfig strategyConfig;

        public MyBatisPlusGenerator build() {
            Assert.notNull(this.url, "datasource url can not be null!");
            Assert.notNull(this.name, "db user url can not be null!");
            Assert.notNull(this.pwd, "db password url can not be null!");
            FastAutoGenerator fastAutoGenerator = FastAutoGenerator.create(this.url, this.name, this.pwd);
            return new MyBatisPlusGenerator(fastAutoGenerator, this.globalConfig, this.packageConfig, this.strategyConfig);
        }


        @AllArgsConstructor
        @Getter
        @Setter
        public static class GlobalConfig {
            private String author;

            private boolean enableSwagger = false;

            private String outPutDir;
        }

        @AllArgsConstructor
        @Getter
        @Setter
        public static class PackageConfig {
            private String parent;

            private String moduleName;

            private String xmlPath;

        }

        @AllArgsConstructor
        @Getter
        @Setter
        public static class StrategyConfig {
            private String include;

            private boolean fileOverride = true;

            private String[] prefix;

            Class<? extends BasePO> superPO;
        }
    }

    public void execute() {
        fastAutoGenerator.globalConfig(builder -> {
            builder.author(this.globalConfig.author);
            if (this.globalConfig.enableSwagger) {
                builder.enableSwagger();
            }
            builder.outputDir(this.globalConfig.outPutDir);
        });

        fastAutoGenerator.dataSourceConfig(builder -> {
            builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                if (typeCode == Types.SMALLINT) {
                    return DbColumnType.INTEGER;
                }
                return typeRegistry.getColumnType(metaInfo);
            });
        });

        fastAutoGenerator.packageConfig(builder -> {
            builder.parent(this.packageConfig.parent)
                    .moduleName(this.packageConfig.moduleName)
                    .entity("dal.po")
                    .mapper("dal.mapper")
                    .pathInfo(Collections.singletonMap(OutputFile.xml, this.packageConfig.xmlPath));
        });

        fastAutoGenerator.strategyConfig(builder -> {
                    builder.addInclude(this.strategyConfig.include)
                            .addTablePrefix(this.strategyConfig.prefix);
                    builder.entityBuilder()
                            .enableLombok()
                            .formatFileName("%sPO")
                            .addIgnoreColumns("id", "deleted", "create_time", "update_time", "creator", "creator_id", "modifier", "modifier_id");
                    if (this.strategyConfig.fileOverride) {
                        builder.entityBuilder().enableFileOverride();
                    }
                    if (this.strategyConfig.superPO != null) {
                        builder.entityBuilder()
                                .superClass(this.strategyConfig.superPO);
                    }
                    builder.controllerBuilder()
                            .enableRestStyle()
                            .enableHyphenStyle();
                })
                .templateEngine(new FreemarkerTemplateEngine());
        fastAutoGenerator.execute();
    }
}