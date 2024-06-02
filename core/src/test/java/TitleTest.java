import com.satori.doc.core.dto.TitleDTO;
import com.satori.doc.core.handler.DocHandler;
import com.satori.doc.core.handler.ParagraphContext;
import com.satori.doc.model.enums.AlignMethodEnum;
import com.satori.doc.model.enums.FontFamilyEnum;
import com.satori.doc.model.enums.FontStyleEnum;
import com.satori.doc.model.enums.GlyphEnum;
import com.satori.doc.model.json.FontConfiguration;
import com.satori.doc.model.json.TitleConfiguration;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author cat_y
 */
public class TitleTest {
    static String resourcesDir = System.getProperty("user.dir") + "/src/main/resources/doc/";

    @Test
    public void genTest() throws IOException {
        TitleDTO title = new TitleDTO();
        title.setContent("这是一个标题");
        TitleConfiguration configuration = new TitleConfiguration();
        configuration.setAlign(AlignMethodEnum.CENTER);
        FontConfiguration fontConfiguration = new FontConfiguration();
        fontConfiguration.setFontFamily(FontFamilyEnum.SONG_TI);
        fontConfiguration.setFontStyle(FontStyleEnum.BOLD);
        fontConfiguration.setGlyph(GlyphEnum.NUMBER_ONE);
        configuration.setFontConfiguration(fontConfiguration);
        title.setConfiguration(configuration);
        ParagraphContext context = ParagraphContext.of(title, null);
        try (XWPFDocument xwpfDocument = DocHandler.commonGenerator(context)) {
            FileOutputStream fileOutputStream = new FileOutputStream(resourcesDir + "title.docx");
            xwpfDocument.write(fileOutputStream);
        } catch (Exception e) {
            throw e;
        }


    }

}
