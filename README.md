# SauceDemo Test Otomasyon Projesi

SauceDemo (https://www.saucedemo.com) web uygulaması için Gauge ve Selenium
kullanılarak geliştirilmiş uçtan uca (end-to-end) test otomasyon projesidir.
Proje; giriş (login), ürün listeleme, sepet, sıralama ve satın alma akışları
gibi uygulamanın temel kullanıcı senaryolarını doğrulamayı hedefler.

Testler Maven üzerinden çalıştırılır ve sonuçlar Allure raporlama aracı ile
görselleştirilir. Framework; locator ve test verilerini kod içine gömmek
yerine JSON dosyaları üzerinden yönetecek şekilde tasarlanmıştır, bu sayede
yeni sayfa/senaryo eklemek ve mevcut testleri bakımda tutmak kolaylaşır.
Ayrıca Chrome ve Firefox tarayıcılarında çalışabilme, hata anında otomatik
ekran görüntüsü alma ve görsel (visual) karşılaştırma gibi ek yetenekler de
projeye dahildir.

## Teknoloji Stack'i

- **Dil:** Java 17
- **Test Framework:** Gauge (BDD tarzı spesifikasyonlar)
- **Web Otomasyon:** Selenium 4.34.0
- **Build Tool:** Maven
- **Driver Yönetimi:** WebDriverManager 6.3.0
- **Assertion:** AssertJ 3.27.3
- **Test Runner:** TestNG 7.11.0
- **Raporlama:** Allure 2 (allure-java-commons, custom entegrasyon)
- **JSON İşleme:** Jackson (jackson-databind)
- **Loglama:** Log4j 2

## Gereksinimler

Projeyi çalıştırmadan önce aşağıdakilerin kurulu olması gerekir:

- **JDK 17** (Eclipse Adoptium Temurin önerilir)
- **Apache Maven** 3.9+
- **Gauge CLI** (ayrıca kurulmalı — Maven bağımlılığı yeterli değildir)
  ```
  gauge install java
  ```
- **Git**
- **Chrome** ve/veya **Firefox** tarayıcısı (ChromeDriver/GeckoDriver,
  WebDriverManager tarafından otomatik indirilir)
- **Allure Commandline** (raporu görüntülemek için, opsiyonel)

> ⚠️ Not: Gauge CLI, `pom.xml` içindeki `gauge-java` bağımlılığından ayrı
> olarak sisteme kurulmalıdır. Kurulum sonrası mutlaka `gauge install java`
> komutu çalıştırılmalıdır, aksi halde Java plugin tanınmaz.

## Kurulum

1. **Repoyu klonlayın**
   ```bash
   git clone https://github.com/efeisliyen0/Test-Otomasyon.git
   cd Test-Otomasyon
   ```

2. **Gauge CLI'ı kurun** (henüz kurulu değilse)

   Windows (Chocolatey ile):
   ```bash
   choco install gauge
   ```

   Kurulumdan sonra Java plugin'i ekleyin:
   ```bash
   gauge install java
   ```

3. **Bağımlılıkları indirin**
   ```bash
   mvn clean install -DskipTests
   ```

4. **Konfigürasyonu kontrol edin**

   `src/test/config.properties` dosyasında test edilecek URL'i kontrol edin:
   ```properties
   url=https://www.saucedemo.com/
   browser=chrome
   ```

   > ⚠️ Not: `config.properties` içindeki `browser` alanı şu an
   > kullanılmıyor. Tarayıcı seçimi `BROWSER` ortam değişkeni ile yapılır
   > (bkz. [Tarayıcı Desteği](#tarayıcı-desteği) bölümü).

## Proje Yapısı

```
Test-Otomasyon/
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java           # Gauge before/after hook'ları, Allure yaşam döngüsü
│       │   ├── driverManager/
│       │   │   └── Driver.java             # WebDriver oluşturma (Chrome/Firefox)
│       │   ├── helpers/
│       │   │   ├── elementhelper.java      # Element etkileşimleri (click, sendKeys vs.)
│       │   │   ├── DriverHelper.java       # Driver ve locator erişimi
│       │   │   ├── waithelper.java         # Explicit wait yardımcıları
│       │   │   ├── VerifyHelper.java       # Assertion/doğrulama metodları
│       │   │   ├── ScreenshotHelper.java   # Ekran görüntüsü alma ve Allure'a ekleme
│       │   │   ├── TestDataHelper.java     # Test verisi çözümleme
│       │   │   └── ImageComparisonHelper.java # Görsel karşılaştırma
│       │   ├── locators/
│       │   │   └── LocatorManager.java     # Locator tipi -> By nesnesi dönüşümü
│       │   ├── Steps/
│       │   │   ├── ClickSteps.java         # Tıklama adımları
│       │   │   ├── WriteSteps.java         # Yazma/temizleme adımları
│       │   │   ├── SelectSteps.java        # Dropdown seçim adımları
│       │   │   ├── VerifySteps.java        # Doğrulama adımları
│       │   │   ├── WaitSteps.java          # Bekleme adımları
│       │   │   ├── ActionSteps.java        # Navigasyon/pencere aksiyonları
│       │   │   ├── InventorySteps.java     # Ürün listesi/sıralama adımları
│       │   │   └── VisualSteps.java        # Görsel karşılaştırma adımları
│       │   └── utils/
│       │       ├── ConfigReader.java       # config.properties okuma
│       │       ├── JsonReader.java         # Locator JSON'larını okuma/birleştirme
│       │       ├── TestDataReader.java     # Test data JSON'larını okuma
│       │       ├── AllureStatusHolder.java # Thread-safe test durumu takibi
│       │       └── AllureStepRunner.java   # Gauge step'lerini Allure step'ine çevirme
│       ├── resources/
│       │   ├── locators/                   # Sayfa bazlı locator JSON dosyaları
│       │   │   ├── loginlocators.json
│       │   │   ├── homelocators.json
│       │   │   ├── cartlocators.json
│       │   │   ├── checkoutlocators.json
│       │   │   └── locators.json           # 
│       │   ├── testdata/                   # Sayfa/senaryo bazlı test verisi JSON dosyaları
│       │   │   ├── login.json
│       │   │   ├── cart.json
│       │   │   ├── checkout.json
│       │   │   ├── products.json
│       │   │   ├── sort.json
│       │   │   └── messages.json
│       │   └── log4j2.properties           # Loglama konfigürasyonu
│       └── config.properties               # Ortam ayarları (url, browser)
├── specs/                                  # Gauge .spec dosyaları
│   ├── login.spec
│   ├── logout.spec
│   ├── cart.spec
│   ├── checkout.spec
│   ├── inventory.spec
│   ├── reset.spec
│   └── visual.spec
├── Jenkinsfile
├── pom.xml
└── README.md
```

## Testleri Çalıştırma

Tüm testleri çalıştırmak için:
```bash
mvn clean test
```

Belirli bir tarayıcı ile çalıştırmak için (`BROWSER` ortam değişkeni kullanılır):

**Windows PowerShell:**
```powershell
$env:BROWSER="firefox"
mvn clean test
```

**Windows CMD:**
```cmd
set BROWSER=firefox
mvn clean test
```

> Not: `BROWSER` belirtilmezse varsayılan olarak `chrome` kullanılır.

Belirli bir spec dosyasını çalıştırmak için:
```bash
mvn clean test -Dgauge.specs="specs/login.spec"
```

## Örnek Senaryo

Gauge spec dosyaları düz metin (`.spec`) formatında yazılır, her satır bir
step'e karşılık gelir:

**specs/login.spec**
```gauge
# Login

## Valid Login
* User enters "login.standardUser" into "username" field
* User enters "login.password" into "password" field
* User clicks "login" button
* User should see products
```

Buradaki `"login.standardUser"` gibi ifadeler `TestDataHelper` tarafından
çözümlenir: `.` işaretinden önceki kısım JSON dosya adını (`login.json`),
sonraki kısım ise o dosyadaki key'i (`standardUser`) belirtir.

## Raporlama (Allure)

Gauge'ın resmi bir Allure adaptörü olmadığı için, bu projede özel bir
entegrasyon geliştirilmiştir:

- `BaseTest` sınıfı, her senaryo başında/sonunda Allure test case'ini
  manuel olarak başlatır/kapatır (`@BeforeScenario` / `@AfterScenario`)
- `AllureStepRunner`, her Gauge step'ini bir Allure step'i olarak sarar
  ve hata durumunda otomatik ekran görüntüsü ekler
- `AllureStatusHolder`, thread-safe şekilde senaryonun başarılı/başarısız
  durumunu takip eder

Test sonrası Allure raporunu görüntülemek için:
```bash
mvn allure:report
mvn allure:serve
```

> ⚠️ Not: Allure 3 (Node.js tabanlı) bu custom entegrasyonun ürettiği JSON
> formatı ile uyumlu değildir. Bu yüzden `pom.xml` içinde Allure raporu
> `2.34.1` sürümüne (`reportVersion`) sabitlenmiştir.

### Bilinen Eksik / Yapılacaklar
- Her step'i saran `AllureStepRunner.run(...)` çağrıları geçici bir
  çözümdür; temizlenmesi planlanmaktadır.

## Tarayıcı Desteği

Proje Chrome ve Firefox tarayıcılarını destekler. Seçim, `-Dbrowser` gibi
bir sistem property'si ile değil, **işletim sistemi ortam değişkeni**
(`BROWSER`) ile yapılır:

```java
String browser = System.getenv("BROWSER") != null
        ? System.getenv("BROWSER").toLowerCase()
        : "chrome";
```

> ⚠️ Neden ortam değişkeni? Gauge, testleri ayrı bir alt süreç (subprocess)
> olarak çalıştırdığı için Maven'e `-Dbrowser=firefox` şeklinde verilen
> sistem property'leri bu alt sürece **iletilmez**. Bu yüzden işletim
> sistemi seviyesinde bir ortam değişkeni kullanmak gerekir.

Kullanım:

**PowerShell:**
```powershell
$env:BROWSER="firefox"
mvn clean test
```

**CMD:**
```cmd
set BROWSER=firefox
mvn clean test
```

`BROWSER` tanımlı değilse varsayılan olarak Chrome kullanılır. Her iki
tarayıcı için de driver kurulumu `WebDriverManager` tarafından otomatik
yapılır, elle driver indirmeye gerek yoktur.

Ayrıca her iki tarayıcı da gizlilik modunda başlatılır:
- Chrome: `--incognito`
- Firefox: `-private`

## Jenkins CI/CD

Proje, testleri otomatik çalıştırmak için bir Jenkins pipeline'ı (`Jenkinsfile`)
içerir. Pipeline şu adımları uygular:

1. **Checkout** — Repo'yu Jenkins workspace'ine çeker
2. **Build & Test** — `mvn clean test` komutunu çalıştırır
3. **Post (Always)** — Allure Jenkins Plugin ile `allure-results/` klasöründeki
   sonuçlardan otomatik rapor üretir

### Gereksinimler (Jenkins tarafında)
- **JDK 17** tool tanımı: `JDK17`
- **Maven** tool tanımı: `Maven3.9.16`
- **Allure Jenkins Plugin** kurulu olmalı
- `BROWSER` ortam değişkeni pipeline içinde `chrome` olarak sabitlenmiştir

### Jenkins Job Kurulumu
1. Jenkins'te yeni bir **Pipeline** job oluşturun
2. "Pipeline script from SCM" seçin, repo URL'ini girin:
   `https://github.com/efeisliyen0/Test-Otomasyon.git`
3. Script Path: `Jenkinsfile`
4. **Manage Jenkins → Global Tool Configuration** altında `JDK17` ve
   `Maven3.9.16` adlarıyla JDK/Maven kurulumlarını tanımlayın
5. Build'i tetikleyin, sonuçları job sayfasındaki **Allure Report**
   linkinden görüntüleyin

## Loglama

Log4j2 kullanılarak hem konsola hem de dosyaya loglama yapılır:

- Loglar `logs/test-automation.log` dosyasına yazılır
- Günlük olarak `logs/archived/` altında 10 MB boyut limitiyle
  rotasyona (rolling) tabi tutulur
- Konfigürasyon: `src/test/resources/log4j2.properties`

## Katkıda Bulunma

1. Yeni bir özellik veya düzeltme için kendi branch'inizi oluşturun
   (örn. `feature/xyz`, `fix/xyz`)
2. Değişikliklerinizi yapıp commit atın
3. Branch'inizi push edip Pull Request açın
4. PR'da testlerin başarıyla çalıştığından emin olun (`mvn clean test`)
