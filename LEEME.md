# QuickMoveRebind (versión minimalista)

Rebindea la tecla que activa el "quick move" (equipar/mover items rápido con shift-click)
en Minecraft Forge 1.8.9. Por defecto es Left Shift (igual que vanilla), rebindeable desde
Opciones -> Controles -> categoria "Inventario".

## Como funciona (y por que no tiene delay)
Un solo mixin (MixinGuiScreen) sobreescribe el metodo estatico isShiftKeyDown(), que es
el que Minecraft 1.8.9 usa nativamente en toda la GUI del inventario para chequear shift.
La sobreescritura llama a GameSettings.isKeyDown(KeyBinding) -- el mismo mecanismo interno
que usa el juego para cualquier tecla rebindeable (sneak, sprint, etc). No hay polling extra,
ni delay, ni logica añadida: es una lectura directa del estado del teclado, igual que el
codigo vanilla original.

## Por que es mas simple que la version anterior
La primera version traia un segundo mixin que interceptaba Keyboard.isKeyDown dentro de
GuiContainer.mouseClicked/mouseReleased. Era redundante (cubre lo mismo que el de arriba)
y mas riesgoso: si el punto de inyeccion no coincide exactamente con el bytecode compilado,
el mod puede fallar al ABRIR Minecraft (no al compilar el .jar). Se quito para minimizar
puntos de falla.

## Compilar en GitHub (gratis, sin instalar nada en tu PC)

1. Descarga el Gradle Wrapper del MDK oficial de Forge 1.8.9
   - https://files.minecraftforge.net/ -> Minecraft 1.8.9 -> version 11.15.1.2318-1.8.9 -> boton MDK.
   - Descomprime el zip descargado en tu PC.
   - De ahi copia a esta carpeta (QuickMoveRebind), reemplazando si pregunta:
     - gradlew
     - gradlew.bat
     - la carpeta gradle/ completa (trae gradle-wrapper.jar y gradle-wrapper.properties)
   - No copies el build.gradle del MDK -- el de esta carpeta ya esta listo.

2. Sube la carpeta completa a un repo de GitHub
   - Crea un repo nuevo en github.com.
   - Sube TODO, incluyendo gradlew, gradlew.bat y gradle/ (los que copiaste en el paso 1).
   - Si usas git:
     git init
     git add .
     git commit -m "quickmove rebind - version minimalista"
     git branch -M main
     git remote add origin https://github.com/TU_USUARIO/TU_REPO.git
     git push -u origin main

3. Espera a que Actions compile
   - Pestaña "Actions" de tu repo -> el workflow arranca solo con el push.
   - 2-5 minutos. Verde = compilo bien.
   - Entra al run -> "Artifacts" (al fondo de la pagina) -> descarga QuickMoveRebind.zip -> adentro esta el .jar.

4. Instalar el mod
   - Copia el .jar a la carpeta mods de tu instalacion de Forge 1.8.9.

5. Si el build falla, copia el error de las ultimas 20-30 lineas del log del paso "Build" en Actions
   y pegamelo -- reviso y te digo la correccion exacta.
