# Local Music Player — M0

Základ offline hudebního přehrávače pro Samsung Galaxy S7 (SM-G930F), Android 14 / API 34.

## Build přes GitHub Actions

1. Přihlas se na GitHub a vytvoř nový prázdný repository.
2. Rozbal ZIP tohoto projektu do počítače.
3. Na stránce repository zvol **Add file → Upload files**.
4. Nahraj obsah složky projektu (ne samotnou nadřazenou složku).
5. Potvrď **Commit changes**.
6. Otevři záložku **Actions**.
7. Vyber workflow **Android CI**. Po každém pushi se spustí automaticky.
8. Po dokončení otevři úspěšný běh workflow a v části **Artifacts** stáhni `LocalMusicPlayer-debug`.
9. Rozbal stažený artifact. Uvnitř bude `app-debug.apk`.

## Instalace APK

Na telefonu povol instalaci aplikací z prohlížeče/správce souborů, kterým APK otevřeš. Přenes APK do Galaxy S7, otevři ho a potvrď instalaci.

Alternativně přes ADB:

```bash
adb install -r app-debug.apk
```

## Lokální sestavení

Vyžaduje JDK 17, Android SDK Platform 36 a Gradle 8.13:

```bash
gradle --no-daemon :app:assembleDebug
```

APK vznikne v:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Konfigurace

- Application ID: `cz.local.musicplayer`
- minSdk: 34
- targetSdk: 34
- compileSdk: 36
- ABI: arm64-v8a
- Kotlin: 2.4.21
- Android Gradle Plugin: 8.13.2
- Gradle: 8.13
- Compose BOM: 2026.09.00

## Stav

M0 skeleton: základní Compose UI, tři navigační obrazovky, české/anglické řetězce a deklarace oprávnění. Hudební skenování a přehrávání zatím nejsou implementované.
