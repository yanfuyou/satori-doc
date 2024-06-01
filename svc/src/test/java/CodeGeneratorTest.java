import com.satori.doc.common.generator.MyBatisPlusGenerator;
import com.satori.doc.model.po.IdAutoOptionalPO;
import org.junit.jupiter.api.Test;

public class CodeGeneratorTest {
    final String baseDir = System.getProperty("user.dir") + "%s";
    final MyBatisPlusGenerator.Builder.GlobalConfig globalConfig = new MyBatisPlusGenerator.Builder.GlobalConfig("cat_y", false,
            baseDir.formatted("/src/main/java"));

    final MyBatisPlusGenerator.Builder.PackageConfig packageConfig = new MyBatisPlusGenerator.Builder.PackageConfig("com.satori.doc", "svc",
            baseDir.formatted("/src/main/resources/mapper"));

    @Test
    public void gen() {

        MyBatisPlusGenerator.Builder.StrategyConfig strategyConfig = new MyBatisPlusGenerator
                .Builder
                .StrategyConfig("doc", true, new String[]{}, IdAutoOptionalPO.class);
        MyBatisPlusGenerator generator = new MyBatisPlusGenerator.Builder()
                .url("jdbc:mysql://64.110.98.55:3306/satori_doc?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&nullCatalogMeansCurrent=true&useInformationSchema=true&allowMultiQueries=true&allowMultiQueries=true&allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&allowMultiQueries=true&allowMultiQu-eries=true&allowPublicKeyRetrieval=true&useSSL=false")
                .name("satori")
                .pwd("Stu1yanl@satori.")
                .globalConfig(globalConfig)
                .packageConfig(packageConfig)
                .strategyConfig(strategyConfig)
                .build();
        generator.execute();
    }
}
