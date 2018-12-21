package etc.key;

/**
 * キーを表すインタフェース
 *
 * @author Hyungcheol Kim
 */
public interface Key {
    /**
     * 引数の文字列に該当するキーを返す。
     *
     * @param key 文字列
     * @return キー
     */
    Key of(String key);
}
