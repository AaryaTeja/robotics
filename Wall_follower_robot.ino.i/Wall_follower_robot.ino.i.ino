const int LEFT_SENSOR_PIN = 2;
const int RIGHT_SENSOR_PIN = 3;
const int MOTOR_LEFT_FORWARD = 4;
const int MOTOR_LEFT_BACKWARD = 5;
const int MOTOR_RIGHT_FORWARD = 6;
const int MOTOR_RIGHT_BACKWARD = 7;

void setup() {
    pinMode(LEFT_SENSOR_PIN, INPUT);
    pinMode(RIGHT_SENSOR_PIN, INPUT);
    pinMode(MOTOR_LEFT_FORWARD, OUTPUT);
    pinMode(MOTOR_LEFT_BACKWARD, OUTPUT);
    pinMode(MOTOR_RIGHT_FORWARD, OUTPUT);
    pinMode(MOTOR_RIGHT_BACKWARD, OUTPUT);
}

void loop() {
    int leftSensorValue = digitalRead(LEFT_SENSOR_PIN);
    int rightSensorValue = digitalRead(RIGHT_SENSOR_PIN);
    
    if (leftSensorValue == HIGH && rightSensorValue == HIGH) {
      
        turnLeft();
    } else if (leftSensorValue == HIGH && rightSensorValue == LOW) {
        turnRight();
        delay(500);
    } else if (leftSensorValue == LOW && rightSensorValue == LOW) {
        turnRight();
        delay(500);
    } else if (leftSensorValue == LOW && rightSensorValue == HIGH ) {
        turnRight();
    }
}

void moveForward() {
    digitalWrite(MOTOR_LEFT_FORWARD, HIGH);
    digitalWrite(MOTOR_RIGHT_FORWARD, HIGH);
    digitalWrite(MOTOR_LEFT_BACKWARD, LOW);
    digitalWrite(MOTOR_RIGHT_BACKWARD, LOW);
}

void moveBackward() {
    digitalWrite(MOTOR_LEFT_FORWARD, LOW);
    digitalWrite(MOTOR_RIGHT_FORWARD, LOW);
    digitalWrite(MOTOR_LEFT_BACKWARD, HIGH);
    digitalWrite(MOTOR_RIGHT_BACKWARD, HIGH);
}

void turnLeft() {
    digitalWrite(MOTOR_LEFT_FORWARD, LOW);
    digitalWrite(MOTOR_RIGHT_FORWARD, HIGH);
    digitalWrite(MOTOR_LEFT_BACKWARD, LOW);
    digitalWrite(MOTOR_RIGHT_BACKWARD, LOW);
}

void turnRight() {
    digitalWrite(MOTOR_LEFT_FORWARD, HIGH);
    digitalWrite(MOTOR_RIGHT_FORWARD, LOW);
    digitalWrite(MOTOR_LEFT_BACKWARD, LOW);
    digitalWrite(MOTOR_RIGHT_BACKWARD, LOW);
}
