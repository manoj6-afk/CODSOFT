# Download OpenCV JAR for Java
$url = "https://repo1.maven.org/maven2/org/openpnp/opencv/4.9.0-0/opencv-4.9.0-0.jar"
$output = "opencv-4.9.0-0.jar"

Write-Host "Downloading OpenCV JAR..."
Invoke-WebRequest -Uri $url -OutFile $output

Write-Host "Download complete! File saved as: $output"
Write-Host ""
Write-Host "To compile: javac -cp opencv-4.9.0-0.jar SimpleFaceDetect.java"
Write-Host "To run: java -cp .;opencv-4.9.0-0.jar SimpleFaceDetect"
