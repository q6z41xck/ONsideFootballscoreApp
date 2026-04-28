# ONside

<p align="center">
<img src="https://reluctant-lime-ctird6ty1u.edgeone.app/ONside.jpg" alt="App icon" width="256px" height="256px">
</p>


**ONside** แอปพลิเคชันสำหรับตรวจสอบผลการแข่งขันฟุตบอล, ดูอันดับดาวซัลโวของแต่ละลีก, ตารางคะแนนลีก และอ่านข่าวสารกีฬาล่าสุด 
ในการสร้าง UI Layout จะใช้ **Jetpack Compose** และใช้ **Kotlin Flow** ร่วมกับ **Coroutines** สำหรับจัดการการทำงานแบบ Asynchronous

## Tech stack ที่ใช้
* **ภาษา:** Kotlin
* **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose?gclsrc=ds&gclsrc=ds)
* **UI Design:** [Material Design 3](https://m3.material.io/)
* **Asynchronous Tasks:** [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) และ [Kotlin Flow](https://kotlinlang.org/docs/flow.html)
* **Dependency Injection:** [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* **Networking:** [Retrofit](https://square.github.io/retrofit/) และ [OkHttp](https://square.github.io/okhttp/)
* **Logging:** [Timber](https://github.com/JakeWharton/timber)
* **Animations:** [Lottie Animations](https://airbnb.design/lottie/)
* **Delivery:** [Play Feature Delivery](https://developer.android.com/guide/playcore/feature-delivery)
* **Crash Reporting:** [Firebase Crashlytics](https://firebase.google.com/docs/crashlytics?hl=pl)

## Feature
* ดูผลการแข่งขันฟุตบอลแบบอัปเดต
* ดูรายละเอียดของการแข่งขัน
* ดูตารางคะแนน (League Table) ของลีกต่างๆ
* ตรวจสอบอันดับผู้ทำประตูสูงสุด (Top Scorers) ของแต่ละลีก
* ตรวจสอบทีมที่ชนะเลิศของแต่ละลีก (Winners)
* ติดตามและบันทึกการแข่งขันที่สนใจ (Watched Matches)
* อ่านข่าวสารกีฬาล่าสุด (Sports News)

## อื่นๆ

### API ที่ใช้
แอปนี้ดึงข้อมูลสำหรับการแสดงผลต่างๆ มาจาก 2 แหล่งข้อมูลหลัก:
- [football-data.org](https://www.football-data.org/documentation/quickstart) (สำหรับข้อมูลฟุตบอล)
- [newsapi.org](https://newsapi.org/) (สำหรับข่าวสารกีฬา)

### วิธีการ Build และรันแอป
1. สร้าง Authorization key สำหรับดึงข้อมูลฟุตบอลจาก [football-data.org](https://www.football-data.org/documentation/quickstart)
2. สร้าง Authorization key สำหรับดึงข้อมูลข่าวจาก [newsapi.org](https://newsapi.org/)
3. นำ key ที่ได้ไปใส่ไว้ในไฟล์ `gradle.properties` (ตำแหน่งไฟล์: `C:\Users\username\.gradle`):
   ```properties
   API_KEY=your_api_key
   NEWS_API_KEY=your_news_api_key
   ```
4. สร้างโปรเจ็คใน Firebase console และนำไฟล์ `google-services.json` มาใส่ในโฟลเดอร์ `app`
