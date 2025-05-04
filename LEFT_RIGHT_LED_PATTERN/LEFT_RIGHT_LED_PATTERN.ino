// Define the pin modes for LEDs in the global scope
void setup() {
    pinMode(2, OUTPUT);
    pinMode(3, OUTPUT);
    pinMode(4, OUTPUT);
    pinMode(5, OUTPUT);
    pinMode(6, OUTPUT);
    pinMode(7, OUTPUT);
    pinMode(8, OUTPUT);
    pinMode(9, OUTPUT);
    pinMode(10, OUTPUT);
}

// Control the LED pattern
void loop() {
    // Left to right
    for (int i = 2; i <= 10; i++) {
        digitalWrite(i, HIGH);
        delay(40);
        digitalWrite(i, LOW);
    }

    // Delay between sequences
    delay(200); // Adjust the delay time as needed

    // Right to left
    for (int i = 10; i >= 2; i--) {
        digitalWrite(i, HIGH);
        delay(40);
        digitalWrite(i, LOW);
    }

    // Delay between sequences
    delay(200);
    
}
