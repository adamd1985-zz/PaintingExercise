# Painting exercise solution

Painting exercise for google.

Comes with two modules:
1. ImageScannerAndMapper: Reads ASCII image formated by google and generates the google defined print commands to redraw it.
2. Rasterizer: Reads the output file of the above and prints out an image to be validated.


## Abstract

Takes a goolge image and tries to find the best instruction to draw it.

## Usage

### ImageScannerAndMapper

Program parameters: 2

1. Input instruction filename and path
2. Output rasterized image filename and path location


### Rasterizer

Program parameters: 4

1. Canvas max rows [1 to MAX_INTEGER]
2. Canvas max columns [1 to MAX_INTEGER]
3. Input rasterized image filename and path
4. Output instruction filename and path location

*Example*: java -jar rasterizer.jar 5 7 "./testInstructions1.txt" "./print.out"

## Compilation

mvn clean install

Will create an executable package.

## Requirements

* Maven 3.1+
* Java JDK 8+

## Potential Improvements

* Optimize command sets my mixing and matching.
* Create a heatmap identifier to allow human-eye driven optimization on potential hotzones.
** Heatmap should use simple trigonometry to detect where print commands intersect.


# Legal

See license file.
