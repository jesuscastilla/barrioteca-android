## [2026-10-21 01:18] — Añadir descripciones de accesibilidad a iconos

- **Archivos afectados:**
  - `app/src/main/java/com/lebeche/barrioteca/ui/AboutScreen.kt`
  - `app/src/main/java/com/lebeche/barrioteca/ui/ScanScreen.kt`
  - `app/src/main/java/com/lebeche/barrioteca/ui/SettingsScreen.kt`
  - `app/src/main/java/com/lebeche/barrioteca/ui/LoginScreen.kt`
- **Motivo:** Varios componentes `Icon` que sirven como botones o elementos informativos clave carecían de `contentDescription` (estaba en `null`), impidiendo a las usuarias que usan lectores de pantalla entender su propósito.
- **Riesgo:** bajo
- **Validación:** Ejecutar un lector de pantalla o verificar que los tests pasan (no hay cambios en comportamiento lógico, solo strings agregados).

```diff
--- app/src/main/java/com/lebeche/barrioteca/ui/AboutScreen.kt
+++ app/src/main/java/com/lebeche/barrioteca/ui/AboutScreen.kt
@@ -74,3 +74,3 @@
             ) {
-                Icon(Icons.AutoMirrored.Filled.OpenInNew, contentDescription = null)
+                Icon(Icons.AutoMirrored.Filled.OpenInNew, contentDescription = "Abrir web en el navegador")
                 Text("  Visitar nuestra web")

--- app/src/main/java/com/lebeche/barrioteca/ui/ScanScreen.kt
+++ app/src/main/java/com/lebeche/barrioteca/ui/ScanScreen.kt
@@ -132,3 +132,3 @@
             ) {
-                Icon(Icons.Filled.QrCodeScanner, contentDescription = null)
+                Icon(Icons.Filled.QrCodeScanner, contentDescription = "Escanear libro")
                 Text("  Escanear libro")

--- app/src/main/java/com/lebeche/barrioteca/ui/SettingsScreen.kt
+++ app/src/main/java/com/lebeche/barrioteca/ui/SettingsScreen.kt
@@ -98,3 +98,3 @@
             ) {
-                Icon(Icons.Filled.Sync, contentDescription = null)
+                Icon(Icons.Filled.Sync, contentDescription = "Sincronizar ahora")
                 Text("  Sincronizar ahora")
@@ -121,3 +121,3 @@
             ) {
-                Icon(Icons.Filled.Email, contentDescription = null)
+                Icon(Icons.Filled.Email, contentDescription = "Contactar administración")
                 Text("  Contactar administración")
@@ -128,3 +128,3 @@
             OutlinedButton(onClick = onLogout, modifier = Modifier.fillMaxWidth()) {
-                Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = null)
+                Icon(Icons.AutoMirrored.Filled.Logout, contentDescription = "Cerrar sesión")
                 Text("  Cerrar sesión")

--- app/src/main/java/com/lebeche/barrioteca/ui/LoginScreen.kt
+++ app/src/main/java/com/lebeche/barrioteca/ui/LoginScreen.kt
@@ -173,3 +173,3 @@
         ) {
-            Icon(Icons.Filled.QrCodeScanner, contentDescription = null)
+            Icon(Icons.Filled.QrCodeScanner, contentDescription = "Escanear carné")
             Spacer(Modifier.height(0.dp))
```
