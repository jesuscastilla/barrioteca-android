#!/usr/bin/env python3
"""Incrementa versionCode y el parche de versionName en app/build.gradle.

Regla del proyecto: subir el numero de version en CADA compilacion del CI.
Se invoca desde .github/workflows/release.yml (paso de bump, incluidos los
reintentos cuando dos runs coinciden).
"""
import re
import sys

p = 'app/build.gradle'
s = open(p, encoding='utf-8').read()

code = int(re.search(r'versionCode (\d+)', s).group(1)) + 1
s = re.sub(r'versionCode \d+', f'versionCode {code}', s)

m = re.search(r"versionName '(\d+)\.(\d+)\.(\d+)'", s)
if not m:
    print('ERROR: no se encontro versionName en app/build.gradle', file=sys.stderr)
    sys.exit(1)
maj, minor, patch = map(int, m.groups())
new_name = f"{maj}.{minor}.{patch + 1}"
s = re.sub(r"versionName '\d+\.\d+\.\d+'", f"versionName '{new_name}'", s)

open(p, 'w', encoding='utf-8').write(s)
print(f"VERSION_CODE={code}")
print(f"VERSION_NAME={new_name}")
