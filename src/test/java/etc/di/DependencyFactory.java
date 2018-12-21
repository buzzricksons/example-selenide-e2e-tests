package etc.di;

import java.util.Arrays;
import java.util.List;
import java.util.ServiceLoader;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import etc.setting.ConfigSetting;

/**
 * DI(Dependency Injection)するDependencyオブジェクトを提供するFactoryクラス
 *
 * @author Hyungcheol Kim
 */
public class DependencyFactory {
    /**
     * 引数のインタフェースのimplementクラスの中で{@link etc.Env 現在の環境}に該当するオブジェクトを返す。
     *
     * @param interfaze 対象のインタフェースクラス
     * @see ServiceLoader
     * @return 実装された一つのDependencyクラス
     */
    public static <T> T loadDependencyByEnvAnnotaion(Class<T> interfaze) {
        //implementしたクラスのアノテーションから取った環境情報をConfigSettingの現在の環境と比較する
        Predicate<Class> isForCurrentEnvironment = implementsClass -> Arrays.stream(implementsClass.getAnnotations())
                .anyMatch(implementsClassAnnotation ->
                        (implementsClassAnnotation instanceof Environment) && ((Environment) implementsClassAnnotation).environment().equals(ConfigSetting.INSTANCE.getCurrentEnvironment())
                );
        return allImplementsClasses(interfaze).stream()
                .filter(dependency -> isForCurrentEnvironment.test(dependency.getClass()))
                .findAny()
                .orElseThrow(() ->new RuntimeException("実装されているDependencyクラスが存在しません: "+interfaze));
    }

    /**
     * 引数のインタフェースをimplementしたすべてのクラスをリストで返す。
     *
     * @param interfaze 対象のインタフェース
     * @see src/test/resources/META-INF/services
     * @return implementsしたクラスのリスト
     */
    private static <T> List<T> allImplementsClasses(Class<T> interfaze) {
        return ServiceLoader.load(interfaze)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
