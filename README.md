Example-selenide-e2e-tests
==============================

# テスト方法
## 1.設定
src/test/resources/META-INF直下にある下記のファイルの中で実行する環境に該当するファイルの中身を修正する
```
config-local.properties
config-staging.properties
config-prod.properties
```

## 2.環境に該当するmavenコマンドを実行してテストを行う
-Dyoda.config引数に実行する環境を設定して実行する。環境は下記になる。(設定しない場合はlocalが設定される)
prod
staging
local

### 本番環境の場合
```
mvn clean test -Dstcpro.config="prod"
```

### staging環境の場合
```
mvn clean test -Dstcpro.config="staging"
```

### local環境の場合
```
mvn clean test
```

### ※Headlessテスト
下記の２つの方法がある
1.mavenコマンドで実行する場合
```
mvn clean test -Dchromeoptions.args="--headless --disable-gpu"
```

2.config-環境.propertiesファイルを修正する場合
```
# true, false
is_headless=true
```

# 構成図
```
── build
│   └── reports
│       └── tests <----------------------------テストが失敗した時の画面htmlとキャプチャーが保存される場所
│           ├── 1545012945186.0.html
│           ├── 1545012945186.0.png
│           ├── 1545013474507.0.html
│           └── 1545013474507.0.png
├── pom.xml
├── src
│   └── test
│       ├── java
│       │   ├── TestTopPage.java <----------------------トップページのテストクラス
│       │   ├── etc
│       │   │   ├── AbstractTests.java <------テストの初期化を行うクラス(ex:ブラウザの設定、ヘッドレスなど)
│       │   │   ├── Env.java <----------環境を表すクラス
│       │   │   ├── Utils.java <-----------Utilityクラス
│       │   │   ├── di
│       │   │   │   ├── DependencyFactory.java <------------DIするオブジェクトを提供するファクトリクラス
│       │   │   │   ├── Environment.java <---------環境情報を表すアノテーションインタフェース
│       │   │   │   ├── PageSupplier.java <--------テストするページを提供するインタフェース
│       │   │   │   └── impl
│       │   │   │       └── LocalPageSupplier.java <-------PageSupplier.javaのLocal環境用の実装クラス
│       │   │   ├── key
│       │   │   │   ├── Key.java
│       │   │   │   └── impl
│       │   │   │       └── ConfigKey.java <--------------ConfigSetting.javaで利用されるキー
│       │   │   └── setting
│       │   │       └── ConfigSetting.java <--------------設定情報を持っているシングルトンクラス
│       │   └── page
│       │       └── basic
│       │           ├── BeginPage.java <------------一番最初にランディングするページオブジェクト
│       │           └── TopPage.java <----------トップページオブジェクト
│       └── resources
│           ├── META-INF
│           │   └── services
│           │       └── etc.di.PageSupplier <----------------- PageSupplier.javaの実装クラス定義
│           ├── config-local.properties <---------------Local環境の設定値を持っているファイル
│           ├── config-staging.properties <---------------Staging環境の設定値を持っているファイル
│           └── config-prod.properties <----------------本番環境の設定値を持っているファイル
```

# テスト実行の流れ
mavenコマンドでテスト実行（Local環境を例として記述する）
```
mvn clean test
```
↓
AbstractTestクラスで初期化を行う
↓
各テストクラスのテスト実行される
