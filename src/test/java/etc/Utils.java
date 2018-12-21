package etc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utilityクラス
 *
 * @author Hyungcheol Kim
 */
public class Utils {
    /**
     * 引数のprefixに該当する{@link Properties プロパティ}を返す。
     *
     * @param filePrefix
     * @return {@link Properties}
     */
    public static Properties properties(String filePrefix) {
        var properties = new Properties();
        var file = "src/test/resources/"+filePrefix+".properties";
        try (InputStream inputStream = new FileInputStream(file)) {
            properties.load(inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
