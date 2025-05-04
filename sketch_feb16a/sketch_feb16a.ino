
#include <Keypad.h>
#include <Servo.h>

// Keypad setup
const byte ROWS = 4; // Four rows
const byte COLS = 4; // Four columns
char keys[ROWS][COLS] = {
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};
byte rowPins[ROWS] = {2, 3, 4, 5}; // Connect to the row pinouts of the keypad
byte colPins[COLS] = {6, 7, 8, 9}; // Connect to the column pinouts of the keypad
Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, ROWS, COLS);

// Servo setup
Servo servo;
const int servoPin = 11;
const int lockedPos = 0; // Position when door is locked
const int unlockedPos = 90; // Position when door is unlocked

// Password setup
String password = "1467";
String inputPassword;

void setup() {
  Serial.begin(9600);
  servo.attach(servoPin);
  lockDoor();
}

void loop() {
  char key = keypad.getKey();
  if (key) {
    Serial.print(key);
    if (key == '#') {
      if (inputPassword == password) {
        Serial.println("Password correct"); // Debugging statement
        unlockDoor();
        delay(5000); // Door stays unlocked for 5 seconds
        lockDoor();
      } else {
        Serial.println("Password incorrect"); // Debugging statement
      }
      inputPassword = ""; // Clear input
    } else if (key == '*') {
      inputPassword = ""; // Clear input
    } else {
      inputPassword += key;
    }
  }
}

void lockDoor() {
  servo.write(lockedPos);
  Serial.println("Door locked.");
}

void unlockDoor() {
  servo.write(unlockedPos);
  Serial.println("Door unlocked.");
}