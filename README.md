# Slime Launch

Fabric mod for **Minecraft Java Edition 26.1.2**.

## How to use
1. Hold a slime ball.
2. Look upward.
3. Right-click to launch in the direction you are looking.
4. One slime ball is consumed per launch.

The launch strength is controlled by `LAUNCH_STRENGTH` in `SlimeLaunchMod.java`.

## Build
This project targets Java 25 and uses Fabric Loader 0.19.2, Fabric Loom 1.18.2, and Fabric API 0.146.1+26.1.2.

Run `gradle build`. The mod JAR is created in `build/libs/`.

A GitHub Actions workflow is included at `.github/workflows/build.yml`. Push this project to a GitHub repository, open **Actions**, and download the `slime-launch-1.0.1` artifact from a successful run.

Install the resulting JAR in the `mods` folder alongside Fabric Loader and Fabric API.
