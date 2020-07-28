# GPIO Pin Convert
GPIOPinConvert is a command line utility for converting Raspberry Pi GPIO pins from the BCM numbering scheme to the wiringPi numbering scheme.

This can come in handy if you are using the wiringPi library (https://www.wiringpi.com) or any other library that depends on it; requiring this special pin numbering.

## Building GPIOPinConvert

GPIOPinConvert is designed to be compiled with Kotlin/Native, but it can also target Kotlin/JVM:

- `kotlinc-native src/GPIOPinConvert.kt` with a Kotlin/Native compiler on PATH
- `kotlinc src/GPIOPinConvert.kt` with a Kotlin/JVM compiler on PATH

Pre-built binaries are available under the `v1.0` release.

## Usage

Call the program output by your compiler (named `gpio-pin-convert` or `program.kexe`, for example) and pass in the BCM pin number you want to convert:
```
gpio-pin-convert <pin>
```

### Example usage
Calling `gpio-pin-convert 5` gives `GPIO BCM 5 => GPIO wPi 21` as an output, so you know the BCM port 5 maps to the wiring Pi port 21:
```shell
> ./gpio-pin-convert 5
GPIO BCM 5 => GPIO wPi 21
```
