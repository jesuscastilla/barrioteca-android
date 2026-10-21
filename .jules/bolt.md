## 2025-02-18 - Replacing SimpleDateFormat with java.time APIs
**Learning:** `java.text.SimpleDateFormat` is synchronized or needs to be recreated on every call because it's not thread-safe, leading to poor performance, especially when parsing dates within lists or loops.
**Action:** Replace `SimpleDateFormat` and `java.util.Date/Calendar` with the thread-safe, immutable `java.time` APIs (like `LocalDate` and `DateTimeFormatter`) which are supported natively in Android API 26+ (this app is API 28+).
