# Ecommerce

Gereksinimler:

Bir E-ticaret sistemi oluşturmak istiyoruz. Spring Boot 3.0.4, paket yöneticisi olarak Maven ve Java SDK olarak 17 veya daha üst bir versiyon kullanılacaktır.
(Sadece Spring Web ve Swagger bağımlılığını eklemeniz yeterli olacaktır.)

Proje ismi : e-commerce

Req 1 : Sistemde Ürünler(Product) tutulmalıdır.

Req 2 : Ürünün id,name,quantity,price ve description şeklinde özellikleri olacaktır.

Req 3 : Ürünleri eklenebilecek, silinebilecek, güncellenebilecek, listelenebilecek, id ile getirebilecektir. (In Memory)

Req 4 : Ürünlerin fiyat bilgisi 0 dan büyük olmalıdır.

Req 5 : Ürünlerin quantity(miktarı) 0 dan küçük olamaz.

Req 6 : Ürünlerin description(açıklama) alanı min 10 karakter max 50 karakter olmalıdır.

Projede katmanlı mimari kullanılmıştır. 

NOT:
Swagger bağımlılığı için pom.xml'e ekleyiniz.

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.4</version>
</dependency>
